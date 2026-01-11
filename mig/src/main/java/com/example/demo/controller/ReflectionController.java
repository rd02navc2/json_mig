package com.example.demo.controller;

import com.example.demo.service.ReflectionService;
import com.example.demo.utils.DynamicClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 反射測試控制器
 * 提供 API 來測試動態類別載入功能
 */
@RestController
@RequestMapping("/api/reflection")
public class ReflectionController {

    @Autowired
    private DynamicClassLoader dynamicClassLoader;

    @Autowired
    private ReflectionService reflectionService;

    /**
     * 測試從 resources 載入類別
     * GET /api/reflection/test-load
     */
    @GetMapping("/test-load")
    public Map<String, Object> testLoadClass() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // ✅ 簡化版 - 只需要一個參數
            Class<?> clazz = dynamicClassLoader.loadClassFromResource("template/MyMapping.java");
            
            response.put("success", true);
            response.put("className", clazz.getName());
            response.put("packageName", clazz.getPackage().getName());
            response.put("simpleClassName", clazz.getSimpleName());
            response.put("fieldCount", clazz.getDeclaredFields().length);
            response.put("message", "類別載入成功");
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            e.printStackTrace();
        }
        
        return response;
    }

    /**
     * 取得所有欄位資訊
     * GET /api/reflection/fields
     */
    @GetMapping("/fields")
    public Map<String, Object> getAllFields() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            List<ReflectionService.FieldInfo> fields = reflectionService.getAllFieldsFromResource();
            
            response.put("success", true);
            response.put("count", fields.size());
            response.put("fields", fields);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            e.printStackTrace();
        }
        
        return response;
    }

    /**
     * 取得帶有 @DSREF 註解的欄位
     * GET /api/reflection/dsref-fields
     */
    @GetMapping("/dsref-fields")
    public Map<String, Object> getDsrefFields() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            List<ReflectionService.FieldInfo> fields = reflectionService.getDsrefFields();
            
            response.put("success", true);
            response.put("count", fields.size());
            response.put("fields", fields);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            e.printStackTrace();
        }
        
        return response;
    }

    /**
     * 從檔案系統路徑載入類別
     * POST /api/reflection/load-from-file
     */
    @PostMapping("/load-from-file")
    public Map<String, Object> loadFromFile(@RequestParam("filePath") String filePath) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // ✅ 簡化版 - 只需要檔案路徑
            Class<?> clazz = dynamicClassLoader.loadClassFromFile(filePath);
            
            response.put("success", true);
            response.put("filePath", filePath);
            response.put("className", clazz.getName());
            response.put("packageName", clazz.getPackage().getName());
            response.put("fieldCount", clazz.getDeclaredFields().length);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            e.printStackTrace();
        }
        
        return response;
    }

    /**
     * 從原始碼載入類別
     * POST /api/reflection/load-from-source
     */
    @PostMapping("/load-from-source")
    public Map<String, Object> loadFromSource(@RequestBody SourceCodeRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // ✅ 簡化版 - 只需要原始碼
            Class<?> clazz = dynamicClassLoader.loadClassFromSource(request.getSourceCode());
            
            response.put("success", true);
            response.put("className", clazz.getName());
            response.put("packageName", clazz.getPackage().getName());
            response.put("fieldCount", clazz.getDeclaredFields().length);
            response.put("methodCount", clazz.getDeclaredMethods().length);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            e.printStackTrace();
        }
        
        return response;
    }

    /**
     * 請求 DTO
     */
    public static class SourceCodeRequest {
        private String sourceCode;

        public String getSourceCode() { return sourceCode; }
        public void setSourceCode(String sourceCode) { this.sourceCode = sourceCode; }
    }
}