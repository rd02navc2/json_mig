package com.example.demo.utils;

import org.springframework.stereotype.Component;

import javax.tools.*;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 動態類別載入器（簡化版）
 * 從 resources 目錄讀取 .java 檔案並動態編譯載入
 * 自動從原始碼中提取 package 和 class 名稱
 */
@Component
public class DynamicClassLoader {

    /**
     * 從 resources 目錄載入並編譯 Java 類別
     * 自動從原始碼提取完整類別名稱
     * 
     * @param resourcePath resources 下的路徑，例如: "template/MyMapping.java"
     * @return 編譯後的 Class 物件
     */
    public Class<?> loadClassFromResource(String resourcePath) throws Exception {
        System.out.println("========================================");
        System.out.println("動態載入類別");
        System.out.println("資源路徑: " + resourcePath);
        System.out.println("========================================");

        // 1. 從 resources 讀取 Java 原始碼
        String sourceCode = readResourceFile(resourcePath);
        if (sourceCode == null || sourceCode.isEmpty()) {
            throw new IOException("無法讀取資源檔案: " + resourcePath);
        }
        System.out.println("✓ 已讀取原始碼 (" + sourceCode.length() + " bytes)");

        // 2. 自動提取完整類別名稱
        String fullClassName = extractFullClassName(sourceCode);
        System.out.println("✓ 提取類別名稱: " + fullClassName);

        // 3. 動態編譯
        Class<?> clazz = compileAndLoad(fullClassName, sourceCode);
        System.out.println("✓ 類別載入成功: " + clazz.getName());
        System.out.println("========================================");

        return clazz;
    }

    /**
     * 從檔案系統路徑載入 Java 類別
     * 自動從原始碼提取完整類別名稱
     * 
     * @param filePath 檔案系統路徑，例如: "C:/Users/User/Downloads/template/MyMapping.java"
     * @return 編譯後的 Class 物件
     */
    public Class<?> loadClassFromFile(String filePath) throws Exception {
        System.out.println("========================================");
        System.out.println("從檔案載入類別");
        System.out.println("檔案路徑: " + filePath);
        System.out.println("========================================");

        // 讀取檔案
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new FileNotFoundException("檔案不存在: " + filePath);
        }

        String sourceCode = Files.readString(path, StandardCharsets.UTF_8);
        System.out.println("✓ 已讀取原始碼 (" + sourceCode.length() + " bytes)");

        // 自動提取完整類別名稱
        String fullClassName = extractFullClassName(sourceCode);
        System.out.println("✓ 提取類別名稱: " + fullClassName);

        // 動態編譯
        Class<?> clazz = compileAndLoad(fullClassName, sourceCode);
        System.out.println("✓ 類別載入成功: " + clazz.getName());
        System.out.println("========================================");

