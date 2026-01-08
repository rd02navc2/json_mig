package com.example.demo.controller;

import com.example.demo.dto.EnhancedFieldInfo;
import com.example.demo.service.FieldEnrichmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/mig")
public class Den2Controller {

    @Autowired
    private FieldEnrichmentService fieldEnrichmentService;

    @Value("${mig.template.path:template/}")
    private String templatePath;
    
    @Value("${mig.template.default-file:MyMapping.java}")
    private String defaultTemplateFile;
    
    @Value("${mig.output.dir:#{systemProperties['user.dir']}/output}")
    private String outputDir;
    
    @Value("${mig.backup.dir:#{systemProperties['user.dir']}/backup}")
    private String backupDir;

    @GetMapping("/den2")
    public String den2() {
        return "den2"; 
    }

    /**
     * 搜尋並解析指定欄位的所有出現位置 (整合資料庫資訊)
     */
    @PostMapping("/searchFieldEnhanced")
    @ResponseBody
    public Map<String, Object> searchFieldEnhanced(
            @RequestParam("fieldName") String fieldName,
            @RequestParam(value = "fileName", required = false) String fileName,
            @RequestParam(value = "enrichFromDb", defaultValue = "true") boolean enrichFromDb) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            if (fileName == null || fileName.isEmpty()) {
                fileName = defaultTemplateFile;
            }
            
            // 讀取檔案內容
            List<String> lines = readFileLines(fileName);
            
            // 遞迴搜尋欄位
            List<EnhancedFieldInfo> fieldInfos = recursiveSearchField(lines, fieldName);
            
            // 從資料庫擴充資訊
            if (enrichFromDb) {
                fieldEnrichmentService.enrichFieldInfoList(fieldInfos);
            }
            
            result.put("success", true);
            result.put("count", fieldInfos.size());
            result.put("results", fieldInfos);
            result.put("message", "找到 " + fieldInfos.size() + " 個匹配的欄位");
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "搜尋失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * 根據欄位名稱從資料庫推薦資訊
     */
    @PostMapping("/suggestFromDb")
    @ResponseBody
    public Map<String, Object> suggestFromDb(@RequestParam("fieldName") String fieldName) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            EnhancedFieldInfo suggestion = fieldEnrichmentService.suggestFromDatabase(fieldName);
            
            result.put("success", true);
            result.put("suggestion", suggestion);
            result.put("message", "已從資料庫取得建議資訊");
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "查詢失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * 更新欄位資料 (整合資料庫同步)
     */
    @PostMapping("/updateFieldEnhanced")
    @ResponseBody
    public Map<String, Object> updateFieldEnhanced(@RequestBody FieldUpdateRequest request) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            String fileName = request.getFileName();
            if (fileName == null || fileName.isEmpty()) {
                fileName = defaultTemplateFile;
            }
            
            EnhancedFieldInfo fieldData = request.getFieldData();
            
            // 讀取檔案內容
            List<String> lines = readFileLines(fileName);
            
            // 建立備份
            String backupPath = createBackup(lines);
            
            // 更新檔案中的欄位
            boolean success = updateFieldInFile(lines, fieldData);
            
