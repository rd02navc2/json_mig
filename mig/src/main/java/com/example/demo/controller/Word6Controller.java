package com.example.demo.controller;

import com.example.demo.MyConst;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.MyConst;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

@Controller
@RequestMapping("/word6")
public class Word6Controller {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 前端頁面路由
     */
    @GetMapping("/word-editor6")
    public String wordEditor6() {
        return "word-editor6";
    }

    @PostMapping("/parseDocxFields")
    public ResponseEntity<Map<String, Object>> parseDocxFields(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "fieldTitles", required = false) String fieldTitlesJson) {

        Map<String, Object> result = new HashMap<>();

        try (InputStream inputStream = file.getInputStream();
             XWPFDocument document = new XWPFDocument(inputStream)) {

            List<XWPFHeader> headers = document.getHeaderList();
            if (headers != null && !headers.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (XWPFParagraph para : headers.getFirst().getParagraphs()) {
                    sb.append(para.getText()).append("\n");
                }
                result.put("headerText", sb.toString().trim());
            }

            String descriptionText = extractDescriptionText(document);
            if (descriptionText != null && !descriptionText.isEmpty()) {
                result.put("descriptionText", descriptionText);
            }

            List<String> fieldTitles = parseFieldTitles(fieldTitlesJson);

            if (!fieldTitles.isEmpty()) {
                Map<String, String> dynamicFields = extractDynamicFieldsFromDocx(document, fieldTitles);
                result.put("dynamicFields", dynamicFields);
            }

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", "解析失敗: " + e.getMessage());
            return ResponseEntity.status(500).body(result);
        }
    }

    private String extractDescriptionText(XWPFDocument document) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph para : paragraphs) {
            String text = para.getText().trim();
            if (text.contains("此訊息範例為") || text.contains("主要內容如下")) {
                System.out.println("找到說明段落: " + text);
                return text;
            }
        }

        return "此訊息範例為基隆五堵分關傳送給新齊發報關行之應補辦事項通知。主要內容如下：";
    }

    private List<String> parseFieldTitles(String fieldTitlesJson) throws Exception {
        if (fieldTitlesJson == null || fieldTitlesJson.isEmpty()) {
            return List.of();
        }
        return objectMapper.readValue(fieldTitlesJson,
                objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
    }

    private Map<String, String> extractDynamicFieldsFromDocx(XWPFDocument document, List<String> fieldTitles) {
        Map<String, String> result = new HashMap<>();
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        System.out.println("開始搜尋動態欄位（對齊格式），總段落數: " + paragraphs.size());

        for (int i = 0; i < paragraphs.size(); i++) {
            XWPFParagraph para = paragraphs.get(i);
            String paraText = para.getText().trim();

            if (paraText.isEmpty()) continue;

            for (String fieldTitle : fieldTitles) {
                String paraTextNoSpaces = paraText.replaceAll("\\s+", "");

                if (paraTextNoSpaces.startsWith(fieldTitle + "：") || paraTextNoSpaces.startsWith(fieldTitle + ":")) {
                    System.out.println("找到欄位: " + fieldTitle);

                    String content = "";
                    int colonIndex = paraText.indexOf("：");
                    if (colonIndex == -1) {
                        colonIndex = paraText.indexOf(":");
                    }

                    if (colonIndex != -1 && colonIndex + 1 < paraText.length()) {
                        content = paraText.substring(colonIndex + 1).trim();
                    }

                    result.put(fieldTitle, content);
                    break;
                }
            }
        }

        return result;
    }

    @PostMapping("/replaceSecondPageXML")
    public ResponseEntity<byte[]> replaceSecondPageXML(
            @RequestParam("file") MultipartFile file,
            @RequestParam("fields") String fieldsJson,
            @RequestParam("xmlContent") String xmlContent) {

        try (InputStream inputStream = file.getInputStream();
             XWPFDocument document = new XWPFDocument(inputStream);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            @SuppressWarnings("unchecked")
            Map<String, Object> fields = objectMapper.readValue(fieldsJson, Map.class);

            String headerText = (String) fields.get("headerText");
            updateHeader(document, headerText);

            String descriptionText = (String) fields.get("descriptionText");

            @SuppressWarnings("unchecked")
            Map<String, String> dynamicFieldsMap = (Map<String, String>) fields.get("dynamicFields");

            @SuppressWarnings("unchecked")
            List<String> fieldOrder = (List<String>) fields.get("fieldOrder");

            if (dynamicFieldsMap != null && !dynamicFieldsMap.isEmpty()) {
                System.out.println("開始替換動態欄位，共 " + dynamicFieldsMap.size() + " 個");

                Map<String, String> orderedFields = new LinkedHashMap<>();

                if (fieldOrder != null && !fieldOrder.isEmpty()) {
                    for (String fieldTitle : fieldOrder) {
                        if (dynamicFieldsMap.containsKey(fieldTitle)) {
                            orderedFields.put(fieldTitle, dynamicFieldsMap.get(fieldTitle));
                        }
                    }
                    System.out.println("使用指定順序，共 " + orderedFields.size() + " 個欄位");
                } else {
                    orderedFields = dynamicFieldsMap;
                }

                replaceDynamicFieldsInDocx(document, orderedFields, descriptionText);
            }

            replaceSecondPage(document, xmlContent);

            document.write(out);
            byte[] bytes = out.toByteArray();

            String originalName = file.getOriginalFilename();
            String modifiedName = (originalName != null
                    ? originalName.replace(".docx", "_modified.docx")
                    : "result_modified.docx");

         // 一定可寫的輸出目錄（系統暫存）
            File dir = new File(MyConst.getWordAllBaseFilePath(), "docx");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File outFile = new File(dir, modifiedName);
            try (FileOutputStream fos = new FileOutputStream(outFile)) {
                fos.write(bytes);
            }

            System.out.println("本地檔案已保存: " + outFile.getAbsolutePath());

            // 回傳給前端
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(
                MediaType.parseMediaType(
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
            headers.setContentDispositionFormData("attachment", modifiedName);

            return ResponseEntity.ok().headers(headers).body(bytes);


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    private void replaceDynamicFieldsInDocx(XWPFDocument document,
                                            Map<String, String> dynamicFields,
                                            String descriptionText) {
        if (dynamicFields == null || dynamicFields.isEmpty()) {
            System.out.println("沒有動態欄位需要處理");
            return;
        }

        System.out.println("開始替換動態欄位（含說明文字），共 " + dynamicFields.size() + " 個");

        // 找到標記段落
        int markerIndex = findMarkerParagraph(document);

        if (markerIndex == -1) {
            System.out.println("未找到標記段落");
            return;
        }

        System.out.println("找到標記段落，位置: " + markerIndex);
        replaceDynamicFieldsAfterMarker(document, markerIndex, dynamicFields, descriptionText);
    }

    private int findMarkerParagraph(XWPFDocument document) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (int i = 0; i < paragraphs.size(); i++) {
            String paraText = paragraphs.get(i).getText().trim();
            if (paraText.contains("此訊息範例為") || paraText.contains("主要內容如下")) {
                return i;
            }
        }

        return -1;
    }

    private void replaceDynamicFieldsAfterMarker(XWPFDocument document,
                                                 int markerIndex,
                                                 Map<String, String> dynamicFields,
                                                 String descriptionText) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        // 找出分頁符位置
        int endIndex = findPageBreakIndex(document, markerIndex + 1);
        if (endIndex == -1) {
            endIndex = paragraphs.size();
        }

        System.out.println("標記段落索引: " + markerIndex);
        System.out.println("結束索引: " + endIndex);

        for (int i = endIndex - 1; i > markerIndex; i--) {
            if (i < document.getParagraphs().size()) {
                document.removeBodyElement(i);
            }
        }

        XWPFParagraph markerPara = document.getParagraphs().get(markerIndex);
        int insertPos = document.getPosOfParagraph(markerPara);
        int currentOffset = 1;

        if (descriptionText != null && !descriptionText.isEmpty()) {
            XWPFParagraph descPara = document.insertNewParagraph(markerPara.getCTP().newCursor());
            XWPFRun descRun = descPara.createRun();
            descRun.setText(descriptionText);
            descRun.setFontFamily("標楷體");
            descRun.setFontSize(12);
            document.setParagraph(descPara, insertPos + currentOffset);
            currentOffset++;
            System.out.println("插入說明文字: " + descriptionText);
        }

        XWPFParagraph emptyPara1 = document.insertNewParagraph(markerPara.getCTP().newCursor());
        document.setParagraph(emptyPara1, insertPos + currentOffset);
        currentOffset++;

        XWPFParagraph headerPara = document.insertNewParagraph(markerPara.getCTP().newCursor());
        XWPFRun headerRun = headerPara.createRun();
        headerRun.setText("表頭資料：");
        headerRun.setFontFamily("標楷體");
        headerRun.setFontSize(12);
        document.setParagraph(headerPara, insertPos + currentOffset);
        currentOffset++;

        XWPFParagraph emptyPara2 = document.insertNewParagraph(markerPara.getCTP().newCursor());
        document.setParagraph(emptyPara2, insertPos + currentOffset);
        currentOffset++;

        for (Map.Entry<String, String> entry : dynamicFields.entrySet()) {
            String fieldTitle = entry.getKey();
            String fieldContent = entry.getValue();

            int targetWidth = 32;
            int titleLength = getChineseStringWidth(fieldTitle);
            int spacesNeeded = Math.max(1, targetWidth - titleLength);
            String spaces = " ".repeat(spacesNeeded);

            XWPFParagraph para = document.insertNewParagraph(markerPara.getCTP().newCursor());
            XWPFRun run = para.createRun();
            run.setText(fieldTitle + spaces + "：" +
                    (fieldContent != null ? fieldContent : ""));
            run.setFontFamily("標楷體");
            run.setFontSize(12);

            document.setParagraph(para, insertPos + currentOffset);
            currentOffset++;
        }

        // 6. 插入結尾空行
        XWPFParagraph emptyPara3 = document.insertNewParagraph(markerPara.getCTP().newCursor());
        document.setParagraph(emptyPara3, insertPos + currentOffset);

        System.out.println("完成插入，共 " + currentOffset + " 個段落");
    }

    private int getChineseStringWidth(String str) {
        if (str == null || str.isEmpty()) return 0;

        int width = 0;
        for (char c : str.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                    || c >= 0x3000 && c <= 0x303F) {
                width += 2;
            } else {
                width += 1;
            }
        }
        return width;
    }

    private int findPageBreakIndex(XWPFDocument document, int startIndex) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (int i = startIndex; i < paragraphs.size(); i++) {
            String xml = paragraphs.get(i).getCTP().toString();
            if (xml.contains("w:br") && xml.contains("w:type=\"page\"")) {
                return i;
            }
        }

        return -1;
    }

    private void updateHeader(XWPFDocument doc, String headerText) {
        if (headerText == null || headerText.trim().isEmpty()) return;

        try {
            List<XWPFHeader> headers = doc.getHeaderList();
            XWPFHeader header;

            if (headers == null || headers.isEmpty()) {
                header = doc.createHeader(HeaderFooterType.DEFAULT);
            } else {
                header = headers.getFirst();
                header.getParagraphs().clear();
            }

            Arrays.stream(headerText.split("\n")).forEach(line -> {
                XWPFParagraph p = header.createParagraph();
                XWPFRun run = p.createRun();
                run.setText(line);
                run.setFontSize(12);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void replaceSecondPage(XWPFDocument doc, String xmlContent) {
        List<XWPFParagraph> pars = doc.getParagraphs();
        boolean found = false;
        int idx = -1;

        for (int i = 0; i < pars.size(); i++) {
            String xml = pars.get(i).getCTP().toString();
            if (xml.contains("w:br") && xml.contains("w:type=\"page\"")) {
                found = true;
                idx = i + 1;
                break;
            }
        }

        if (!found) {
            XWPFParagraph p = doc.createParagraph();
            p.createRun().addBreak(BreakType.PAGE);
        } else {
            for (int i = doc.getParagraphs().size() - 1; i >= idx; i--) {
                doc.removeBodyElement(i);
            }
        }

        Arrays.stream(xmlContent.split("\n")).forEach(line -> {
            XWPFParagraph p = doc.createParagraph();
            XWPFRun run = p.createRun();
            run.setText(line);
            run.setFontFamily("Courier New");
            run.setFontSize(10);
        });
    }
}

