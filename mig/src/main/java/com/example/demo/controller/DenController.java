package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class DenController {

    @Value("${mig.template.path:template/}")
    private String templatePath;
    
    @Value("${mig.template.default-file:MyMapping.java}")
    private String defaultTemplateFile;
    
    @Value("${mig.output.dir:#{systemProperties['user.dir']}/output}")
    private String outputDir;
    
    @Value("${mig.backup.dir:#{systemProperties['user.dir']}/backup}")
    private String backupDir;

    @GetMapping("/den")
    public ModelAndView den() {
        return new ModelAndView("den");
    }

    @PostMapping("/parseJava")
    @ResponseBody
    public Map<String, Object> parseJavaFile(@RequestParam(value = "file", required = false) MultipartFile file,
                                             @RequestParam(value = "fileName", required = false) String fileName) throws Exception {
        List<String> lines = new ArrayList<>();

        if (file != null && !file.isEmpty()) {
            // 從上傳的檔案讀取
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } else {
            if (fileName == null || fileName.isEmpty()) {
                fileName = defaultTemplateFile;
            }
            
            // 優先從 output 目錄讀取 (修改後的檔案)
            String outputPath = getOutputFilePath(fileName);
            java.io.File outputFile = new java.io.File(outputPath);
            
            if (outputFile.exists()) {
                // 從 output 目錄讀取
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new java.io.FileInputStream(outputFile), "UTF-8"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                }
            } else {
                // 從 resources/template 目錄讀取原始檔案
                String resourcePath = templatePath + fileName;
                java.io.InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
                
                if (inputStream == null) {
                    throw new RuntimeException("檔案不存在: resources/" + resourcePath + " 且 output/" + fileName + " 也不存在");
                }
                
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                }
            }
        }

        List<TreeNode> tree = parseJavaToTree(lines);

        Map<String, Object> result = new HashMap<>();
        result.put("tree", tree);
        result.put("totalLines", lines.size());
        result.put("nodeCount", countNodes(tree));

        return result;
    }

    private int countNodes(List<TreeNode> nodes) {
        int count = nodes.size();
        for (TreeNode node : nodes) {
            if (node.getChildren() != null) {
                count += countNodes(node.getChildren());
            }
        }
        return count;
    }

    private List<TreeNode> parseJavaToTree(List<String> lines) {
        List<TreeNode> tree = new ArrayList<>();
        Stack<ContextNode> contextStack = new Stack<>();
        
        int lineNumber = 0;
        boolean inMultiLineComment = false;
        StringBuilder multiLineBuffer = new StringBuilder();
        
        List<TreeNode> recentFields = new ArrayList<>();
        int consecutiveFields = 0;

        for (String lineRaw : lines) {
            lineNumber++;
            String line = lineRaw.trim();
            
            if (inMultiLineComment) {
                if (line.contains("*/")) {
                    inMultiLineComment = false;
                }
                continue;
            }
            if (line.startsWith("/*")) {
                inMultiLineComment = true;
                if (line.contains("*/")) {
                    inMultiLineComment = false;
                }
                continue;
            }
            
            if (line.isEmpty() || line.startsWith("//")) continue;

            if (line.startsWith("package ") || line.startsWith("import ")) continue;

            boolean endsWithSymbol = line.endsWith(";") || line.contains("{") || line.contains("}");
            if (!endsWithSymbol) {
                multiLineBuffer.append(line).append(" ");
                continue;
            } else if (multiLineBuffer.length() > 0) {
                line = multiLineBuffer.toString() + line;
                multiLineBuffer.setLength(0);
            }
            
            String cleanedLine = removeStringsAndComments(line);

            try {
                TreeNode newNode = null;

                if (isClassDeclaration(cleanedLine)) {
                    newNode = createNode("CLASS", line, lineNumber);
                    recentFields.clear();
                    consecutiveFields = 0;
                }
                else if (isMethodDeclaration(cleanedLine)) {
                    newNode = createNode("METHOD", line, lineNumber);
                    recentFields.clear();
                    consecutiveFields = 0;
                }
                else if (!contextStack.isEmpty() && isConstructorDeclaration(cleanedLine, contextStack)) {
                    newNode = createNode("CONSTRUCTOR", line, lineNumber);
                    recentFields.clear();
                    consecutiveFields = 0;
                }
                else if (isFieldDeclaration(cleanedLine) && !cleanedLine.contains("(") && !cleanedLine.contains(")")) {
                    if (cleanedLine.matches(".*(public|private|protected|static|final)\\s+.*")) {
                        newNode = createNode("FIELD", line, lineNumber);
                        
                        if (consecutiveFields > 0 && recentFields.size() > 0) {
                            TreeNode lastField = recentFields.get(recentFields.size() - 1);
                            if (isAlignedFieldGroup(lastField.getText(), newNode.getText())) {
                                newNode.setText(newNode.getText() + " [對齊]");
                                lastField.setText(lastField.getText() + " [對齊群組]");
                            }
                        }
                        recentFields.add(newNode);
                        consecutiveFields++;
                        
                        if (recentFields.size() > 5) {
                            recentFields.remove(0);
                        }
                    }
                }
                
                if (newNode != null) {
                    if (newNode.getItIsFolder()) {
                        newNode.setChildren(new ArrayList<>());
                    }
                    
                    if (contextStack.isEmpty()) {
                        tree.add(newNode);
                    } else {
                        contextStack.peek().node.getChildren().add(newNode);
                    }

                    if (newNode.getItIsFolder() && line.contains("{")) {
                        int level = contextStack.isEmpty() ? 1 : contextStack.peek().braceLevel + 1;
                        contextStack.push(new ContextNode(newNode, level));
                    }
                }
            } catch (Exception e) {
                System.err.println("Error parsing line " + lineNumber + ": " + line);
            }

            int openBraces = countChar(cleanedLine, '{');
            int closeBraces = countChar(cleanedLine, '}');
            
            if (closeBraces > 0) {
                for (int i = 0; i < closeBraces; i++) {
                    if (!contextStack.isEmpty()) {
                        if (contextStack.peek().node.getText().startsWith("CLASS:") || 
                            contextStack.peek().node.getText().startsWith("METHOD:") ||
                            contextStack.peek().node.getText().startsWith("CONSTRUCTOR:")) {
                            
                            contextStack.pop();
                        }
                    }
                }
            }
        }

        return tree;
    }

    private boolean isAlignedFieldGroup(String field1Text, String field2Text) {
        Pattern dsrefParams = Pattern.compile(
            "@DSREF\\s*\\(\\s*den\\s*=\\s*\"([^\"]+)\"\\s*,\\s*uid\\s*=\\s*\"(\\d+)\"\\s*,\\s*cls\\s*=\\s*\"([^\"]+)\"\\s*\\)"
        );
        
        Matcher m1 = dsrefParams.matcher(field1Text);
        Matcher m2 = dsrefParams.matcher(field2Text);
        
        if (!m1.find() || !m2.find()) return false;
        
        boolean paramsMatch = m1.group(1).equals(m2.group(1)) && 
                             m1.group(2).equals(m2.group(2)) && 
                             m1.group(3).equals(m2.group(3));
        
        if (!paramsMatch) return false;
        
        String norm1 = normalizeFieldText(field1Text);
        String norm2 = normalizeFieldText(field2Text);
        
        Pattern structurePattern = Pattern.compile(
            "(@DSREF\\([^)]*\\))\\s*" +
            "(@AAA\\([^)]*\\))?\\s*" +
            "(public|private|protected)\\s+String\\s+(\\w+)\\s*;?"
        );
        
        Matcher s1 = structurePattern.matcher(norm1);
        Matcher s2 = structurePattern.matcher(norm2);
        
        if (!s1.matches() || !s2.matches()) return false;
        
        return Math.abs(s1.start(3) - s2.start(3)) <= 3;
    }

    private String normalizeFieldText(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    private TreeNode createNode(String type, String line, int lineNumber) {
        String displayText = extractDisplayText(type, line);
        TreeNode node = new TreeNode(type + ": " + displayText);
        
        node.setId(type + "-" + UUID.randomUUID().toString());
        node.setLineNumber(lineNumber);
        node.setItIsFolder(type.equals("CLASS"));
        
        return node;
    }

    private String extractDisplayText(String type, String line) {
        String cleaned = removeStringsAndComments(line).trim();
        
        switch (type) {
            case "CLASS":
                Pattern classPattern = Pattern.compile("\\b(class|interface|enum)\\s+(\\w+)(.*)");
                Matcher classMatcher = classPattern.matcher(cleaned);
                if (classMatcher.find()) {
                    String declaration = classMatcher.group(0);
                    int braceIndex = declaration.indexOf('{');
                    if (braceIndex > 0) {
                        declaration = declaration.substring(0, braceIndex).trim();
                    }
                    return declaration;
                }
                break;
                
            case "METHOD":
            case "CONSTRUCTOR":
                Pattern methodPattern = Pattern.compile("(\\w+)\\s*\\([^)]*\\)");
                Matcher methodMatcher = methodPattern.matcher(cleaned);
                if (methodMatcher.find()) {
                    int startIndex = cleaned.indexOf(methodMatcher.group(1));
                    if(startIndex != -1) {
                         String methodHeader = cleaned.substring(startIndex);
                         if (methodHeader.length() > 60) {
                            return methodHeader.substring(0, 57) + "...)";
                         }
                         return methodHeader;
                    }
                }
                break;
                
            case "FIELD":
                return formatAlignedField(line);
        }
        
        if (cleaned.length() > 60) {
            return cleaned.substring(0, 57) + "...";
        }
        return cleaned;
    }

    private String formatAlignedField(String originalLine) {
        String trimmedLine = originalLine.trim();
        if (trimmedLine.length() > 120) {
            return trimmedLine.substring(0, 117) + "...";
        }
        
        Pattern dsrefPattern = Pattern.compile("@DSREF\\s*\\([^)]*\\)");
        Matcher dsrefMatcher = dsrefPattern.matcher(trimmedLine);
        
        if (dsrefMatcher.find()) {
            String dsrefPart = dsrefMatcher.group(0);
            String rest = trimmedLine.substring(dsrefMatcher.end()).trim();
            
            Pattern fieldDeclPattern = Pattern.compile("(public|private|protected)\\s+[^;{]+[;{]");
            Matcher fieldMatcher = fieldDeclPattern.matcher(rest);
            
            if (fieldMatcher.find()) {
                String fieldDecl = fieldMatcher.group(0).trim();
                String display = String.format("%s\n  └ %s", dsrefPart, fieldDecl);
                
                Pattern aaaPattern = Pattern.compile("@AAA\\s*\\([^)]*\\)");
                Matcher aaaMatcher = aaaPattern.matcher(rest);
                if (aaaMatcher.find()) {
                    String aaaPart = aaaMatcher.group(0);
                    display = String.format("%s\n  ├ %s\n  └ %s", dsrefPart, aaaPart, fieldDecl);
                }
                
                return display;
            }
        }
        
        Pattern fieldPattern = Pattern.compile(".*\\s+(\\w+)\\s*[=;]");
        Matcher fieldMatcher = fieldPattern.matcher(trimmedLine);
        if (fieldMatcher.find()) {
            int semiColon = trimmedLine.indexOf(';');
            int equalSign = trimmedLine.indexOf('=');
            int end = (semiColon != -1) ? semiColon : ((equalSign != -1) ? equalSign : trimmedLine.length());
            
            String declaration = trimmedLine.substring(0, end).trim();
            if (declaration.length() > 60) {
                return declaration.substring(0, 57) + "...";
            }
            return declaration;
        }
        
        return trimmedLine.length() > 60 ? trimmedLine.substring(0, 57) + "..." : trimmedLine;
    }

    private boolean isClassDeclaration(String line) {
        return line.matches(".*\\b(class|interface|enum)\\s+\\w+.*");
    }

    private boolean isMethodDeclaration(String line) {
        if (isClassDeclaration(line)) return false;
        
        if (line.endsWith(";") && !line.matches(".*(abstract|default)\\s+.*")) return false;

        return line.matches(".*\\w+\\s*\\([^)]*\\).*") && !line.matches(".*[=].*");
    }

    private boolean isConstructorDeclaration(String line, Stack<ContextNode> contextStack) {
        if (contextStack.isEmpty()) return false;
        
        String cleaned = removeStringsAndComments(line);
        String className = extractClassName(contextStack.peek().node.getText());
        if (className == null) return false;
        
        return cleaned.matches(".*\\b" + Pattern.quote(className) + "\\s*\\([^)]*\\).*");
    }

    private boolean isFieldDeclaration(String line) {
        String cleaned = removeStringsAndComments(line);
        
        if (!cleaned.contains(";") && !cleaned.contains("=")) return false;
        if (cleaned.contains("(") || cleaned.contains(")")) return false;
        
        return cleaned.matches(".*\\w+\\s+\\w+.*");
    }

    private String removeStringsAndComments(String line) {
        String result = line.replaceAll("\"([^\"\\\\]|\\\\.)*\"", "\"\"");
        result = result.replaceAll("'([^'\\\\]|\\\\.)*'", "''");
        int commentIndex = result.indexOf("//");
        if (commentIndex >= 0) {
            result = result.substring(0, commentIndex);
        }
        return result;
    }

    private String extractClassName(String text) {
        if (text == null || !text.startsWith("CLASS: ")) return null;
        Pattern pattern = Pattern.compile("\\b(class|interface|enum)\\s+(\\w+)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }

    private int countChar(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) count++;
        }
        return count;
    }

    private static class ContextNode {
        TreeNode node;
        int braceLevel;

        ContextNode(TreeNode node, int braceLevel) {
            this.node = node;
            this.braceLevel = braceLevel;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    public static class TreeNode {
        private String id;              
        private String text;
        private List<TreeNode> children;
        private Integer lineNumber;
        private Boolean itIsFolder = false; 

        public TreeNode() {
            this.id = UUID.randomUUID().toString();
        }

        public TreeNode(String text) {
            this();
            this.text = text;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode> children) {
            this.children = children;
        }

        public Integer getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(Integer lineNumber) {
            this.lineNumber = lineNumber;
        }

        public Boolean getItIsFolder() {
            return itIsFolder;
        }

        public void setItIsFolder(Boolean itIsFolder) {
            this.itIsFolder = itIsFolder;
        }
    }
    
    /**
     * 新增內部類別的 API
     */
    @PostMapping("/addClass")
    @ResponseBody
    public Map<String, Object> addClass(
            @RequestParam("parentClassName") String parentClassName,
            @RequestParam("newClassName") String newClassName,
            @RequestParam("den") String den,
            @RequestParam("cls") String cls,
            @RequestParam("msgName") String msgName,
            @RequestParam("msgCar") String msgCar,
            @RequestParam(value = "msgBoro", required = false, defaultValue = "") String msgBoro,
            @RequestParam("msgChn") String msgChn,
            @RequestParam("fieldName") String fieldName,
            @RequestParam("target") String target,
            @RequestParam("insertBeforeClass") boolean insertBeforeClass) throws Exception {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 從 classpath 讀取檔案 (resources/template 目錄)
            String resourcePath = templatePath + defaultTemplateFile;
            
            // 使用 ClassLoader 讀取 (只讀)
            java.io.InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
            
            if (inputStream == null) {
                result.put("success", false);
                result.put("message", "檔案不存在: resources/" + resourcePath);
                return result;
            }
            
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
            
            String uid = generateUid();
            String backupPath = createBackup(lines);
            
            boolean success = addClassToFile(lines, parentClassName, newClassName, 
                                            den, uid, cls, msgName, msgCar, msgBoro, msgChn, 
                                            fieldName, target, insertBeforeClass);
            
            if (success) {
                // 寫回檔案到外部目錄 (因為 resources 在 JAR 中是唯讀的)
                String outputPath = getOutputFilePath("MyMapping.java");
                java.io.File outputFile = new java.io.File(outputPath);
                
                // 確保輸出目錄存在
                if (outputFile.getParentFile() != null && !outputFile.getParentFile().exists()) {
                    outputFile.getParentFile().mkdirs();
                }
                
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                        new java.io.FileOutputStream(outputFile), "UTF-8"))) {
                    for (String l : lines) {
                        bw.write(l);
                        bw.newLine();
                    }
                }
                
                result.put("success", true);
                result.put("message", "成功在 " + parentClassName + " 中新增類別 " + newClassName);
                result.put("backupPath", backupPath);
                result.put("outputPath", outputPath);
                result.put("uid", uid);
            } else {
                result.put("success", false);
                result.put("message", "找不到父類別 " + parentClassName + " 或目標類別實例 " + target);
            }
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "執行失敗: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * 在檔案中新增類別
     */
    private boolean addClassToFile(List<String> lines, String parentClassName, String newClassName,
                                   String den, String uid, String cls, String msgName, String msgCar,
                                   String msgBoro, String msgChn, String fieldName, String target, 
                                   boolean insertBeforeClass) {
        
        boolean parentFound = false;
        
        for (int i = 0; i < lines.size(); i++) {
            String trimmed = lines.get(i).trim();
            
            if (trimmed.matches(".*class\\s+\\w+\\b.*")) {
                String currentClass = trimmed.replaceAll(".*class\\s+(\\w+).*", "$1");
                
                if (currentClass.equals(parentClassName)) {
                    parentFound = true;
                    System.out.println("找到父類別: " + parentClassName);
                    
                    int classEndLine = findClassEndLine(lines, i);
                    
                    boolean classExists = checkClassExists(lines, i, classEndLine, newClassName);
                    
                    if (classExists) {
                        System.out.println("類別 " + newClassName + " 已存在,跳過新增");
                        return true;
                    }
                    
                    int targetLine = findTargetLine(lines, i, classEndLine, target);
                    
                    if (targetLine == -1) {
                        System.out.println("找不到目標類別實例: " + target);
                        return false;
                    }
                    
                    System.out.println("找到目標類別實例位置: 第 " + (targetLine + 1) + " 行");
                    
                    String parentIndent = "";
                    if (i + 1 < lines.size()) {
                        parentIndent = getIndentationForClass(lines.get(i + 1));
                    }
                    String classIndent = parentIndent;
                    String fieldIndent = parentIndent + "\t";
                    String methodIndent = parentIndent + "\t\t";
                    
                    StringBuilder newClassCode = new StringBuilder();
                    
                    // 1. 類別實例宣告
                    newClassCode.append(classIndent).append("public ").append(newClassName).append(" ")
                               .append(newClassName).append(" = new ").append(newClassName).append("();\n");
                    
                    // 2. DSREF 和 AAA 註解
                    newClassCode.append(classIndent).append("@DSREF(cls = \"").append(cls).append("\")\n");
                    newClassCode.append(classIndent).append("@AAA(msg = {\n");
                    newClassCode.append(classIndent).append("//\n");
                    newClassCode.append(classIndent).append("\t\"name=").append(msgName)
                               .append(",car=").append(msgCar)
                               .append(",boro=").append(msgBoro).append("\",//\n");
                    newClassCode.append(classIndent).append("})\n");
                    
                    // 3. 類別定義開始
                    newClassCode.append(classIndent).append("public static class ").append(newClassName).append(" {\n");
                    
                    // 4. 建構函式
                    newClassCode.append(fieldIndent).append("public ").append(newClassName).append("() {\n");
                    newClassCode.append(methodIndent).append("}\n");
                    
                    // 5. hasMachedProps 方法
                    newClassCode.append(fieldIndent).append("public boolean hasMachedProps() {\n");
                    newClassCode.append(methodIndent).append("return new Worker(msgName).hasMachedProps(this);\n");
                    newClassCode.append(methodIndent).append("}\n");
                    
                    // 6. getSchema 方法
                    newClassCode.append(fieldIndent).append("public String getSchema() {\n");
                    newClassCode.append(methodIndent).append("return new Worker(msgName).getSchema(this);\n");
                    newClassCode.append(methodIndent).append("}\n");
                    
                    // 7. 欄位註解和宣告
                    newClassCode.append(fieldIndent).append("@DSREF(den=\"").append(den)
                               .append("\", uid=\"").append(uid)
                               .append("\", cls=\"").append(cls).append("\")\n");
                    newClassCode.append(fieldIndent).append("@AAA(msg={\n");
                    newClassCode.append(fieldIndent).append("\t\"name=").append(msgName)
                               .append(",car=").append(msgCar)
                               .append(",boro=").append(msgBoro)
                               .append(",chn=").append(msgChn).append("\"\n");
                    newClassCode.append(fieldIndent).append("})\n");
                    newClassCode.append(fieldIndent).append("public String ").append(fieldName).append(";\n");
                    
                    // 8. 類別結束
                    newClassCode.append(classIndent).append("}\n\n");
                    
                    // 根據 insertBeforeClass 決定插入位置
                    int insertPosition;
                    if (insertBeforeClass) {
                        // 插入在目標類別實例宣告之前
                        insertPosition = targetLine;
                        System.out.println("插入模式: 在目標類別實例宣告之前 (第 " + (insertPosition + 1) + " 行)");
                    } else {
                        // 插入在目標類別實例宣告之後
                        insertPosition = targetLine + 1;
                        System.out.println("插入模式: 在目標類別實例宣告之後 (第 " + (insertPosition + 1) + " 行)");
                    }
                    
                    lines.add(insertPosition, newClassCode.toString());
                    
                    System.out.println("成功新增類別 " + newClassName + " 到 " + parentClassName);
                    return true;
                }
            }
        }
        
        return parentFound;
    }

    /**
     * 尋找目標類別實例宣告的行號
     */
    private int findTargetLine(List<String> lines, int startLine, int endLine, String target) {
        String cleanTarget = target.trim().replaceAll("\\s+", " ");
        
        for (int i = startLine; i <= endLine && i < lines.size(); i++) {
            String line = lines.get(i).trim().replaceAll("\\s+", " ");
            
            if (line.equals(cleanTarget)) {
                return i;
            }
            
            String lineWithoutSemicolon = line.replace(";", "").trim();
            String targetWithoutSemicolon = cleanTarget.replace(";", "").trim();
            if (lineWithoutSemicolon.equals(targetWithoutSemicolon)) {
                return i;
            }
        }
        
        return -1;
    }

    /**
     * 找到類別結束的行號
     */
    private int findClassEndLine(List<String> lines, int startIndex) {
        int braceCount = 0;
        boolean foundFirstBrace = false;
        
        for (int i = startIndex; i < lines.size(); i++) {
            String line = lines.get(i);
            
            for (char c : line.toCharArray()) {
                if (c == '{') {
                    braceCount++;
                    foundFirstBrace = true;
                } else if (c == '}') {
                    braceCount--;
                }
            }
            
            if (foundFirstBrace && braceCount == 0) {
                return i;
            }
        }
        
        return lines.size() - 1;
    }

    /**
     * 檢查類別是否已存在於指定範圍內
     */
    private boolean checkClassExists(List<String> lines, int startLine, int endLine, String className) {
        for (int i = startLine; i <= endLine && i < lines.size(); i++) {
            String trimmed = lines.get(i).trim();
            if (trimmed.matches(".*class\\s+" + Pattern.quote(className) + "\\b.*")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 生成 UID
     */
    private String generateUid() {
        Random random = new Random();
        StringBuilder uidStr = new StringBuilder();
        
        Date date = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        int month = Integer.parseInt(monthFormat.format(date));
        
        char monthLetter = (char) ('A' + (month - 1));
        uidStr.append(monthLetter);
        
        for (int i = 0; i < 4; i++) {
            uidStr.append(random.nextInt(10));
        }
        
        return uidStr.toString();
    }

    /**
     * 取得輸出檔案路徑 (從配置檔讀取)
     */
    private String getOutputFilePath(String fileName) {
        return outputDir + "/" + fileName;
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
     * 取得字串開頭的縮排(空白或 Tab)
     */
    private String getIndentationForClass(String line) {
        if (line == null || line.isEmpty()) {
            return "";
        }
        
        int count = 0;
        while (count < line.length() && Character.isWhitespace(line.charAt(count))) {
            count++;
        }
        return line.substring(0, count);
    }
}