package com.example.demo.service;

import com.example.demo.dto.EnhancedFieldInfo;
import com.github.javaparser.ast.CompilationUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 欄位操作服務 (更新版 - 支援多路徑同步)
 * 負責欄位搜尋、更新、批次處理等業務邏輯
 */
@Service
public class FieldOperationService {

    @Autowired
    private JavaParserService javaParserService;

    @Autowired
    private FieldEnrichmentService fieldEnrichmentService;

    @Autowired
    private FileManagementService fileManagementService;

    /**
     * 搜尋欄位
     */
    public FieldSearchResult searchField(String fieldName, boolean enrichFromDb) {
        FieldSearchResult result = new FieldSearchResult();
        
        try {
            // 檢查是否已載入檔案
            CompilationUnit cu = fileManagementService.getCachedCompilationUnit();
            if (cu == null) {
                result.setSuccess(false);
                result.setMessage("請先載入檔案");
                return result;
            }
            
            // 搜尋欄位
            List<EnhancedFieldInfo> fieldInfos = javaParserService.searchFieldsByName(cu, fieldName);
            
            // 從資料庫擴充資訊
            if (enrichFromDb && !fieldInfos.isEmpty()) {
                fieldEnrichmentService.enrichFieldInfoList(fieldInfos);
            }
            
            if (fieldInfos.isEmpty()) {
                System.out.println("搜尋結束，結果為空。輸入的 fieldName: [" + fieldName + "]");
            }
            
            result.setSuccess(true);
            result.setCount(fieldInfos.size());
            result.setResults(fieldInfos);
            result.setMessage("找到 " + fieldInfos.size() + " 個匹配的欄位");
            
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("搜尋失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * 從資料庫取得建議
     */
    public EnhancedFieldInfo suggestFromDatabase(String fieldName) {
        try {
            return fieldEnrichmentService.suggestFromDatabase(fieldName);
        } catch (Exception e) {
            System.err.println("從資料庫取得建議失敗: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 更新欄位 (更新版 - 支援多路徑同步)
     */
    public FieldUpdateResult updateField(EnhancedFieldInfo fieldData, boolean syncToDb) {
        FieldUpdateResult result = new FieldUpdateResult();
        
        try {
            String originalContent = fileManagementService.getCachedFileContent();
            
            if (originalContent == null) {
                result.setSuccess(false);
                result.setMessage("找不到檔案內容");
                return result;
            }

            // 生成新的欄位程式碼
            String newFieldCode = javaParserService.generateFieldCode(fieldData);
            
            // 替換欄位程式碼
            String updatedContent = javaParserService.replaceFieldInContent(
                originalContent, fieldData, newFieldCode
            );
            
            // 儲存檔案（含多路徑同步）
            FileManagementService.FileSaveResult saveResult = 
                fileManagementService.updateFile(updatedContent, fieldData.getFieldName());
            
            result.setBackupPath(saveResult.getBackupPath());
            result.setFilePath(saveResult.getFilePath());
            result.setSyncedPaths(saveResult.getSyncedPaths()); // 新增：同步路徑
            
            // 同步到資料庫
            if (syncToDb) {
                try {
                    fieldEnrichmentService.syncToDatabase(fieldData);
                    result.setDbSynced(true);
                } catch (Exception e) {
                    result.setDbSynced(false);
                    result.setDbSyncError(e.getMessage());
                    System.err.println("資料庫同步失敗: " + e.getMessage());
                }
            }
            
            result.setSuccess(true);
            result.setMessage("欄位更新成功");
            
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("更新失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * 批次匯入欄位到資料庫
     */
    public BatchImportResult batchImportToDatabase() {
        BatchImportResult result = new BatchImportResult();
        
        try {
            // 檢查是否已載入檔案
            CompilationUnit cu = fileManagementService.getCachedCompilationUnit();
            if (cu == null) {
                result.setSuccess(false);
                result.setMessage("請先載入檔案");
                return result;
            }
            
            // 搜尋所有帶有 @DSREF 的欄位
            List<EnhancedFieldInfo> allFields = javaParserService.findAllDsrefFields(cu);
            
            // 同步到資料庫
            int successCount = 0;
            List<String> errors = new ArrayList<>();
            
            for (EnhancedFieldInfo field : allFields) {
                try {
                    fieldEnrichmentService.syncToDatabase(field);
                    successCount++;
                } catch (Exception e) {
                    errors.add(field.getFieldName() + ": " + e.getMessage());
                    System.err.println("同步欄位失敗 [" + field.getFieldName() + "]: " + e.getMessage());
                }
            }
            
            result.setSuccess(true);
            result.setTotalFields(allFields.size());
            result.setSuccessCount(successCount);
            result.setFailureCount(allFields.size() - successCount);
            result.setErrors(errors);
            result.setMessage("批次匯入完成: " + successCount + "/" + allFields.size());
            
            System.out.println("批次匯入完成: 成功 " + successCount + " 個，失敗 " + 
                             (allFields.size() - successCount) + " 個");
            
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("批次匯入失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    // ===== 結果 DTO =====

    public static class FieldSearchResult {
        private boolean success;
        private String message;
        private int count;
        private List<EnhancedFieldInfo> results;

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        
        public int getCount() { return count; }
        public void setCount(int count) { this.count = count; }
        
        public List<EnhancedFieldInfo> getResults() { return results; }
        public void setResults(List<EnhancedFieldInfo> results) { this.results = results; }
    }

    public static class FieldUpdateResult {
        private boolean success;
        private String message;
        private String backupPath;
        private String filePath;
        private List<String> syncedPaths; // 新增：同步路徑列表
        private boolean dbSynced;
        private String dbSyncError;

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        
        public String getBackupPath() { return backupPath; }
        public void setBackupPath(String backupPath) { this.backupPath = backupPath; }
        
        public String getFilePath() { return filePath; }
        public void setFilePath(String filePath) { this.filePath = filePath; }
        
        public List<String> getSyncedPaths() { return syncedPaths; }
        public void setSyncedPaths(List<String> syncedPaths) { this.syncedPaths = syncedPaths; }
        
        public boolean isDbSynced() { return dbSynced; }
        public void setDbSynced(boolean dbSynced) { this.dbSynced = dbSynced; }
        
        public String getDbSyncError() { return dbSyncError; }
        public void setDbSyncError(String dbSyncError) { this.dbSyncError = dbSyncError; }
    }

    public static class BatchImportResult {
        private boolean success;
        private String message;
        private int totalFields;
        private int successCount;
        private int failureCount;
        private List<String> errors;

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        
        public int getTotalFields() { return totalFields; }
        public void setTotalFields(int totalFields) { this.totalFields = totalFields; }
        
        public int getSuccessCount() { return successCount; }
        public void setSuccessCount(int successCount) { this.successCount = successCount; }
        
        public int getFailureCount() { return failureCount; }
        public void setFailureCount(int failureCount) { this.failureCount = failureCount; }
        
        public List<String> getErrors() { return errors; }
        public void setErrors(List<String> errors) { this.errors = errors; }
    }
}