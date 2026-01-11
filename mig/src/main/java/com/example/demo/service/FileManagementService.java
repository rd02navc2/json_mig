package com.example.demo.service;

import com.example.demo.dto.EnhancedFieldInfo;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 檔案管理服務 (修復版)
 * - 修正回存路徑問題
 * - 確保檔案正確儲存到指定目錄
 */
@Service
public class FileManagementService {

    @Autowired
    private JavaParserService javaParserService;

    // 修改為絕對路徑
    @Value("${mig.template.path:C:/Users/User/Downloads/template/}")
    private String templatePath;
    
    @Value("${mig.template.default-file:MyMapping.java}")
    private String defaultTemplateFile;
    
    @Value("${mig.backup.dir:C:/Users/User/Downloads/template/backup}")
    private String backupDir;

    // 同步回存路徑（多個路徑用逗號分隔）
    @Value("${mig.sync.paths:}")
    private String syncPaths;

    // 快取
    private String cachedFileContent = null;
    private CompilationUnit cachedCompilationUnit = null;
    private String currentFilePath = null;

    /**
     * 載入預設的 Java 檔案
     */
    public FileLoadResult loadDefaultFile() {
        FileLoadResult result = new FileLoadResult();
        long startTime = System.currentTimeMillis();
        
        try {
            System.out.println("========================================");
            System.out.println("開始載入預設檔案: " + defaultTemplateFile);
            System.out.println("模板路徑: " + templatePath);
            System.out.println("========================================");

            // 標準化路徑（將反斜線轉為正斜線）
            String normalizedTemplatePath = templatePath.replace("\\", "/");
            if (!normalizedTemplatePath.endsWith("/")) {
                normalizedTemplatePath += "/";
            }

            // 建立完整檔案路徑
            Path filePath = Paths.get(normalizedTemplatePath + defaultTemplateFile);
            System.out.println("完整檔案路徑: " + filePath.toAbsolutePath());

            String content = null;
            
            // 檢查檔案是否存在
            if (Files.exists(filePath)) {
                // 從檔案系統讀取
                content = Files.readString(filePath, StandardCharsets.UTF_8);
                currentFilePath = filePath.toAbsolutePath().toString();
                System.out.println("✓ 從檔案系統載入成功");
                System.out.println("  檔案路徑: " + currentFilePath);
                System.out.println("  檔案大小: " + content.length() + " bytes");
            } else {
                // 嘗試從 resources 讀取
                String resourcePath = normalizedTemplatePath.replace("C:/Users/User/Downloads/", "") + defaultTemplateFile;
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
                
                if (inputStream != null) {
                    content = readInputStream(inputStream);
                    currentFilePath = "classpath:" + resourcePath;
                    System.out.println("✓ 從 classpath 載入成功");
                    System.out.println("⚠️ 注意: 從 classpath 載入的檔案無法回存，建議將檔案放到: " + filePath.toAbsolutePath());
                } else {
                    result.setSuccess(false);
                    result.setMessage("找不到檔案: " + filePath.toAbsolutePath());
                    System.err.println("❌ 檔案不存在: " + filePath.toAbsolutePath());
                    System.err.println("請確認檔案是否存在於該路徑");
                    return result;
                }
            }

            // 正規化換行符號
            content = content.replace("\r\n", "\n").replace("\r", "\n");
            System.out.println("✓ 換行符號正規化完成");

            // 解析 Java 檔案
            System.out.println("開始解析 Java 檔案...");
            ParseResult<CompilationUnit> parseResult = javaParserService.parseJavaContent(content);

            if (!parseResult.isSuccessful()) {
                System.err.println("❌ Java 解析失敗");
                List<String> errorList = new ArrayList<>();
                for (var problem : parseResult.getProblems()) {
                    String errorMsg = problem.toString();
                    errorList.add(errorMsg);
                    System.err.println("  - " + errorMsg);
                    if (errorList.size() >= 10) {
                        errorList.add("... (還有更多錯誤)");
                        break;
                    }
                }
                result.setSuccess(false);
                result.setMessage("Java 解析失敗");
                result.setErrors(errorList);
                return result;
            }

            System.out.println("✓ Java 解析成功");

            // 快取
            cachedFileContent = content;
            cachedCompilationUnit = parseResult.getResult().get();

            // 統計
            int lineCount = content.split("\n", -1).length;
            System.out.println("✓ 行數統計: " + lineCount);
            
            int fieldCount = 0;
            try {
                List<EnhancedFieldInfo> fields = javaParserService.findAllDsrefFields(cachedCompilationUnit);
                fieldCount = fields != null ? fields.size() : 0;
                System.out.println("✓ @DSREF 欄位統計: " + fieldCount);
            } catch (Exception e) {
                System.err.println("⚠️ 欄位統計失敗: " + e.getMessage());
            }

            long endTime = System.currentTimeMillis();
            long processingTime = endTime - startTime;

            System.out.println("========================================");
            System.out.println("✓✓✓ 檔案載入成功 ✓✓✓");
            System.out.println("檔案: " + defaultTemplateFile);
            System.out.println("行數: " + lineCount);
            System.out.println("欄位: " + fieldCount);
            System.out.println("耗時: " + processingTime + "ms");
            System.out.println("========================================");

            result.setSuccess(true);
            result.setFileName(defaultTemplateFile);
            result.setFilePath(currentFilePath);
            result.setFileSize(content.length());
            result.setLineCount(lineCount);
            result.setFieldCount(fieldCount);
            result.setProcessingTime(processingTime);

        } catch (Exception e) {
            String msg = e.getMessage() != null ? e.getMessage() : e.toString();
            System.err.println("❌ 載入失敗: " + msg);
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("載入失敗: " + msg);
        }

        return result;
    }

