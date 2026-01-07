package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class JsonModifierService {
    
    private final ObjectMapper objectMapper;
    
    public JsonModifierService() {
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * 添加 TW_LimitDateTime2 元素到 AdditionalInformation 中
     */
    public String addTW_LimitDateTime2(String jsonContent) throws IOException {
        JsonNode rootNode = objectMapper.readTree(jsonContent);
        
        // 導航到 AdditionalInformation 元素
        JsonNode schema = rootNode.get("xsd:schema");
        JsonNode element = schema.get("xsd:element");
        JsonNode complexType = element.get("xsd:complexType");
        JsonNode sequence = complexType.get("xsd:sequence");
        JsonNode elements = sequence.get("xsd:element");
        
        // 尋找 AdditionalInformation
        ObjectNode additionalInfo = null;
        if (elements.isArray()) {
            for (JsonNode el : elements) {
                if ("AdditionalInformation".equals(el.get("@name").asText())) {
                    additionalInfo = (ObjectNode) el;
                    break;
                }
            }
        }
        
        if (additionalInfo == null) {
            throw new IllegalStateException("找不到 AdditionalInformation 元素");
        }
        
        // 取得或創建 xsd:element 陣列
        JsonNode innerComplexType = additionalInfo.get("xsd:complexType");
        JsonNode innerSequence = innerComplexType.get("xsd:sequence");
        JsonNode innerElements = innerSequence.get("xsd:element");
        
        ArrayNode elementsArray;
        if (innerElements.isArray()) {
            elementsArray = (ArrayNode) innerElements;
        } else {
            elementsArray = objectMapper.createArrayNode();
            elementsArray.add(innerElements);
            ((ObjectNode) innerSequence).set("xsd:element", elementsArray);
        }
        
        // 創建新的 LimitDateTime2 元素
        ObjectNode newElement = createTW_LimitDateTime2Element();
        
        // 添加到陣列
        elementsArray.add(newElement);
        
        // 轉換回 JSON 字串
        return objectMapper.writerWithDefaultPrettyPrinter()
                          .writeValueAsString(rootNode);
    }
    
    /**
     * 創建 TW_LimitDateTime2 元素
     */
    private ObjectNode createTW_LimitDateTime2Element() {
        ObjectNode element = objectMapper.createObjectNode();
        element.put("@name", "TW_LimitDateTime2");
        element.put("@type", "ds:AdditionalInformation2Limit2DateTimeType");
        
        // 創建 annotation
        ObjectNode annotation = objectMapper.createObjectNode();
        ObjectNode documentation = objectMapper.createObjectNode();
        
        documentation.put("@xml:lang", "en");
        documentation.put("ccts:UniqueID", "WCO");
        documentation.put("ccts:DictionaryEntryName", 
                         "Additional Information2. Limit2. Date Time");
        documentation.put("ccts:Definition", 
                         "Date and time by when the event has to be completed2.");
        documentation.put("ccts:Cardinality", "1");
        documentation.put("ccts:ObjectClassTerm", "Additional Information2");
        documentation.put("ccts:PropertyTerm", "Limit2");
        documentation.put("ccts:RepresentationTerm", "Date Time");
        documentation.put("tsw:ChineseName", "補辦期限2");
        documentation.set("tsw:Remark", objectMapper.createObjectNode());
        documentation.put("tsw:Format", "an8");
        
        annotation.set("xsd:documentation", documentation);
        element.set("xsd:annotation", annotation);
        
        return element;
    }
    
    /**
     * 驗證 JSON 格式
     */
    public boolean isValidJson(String jsonContent) {
        try {
            objectMapper.readTree(jsonContent);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}