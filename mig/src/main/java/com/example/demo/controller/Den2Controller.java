package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/mig")
public class Den2Controller {

    @Value("${mig.template.path:template/}")
    private String templatePath;
    
    @Value("${mig.template.default-file:MyMapping.java}")
    private String defaultTemplateFile;
    
    @Value("${mig.output.dir:#{systemProperties['user.dir']}/output}")
    private String outputDir;
    
    @Value("${mig.backup.dir:#{systemProperties['user.dir']}/backup}")
    private String backupDir;

    @GetMapping("/den2")
    public String den2(Model model) {
        return "den2"; 
    }

    /**
     * 搜尋並解析指定欄位的所有出現位置
     */
    @PostMapping("/searchField")
    @ResponseBody
    public Map<String, Object> searchField(
            @RequestParam("fieldName") String fieldName,
            @RequestParam(value = "fileName", required = false) String fileName) throws Exception {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            if (fileName == null || fileName.isEmpty()) {
                fileName = defaultTemplateFile;
            }
            
            // 讀取檔案內容
            List<String> lines = readFileLines(fileName);
            
            // 遞迴搜尋欄位
            List<FieldInfo> fieldInfos = recursiveSearchField(lines, fieldName);
            
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
     * 更新欄位資料
     */
    @PostMapping("/updateField")
    @ResponseBody
    public Map<String, Object> updateField(@RequestBody FieldUpdateRequest request) throws Exception {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            String fileName = request.getFileName();
            if (fileName == null || fileName.isEmpty()) {
                fileName = defaultTemplateFile;
            }
            
            // 讀取檔案內容
            List<String> lines = readFileLines(fileName);
            
            // 建立備份
            String backupPath = createBackup(lines);
            
            // 更新欄位
            boolean success = updateFieldInFile(lines, request.getFieldData());
            
            if (success) {
                // 寫回檔案
                String outputPath = getOutputFilePath(fileName);
                java.io.File outputFile = new java.io.File(outputPath);
                
                if (outputFile.getParentFile() != null && !outputFile.getParentFile().exists()) {
                    outputFile.getParentFile().mkdirs();
                }
                
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                        new java.io.FileOutputStream(outputFile), "UTF-8"))) {
                    for (String line : lines) {
                        bw.write(line);
                        bw.newLine();
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
     * 遞迴搜尋欄位
     */
    private List<FieldInfo> recursiveSearchField(List<String> lines, String fieldName) {
        List<FieldInfo> results = new ArrayList<>();
        
        // 搜尋欄位宣告
        Pattern fieldPattern = Pattern.compile("public\\s+\\w+\\s+" + Pattern.quote(fieldName) + "\\s*[;=]");
        
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            
            if (fieldPattern.matcher(line).find()) {
                FieldInfo fieldInfo = extractFieldInfo(lines, i);
                if (fieldInfo != null) {
                    results.add(fieldInfo);
                    
                    // 最多返回 5 個結果
                    if (results.size() >= 5) {
                        break;
                    }
                }
            }
        }
        
        return results;
    }

    /**
     * 提取欄位資訊
     */
    private FieldInfo extractFieldInfo(List<String> lines, int fieldLineIndex) {
        FieldInfo fieldInfo = new FieldInfo();
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
                // 收集完整的 @AAA 註解
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
            DsrefInfo dsref = new DsrefInfo();
            
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
            AaaInfo aaa = new AaaInfo();
            List<MsgInfo> msgList = new ArrayList<>();
            
            String aaaText = String.join("\n", aaaLines);
            Pattern msgPattern = Pattern.compile("name=([^,]*),car=([^,]*),boro=([^,]*),chn=([^\"]*)");
            Matcher msgMatcher = msgPattern.matcher(aaaText);
            
            while (msgMatcher.find()) {
                MsgInfo msg = new MsgInfo();
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
            
            braceLevel -= countChar(line, '{');
            braceLevel += countChar(line, '}');
            
            Pattern classPattern = Pattern.compile("\\b(?:static\\s+)?class\\s+(\\w+)");
            Matcher classMatcher = classPattern.matcher(line);
            
            if (classMatcher.find() && braceLevel > 0) {
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
    private boolean updateFieldInFile(List<String> lines, FieldInfo fieldData) {
        // 根據 classPath 和 fieldName 找到要更新的欄位
        int targetLine = findFieldLineByPath(lines, fieldData.getClassPath(), fieldData.getFieldName());
        
        if (targetLine == -1) {
            return false;
        }
        
        // 找到註解起始行
        int annotationStartLine = targetLine;
        for (int i = targetLine - 1; i >= 0 && i >= targetLine - 20; i--) {
            String line = lines.get(i).trim();
            if (line.startsWith("@DSREF") || line.startsWith("@AAA")) {
                annotationStartLine = i;
            } else if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("@")) {
                break;
            }
        }
        
        // 生成新的程式碼
        String newCode = generateFieldCode(fieldData);
        
        // 替換舊的程式碼
        List<String> newLines = Arrays.asList(newCode.split("\n"));
        
        // 刪除舊的行
        for (int i = targetLine; i >= annotationStartLine; i--) {
            lines.remove(i);
        }
        
        // 插入新的行
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
                // 驗證類別路徑
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
            
            braceLevel -= countChar(line, '{');
            braceLevel += countChar(line, '}');
            
            Pattern classPattern = Pattern.compile("\\b(?:static\\s+)?class\\s+(\\w+)");
            Matcher classMatcher = classPattern.matcher(line);
            
            if (classMatcher.find() && braceLevel > 0) {
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
    private String generateFieldCode(FieldInfo fieldData) {
        StringBuilder code = new StringBuilder();
        
        // DSREF 註解
        DsrefInfo dsref = fieldData.getDsref();
        code.append(String.format("@DSREF(den = \"%s\", uid = \"%s\", cls = \"%s\")\n",
                dsref.getDen(), dsref.getUid(), dsref.getCls()));
        
        // AAA 註解
        code.append("@AAA(msg = {\n");
        code.append("//\n");
        
        for (MsgInfo msg : fieldData.getAaa().getMsg()) {
            code.append(String.format("    \"name=%s,car=%s,boro=%s,chn=%s\",//\n",
                    msg.getName(), msg.getCar(), msg.getBoro(), msg.getChn()));
        }
        
        code.append("})\n");
        
        // 欄位宣告
        code.append(String.format("public String %s;", fieldData.getFieldName()));
        
        return code.toString();
    }

    /**
     * 讀取檔案行
     */
    private List<String> readFileLines(String fileName) throws Exception {
        List<String> lines = new ArrayList<>();
        
        // 優先從 output 目錄讀取
        String outputPath = getOutputFilePath(fileName);
        java.io.File outputFile = new java.io.File(outputPath);
        
        if (outputFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new java.io.FileInputStream(outputFile), "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } else {
            // 從 resources 目錄讀取
            String resourcePath = templatePath + fileName;
            java.io.InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
            
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
    /**
     * 建立備份檔案 (從配置檔讀取備份目錄)
     */
    private String createBackup(List<String> lines) throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String nowDay = dateFormat.format(date);
        
        // 檢查備份目錄
        String checkDayFd = nowDay.substring(0, 6);
        String folderPath = backupDir + "/" + checkDayFd;
        java.io.File folder = new java.io.File(folderPath);
        
        if (!folder.exists()) {
            folder.mkdirs();
        }
        
        String backupPath = folderPath + "/MyMapping_" + nowDay + ".java";
        
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new java.io.FileOutputStream(backupPath), "UTF-8"))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        }
        
        System.out.println("備份檔案已建立: " + backupPath);
        return backupPath;
    }
    
    /**
     * 取得輸出檔案路徑 (從配置檔讀取)
     */
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
    
    
    
    
    
    // ===== 資料類別 =====

    public static class FieldInfo {
        private String fieldName;
        private List<String> classPath;
        private DsrefInfo dsref;
        private AaaInfo aaa;
        private int startLine;
        private int endLine;
        private int fieldLineNumber;
        private String originalCode;
        
        // Getters and Setters
        public String getFieldName() { return fieldName; }
        public void setFieldName(String fieldName) { this.fieldName = fieldName; }
        
        public List<String> getClassPath() { return classPath; }
        public void setClassPath(List<String> classPath) { this.classPath = classPath; }
        
        public DsrefInfo getDsref() { return dsref; }
        public void setDsref(DsrefInfo dsref) { this.dsref = dsref; }
        
        public AaaInfo getAaa() { return aaa; }
        public void setAaa(AaaInfo aaa) { this.aaa = aaa; }
        
        public int getStartLine() { return startLine; }
        public void setStartLine(int startLine) { this.startLine = startLine; }
        
        public int getEndLine() { return endLine; }
        public void setEndLine(int endLine) { this.endLine = endLine; }
        
        public int getFieldLineNumber() { return fieldLineNumber; }
        public void setFieldLineNumber(int fieldLineNumber) { this.fieldLineNumber = fieldLineNumber; }
        
        public String getOriginalCode() { return originalCode; }
        public void setOriginalCode(String originalCode) { this.originalCode = originalCode; }
    }

    public static class DsrefInfo {
        private String den;
        private String uid;
        private String cls;
        
        public String getDen() { return den; }
        public void setDen(String den) { this.den = den; }
        
        public String getUid() { return uid; }
        public void setUid(String uid) { this.uid = uid; }
        
        public String getCls() { return cls; }
        public void setCls(String cls) { this.cls = cls; }
    }

    public static class AaaInfo {
        private List<MsgInfo> msg;
        
        public List<MsgInfo> getMsg() { return msg; }
        public void setMsg(List<MsgInfo> msg) { this.msg = msg; }
    }

    public static class MsgInfo {
        private String name;
        private String car;
        private String boro;
        private String chn;
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getCar() { return car; }
        public void setCar(String car) { this.car = car; }
        
        public String getBoro() { return boro; }
        public void setBoro(String boro) { this.boro = boro; }
        
        public String getChn() { return chn; }
        public void setChn(String chn) { this.chn = chn; }
    }

    public static class FieldUpdateRequest {
        private String fileName;
        private FieldInfo fieldData;
        
        public String getFileName() { return fileName; }
        public void setFileName(String fileName) { this.fileName = fileName; }
        
        public FieldInfo getFieldData() { return fieldData; }
        public void setFieldData(FieldInfo fieldData) { this.fieldData = fieldData; }
    }
}