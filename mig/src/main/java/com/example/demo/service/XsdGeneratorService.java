package com.example.demo.service;

import com.example.demo.MyConst;
import com.example.demo.phase1.DateTimeFormater;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.InputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

@Service
public class XsdGeneratorService {

    private static final String XSD_NS = "http://www.w3.org/2001/XMLSchema";
    private static final String XSD_PREFIX = "xsd";

    /**
     * 支援 InputStream 的 XSD 生成（jar-safe）
     * rootEleName 例如: "Response"
     * msgName     例如: "N5107"
     */
    public void generateXsdFromJson(InputStream jsonInput, File outputXsd,
                                    String rootEleName, String msgName) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonInput);

        // Debug: 印出 JSON 結構
        System.out.println("Root JSON keys: " + rootNode.fieldNames());
        
        Document doc = createDocument();

        // 1. XML stylesheet
        addStylesheetProcessingInstruction(doc);

        // 2. schema root
        Element schema = createSchemaElement(doc, msgName);
        doc.appendChild(schema);

        // 3. import
        addImportElements(schema, doc);

        // 4. 版權註解
        addCopyrightComment(schema, doc, msgName);

        // 5. 根元素 Response + 結構
        Element rootElement = createRootElement(doc, rootEleName, rootNode);
        schema.appendChild(rootElement);

        // 6. 輸出檔案
        writeXsdToFile(doc, outputXsd);
    }

    /** 建立 Document */
    private Document createDocument() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.newDocument();
    }

    /** 加入 XSLT 指令 */
    private void addStylesheetProcessingInstruction(Document doc) {
        ProcessingInstruction pi = doc.createProcessingInstruction(
                "xml-stylesheet",
                "href=\"GenHTML_TW.xslt\" type=\"text/xsl\""
        );
        doc.appendChild(pi);
    }

    /**
     * 建立 schema 根元素
     */
    private Element createSchemaElement(Document doc, String msgName) {
        Element schema = doc.createElementNS(XSD_NS, XSD_PREFIX + ":schema");
        String msgVersion = MyConst.getMsgVersion(msgName);

        String targetNs = "urn:wco:datamodel:TW:" + msgName + ":" + msgVersion;

        schema.setAttribute("xmlns", targetNs);
        schema.setAttribute("xmlns:ccts",
                "urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2");
        schema.setAttribute("xmlns:ds", "urn:wco:datamodel:WCO:DS:1");
        schema.setAttribute("xmlns:tsw", "urn:SingleWindow:TW");
        schema.setAttribute("xmlns:twds", "urn:wco:datamodel:TW:DS:1");
        schema.setAttribute("xmlns:xsd", XSD_NS);

        schema.setAttribute("attributeFormDefault", "unqualified");
        schema.setAttribute("elementFormDefault", "qualified");
        schema.setAttribute("targetNamespace", targetNs);
        schema.setAttribute("version", msgVersion);

        return schema;
    }

    /** 加入 import */
    private void addImportElements(Element schema, Document doc) {
        schema.appendChild(createImportElement(doc,
                "urn:wco:datamodel:WCO:DS:1",
                "../common/WCODS_1p0.xsd"));
        schema.appendChild(createImportElement(doc,
                "urn:wco:datamodel:TW:DS:1",
                "../common/TWDS_1p0.xsd"));
    }

    private Element createImportElement(Document doc, String namespace, String schemaLocation) {
        Element importEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":import");
        importEle.setAttribute("namespace", namespace);
        importEle.setAttribute("schemaLocation", schemaLocation);
        return importEle;
    }

    /** 版權註解：放在 import 之後 */
    private void addCopyrightComment(Element schema, Document doc, String msgName) {
        String commentText = String.format(
                "\n\tSchema agency\t: Taiwan Customs\n" +
                "\tSchema type\t\t\t: %s\n" +
                "\tSchema version\t\t: %s\n" +
                "\tSchema date\t\t\t: %s\n\n" +
                "\tCopyright (C) Taiwan Customs (%s). All Rights Reserved.\n",
                msgName,
                MyConst.getMsgVersion(msgName),
                DateTimeFormater.getDateForm(),
                DateTimeFormater.getYearForm()
        );
        Comment comment = doc.createComment(commentText);
        schema.appendChild(comment);
    }

    /**
     * 建立根元素 Response
     * JSON 結構應該是：
     * {
     *   "xsd:schema": {
     *     "xsd:element": {
     *       "@name": "Response",
     *       "xsd:annotation": { ... },
     *       "xsd:complexType": {
     *         "xsd:sequence": {
     *           "xsd:element": [ ... ]
     *         }
     *       }
     *     }
     *   }
     * }
     */
    private Element createRootElement(Document doc, String rootEleName, JsonNode rootNode) {
        Element rootElement = doc.createElementNS(XSD_NS, XSD_PREFIX + ":element");
        rootElement.setAttribute("name", rootEleName);

        // 嘗試多種可能的 JSON 結構
        JsonNode elementDef = findElementDefinition(rootNode, rootEleName);
        
        if (elementDef == null) {
            System.err.println("Warning: Cannot find element definition for: " + rootEleName);
            System.err.println("Available keys: " + rootNode.fieldNames());
            return rootElement;
        }

        System.out.println("Found element definition for: " + rootEleName);

        // annotation
        if (elementDef.has("xsd:annotation")) {
            //dc-
        	rootElement.appendChild(createAnnotation(doc, elementDef.get("xsd:annotation")));
        }

        // complexType
        if (elementDef.has("xsd:complexType")) {
            JsonNode complexType = elementDef.get("xsd:complexType");
            Element complexTypeEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":complexType");
            
            if (complexType.has("xsd:sequence")) {
                JsonNode sequence = complexType.get("xsd:sequence");
                Element sequenceEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":sequence");
                
                if (sequence.has("xsd:element")) {
                    JsonNode elements = sequence.get("xsd:element");
                    if (elements.isArray()) {
                        for (JsonNode field : elements) {
                            sequenceEle.appendChild(createFieldElement(doc, field));
                        }
                    } else {
                        sequenceEle.appendChild(createFieldElement(doc, elements));
                    }
                }
                
                complexTypeEle.appendChild(sequenceEle);
            }
            
            rootElement.appendChild(complexTypeEle);
        }

        return rootElement;
    }

    /**
     * 從 JSON 中尋找元素定義
     * 支援多種可能的 JSON 結構
     */
    private JsonNode findElementDefinition(JsonNode rootNode, String elementName) {
        // 方式 1: { "Response": { ... } }
        if (rootNode.has(elementName)) {
            return rootNode.get(elementName);
        }
        
        // 方式 2: { "xsd:schema": { "xsd:element": { "@name": "Response", ... } } }
        if (rootNode.has("xsd:schema")) {
            JsonNode schema = rootNode.get("xsd:schema");
            if (schema.has("xsd:element")) {
                JsonNode element = schema.get("xsd:element");
                if (element.has("@name") && element.get("@name").asText().equals(elementName)) {
                    return element;
                }
            }
        }
        
        // 方式 3: 直接是 element 定義
        if (rootNode.has("@name") && rootNode.get("@name").asText().equals(elementName)) {
            return rootNode;
        }
        
        return null;
    }

    /**
     * 建立欄位元素（遞迴子元素 + annotation + restriction）
     */
    private Element createFieldElement(Document doc, JsonNode fieldNode) {
        Element fieldEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":element");

        // name 屬性
        if (fieldNode.has("@name")) {
            fieldEle.setAttribute("name", fieldNode.get("@name").asText());
        }

        // minOccurs / maxOccurs
        if (fieldNode.has("@minOccurs")) {
            fieldEle.setAttribute("minOccurs", fieldNode.get("@minOccurs").asText());
        }
        if (fieldNode.has("@maxOccurs")) {
            fieldEle.setAttribute("maxOccurs", fieldNode.get("@maxOccurs").asText());
        }

        // type 屬性
        String type = fieldNode.has("@type") ? fieldNode.get("@type").asText() : null;
        if (type != null) {
            fieldEle.setAttribute("type", type);
        }

        // annotation
        if (fieldNode.has("xsd:annotation")) {
            fieldEle.appendChild(createAnnotation(doc, fieldNode.get("xsd:annotation")));
        }

        // complexType
        if (fieldNode.has("xsd:complexType")) {
            Element complexTypeEle = processComplexType(doc, fieldNode.get("xsd:complexType"));
            if (complexTypeEle != null) {
                // 如果有 complexType，移除 type 屬性
                fieldEle.removeAttribute("type");
                fieldEle.appendChild(complexTypeEle);
            }
        }

        // simpleType
        if (fieldNode.has("xsd:simpleType")) {
            Element simpleTypeEle = processSimpleType(doc, fieldNode.get("xsd:simpleType"));
            if (simpleTypeEle != null) {
                fieldEle.removeAttribute("type");
                fieldEle.appendChild(simpleTypeEle);
            }
        }

        return fieldEle;
    }

    /**
     * 處理 complexType
     */
    private Element processComplexType(Document doc, JsonNode complexTypeNode) {
        Element complexTypeEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":complexType");

        // sequence
        if (complexTypeNode.has("xsd:sequence")) {
            JsonNode sequence = complexTypeNode.get("xsd:sequence");
            Element sequenceEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":sequence");
            
            if (sequence.has("xsd:element")) {
                JsonNode elements = sequence.get("xsd:element");
                if (elements.isArray()) {
                    for (JsonNode field : elements) {
                        sequenceEle.appendChild(createFieldElement(doc, field));
                    }
                } else {
                    sequenceEle.appendChild(createFieldElement(doc, elements));
                }
            }
            
            complexTypeEle.appendChild(sequenceEle);
        }

        // simpleContent
        if (complexTypeNode.has("xsd:simpleContent")) {
            JsonNode simpleContent = complexTypeNode.get("xsd:simpleContent");
            Element simpleContentEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":simpleContent");
            
            if (simpleContent.has("xsd:restriction")) {
                Element restrictionEle = processRestriction(doc, simpleContent.get("xsd:restriction"));
                if (restrictionEle != null) {
                    simpleContentEle.appendChild(restrictionEle);
                }
            }
            
            complexTypeEle.appendChild(simpleContentEle);
        }

        return complexTypeEle;
    }

    /**
     * 處理 simpleType
     */
    private Element processSimpleType(Document doc, JsonNode simpleTypeNode) {
        Element simpleTypeEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":simpleType");

        if (simpleTypeNode.has("xsd:restriction")) {
            Element restrictionEle = processRestriction(doc, simpleTypeNode.get("xsd:restriction"));
            if (restrictionEle != null) {
                simpleTypeEle.appendChild(restrictionEle);
            }
        }

        return simpleTypeEle;
    }

    /**
     * 處理 restriction
     */
    private Element processRestriction(Document doc, JsonNode restrictionNode) {
        String baseType = restrictionNode.has("@base") ? 
            restrictionNode.get("@base").asText() : "xsd:string";
        
        Element restrictionEle = doc.createElementNS(XSD_NS, XSD_PREFIX + ":restriction");
        restrictionEle.setAttribute("base", baseType);

        // 處理各種 restriction facets
        String[] facets = {"xsd:length", "xsd:minLength", "xsd:maxLength", 
                          "xsd:minInclusive", "xsd:maxInclusive"};
        
        for (String facet : facets) {
            if (restrictionNode.has(facet)) {
                JsonNode facetNode = restrictionNode.get(facet);
                Element facetEle = doc.createElementNS(XSD_NS, facet);
                
                if (facetNode.has("@value")) {
                    facetEle.setAttribute("value", facetNode.get("@value").asText());
                } else if (facetNode.isTextual()) {
                    facetEle.setAttribute("value", facetNode.asText());
                }
                
                restrictionEle.appendChild(facetEle);
            }
        }

        return restrictionEle;
    }

    /** 建立 annotation 節點 */
    private Element createAnnotation(Document doc, JsonNode annNode) {
        Element ann = doc.createElementNS(XSD_NS, XSD_PREFIX + ":annotation");
        Element docu = doc.createElementNS(XSD_NS, XSD_PREFIX + ":documentation");
        docu.setAttribute("xml:lang", "en");

        if (annNode.has("xsd:documentation")) {
            JsonNode docNode = annNode.get("xsd:documentation");
            
            // 處理 documentation 的內容
            docNode.fields().forEachRemaining(field -> {
                String key = field.getKey();
                String value = field.getValue().asText();
                
                // 跳過 XML 屬性
                if (key.startsWith("@")) {
                    return;
                }
                
                Element element = doc.createElement(key);
                element.setTextContent(value);
                docu.appendChild(element);
            });
        }

        ann.appendChild(docu);
        return ann;
    }

    /** 寫入 XSD */
    private void writeXsdToFile(Document doc, File outputFile) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        try (PrintWriter out = new PrintWriter(new FileWriter(outputFile))) {
            transformer.transform(new DOMSource(doc), new StreamResult(out));
        }
    }
}