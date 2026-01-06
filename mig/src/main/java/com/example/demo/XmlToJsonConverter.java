package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlToJsonConverter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static ObjectNode convertXmlToJson(File xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        ObjectNode rootNode = MAPPER.createObjectNode();
        Element rootElement = document.getDocumentElement();

        rootNode.set(rootElement.getNodeName(), elementToJson(rootElement));
        return rootNode;
    }

    private static JsonNode elementToJson(Element element) {
        ObjectNode jsonObject = MAPPER.createObjectNode();

        // 1️ Attributes
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            jsonObject.put("@" + attr.getName(), attr.getValue());
        }

        // 2️ Child elements
        Map<String, ArrayNode> arrayTracker = new HashMap<>();
        NodeList children = element.getChildNodes();

        boolean hasElementChild = false;

        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                hasElementChild = true;
                Element child = (Element) node;
                String name = child.getNodeName();
                JsonNode childJson = elementToJson(child);

                if (jsonObject.has(name)) {
                    // Already exists → convert to array
                    if (!arrayTracker.containsKey(name)) {
                        ArrayNode array = MAPPER.createArrayNode();
                        array.add(jsonObject.get(name));
                        jsonObject.set(name, array);
                        arrayTracker.put(name, array);
                    }
                    arrayTracker.get(name).add(childJson);
                } else {
                    jsonObject.set(name, childJson);
                }
            }
        }

        // 3️ Text content
        String textContent = element.getTextContent().trim();
        if (!textContent.isEmpty() && !hasElementChild) {
            return new TextNode(textContent);
        }

        return jsonObject;
    }

 // === 測試入口 ===
    public static void main(String[] args) throws Exception {

        File xmlFile = new File("src/main/resources/N5108.xml");

        // 這裡雖然叫 outputXsd，但實際輸出是 JSON 內容
        File outputJSON = new File("src/main/resources/N5108.json");

        ObjectNode json = convertXmlToJson(xmlFile);

        // 直接輸出成檔案（Pretty JSON）
        MAPPER
            .writerWithDefaultPrettyPrinter()
            .writeValue(outputJSON, json);

        System.out.println("XML 已成功轉換並輸出至檔案：");
        System.out.println("   " + outputJSON.getAbsolutePath());
    }
}
