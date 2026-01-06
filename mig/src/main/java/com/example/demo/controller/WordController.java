package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/word")
public class WordController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/word-editor")
    public String word() {
        return "word-editor";
    }

    @PostMapping("/parse")
    @ResponseBody
    public Map<String, Object> parseDocx(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        try (InputStream is = file.getInputStream();
             XWPFDocument doc = new XWPFDocument(is)) {

            String fullText = extractFullText(doc);
            Map<String, String> fields = autoExtractFields(fullText);
            List<String> mainFeatures = extractMainFeatures(doc);

            result.put("success", true);
            result.put("fields", fields);
            result.put("mainFeatures", mainFeatures);
            result.put("fullText", fullText);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    @PostMapping("/replace")
    public void replaceDocx(
            @RequestParam("file") MultipartFile file,
            @RequestParam("fields") String fieldsJson,
            @RequestParam("mainFeatures") String mainFeaturesJson,
            @RequestParam(value = "homeText", required = false) String homeText,
            HttpServletResponse response) {

        try (InputStream is = file.getInputStream();
             XWPFDocument doc = new XWPFDocument(is)) {

            Map<String, String> fields = objectMapper.readValue(fieldsJson, Map.class);
            List<String> mainFeatures = objectMapper.readValue(mainFeaturesJson, List.class);

            replaceFields(doc, fields);
            if (homeText != null && !homeText.isEmpty()) {
                replacePlaceholder(doc, "${HOME_TEXT}", homeText);
            }
            if (mainFeatures != null && !mainFeatures.isEmpty()) {
                replaceMainFeatures(doc, mainFeatures);
            }

            response.setContentType(
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader(
                    "Content-Disposition",
                    "attachment; filename=\"" +
                            URLEncoder.encode(getModifiedFileName(file.getOriginalFilename()), "UTF-8") +
                            "\"");

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                doc.write(baos);
                response.getOutputStream().write(baos.toByteArray());
            }
            response.flushBuffer();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "處理失敗：" + e.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private String getModifiedFileName(String originalName) {
        if (originalName == null || originalName.isEmpty()) return "modified.docx";
        return originalName.replaceAll("\\.docx$", "_modified.docx");
    }

    private String extractFullText(XWPFDocument doc) {
        StringBuilder sb = new StringBuilder();
        for (XWPFParagraph p : doc.getParagraphs()) {
            sb.append(p.getText()).append("\n");
        }
        return sb.toString();
    }

    private Map<String, String> autoExtractFields(String text) {
        Map<String, String> fields = new LinkedHashMap<>();

        String[] lines = text.split("\\r?\\n");
        List<String> nonEmptyLines = new ArrayList<>();
        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty()) nonEmptyLines.add(line);
        }
        String titleValue = "";
        for (int i = 0; i < nonEmptyLines.size(); i++) {
            if (nonEmptyLines.get(i).contains("(通關)")) {
                int count = 0;
                for (int j = i + 1; j < nonEmptyLines.size() && count < 2; j++) {
                    if (!nonEmptyLines.get(j).isEmpty()) {
                        titleValue += (count > 0 ? " " : "") + nonEmptyLines.get(j);
                        count++;
                    }
                }
                break;
            }
        }
        fields.put("title", titleValue.trim());

        Map<String, String> labels = new LinkedHashMap<>();
        labels.put("sender", "訊息發送方");
        labels.put("receiver", "訊息接收方");
        labels.put("category", "訊息類別");
        labels.put("version", "版 本");
        labels.put("subVersion", "副 版 本");
        labels.put("revisionDate", "修訂日期");
        labels.put("organization", "制定機構");

        for (Map.Entry<String, String> entry : labels.entrySet()) {
            String pattern = entry.getValue() + "[:：\\s]+([^\\n]+)";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
            java.util.regex.Matcher m = p.matcher(text);
            if (m.find()) fields.put(entry.getKey(), m.group(1).trim());
            else fields.put(entry.getKey(), "");
        }

        return fields;
    }

    private List<String> extractMainFeatures(XWPFDocument doc) {
        List<String> features = new ArrayList<>();
        boolean foundHeader = false;

        for (XWPFParagraph p : doc.getParagraphs()) {
            String text = p.getText().trim();
            if (text.startsWith("本訊息主要功能如下")) {
                foundHeader = true;
                continue;
            }
            if (foundHeader) {
                if (text.matches("^\\d+\\.\\s+.+") || text.matches("^\\(\\d+\\)\\s+.+")) {
                    String cleanText = text.replaceFirst("^\\d+\\.\\s+", "").replaceFirst("^\\(\\d+\\)\\s+", "");
                    features.add(cleanText);
                } else if (text.isEmpty() || text.startsWith("壹、") || text.startsWith("貳、")) {
                    break;
                }
            }
        }

        if (features.isEmpty()) {
            features.add("原申報「單證合一進口報單(NX5105)」、「出口報單(N5203)」或「轉運申請書(N5301)」，經海關系統核定為C2 或 C3 者。");
            features.add("C2、C3 通關案件逾期未補報單或相關文件。");
            features.add("原申報之報單與簽審機關資料比對不符，應以人工辦理補正。");
        }

        return features;
    }

    private void replaceFields(XWPFDocument doc, Map<String, String> fields) {
        Map<String, String> labels = new LinkedHashMap<>();
        labels.put("title", "關港貿XML訊息建置指引(通關)");
        labels.put("sender", "訊息發送方");
        labels.put("receiver", "訊息接收方");
        labels.put("category", "訊息類別");
        labels.put("version", "版 本");
        labels.put("subVersion", "副 版 本");
        labels.put("revisionDate", "修訂日期");
        labels.put("organization", "制定機構");

        for (XWPFParagraph p : doc.getParagraphs()) {
            String text = p.getText();
            for (Map.Entry<String, String> entry : labels.entrySet()) {
                String key = entry.getKey();
                String label = entry.getValue();
                String newValue = fields.get(key);
                if (newValue == null || newValue.isEmpty()) continue;

                if ("title".equals(key) && text.contains("(通關)")) {
                    replaceTitleTwoLinesPOI(doc, newValue);
                } else if (text.contains(label)) {
                    p.getRuns().forEach(r -> r.setText(r.getText(0).replaceAll(label + "[:：\\s]+[^\\n]*", label + "：" + newValue), 0));
                }
            }
        }
    }

    private void replaceTitleTwoLinesPOI(XWPFDocument doc, String newValue) {
        String[] split = newValue.split("\\s+", 2);
        String newLine1 = split.length > 0 ? split[0] : "";
        String newLine2 = split.length > 1 ? split[1] : "";

        int replaced = 0;
        for (XWPFParagraph p : doc.getParagraphs()) {
            String text = p.getText().replace("\n", "").trim();
            if (text.contains("(通關)")) {
                for (XWPFParagraph pp : doc.getParagraphs()) {
                    if (replaced >= 2) break;
                    String t = pp.getText().replace("\n", "").trim();
                    if (!t.isEmpty()) {
                        if (replaced == 0) pp.getRuns().forEach(r -> r.setText(newLine1, 0));
                        else pp.getRuns().forEach(r -> r.setText(newLine2, 0));
                        replaced++;
                    }
                }
                break;
            }
        }
    }

    private void replacePlaceholder(XWPFDocument doc, String placeholder, String value) {
        for (XWPFParagraph p : doc.getParagraphs()) {
            for (XWPFRun run : p.getRuns()) {
                String text = run.getText(0);
                if (text != null && text.contains(placeholder)) {
                    run.setText(text.replace(placeholder, value), 0);
                }
            }
        }
    }

    private void replaceMainFeatures(XWPFDocument doc, List<String> mainFeatures) {
        List<XWPFParagraph> paras = doc.getParagraphs();
        int startIndex = -1;
        for (int i = 0; i < paras.size(); i++) {
            if (paras.get(i).getText().trim().startsWith("本訊息主要功能如下")) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) return;

        int endIndex = startIndex + 1;
        while (endIndex < paras.size()) {
            String text = paras.get(endIndex).getText().trim();
            if (text.startsWith("壹、") || text.startsWith("貳、") || text.startsWith("參、")) break;
            endIndex++;
        }

        for (int i = endIndex - 1; i > startIndex; i--) doc.removeBodyElement(doc.getPosOfParagraph(paras.get(i)));

        int insertIndex = startIndex + 1;
        XWPFParagraph templateP = paras.get(startIndex);
        for (int i = 0; i < mainFeatures.size(); i++) {
            String itemText = (i + 1) + ". " + mainFeatures.get(i);
            XWPFParagraph newP = doc.insertNewParagraph(doc.getParagraphArray(insertIndex).getCTP().newCursor());
            newP.createRun().setText(itemText);
            insertIndex++;
        }
    }
}
