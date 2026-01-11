package com.example.demo.service;

import com.example.demo.utils.DynamicClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射操作服務
 * 使用動態載入的類別進行反射操作
 */
@Service
public class ReflectionService {

    @Autowired
    private DynamicClassLoader dynamicClassLoader;

    @Value("${mig.class.resource-path:template/MyMapping.java}")
    private String classResourcePath;

    @Value("${mig.class.full-name:com.example.demo.MyMapping}")
    private String classFullName;

    /**
     * 從 resources 載入類別並取得所有欄位
     */
    public List<FieldInfo> getAllFieldsFromResource() throws Exception {
        // 從 resources 載入類別
        Class<?> clazz = dynamicClassLoader.loadClassFromResource(classResourcePath);
        
        return extractFieldInfo(clazz);
    }

    /**
     * 從類別中提取欄位資訊
     */
    private List<FieldInfo> extractFieldInfo(Class<?> clazz) {
        List<FieldInfo> fieldInfoList = new ArrayList<>();

        System.out.println("========================================");
        System.out.println("開始提取欄位資訊: " + clazz.getName());
        System.out.println("========================================");

        // 取得所有宣告的欄位（包括 private）
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("找到 " + fields.length + " 個欄位");

        for (Field field : fields) {
            FieldInfo info = new FieldInfo();
            info.setFieldName(field.getName());
            info.setFieldType(field.getType().getSimpleName());

            // 取得所有註解
            Annotation[] annotations = field.getAnnotations();
            List<String> annotationNames = new ArrayList<>();
            
            for (Annotation annotation : annotations) {
                String annotationName = annotation.annotationType().getSimpleName();
                annotationNames.add(annotationName);
                
                // 特別處理 @DSREF 註解
                if ("DSREF".equals(annotationName)) {
                    info.setHasDsref(true);
                    info.setDsrefAnnotation(annotation.toString());
                }
                
                // 特別處理 @AAA 註解
                if ("AAA".equals(annotationName)) {
                    info.setHasAaa(true);
                    info.setAaaAnnotation(annotation.toString());
                }
            }
            
            info.setAnnotations(annotationNames);
            fieldInfoList.add(info);

            System.out.println("欄位: " + field.getName() + 
                             " | 類型: " + field.getType().getSimpleName() + 
                             " | 註解: " + annotationNames);
        }

        System.out.println("========================================");
        System.out.println("欄位提取完成: 共 " + fieldInfoList.size() + " 個");
        System.out.println("========================================");

        return fieldInfoList;
    }

    /**
     * 取得特定註解的欄位
     */
    public List<FieldInfo> getFieldsWithAnnotation(String annotationName) throws Exception {
        Class<?> clazz = dynamicClassLoader.loadClassFromResource(classResourcePath);
        
        List<FieldInfo> result = new ArrayList<>();
        List<FieldInfo> allFields = extractFieldInfo(clazz);
        
        for (FieldInfo fieldInfo : allFields) {
            if (fieldInfo.getAnnotations().contains(annotationName)) {
                result.add(fieldInfo);
            }
        }
        
        return result;
    }

    /**
     * 取得所有帶有 @DSREF 註解的欄位
     */
    public List<FieldInfo> getDsrefFields() throws Exception {
        return getFieldsWithAnnotation("DSREF");
    }

    /**
     * 欄位資訊 DTO
     */
    public static class FieldInfo {
        private String fieldName;
        private String fieldType;
        private List<String> annotations = new ArrayList<>();
        private boolean hasDsref = false;
        private boolean hasAaa = false;
        private String dsrefAnnotation;
        private String aaaAnnotation;

        // Getters and Setters
        public String getFieldName() { return fieldName; }
        public void setFieldName(String fieldName) { this.fieldName = fieldName; }

        public String getFieldType() { return fieldType; }
        public void setFieldType(String fieldType) { this.fieldType = fieldType; }

        public List<String> getAnnotations() { return annotations; }
        public void setAnnotations(List<String> annotations) { this.annotations = annotations; }

        public boolean isHasDsref() { return hasDsref; }
        public void setHasDsref(boolean hasDsref) { this.hasDsref = hasDsref; }

        public boolean isHasAaa() { return hasAaa; }
        public void setHasAaa(boolean hasAaa) { this.hasAaa = hasAaa; }

        public String getDsrefAnnotation() { return dsrefAnnotation; }
        public void setDsrefAnnotation(String dsrefAnnotation) { this.dsrefAnnotation = dsrefAnnotation; }

        public String getAaaAnnotation() { return aaaAnnotation; }
        public void setAaaAnnotation(String aaaAnnotation) { this.aaaAnnotation = aaaAnnotation; }
    }
}