package com.example.demo.service;

import com.example.demo.dto.EnhancedFieldInfo;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JavaParser 服務 (修復版)
 * - 修正 @AAA msg 陣列抓取問題
 * - 改善欄位替換邏輯
 */
@Service
public class JavaParserService {

    private final JavaParser javaParser;

    public JavaParserService() {
        this.javaParser = new JavaParser();
    }

    /**
     * 解析 Java 檔案內容
     */
    public ParseResult<CompilationUnit> parseJavaContent(String content) {
        return javaParser.parse(content);
    }

    /**
     * 解析 Java 檔案 (從檔案路徑)
     */
    public ParseResult<CompilationUnit> parseJavaFile(String filePath) throws Exception {
        try (InputStream in = new FileInputStream(filePath)) {
            return javaParser.parse(in, StandardCharsets.UTF_8);
        }
    }

    /**
     * 搜尋指定欄位名稱的所有出現位置
     */
    public List<EnhancedFieldInfo> searchFieldsByName(CompilationUnit cu, String fieldName) {
        List<EnhancedFieldInfo> results = new ArrayList<>();

        if (fieldName == null || fieldName.trim().isEmpty()) return results;
        String target = fieldName.trim();

        System.out.println("開始搜尋欄位: " + target);

        List<FieldDeclaration> allFields = cu.findAll(FieldDeclaration.class);
        System.out.println("檔案中總欄位數: " + allFields.size());

        int matchCount = 0;
        for (FieldDeclaration field : allFields) {
            for (VariableDeclarator variable : field.getVariables()) {
                if (variable.getNameAsString().trim().equals(target)) {
                    matchCount++;
                    try {
                        EnhancedFieldInfo fieldInfo = extractFieldInfo(field, variable, cu);
                        if (fieldInfo != null) {
                            results.add(fieldInfo);
                            System.out.println("找到匹配欄位 #" + matchCount + ": " + target);
                        }
                    } catch (Exception e) {
                        System.err.println("解析欄位 " + target + " 時發生異常: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("搜尋完成，共找到 " + results.size() + " 個匹配欄位");
        return results;
    }

    /**
     * 尋找所有帶有 @DSREF 註解的欄位
     */
    public List<EnhancedFieldInfo> findAllDsrefFields(CompilationUnit cu) {
        List<EnhancedFieldInfo> results = new ArrayList<>();
        
        try {
            System.out.println("=== 開始搜尋 @DSREF 欄位 ===");
            long startTime = System.currentTimeMillis();
            
            List<FieldDeclaration> allFields = cu.findAll(FieldDeclaration.class);
            System.out.println("檔案中總欄位數: " + allFields.size());
            
            int processedCount = 0;
            int dsrefCount = 0;
            
            for (FieldDeclaration field : allFields) {
                processedCount++;
                
                try {
                    boolean hasDsref = field.getAnnotationByName("DSREF").isPresent();
                    
                    if (hasDsref) {
                        dsrefCount++;
                        
                        for (VariableDeclarator variable : field.getVariables()) {
                            try {
                                EnhancedFieldInfo fieldInfo = extractFieldInfo(field, variable, cu);
                                if (fieldInfo != null) {
                                    results.add(fieldInfo);
                                }
                            } catch (Exception e) {
                                System.err.println("提取欄位資訊失敗 [" + variable.getNameAsString() + "]: " + e.getMessage());
                            }
                        }
                        
                        if (dsrefCount % 50 == 0) {
                            System.out.println("進度: 已處理 " + dsrefCount + " 個 @DSREF 欄位");
                        }
                    }
                    
                } catch (Exception e) {
                    System.err.println("處理欄位 #" + processedCount + " 時發生錯誤: " + e.getMessage());
                }
            }
            
            long endTime = System.currentTimeMillis();
            System.out.println("=== @DSREF 欄位搜尋完成 ===");
            System.out.println("@DSREF 欄位: " + results.size() + " / 處理時間: " + (endTime - startTime) + "ms");
            
        } catch (Exception e) {
            System.err.println("搜尋 @DSREF 欄位時發生嚴重錯誤: " + e.getMessage());
            e.printStackTrace();
        }
        
        return results;
    }

    /**
     * 提取欄位詳細資訊（修復版 - 正確抓取 @AAA msg）
     */
    private EnhancedFieldInfo extractFieldInfo(FieldDeclaration field, VariableDeclarator variable, CompilationUnit cu) {
        EnhancedFieldInfo info = new EnhancedFieldInfo();
        
        try {
            String fieldName = variable.getNameAsString();
            info.setFieldName(fieldName);
            
            String originalCode = field.toString();
            info.setOriginalCode(originalCode);
            
            List<String> classPath = extractClassPath(field, cu);
            info.setClassPath(classPath);
            
            // 提取 @DSREF
            EnhancedFieldInfo.DsrefInfo dsref = new EnhancedFieldInfo.DsrefInfo();
            field.getAnnotationByName("DSREF").ifPresent(annotation -> {
                try {
                    annotation.asNormalAnnotationExpr().getPairs().forEach(pair -> {
                        String name = pair.getNameAsString();
                        String value = pair.getValue().toString().replaceAll("\"", "");
                        
                        switch (name) {
                            case "den": dsref.setDen(value); break;
                            case "uid": dsref.setUid(value); break;
                            case "cls": dsref.setCls(value); break;
                        }
                    });
                } catch (Exception e) {
                    System.err.println("解析 @DSREF 註解失敗: " + e.getMessage());
                }
            });
            info.setDsref(dsref);
            
            // 提取 @AAA (修復版 - 使用 Regex 更穩定)
            EnhancedFieldInfo.AaaInfo aaa = new EnhancedFieldInfo.AaaInfo();
            List<EnhancedFieldInfo.MsgInfo> msgList = extractMsgFromCode(originalCode);
            aaa.setMsg(msgList);
            info.setAaa(aaa);
            
            info.setDbEnrichment(new EnhancedFieldInfo.DatabaseEnrichment());
            
            System.out.println("✓ 提取欄位: " + fieldName + " (@AAA: " + msgList.size() + " 個 msg)");
            
        } catch (Exception e) {
            System.err.println("❌ 提取欄位資訊時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
        
        return info;
    }
    
    /**
     * 從原始程式碼中提取 @AAA msg 陣列（使用 Regex，更穩定）
     */
    private List<EnhancedFieldInfo.MsgInfo> extractMsgFromCode(String code) {
        List<EnhancedFieldInfo.MsgInfo> msgList = new ArrayList<>();
        
        try {
            // 尋找 @AAA(msg = { ... })
            Pattern pattern = Pattern.compile("@AAA\\s*\\(\\s*msg\\s*=\\s*\\{([^}]+)\\}", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(code);
            
            if (matcher.find()) {
                String msgArrayContent = matcher.group(1);
                
                // 提取每個 msg 字串（被雙引號包圍）
                Pattern msgPattern = Pattern.compile("\"([^\"]+)\"");
                Matcher msgMatcher = msgPattern.matcher(msgArrayContent);
                
                while (msgMatcher.find()) {
                    String msgStr = msgMatcher.group(1);
                    EnhancedFieldInfo.MsgInfo msg = parseMsgString(msgStr);
                    if (msg != null) {
                        msgList.add(msg);
                    }
                }
            }
            
            // 如果沒有找到 msg，添加一個空的
            if (msgList.isEmpty()) {
                msgList.add(new EnhancedFieldInfo.MsgInfo());
            }
            
        } catch (Exception e) {
            System.err.println("提取 @AAA msg 時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
        
        return msgList;
    }
    
    /**
     * 提取類別路徑
     */
    private List<String> extractClassPath(FieldDeclaration field, CompilationUnit cu) {
        List<String> classPath = new ArrayList<>();
        
        try {
            var parentNode = field.getParentNode();
            
            while (parentNode.isPresent()) {
                var parent = parentNode.get();
                
                if (parent instanceof com.github.javaparser.ast.body.ClassOrInterfaceDeclaration) {
                    com.github.javaparser.ast.body.ClassOrInterfaceDeclaration classDecl = 
                        (com.github.javaparser.ast.body.ClassOrInterfaceDeclaration) parent;
                    classPath.add(0, classDecl.getNameAsString());
                }
                
                parentNode = parent.getParentNode();
            }
        } catch (Exception e) {
            System.err.println("提取類別路徑時發生錯誤: " + e.getMessage());
        }
        
        return classPath;
    }
    
    /**
     * 解析 msg 字串
     */
    private EnhancedFieldInfo.MsgInfo parseMsgString(String msgStr) {
        EnhancedFieldInfo.MsgInfo msg = new EnhancedFieldInfo.MsgInfo();
        
        try {
            String[] pairs = msgStr.split(",");
            
            for (String pair : pairs) {
                String[] kv = pair.split("=", 2);
                if (kv.length == 2) {
                    String key = kv[0].trim();
                    String value = kv[1].trim();
                    
                    switch (key) {
                        case "name": msg.setName(value); break;
                        case "car": msg.setCar(value); break;
                        case "boro": msg.setBoro(value); break;
                        case "chn": msg.setChn(value); break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("解析 msg 字串時發生錯誤: " + msgStr);
        }
        
        return msg;
    }

    /**
     * 生成欄位程式碼（修復版 - 保持正確格式）
     */
    public String generateFieldCode(EnhancedFieldInfo fieldData) {
        StringBuilder sb = new StringBuilder();
        
        // @DSREF 註解
        if (fieldData.getDsref() != null) {
            sb.append("    @DSREF(");
            sb.append("den = \"").append(nullToEmpty(fieldData.getDsref().getDen())).append("\", ");
            sb.append("uid = \"").append(nullToEmpty(fieldData.getDsref().getUid())).append("\", ");
            sb.append("cls = \"").append(nullToEmpty(fieldData.getDsref().getCls())).append("\"");
            sb.append(")\n");
        }
        
        // @AAA 註解
        if (fieldData.getAaa() != null && fieldData.getAaa().getMsg() != null && !fieldData.getAaa().getMsg().isEmpty()) {
            sb.append("    @AAA(msg = {\n");
            
            List<String> msgLines = new ArrayList<>();
            for (var msg : fieldData.getAaa().getMsg()) {
                String msgLine = String.format("        \"name=%s,car=%s,boro=%s,chn=%s\"",
                    nullToEmpty(msg.getName()),
                    nullToEmpty(msg.getCar()),
                    nullToEmpty(msg.getBoro()),
                    nullToEmpty(msg.getChn())
                );
                msgLines.add(msgLine);
            }
            
            sb.append(String.join(",\n", msgLines));
            sb.append("\n    })\n");
        }
        
        // 欄位聲明
        sb.append("    public String ").append(fieldData.getFieldName()).append(";");
        
        return sb.toString();
    }

    /**
     * 在檔案內容中替換欄位（修復版 - 更穩定的替換邏輯）
     */
    public String replaceFieldInContent(String content, EnhancedFieldInfo fieldData, String newFieldCode) {
        String originalCode = fieldData.getOriginalCode();
        
        if (originalCode == null || originalCode.isEmpty()) {
            System.err.println("警告: 原始程式碼為空，無法替換");
            return content;
        }
        
        // 方法 1: 直接替換
        if (content.contains(originalCode)) {
            System.out.println("✓ 使用直接替換");
            return content.replace(originalCode, newFieldCode);
        }
        
        // 方法 2: 使用 Regex 尋找欄位（更穩定）
        try {
            String fieldName = fieldData.getFieldName();
            // 建立匹配該欄位的 Pattern（包含註解到分號）
            String patternStr = "@DSREF[^;]*?public\\s+String\\s+" + Pattern.quote(fieldName) + "\\s*;";
            Pattern pattern = Pattern.compile(patternStr, Pattern.DOTALL);
            Matcher matcher = pattern.matcher(content);
            
            if (matcher.find()) {
                System.out.println("✓ 使用 Regex 替換");
                return matcher.replaceFirst(Matcher.quoteReplacement(newFieldCode));
            }
        } catch (Exception e) {
            System.err.println("Regex 替換失敗: " + e.getMessage());
        }
        
        // 方法 3: 標準化空白後替換
        String normalizedOriginal = normalizeWhitespace(originalCode);
        String normalizedContent = normalizeWhitespace(content);
        
        int index = normalizedContent.indexOf(normalizedOriginal);
        if (index >= 0) {
            System.out.println("✓ 使用標準化替換");
            // 在原始內容中找到對應位置
            return findAndReplace(content, originalCode, newFieldCode);
        }
        
        System.err.println("❌ 所有替換方法都失敗，無法替換欄位: " + fieldData.getFieldName());
        return content;
    }

    /**
     * 智能查找並替換
     */
    private String findAndReplace(String content, String oldCode, String newCode) {
        // 嘗試找到原始程式碼的位置（允許空白差異）
        String[] lines = content.split("\n");
        String[] oldLines = oldCode.split("\n");
        
        for (int i = 0; i <= lines.length - oldLines.length; i++) {
            boolean match = true;
            for (int j = 0; j < oldLines.length; j++) {
                if (!normalizeWhitespace(lines[i + j]).equals(normalizeWhitespace(oldLines[j]))) {
                    match = false;
                    break;
                }
            }
            
            if (match) {
                // 找到匹配位置，進行替換
                StringBuilder result = new StringBuilder();
                for (int k = 0; k < i; k++) {
                    result.append(lines[k]).append("\n");
                }
                result.append(newCode).append("\n");
                for (int k = i + oldLines.length; k < lines.length; k++) {
                    result.append(lines[k]).append("\n");
                }
                return result.toString().replaceAll("\n$", "");
            }
        }
        
        return content;
    }

    /**
     * 標準化空白字元
     */
    private String normalizeWhitespace(String code) {
        if (code == null) return "";
        return code.replaceAll("\\s+", " ").trim();
    }
    
    /**
     * null 轉空字串
     */
    private String nullToEmpty(String str) {
        return str == null ? "" : str;
    }
}