            if (success) {
                // 寫回檔案
                String outputPath = getOutputFilePath(fileName);
                File outputFile = new File(outputPath);
                
                if (outputFile.getParentFile() != null && !outputFile.getParentFile().exists()) {
                    outputFile.getParentFile().mkdirs();
                }
                
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(outputFile), "UTF-8"))) {
                    for (String line : lines) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
                
                // 同步到資料庫
                if (request.isSyncToDb()) {
                    try {
                        fieldEnrichmentService.syncToDatabase(fieldData);
                        result.put("dbSynced", true);
                    } catch (Exception e) {
                        result.put("dbSynced", false);
                        result.put("dbSyncError", e.getMessage());
                    }
                }
                
                result.put("success", true);
                result.put("message", "欄位更新成功");
                result.put("backupPath", backupPath);
                result.put("outputPath", outputPath);
                
            } else {
                result.put("success", false);
                result.put("message", "找不到指定的欄位");
            }
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "更新失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * 批次匯入欄位到資料庫
     */
    @PostMapping("/batchImportToDb")
    @ResponseBody
    public Map<String, Object> batchImportToDb(
            @RequestParam(value = "fileName", required = false) String fileName) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            if (fileName == null || fileName.isEmpty()) {
                fileName = defaultTemplateFile;
            }
            
            // 讀取檔案
            List<String> lines = readFileLines(fileName);
            
            // 搜尋所有欄位
            List<EnhancedFieldInfo> allFields = findAllFields(lines);
            
            // 同步到資料庫
            int successCount = 0;
            List<String> errors = new ArrayList<>();
            
            for (EnhancedFieldInfo field : allFields) {
                try {
                    fieldEnrichmentService.syncToDatabase(field);
                    successCount++;
                } catch (Exception e) {
                    errors.add(field.getFieldName() + ": " + e.getMessage());
                }
            }
            
            result.put("success", true);
            result.put("totalFields", allFields.size());
            result.put("successCount", successCount);
            result.put("failureCount", allFields.size() - successCount);
            result.put("errors", errors);
            result.put("message", "批次匯入完成: " + successCount + "/" + allFields.size());
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "批次匯入失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    // ===== 核心解析邏輯 =====

    /**
     * 遞迴搜尋欄位
     */
    private List<EnhancedFieldInfo> recursiveSearchField(List<String> lines, String fieldName) {
        List<EnhancedFieldInfo> results = new ArrayList<>();
        
        Pattern fieldPattern = Pattern.compile("public\\s+\\w+\\s+" + Pattern.quote(fieldName) + "\\s*[;=]");
        
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            
            if (fieldPattern.matcher(line).find()) {
                EnhancedFieldInfo fieldInfo = extractFieldInfo(lines, i);
                if (fieldInfo != null) {
                    results.add(fieldInfo);
                }
            }
        }
        
        return results;
    }

    /**
     * 搜尋檔案中的所有欄位
     */
    private List<EnhancedFieldInfo> findAllFields(List<String> lines) {
        List<EnhancedFieldInfo> results = new ArrayList<>();
        
        Pattern fieldPattern = Pattern.compile("public\\s+\\w+\\s+(\\w+)\\s*[;=]");
        
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            Matcher matcher = fieldPattern.matcher(line);
            
            if (matcher.find()) {
                // 檢查是否有 @DSREF 註解
                boolean hasDsref = false;
                for (int j = Math.max(0, i - 5); j < i; j++) {
                    if (lines.get(j).trim().startsWith("@DSREF")) {
                        hasDsref = true;
                        break;
                    }
                }
                
                if (hasDsref) {
                    EnhancedFieldInfo fieldInfo = extractFieldInfo(lines, i);
                    if (fieldInfo != null) {
                        results.add(fieldInfo);
                    }
                }
            }
        }
        
        return results;
    }

    /**
     * 提取欄位資訊
     */
    private EnhancedFieldInfo extractFieldInfo(List<String> lines, int fieldLineIndex) {
        EnhancedFieldInfo fieldInfo = new EnhancedFieldInfo();
        fieldInfo.setFieldLineNumber(fieldLineIndex + 1);
        
        // 向上搜尋註解
        int annotationStartLine = fieldLineIndex;
        String dsrefLine = null;
        List<String> aaaLines = new ArrayList<>();
        
        for (int i = fieldLineIndex - 1; i >= 0 && i >= fieldLineIndex - 20; i--) {
            String line = lines.get(i).trim();
            
            if (line.startsWith("@DSREF")) {
                dsrefLine = line;
                annotationStartLine = i;
            } else if (line.startsWith("@AAA")) {
                StringBuilder aaaContent = new StringBuilder();
                int braceCount = 0;
                
                for (int j = i; j <= fieldLineIndex; j++) {
                    String aaaLine = lines.get(j);
                    aaaContent.append(aaaLine).append("\n");
                    
                    braceCount += countChar(aaaLine, '{');
                    braceCount -= countChar(aaaLine, '}');
                    
                    if (braceCount == 0 && aaaLine.contains("}")) {
                        break;
                    }
                }
                
                aaaLines.add(aaaContent.toString());
                if (i < annotationStartLine) {
                    annotationStartLine = i;
                }
            } else if (line.isEmpty() || line.startsWith("//")) {
                continue;
            } else if (!line.startsWith("@")) {
                break;
            }
        }
        
        fieldInfo.setStartLine(annotationStartLine + 1);
        fieldInfo.setEndLine(fieldLineIndex + 1);
        
        // 解析 DSREF
        if (dsrefLine != null) {
            EnhancedFieldInfo.DsrefInfo dsref = new EnhancedFieldInfo.DsrefInfo();
            
            Pattern denPattern = Pattern.compile("den\\s*=\\s*\"([^\"]*)\"");
            Pattern uidPattern = Pattern.compile("uid\\s*=\\s*\"([^\"]*)\"");
            Pattern clsPattern = Pattern.compile("cls\\s*=\\s*\"([^\"]*)\"");
            
            Matcher denMatcher = denPattern.matcher(dsrefLine);
            Matcher uidMatcher = uidPattern.matcher(dsrefLine);
            Matcher clsMatcher = clsPattern.matcher(dsrefLine);
            
            if (denMatcher.find()) dsref.setDen(denMatcher.group(1));
            if (uidMatcher.find()) dsref.setUid(uidMatcher.group(1));
            if (clsMatcher.find()) dsref.setCls(clsMatcher.group(1));
            
            fieldInfo.setDsref(dsref);
        }
        
        // 解析 AAA
        if (!aaaLines.isEmpty()) {
            EnhancedFieldInfo.AaaInfo aaa = new EnhancedFieldInfo.AaaInfo();
            List<EnhancedFieldInfo.MsgInfo> msgList = new ArrayList<>();
            
            String aaaText = String.join("\n", aaaLines);
            Pattern msgPattern = Pattern.compile("name=([^,]*),car=([^,]*),boro=([^,]*),chn=([^\"]*)");
            Matcher msgMatcher = msgPattern.matcher(aaaText);
            
            while (msgMatcher.find()) {
                EnhancedFieldInfo.MsgInfo msg = new EnhancedFieldInfo.MsgInfo();
                msg.setName(msgMatcher.group(1).trim());
                msg.setCar(msgMatcher.group(2).trim());
                msg.setBoro(msgMatcher.group(3).trim());
                msg.setChn(msgMatcher.group(4).trim());
                msgList.add(msg);
            }
            
            aaa.setMsg(msgList);
            fieldInfo.setAaa(aaa);
        }
        
        // 解析欄位名稱
        String fieldLine = lines.get(fieldLineIndex);
        Pattern fieldNamePattern = Pattern.compile("public\\s+\\w+\\s+(\\w+)\\s*[;=]");
        Matcher fieldNameMatcher = fieldNamePattern.matcher(fieldLine);
        if (fieldNameMatcher.find()) {
            fieldInfo.setFieldName(fieldNameMatcher.group(1));
        }
        
        // 向上搜尋類別階層 (最多5層)
        List<String> classPath = new ArrayList<>();
        int braceLevel = 0;
        
        for (int i = annotationStartLine; i >= 0 && classPath.size() < 5; i--) {
            String line = lines.get(i);
            
            braceLevel += countChar(line, '{');
            braceLevel -= countChar(line, '}');
            
            Pattern classPattern = Pattern.compile("\\b(?:static\\s+)?class\\s+(\\w+)");
            Matcher classMatcher = classPattern.matcher(line);
            
            if (classMatcher.find() && braceLevel >= 1) {
                classPath.add(0, classMatcher.group(1));
            }
        }
        
        fieldInfo.setClassPath(classPath);
        
        // 提取原始程式碼
        StringBuilder originalCode = new StringBuilder();
        for (int i = annotationStartLine; i <= fieldLineIndex; i++) {
            originalCode.append(lines.get(i)).append("\n");
        }
        fieldInfo.setOriginalCode(originalCode.toString().trim());
        
        return fieldInfo;
    }

    /**
     * 更新檔案中的欄位
     */
    private boolean updateFieldInFile(List<String> lines, EnhancedFieldInfo fieldData) {
        int targetLine = findFieldLineByPath(lines, fieldData.getClassPath(), fieldData.getFieldName());
        
        if (targetLine == -1) {
            return false;
        }
        
        int annotationStartLine = targetLine;
        for (int i = targetLine - 1; i >= 0 && i >= targetLine - 20; i--) {
            String line = lines.get(i).trim();
            if (line.startsWith("@DSREF") || line.startsWith("@AAA")) {
                annotationStartLine = i;
            } else if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("@")) {
                break;
            }
        }
        
        String newCode = generateFieldCode(fieldData);
        List<String> newLines = Arrays.asList(newCode.split("\n"));
        
        for (int i = targetLine; i >= annotationStartLine; i--) {
            lines.remove(i);
        }
        
        for (int i = 0; i < newLines.size(); i++) {
            lines.add(annotationStartLine + i, newLines.get(i));
        }
        
        return true;
    }

    /**
     * 根據類別路徑找到欄位行號
     */
    private int findFieldLineByPath(List<String> lines, List<String> classPath, String fieldName) {
        Pattern fieldPattern = Pattern.compile("public\\s+\\w+\\s+" + Pattern.quote(fieldName) + "\\s*[;=]");
        
        for (int i = 0; i < lines.size(); i++) {
            if (fieldPattern.matcher(lines.get(i)).find()) {
                List<String> currentPath = getClassPathAtLine(lines, i);
                if (matchClassPath(currentPath, classPath)) {
                    return i;
                }
            }
        }
        
        return -1;
    }

    /**
     * 取得指定行的類別路徑
     */
    private List<String> getClassPathAtLine(List<String> lines, int lineIndex) {
        List<String> classPath = new ArrayList<>();
        int braceLevel = 0;
        
        for (int i = lineIndex; i >= 0 && classPath.size() < 5; i--) {
            String line = lines.get(i);
            
            braceLevel += countChar(line, '{');
            braceLevel -= countChar(line, '}');
            
            Pattern classPattern = Pattern.compile("\\b(?:static\\s+)?class\\s+(\\w+)");
            Matcher classMatcher = classPattern.matcher(line);
            
            if (classMatcher.find() && braceLevel >= 1) {
                classPath.add(0, classMatcher.group(1));
            }
        }
        
        return classPath;
    }

    /**
     * 比對類別路徑
     */
    private boolean matchClassPath(List<String> path1, List<String> path2) {
        if (path1.size() != path2.size()) {
            return false;
        }
        
        for (int i = 0; i < path1.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * 生成欄位程式碼
     */
    private String generateFieldCode(EnhancedFieldInfo fieldData) {
        StringBuilder code = new StringBuilder();
        
        EnhancedFieldInfo.DsrefInfo dsref = fieldData.getDsref();
        code.append(String.format("@DSREF(den = \"%s\", uid = \"%s\", cls = \"%s\")\n",
                dsref.getDen(), dsref.getUid(), dsref.getCls()));
        
        code.append("@AAA(msg = {\n");
        code.append("//\n");
        
        for (EnhancedFieldInfo.MsgInfo msg : fieldData.getAaa().getMsg()) {
            code.append(String.format("    \"name=%s,car=%s,boro=%s,chn=%s\",//\n",
                    msg.getName(), msg.getCar(), msg.getBoro(), msg.getChn()));
        }
        
        code.append("})\n");
        code.append(String.format("public String %s;", fieldData.getFieldName()));
        
        return code.toString();
    }

    // ===== 檔案操作輔助方法 =====

    private List<String> readFileLines(String fileName) throws Exception {
        List<String> lines = new ArrayList<>();
        
        String outputPath = getOutputFilePath(fileName);
        File outputFile = new File(outputPath);
        
        if (outputFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(outputFile), "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } else {
            String resourcePath = templatePath + fileName;
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
            
            if (inputStream == null) {
                throw new RuntimeException("檔案不存在: resources/" + resourcePath);
            }
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        }
        
        return lines;
    }

    private String createBackup(List<String> lines) throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(date);
        
        String checkDayFd = timestamp.substring(0, 6);
        String folderPath = backupDir + "/" + checkDayFd;
        File folder = new File(folderPath);
        
        if (!folder.exists()) {
            folder.mkdirs();
        }
        
        String backupPath = folderPath + "/MyMapping_" + timestamp + ".java";
        
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(backupPath), "UTF-8"))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        }
        
        return backupPath;
    }
    
    private String getOutputFilePath(String fileName) {
        return outputDir + "/" + fileName;
    }
    
    private int countChar(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) count++;
        }
        return count;
    }
    
    // ===== 請求/回應 DTO =====

    public static class FieldUpdateRequest {
        private String fileName;
        private EnhancedFieldInfo fieldData;
        private boolean syncToDb = false;
        
        public String getFileName() { return fileName; }
        public void setFileName(String fileName) { this.fileName = fileName; }
        
        public EnhancedFieldInfo getFieldData() { return fieldData; }
        public void setFieldData(EnhancedFieldInfo fieldData) { this.fieldData = fieldData; }
        
        public boolean isSyncToDb() { return syncToDb; }
        public void setSyncToDb(boolean syncToDb) { this.syncToDb = syncToDb; }
    }
}