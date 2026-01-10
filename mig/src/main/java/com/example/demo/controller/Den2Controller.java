package com.example.demo.controller;

import com.example.demo.dto.EnhancedFieldInfo;
import com.example.demo.service.FieldOperationService;
import com.example.demo.service.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Den2 控制器
 * 負責處理 HTTP 請求並調用相應的服務
 */
@Controller
@RequestMapping("/mig")
public class Den2Controller {

    @Autowired
    private FileManagementService fileManagementService;

    @Autowired
    private FieldOperationService fieldOperationService;

    /**
     * 返回頁面
     */
    @GetMapping("/den2")
    public String den2() {
        return "den2"; 
    }

    /**
     * 載入預設的 Java 檔案
     */
    @PostMapping("/loadDefaultFile")
    @ResponseBody
    public Map<String, Object> loadDefaultFile() {
        FileManagementService.FileLoadResult result = fileManagementService.loadDefaultFile();
        return convertToMap(result);
    }

    /**
     * 重新載入檔案（放棄未儲存的變更）
     */
    @PostMapping("/reloadFile")
    @ResponseBody
    public Map<String, Object> reloadFile() {
        FileManagementService.FileLoadResult result = fileManagementService.reloadFile();
        return convertToMap(result);
    }

    /**
     * 搜尋並解析指定欄位
     */
    @PostMapping("/searchFieldEnhanced")
    @ResponseBody
    public Map<String, Object> searchFieldEnhanced(
            @RequestParam("fieldName") String fieldName,
            @RequestParam(value = "enrichFromDb", defaultValue = "true") boolean enrichFromDb) {
        
        FieldOperationService.FieldSearchResult result = 
            fieldOperationService.searchField(fieldName, enrichFromDb);
        
        return convertToMap(result);
    }

    /**
     * 根據欄位名稱從資料庫推薦資訊
     */
    @PostMapping("/suggestFromDb")
    @ResponseBody
    public Map<String, Object> suggestFromDb(@RequestParam("fieldName") String fieldName) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            EnhancedFieldInfo suggestion = fieldOperationService.suggestFromDatabase(fieldName);
            
            if (suggestion != null) {
                response.put("success", true);
                response.put("suggestion", suggestion);
                response.put("message", "已從資料庫取得建議資訊");
            } else {
                response.put("success", false);
                response.put("message", "資料庫中找不到相關資訊");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查詢失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return response;
    }

    /**
     * 更新欄位資料
     */
    @PostMapping("/updateFieldEnhanced")
    @ResponseBody
    public Map<String, Object> updateFieldEnhanced(@RequestBody FieldUpdateRequest request) {
        FieldOperationService.FieldUpdateResult result = 
            fieldOperationService.updateField(request.getFieldData(), request.isSyncToDb());
        
        return convertToMap(result);
    }

    /**
     * 批次匯入欄位到資料庫
     */
    @PostMapping("/batchImportToDb")
    @ResponseBody
    public Map<String, Object> batchImportToDb() {
        FieldOperationService.BatchImportResult result = 
            fieldOperationService.batchImportToDatabase();
        
        return convertToMap(result);
    }

    /**
     * 清除快取
     */
    @PostMapping("/clearCache")
    @ResponseBody
    public Map<String, Object> clearCache() {
        Map<String, Object> response = new HashMap<>();
        try {
            fileManagementService.clearCache();
            response.put("success", true);
            response.put("message", "快取已清除");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "清除快取失敗: " + e.getMessage());
        }
        return response;
    }

    // ===== 輔助方法 =====

    /**
     * 將 FileLoadResult 轉換為 Map
     */
    private Map<String, Object> convertToMap(FileManagementService.FileLoadResult result) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", result.isSuccess());
        map.put("message", result.getMessage());
        map.put("fileName", result.getFileName());
        map.put("filePath", result.getFilePath());
        map.put("fileSize", result.getFileSize());
        map.put("fileSizeKB", result.getFileSize() / 1024);
        map.put("lineCount", result.getLineCount());
        map.put("fieldCount", result.getFieldCount());
        map.put("processingTime", result.getProcessingTime());
        map.put("errors", result.getErrors());
        return map;
    }

    /**
     * 將 FieldSearchResult 轉換為 Map
     */
    private Map<String, Object> convertToMap(FieldOperationService.FieldSearchResult result) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", result.isSuccess());
        map.put("message", result.getMessage());
        map.put("count", result.getCount());
        map.put("results", result.getResults());
        return map;
    }

    /**
     * 將 FieldUpdateResult 轉換為 Map
     */
    private Map<String, Object> convertToMap(FieldOperationService.FieldUpdateResult result) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", result.isSuccess());
        map.put("message", result.getMessage());
        map.put("backupPath", result.getBackupPath());
        map.put("filePath", result.getFilePath());
        map.put("dbSynced", result.isDbSynced());
        map.put("dbSyncError", result.getDbSyncError());
        return map;
    }

    /**
     * 將 BatchImportResult 轉換為 Map
     */
    private Map<String, Object> convertToMap(FieldOperationService.BatchImportResult result) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", result.isSuccess());
        map.put("message", result.getMessage());
        map.put("totalFields", result.getTotalFields());
        map.put("successCount", result.getSuccessCount());
        map.put("failureCount", result.getFailureCount());
        map.put("errors", result.getErrors());
        return map;
    }

    // ===== 請求 DTO =====

    public static class FieldUpdateRequest {
        private EnhancedFieldInfo fieldData;
        private boolean syncToDb = false;
        
        public EnhancedFieldInfo getFieldData() { return fieldData; }
        public void setFieldData(EnhancedFieldInfo fieldData) { this.fieldData = fieldData; }
        
        public boolean isSyncToDb() { return syncToDb; }
        public void setSyncToDb(boolean syncToDb) { this.syncToDb = syncToDb; }
    }
}