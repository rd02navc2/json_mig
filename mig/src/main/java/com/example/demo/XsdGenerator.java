package com.example.demo;

import java.util.List;
import java.util.Map;

public class XsdGenerator {

    public static String generate(MappingConfig config) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n");
        appendComplexType(sb, config);
        sb.append("</xs:schema>\n");
        return sb.toString();
    }

    private static void appendComplexType(StringBuilder sb, MappingConfig config) {
        String typeName = config.getName();
        sb.append("  <xs:complexType name=\"").append(typeName).append("\">\n");
        sb.append("    <xs:sequence>\n");

        // 處理欄位
        for (Map.Entry<String, FieldConfig> entry : config.getFields().entrySet()) {
            FieldConfig field = entry.getValue();
            String fieldName = field.getName();
            String fieldType = mapType(field.getType());

            String minOccurs = "1";
            String maxOccurs = "1";
            List<MappingRule> rules = field.getMappings();
            String annotation = null;

            if (rules != null && !rules.isEmpty()) {
                MappingRule rule = rules.get(0); // 只取第一個 rule 作示範
                String car = rule.getCar();
                if (car != null) {
                    if (car.startsWith("0")) minOccurs = "0";
                    if (car.contains("..")) maxOccurs = car.split("\\.\\.")[1];
                }
                annotation = rule.getChn();
            }

            sb.append("      <xs:element name=\"").append(fieldName).append("\" type=\"")
              .append(fieldType).append("\" minOccurs=\"").append(minOccurs)
              .append("\" maxOccurs=\"").append(maxOccurs).append("\">");

            if (annotation != null) {
                sb.append("\n        <xs:annotation>\n")
                  .append("          <xs:documentation>").append(annotation)
                  .append("</xs:documentation>\n")
                  .append("        </xs:annotation>\n");
            }
            sb.append("</xs:element>\n");
        }

        // 處理子 class
        for (Map.Entry<String, MappingConfig> entry : config.getChildren().entrySet()) {
            MappingConfig child = entry.getValue();
            sb.append("      <xs:element name=\"").append(child.getName())
              .append("\" type=\"").append(child.getName())
              .append("\" minOccurs=\"0\" maxOccurs=\"1\" />\n");
        }

        sb.append("    </xs:sequence>\n");
        sb.append("  </xs:complexType>\n");

        // 遞迴生成子 class
        for (Map.Entry<String, MappingConfig> entry : config.getChildren().entrySet()) {
            appendComplexType(sb, entry.getValue());
        }
    }

    private static String mapType(String type) {
        if (type == null) return "xs:string";
        switch (type.toLowerCase()) {
            case "string": return "xs:string";
            case "number": return "xs:decimal";
            case "datetime": return "xs:dateTime";
            default: return "xs:string";
        }
    }
}