    /**
     * 重新載入檔案
     */
    public FileLoadResult reloadFile() {
        clearCache();
        return loadDefaultFile();
    }

    /**
     * 清除快取
     */
    public void clearCache() {
        cachedFileContent = null;
        cachedCompilationUnit = null;
        currentFilePath = null;
        System.out.println("✓ 快取已清除");
    }

    public CompilationUnit getCachedCompilationUnit() {
        return cachedCompilationUnit;
    }

    public String getCachedFileContent() {
        return cachedFileContent;
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

    public boolean isFileLoaded() {
        return cachedCompilationUnit != null && cachedFileContent != null;
    }

    /**
     * 更新檔案內容（修復版 - 支援多路徑同步回存）
     */
    public FileSaveResult updateFile(String newContent, String fieldName) throws Exception {
        FileSaveResult result = new FileSaveResult();
        
        System.out.println("========================================");
        System.out.println("開始儲存檔案變更");
        System.out.println("欄位名稱: " + fieldName);
        System.out.println("========================================");
        
        if (cachedFileContent == null || currentFilePath == null) {
            throw new IllegalStateException("找不到檔案內容，請先載入檔案");
        }

        // 1. 建立備份
        System.out.println("正在建立備份...");
        String backupPath = createBackup(cachedFileContent, defaultTemplateFile);
        result.setBackupPath(backupPath);
        System.out.println("✓ 備份已建立: " + backupPath);
        
        // 2. 回存到原檔案
        System.out.println("正在回存到原檔案...");
        saveToOriginalFile(newContent);
        result.setFilePath(currentFilePath);
        System.out.println("✓ 檔案已回存: " + currentFilePath);
        
        // 3. 同步到其他路徑
        List<String> syncedPaths = syncToAdditionalPaths(newContent);
        result.setSyncedPaths(syncedPaths);
        
        // 4. 更新快取
        cachedFileContent = newContent;
        
        // 5. 重新解析
        System.out.println("正在重新解析...");
        ParseResult<CompilationUnit> parseResult = javaParserService.parseJavaContent(newContent);
        if (parseResult.isSuccessful()) {
            cachedCompilationUnit = parseResult.getResult().get();
            System.out.println("✓ 重新解析成功");
        } else {
            System.err.println("⚠️ 重新解析失敗，但檔案已儲存");
        }
        
        result.setSuccess(true);
        
        System.out.println("========================================");
        System.out.println("✓✓✓ 檔案更新成功 ✓✓✓");
        System.out.println("欄位: " + fieldName);
        System.out.println("備份: " + backupPath);
        System.out.println("原檔: " + currentFilePath);
        if (!syncedPaths.isEmpty()) {
            System.out.println("同步位置 (" + syncedPaths.size() + "):");
            for (String path : syncedPaths) {
                System.out.println("  ✓ " + path);
            }
        }
        System.out.println("========================================");
        
        return result;
    }

    /**
     * 建立備份
     */
    private String createBackup(String content, String fileName) throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(date);
        
        String checkDayFd = timestamp.substring(0, 6);
        String normalizedBackupDir = backupDir.replace("\\", "/");
        String folderPath = normalizedBackupDir + "/" + checkDayFd;
        
        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("建立備份目錄: " + folderPath + " - " + (created ? "成功" : "失敗"));
        }
        