        return clazz;
    }

    /**
     * 直接從原始碼字串載入類別
     * 自動從原始碼提取完整類別名稱
     * 
     * @param sourceCode Java 原始碼
     * @return 編譯後的 Class 物件
     */
    public Class<?> loadClassFromSource(String sourceCode) throws Exception {
        String fullClassName = extractFullClassName(sourceCode);
        System.out.println("從原始碼載入類別: " + fullClassName);
        return compileAndLoad(fullClassName, sourceCode);
    }

    /**
     * 從原始碼中提取完整類別名稱（package + class name）
     * 
     * @param sourceCode Java 原始碼
     * @return 完整類別名稱，例如: "com.example.demo.MyMapping"
     */
    private String extractFullClassName(String sourceCode) throws Exception {
        // 1. 提取 package 名稱
        String packageName = "";
        Pattern packagePattern = Pattern.compile("package\\s+([a-zA-Z_][a-zA-Z0-9_.]*);");
        Matcher packageMatcher = packagePattern.matcher(sourceCode);
        
        if (packageMatcher.find()) {
            packageName = packageMatcher.group(1).trim();
            System.out.println("  找到 package: " + packageName);
        } else {
            System.out.println("  ⚠️ 未找到 package 宣告（使用預設 package）");
        }

        // 2. 提取 class 名稱
        // 匹配: public class ClassName 或 class ClassName
        Pattern classPattern = Pattern.compile("(?:public\\s+)?class\\s+([a-zA-Z_][a-zA-Z0-9_]*)");
        Matcher classMatcher = classPattern.matcher(sourceCode);
        
        String className = null;
        if (classMatcher.find()) {
            className = classMatcher.group(1).trim();
            System.out.println("  找到 class: " + className);
        } else {
            throw new Exception("無法從原始碼中提取類別名稱");
        }

        // 3. 組合完整類別名稱
        String fullClassName;
        if (packageName.isEmpty()) {
            fullClassName = className;
        } else {
            fullClassName = packageName + "." + className;
        }

        return fullClassName;
    }

    /**
     * 編譯並載入類別
     */
    private Class<?> compileAndLoad(String fullClassName, String sourceCode) throws Exception {
        // 1. 取得 Java 編譯器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new IllegalStateException(
                "找不到 Java 編譯器！請確認使用 JDK (而非 JRE) 執行此程式。"
            );
        }

        // 2. 建立臨時目錄存放編譯後的 .class 檔案
        Path tempDir = Files.createTempDirectory("dynamic-compile-");
        System.out.println("臨時編譯目錄: " + tempDir);

        // 3. 準備原始碼檔案
        String simpleClassName = extractSimpleClassName(fullClassName);
        Path sourceFile = tempDir.resolve(simpleClassName + ".java");
        Files.writeString(sourceFile, sourceCode, StandardCharsets.UTF_8);
        System.out.println("✓ 原始碼已寫入: " + sourceFile);

        // 4. 設定編譯選項
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

        // 設定輸出目錄
        List<String> options = Arrays.asList(
            "-d", tempDir.toString(),
            "-encoding", "UTF-8"
        );

        // 取得要編譯的檔案
        Iterable<? extends JavaFileObject> compilationUnits = 
            fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile.toFile()));

        // 5. 執行編譯
        System.out.println("開始編譯...");
        JavaCompiler.CompilationTask task = compiler.getTask(
            null, 
            fileManager, 
            diagnostics, 
            options, 
            null, 
            compilationUnits
        );

        boolean success = task.call();

        // 6. 檢查編譯結果
        if (!success) {
            StringBuilder errorMsg = new StringBuilder("編譯失敗:\n");
            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                errorMsg.append("行 ")
                       .append(diagnostic.getLineNumber())
                       .append(": ")
                       .append(diagnostic.getMessage(null))
                       .append("\n");
            }
            fileManager.close();
            throw new Exception(errorMsg.toString());
        }

        System.out.println("✓ 編譯成功");
        fileManager.close();

        // 7. 使用 URLClassLoader 載入編譯後的類別
        URL[] urls = { tempDir.toUri().toURL() };
        URLClassLoader classLoader = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
        
        Class<?> clazz = classLoader.loadClass(fullClassName);

        return clazz;
    }

    /**
     * 從 resources 讀取檔案內容
     */
    private String readResourceFile(String resourcePath) throws IOException {
        // 嘗試從 ClassLoader 載入
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
        
        if (inputStream == null) {
            // 嘗試從當前類別載入
            inputStream = getClass().getResourceAsStream("/" + resourcePath);
        }

        if (inputStream == null) {
            throw new FileNotFoundException("找不到資源: " + resourcePath);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }

    /**
     * 從完整類別名稱提取簡單類別名稱
     * 例如: "com.example.demo.MyMapping" -> "MyMapping"
     */
    private String extractSimpleClassName(String fullClassName) {
        int lastDot = fullClassName.lastIndexOf('.');
        return lastDot >= 0 ? fullClassName.substring(lastDot + 1) : fullClassName;
    }

    /**
     * 從完整類別名稱提取套件名稱
     * 例如: "com.example.demo.MyMapping" -> "com.example.demo"
     */
    private String extractPackageName(String fullClassName) {
        int lastDot = fullClassName.lastIndexOf('.');
        return lastDot >= 0 ? fullClassName.substring(0, lastDot) : "";
    }
}