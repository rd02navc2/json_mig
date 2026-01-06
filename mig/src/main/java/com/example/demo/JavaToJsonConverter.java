package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaToJsonConverter {

    public static void main(String[] args) throws Exception {
        String javaFilePath = "C:/Users/user/eclipse-workspace/mig/src/main/resources/template/MyMapping.java";
        String outputJsonPath = "C:/Users/user/eclipse-workspace/mig/src/main/resources/template/MyMapping.json";

        // 1️⃣ 讀取 Java 檔案
        String javaContent = Files.readString(new File(javaFilePath).toPath(), StandardCharsets.UTF_8);

        // 2️⃣ 解析 Java
        ParseResult<CompilationUnit> parseResult = new JavaParser().parse(javaContent);
        if (!parseResult.isSuccessful() || !parseResult.getResult().isPresent()) {
            parseResult.getProblems().forEach(System.out::println);
            throw new RuntimeException("Java 解析失敗！");
        }

        CompilationUnit cu = parseResult.getResult().get();

        // 3️⃣ 取得主類別
        ClassOrInterfaceDeclaration mainClass = cu.getClassByName("MyMapping")
                .orElseThrow(() -> new RuntimeException("找不到 MyMapping 類別"));

        // 4️⃣ 轉換成 MappingConfig
        MappingConfig config = convertClassToConfig(mainClass);

        // 5️⃣ 寫成 JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJsonPath), config);

        System.out.println("JSON 已生成: " + outputJsonPath);
    }

    private static MappingConfig convertClassToConfig(ClassOrInterfaceDeclaration cls) {
        MappingConfig cfg = new MappingConfig();
        cfg.setName(cls.getNameAsString());

        // 取 DSREF.cls
        cls.getAnnotationByName("DSREF")
           .ifPresent(a -> cfg.setCls(a.toString())); // 可以再改成解析屬性

        // 取 AAA.msg
        cls.getAnnotationByName("AAA")
           .ifPresent(a -> cfg.setMessages(List.of(a.toString()))); // 可改解析 msg

        Map<String, FieldConfig> fields = new LinkedHashMap<>();
        Map<String, MappingConfig> children = new LinkedHashMap<>();

        for (BodyDeclaration<?> member : cls.getMembers()) {
            if (member.isFieldDeclaration()) {
                FieldDeclaration f = member.asFieldDeclaration();
                FieldConfig fc = new FieldConfig();
                fc.setName(f.getVariables().get(0).getNameAsString());
                fc.setType("string"); // 先統一 string
                fields.put(fc.getName(), fc);
            } else if (member.isClassOrInterfaceDeclaration()) {
                ClassOrInterfaceDeclaration inner = member.asClassOrInterfaceDeclaration();
                children.put(inner.getNameAsString(), convertClassToConfig(inner));
            }
        }

        cfg.setFields(fields);
        cfg.setChildren(children);
        return cfg;
    }
}