        String backupFileName = fileName.replace(".java", "_" + timestamp + ".java");
        String backupPath = folderPath + "/" + backupFileName;
        
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(backupPath), StandardCharsets.UTF_8))) {
            writer.write(content);
        }
        
        return backupPath;
    }

    /**
     * 儲存到原檔案位置（修復版）
     */
    private void saveToOriginalFile(String content) throws Exception {
        // 檢查是否為 classpath 資源
        if (currentFilePath.startsWith("classpath:")) {
            System.err.println("⚠️ 檔案從 classpath 載入，嘗試儲存到預設路徑");
            // 儲存到預設路徑
            String normalizedPath = templatePath.replace("\\", "/");
            if (!normalizedPath.endsWith("/")) {
                normalizedPath += "/";
            }
            Path targetPath = Paths.get(normalizedPath + defaultTemplateFile);
            
            // 確保目錄存在
            if (targetPath.getParent() != null) {
                Files.createDirectories(targetPath.getParent());
            }
            
            Files.writeString(targetPath, content, StandardCharsets.UTF_8);
            currentFilePath = targetPath.toAbsolutePath().toString();
            System.out.println("✓ 已儲存到: " + currentFilePath);
            return;
        }
        
        // 正常儲存
        Path filePath = Paths.get(currentFilePath);
        
        // 確保父目錄存在
        if (filePath.getParent() != null) {
            Files.createDirectories(filePath.getParent());
        }
        
        // 寫入檔案
        Files.writeString(filePath, content, StandardCharsets.UTF_8);
        
        System.out.println("✓ 檔案已寫入: " + currentFilePath);
        System.out.println("  大小: " + content.length() + " bytes");
    }

    /**
     * 同步到其他路徑
     */
    private List<String> syncToAdditionalPaths(String content) {
        List<String> syncedPaths = new ArrayList<>();
        
        // 檢查是否有設定同步路徑
        if (syncPaths == null || syncPaths.trim().isEmpty()) {
            return syncedPaths;
        }
        
        System.out.println("========================================");
        System.out.println("開始同步到其他路徑...");
        
        // 分割多個路徑（逗號分隔）
        String[] paths = syncPaths.split(",");
        
        for (String path : paths) {
            String trimmedPath = path.trim();
            if (trimmedPath.isEmpty()) continue;
            
            try {
                // 標準化路徑
                String normalizedPath = trimmedPath.replace("\\", "/");
                if (!normalizedPath.endsWith("/")) {
                    normalizedPath += "/";
                }
                
                // 建立目標檔案路徑
                Path targetPath = Paths.get(normalizedPath + defaultTemplateFile);
                
                System.out.println("正在同步到: " + targetPath);
                
                // 確保目錄存在
                if (targetPath.getParent() != null) {
                    Files.createDirectories(targetPath.getParent());
                }
                
                // 寫入檔案
                Files.writeString(targetPath, content, StandardCharsets.UTF_8);
                
                String absolutePath = targetPath.toAbsolutePath().toString();
                syncedPaths.add(absolutePath);
                
                System.out.println("✓ 同步成功: " + absolutePath);
                System.out.println("  大小: " + content.length() + " bytes");
                
            } catch (Exception e) {
                System.err.println("❌ 同步失敗: " + trimmedPath);
                System.err.println("  錯誤: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        System.out.println("同步完成: 成功 " + syncedPaths.size() + " / 總共 " + paths.length);
        System.out.println("========================================");
        
        return syncedPaths;
    }

    /**
     * 讀取 InputStream
     */
    private String readInputStream(InputStream inputStream) throws Exception {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8), 8192)) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // ===== DTO =====

    public static class FileLoadResult {
        private boolean success;
        private String message;
        private String fileName;
        private String filePath;
        private long fileSize;
        private int lineCount;
        private int fieldCount;
        private long processingTime;
        private List<String> errors;

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getFileName() { return fileName; }
        public void setFileName(String fileName) { this.fileName = fileName; }
        public String getFilePath() { return filePath; }
        public void setFilePath(String filePath) { this.filePath = filePath; }
        public long getFileSize() { return fileSize; }
        public void setFileSize(long fileSize) { this.fileSize = fileSize; }
        public int getLineCount() { return lineCount; }
        public void setLineCount(int lineCount) { this.lineCount = lineCount; }
        public int getFieldCount() { return fieldCount; }
        public void setFieldCount(int fieldCount) { this.fieldCount = fieldCount; }
        public long getProcessingTime() { return processingTime; }
        public void setProcessingTime(long processingTime) { this.processingTime = processingTime; }
        public List<String> getErrors() { return errors; }
        public void setErrors(List<String> errors) { this.errors = errors; }
    }

    public static class FileSaveResult {
        private boolean success;
        private String backupPath;
        private String filePath;
        private List<String> syncedPaths; // 新增：同步的路徑列表

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        public String getBackupPath() { return backupPath; }
        public void setBackupPath(String backupPath) { this.backupPath = backupPath; }
        public String getFilePath() { return filePath; }
        public void setFilePath(String filePath) { this.filePath = filePath; }
        public List<String> getSyncedPaths() { return syncedPaths; }
        public void setSyncedPaths(List<String> syncedPaths) { this.syncedPaths = syncedPaths; }
    }
}