package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.*;
import com.example.demo.MyConst;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/word1")
public class Word1Controller {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FONT_NAME = "標楷體";

    @GetMapping("/word-editor1")
    public String word() {
        return "word-editor1";
    }

    // ------------------- 解析 DOCX -------------------
    @PostMapping("/parse")
    @ResponseBody
    public Map<String, Object> parseDocx(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        XWPFDocument doc = null;
        try {
            // System.out.println("開始解析文件: " + file.getOriginalFilename());
            doc = new XWPFDocument(file.getInputStream());

            // 全文
            String fullText = extractFullText(doc);
            // System.out.println("全文長度: " + fullText.length());

            // 固定欄位
            Map<String, String> fields = autoExtractFields(fullText);
            // System.out.println("已自動抽取欄位: " + fields.keySet());

            // 主要功能
            List<String> mainFeatures = extractMainFeatures(doc);
            // System.out.println("主要功能項目數: " + mainFeatures.size());

            // 頁首文字（兩行）給前端編輯
            String headerText = extractSingleHeaderText(doc);
            // System.out.println("頁首內容(headerText) = \n" + headerText);

            // 修訂表資料
            List<Map<String, String>> revisionRows = extractRevisionTable(doc);
            // System.out.println("修訂表載入列數: " + revisionRows.size());

            result.put("success", true);
            result.put("fields", fields);
            result.put("mainFeatures", mainFeatures);
            result.put("fullText", fullText);
            result.put("headerText", headerText);
            result.put("revisionRows", revisionRows);


        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("error", e.getMessage());
            result.put("errorType", e.getClass().getName());
        } finally {
            if (doc != null) {
                try { doc.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
        return result;
    }

    @PostMapping("/loadRowsByDocx")
    @ResponseBody
    public Map<String, Object> loadRowsByDocx(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        XWPFDocument doc = null;
        try {
            // System.out.println("開始載入修訂表: " + file.getOriginalFilename());
            doc = new XWPFDocument(file.getInputStream());
            List<Map<String, String>> table = extractRevisionTable(doc);

            result.put("success", true);
            result.put("rows", table);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("error", e.getMessage());
            result.put("errorType", e.getClass().getName());
        } finally {
            if (doc != null) {
                try { doc.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
        return result;
    }

    // ------------------- 產生修改後 DOCX -------------------
    @PostMapping("/replace")
    public void replaceDocx(
            @RequestParam("file") MultipartFile file,
            @RequestParam("fields") String fieldsJson,
            @RequestParam("mainFeatures") String mainFeaturesJson,
            @RequestParam(value = "revisionTable", required = false) String revisionTableJson,
            @RequestParam(value = "headerText", required = false) String headerText,
            HttpServletResponse response) {

        XWPFDocument doc = null;
        try {

            Map<String, String> fields = objectMapper.readValue(fieldsJson, Map.class);
            List<String> mainFeatures = objectMapper.readValue(mainFeaturesJson, List.class);
            List<Map<String, String>> revisionTable = (revisionTableJson != null && !revisionTableJson.isEmpty())
                    ? objectMapper.readValue(revisionTableJson, List.class)
                    : null;

            doc = new XWPFDocument(file.getInputStream());

            // 1) 替換頁首 Header
            if (headerText != null && !headerText.isEmpty()) {
                System.out.println("替換頁首內容（所有 header）...");
                replaceAllHeaders(doc, headerText);
            } else {
                System.out.println("headerText 為空，不替換頁首");
            }

            // 2) 固定欄位
            // System.out.println("替換欄位...");
            replaceFields(doc, fields);

            // 3) 主要功能列表
            // System.out.println("替換主要功能列表...");
            replaceMainFeatures(doc, mainFeatures);

            // 4) 修訂表
            if (revisionTable != null && !revisionTable.isEmpty()) {
                // System.out.println("替換修訂表，共 " + revisionTable.size() + " 列");
                replaceRevisionTable(doc, revisionTable);
            } else {
                // System.out.println("未提供修訂表資料，保留原始修訂表內容");
            }

         // 5) 輸出
            String outFilename = getModifiedFileName(file.getOriginalFilename());

            // 透過 ClassPathResource 定位 resources/template/docx
            ClassPathResource mappingResource = new ClassPathResource("template/docx");

            File dir;
            try {
                // dir = mappingResource.getFile(); // 注意: 只能在非打包 jar 時可用
                dir = new File(MyConst.getWordAllBaseFilePath(), "docx");
            } 
            finally {}
            /*catch (IOException e) {
                // 如果是 jar 環境，fallback 到臨時目錄
                // dir = new File(MyConst.getWordAllBaseFilePath(), "docx");
            }
*/
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                // System.out.println("創建輸出目錄: " + created);
            }

            File outFile = new File(dir, outFilename);
            // System.out.println("準備儲存文件到: " + outFile.getAbsolutePath());

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                doc.write(baos);

                try (FileOutputStream fos = new FileOutputStream(outFile)) {
                    baos.writeTo(fos);
                }

                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                response.setHeader("Content-Disposition",
                        "attachment; filename=\"" + URLEncoder.encode(outFilename, "UTF-8") + "\"");
                baos.writeTo(response.getOutputStream());
            }
            response.getOutputStream().flush();
            // System.out.println("========================================");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "處理失敗：" + e.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            if (doc != null) {
                try { doc.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }

    // ------------------- Header 解析：只抓一份給前端 -------------------
    private String extractSingleHeaderText(XWPFDocument doc) {
        try {
            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(doc);
            XWPFHeader header = policy.getFirstPageHeader();
            if (header == null) header = policy.getDefaultHeader();
            if (header == null) {
                List<XWPFHeader> headers = doc.getHeaderList();
                if (headers == null || headers.isEmpty()) {
                    System.out.println("extractSingleHeaderText: 文件中沒有 header");
                    return "";
                }
                header = headers.get(0);
            }

            StringBuilder sb = new StringBuilder();
            for (XWPFParagraph p : header.getParagraphs()) {
                String text = p.getText();
                if (text != null) {
                    text = text.trim();
                    if (!text.isEmpty()) {
                        if (sb.length() > 0) sb.append("\n");
                        sb.append(text);
                    }
                }
            }
            String result = sb.toString().trim();
            System.out.println("extractSingleHeaderText: 抓到 header 文字 = \n" + result);
            return result;

        } catch (Exception e) {
            System.err.println("extractSingleHeaderText 發生錯誤: " + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    // ------------------- Header 寫回：左／右對齊 -------------------
    private void replaceAllHeaders(XWPFDocument doc, String newHeaderText) {
        try {
            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(doc);

            XWPFHeader first = policy.getFirstPageHeader();
            XWPFHeader def = policy.getDefaultHeader();
            XWPFHeader even = policy.getEvenPageHeader();

            if (first != null) replaceHeaderTextForHeader(first, newHeaderText);
            if (def != null && def != first) replaceHeaderTextForHeader(def, newHeaderText);
            if (even != null && even != def && even != first) replaceHeaderTextForHeader(even, newHeaderText);

            // 保險：同步所有 headerList
            List<XWPFHeader> headers = doc.getHeaderList();
            for (XWPFHeader h : headers) {
                replaceHeaderTextForHeader(h, newHeaderText);
            }

            System.out.println("replaceAllHeaders: Header 全部已套用同一份內容");

        } catch (Exception e) {
            System.err.println("replaceAllHeaders 發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void replaceHeaderTextForHeader(XWPFHeader header, String newHeaderText) {
        try {
            if (header == null) return;

            List<XWPFParagraph> headerParagraphs = new ArrayList<>(header.getParagraphs());

            CTPPr templatePPr = null;
            if (!headerParagraphs.isEmpty() && headerParagraphs.get(0).getCTP().getPPr() != null) {
                templatePPr = (CTPPr) headerParagraphs.get(0).getCTP().getPPr().copy();
            }

            for (XWPFParagraph p : headerParagraphs) {
                while (p.getRuns().size() > 0) {
                    p.removeRun(0);
                }
            }

            boolean reuseExistingParas = !headerParagraphs.isEmpty();
            String[] lines = newHeaderText.split("\\r?\\n");
            String line1 = lines.length > 0 ? lines[0] : "";
            String line2 = lines.length > 1 ? lines[1] : "";

            // ---------- 第一行 ----------
            XWPFParagraph p1;
            if (reuseExistingParas && headerParagraphs.size() >= 1) {
                p1 = headerParagraphs.get(0);
            } else {
                p1 = header.createParagraph();
            }
            if (templatePPr != null) {
                p1.getCTP().setPPr((CTPPr) templatePPr.copy());
            }
            XWPFRun run1 = p1.createRun();
            run1.setText(line1);
            run1.setFontFamily(FONT_NAME);

            // ---------- 第二行：左＋右 ----------
            XWPFParagraph p2;
            if (reuseExistingParas && headerParagraphs.size() >= 2) {
                p2 = headerParagraphs.get(1);
            } else {
                p2 = header.createParagraph();
            }
            if (templatePPr != null) {
                p2.getCTP().setPPr((CTPPr) templatePPr.copy());
            }
            p2.setAlignment(ParagraphAlignment.LEFT);

            // 拆 left/right
            String leftText = "關港貿XML訊息建置指引（通關）";
            String rightText = "應補辦事項通知（N5107）";

            if (!line2.isEmpty()) {
                int idx = line2.indexOf("應補辦事項通知");
                if (idx > 0) {
                    leftText = line2.substring(0, idx).trim();
                    rightText = line2.substring(idx).trim();
                } else {
                    leftText = line2.trim();
                    rightText = "";
                }
            }

            CTPPr pPr2 = p2.getCTP().isSetPPr() ? p2.getCTP().getPPr() : p2.getCTP().addNewPPr();
            CTTabs tabs = pPr2.isSetTabs() ? pPr2.getTabs() : pPr2.addNewTabs();
            CTTabStop tabStop = tabs.addNewTab();
            tabStop.setVal(STTabJc.RIGHT);
            // 9000~9500 twips 可依實際頁面寬微調
            tabStop.setPos(BigInteger.valueOf(9300));

            XWPFRun leftRun = p2.createRun();
            leftRun.setText(leftText);
            leftRun.setFontFamily(FONT_NAME);

            XWPFRun tabRun = p2.createRun();
            tabRun.addTab();

            XWPFRun rightRun = p2.createRun();
            rightRun.setText(rightText);
            rightRun.setFontFamily(FONT_NAME);

            if (headerParagraphs.size() > 2) {
                for (int i = 2; i < headerParagraphs.size(); i++) {
                    XWPFParagraph p = headerParagraphs.get(i);
                    while (p.getRuns().size() > 0) {
                        p.removeRun(0);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getCellText(XWPFTableCell cell) {
        StringBuilder sb = new StringBuilder();
        for (XWPFParagraph para : cell.getParagraphs()) {
            sb.append(para.getText());
        }
        return sb.toString().trim();
    }

    private void setCellBorders(XWPFTableCell cell) {
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
        CTTcBorders borders = tcPr.isSetTcBorders() ? tcPr.getTcBorders() : tcPr.addNewTcBorders();

        CTBorder border = CTBorder.Factory.newInstance();
        border.setVal(STBorder.SINGLE);
        border.setSz(BigInteger.valueOf(4));
        border.setColor("000000");

        borders.setTop(border);
        borders.setBottom((CTBorder) border.copy());
        borders.setLeft((CTBorder) border.copy());
        borders.setRight((CTBorder) border.copy());
    }

    private void replaceFields(XWPFDocument doc, Map<String, String> fields) {
        try {
            Map<String, String> labels = new LinkedHashMap<>();
            labels.put("title", "關港貿XML訊息建置指引(通關)");
            labels.put("sender", "訊息發送方");
            labels.put("receiver", "訊息接收方");
            labels.put("category", "訊息類別");
            labels.put("version", "版 本");
            labels.put("subVersion", "副 版 本");
            labels.put("revisionDate", "修訂日期");
            labels.put("organization", "制定機構");

            List<XWPFParagraph> paragraphs = doc.getParagraphs();

            for (Map.Entry<String, String> entry : labels.entrySet()) {
                String key = entry.getKey();
                String label = entry.getValue();
                String newValue = fields.get(key);
                if (newValue == null || newValue.isEmpty()) continue;

                if ("title".equals(key)) {
                    replaceTitleTwoLines(paragraphs, label, newValue);
                    continue;
                }

                for (XWPFParagraph para : paragraphs) {
                    String text = para.getText().trim();
                    if (text.contains(label)) {
                        String replaced = text.replaceFirst(label + "[:：\\s]+[^\\n]*", label + "：" + newValue);
                        setParagraphText(para, replaced);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void replaceTitleTwoLines(List<XWPFParagraph> paragraphs, String label, String newValue) {
        try {
            String[] split = newValue.split("\\s+", 2);
            String newLine1 = split.length > 0 ? split[0] : "";
            String newLine2 = split.length > 1 ? split[1] : "";
            int replaced = 0;

            for (int i = 0; i < paragraphs.size(); i++) {
                String text = paragraphs.get(i).getText().replace("\n", "").trim();
                if (text.contains("(通關)")) {
                    for (int j = i + 1; j < paragraphs.size() && replaced < 2; j++) {
                        String t = paragraphs.get(j).getText().replace("\n", "").trim();
                        if (!t.isEmpty()) {
                            if (replaced == 0) {
                                setParagraphText(paragraphs.get(j), newLine1);
                                applyTitleStyle(paragraphs.get(j));
                            } else if (replaced == 1) {
                                setParagraphText(paragraphs.get(j), newLine2);
                                applyTitleStyle(paragraphs.get(j));
                            }
                            replaced++;
                        }
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyTitleStyle(XWPFParagraph paragraph) {
        try {
            for (XWPFRun run : paragraph.getRuns()) {
                run.setFontFamily("KaiU");
                run.setFontSize(22);

                CTRPr rPr = run.getCTR().isSetRPr() ? run.getCTR().getRPr() : run.getCTR().addNewRPr();

                CTFonts fonts;
                if (rPr.sizeOfRFontsArray() > 0) {
                    fonts = rPr.getRFontsArray(0);
                } else {
                    fonts = rPr.addNewRFonts();
                }

                fonts.setAscii("KaiU");
                fonts.setHAnsi("KaiU");
                fonts.setEastAsia(FONT_NAME);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void replaceMainFeatures(XWPFDocument doc, List<String> mainFeatures) {
        try {
            List<XWPFParagraph> paragraphs = doc.getParagraphs();
            int startIndex = -1;

            for (int i = 0; i < paragraphs.size(); i++) {
                if (paragraphs.get(i).getText().trim().startsWith("本訊息主要功能如下")) {
                    startIndex = i;
                    break;
                }
            }
            if (startIndex == -1) {
                System.out.println("未找到「本訊息主要功能如下」標題");
                return;
            }

            int endIndex = startIndex + 1;
            while (endIndex < paragraphs.size()) {
                XWPFParagraph para = paragraphs.get(endIndex);
                String text = para.getText().trim();

                boolean isListItem = false;
                if (para.getNumID() != null) isListItem = true;
                if (text.matches("^\\d+\\.\\s+.+") || text.matches("^\\(\\d+\\)\\s+.+")) isListItem = true;

                if (!isListItem && !text.isEmpty()) {
                    if (text.startsWith("壹、") || text.startsWith("貳、") || text.startsWith("參、")) break;
                    if (!text.matches(".*[。，、：]$")) break;
                }
                endIndex++;
            }

            List<Integer> positionsToRemove = new ArrayList<>();
            for (int i = startIndex + 1; i < endIndex && i < paragraphs.size(); i++) {
                int pos = doc.getPosOfParagraph(paragraphs.get(i));
                if (pos >= 0) positionsToRemove.add(pos);
            }
            Collections.sort(positionsToRemove, Collections.reverseOrder());
            for (int pos : positionsToRemove) {
                doc.removeBodyElement(pos);
            }

            paragraphs = doc.getParagraphs();
            startIndex = -1;
            for (int i = 0; i < paragraphs.size(); i++) {
                if (paragraphs.get(i).getText().trim().startsWith("本訊息主要功能如下")) {
                    startIndex = i;
                    break;
                }
            }
            if (startIndex == -1) {
                System.err.println("刪除後無法找到標題");
                return;
            }

            int insertAfterPos = doc.getPosOfParagraph(paragraphs.get(startIndex));
            System.out.println("將在位置 " + insertAfterPos + " 後插入新項目");

            for (int i = 0; i < mainFeatures.size(); i++) {
                String itemText = (i + 1) + ". " + mainFeatures.get(i);
                XWPFParagraph newP = doc.createParagraph();
                XWPFRun run = newP.createRun();
                run.setText(itemText);
                run.setFontFamily(FONT_NAME);
                run.setFontSize(12);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> extractMainFeatures(XWPFDocument doc) {
        List<String> features = new ArrayList<>();
        List<XWPFParagraph> paragraphs = doc.getParagraphs();

        boolean foundHeader = false;
        for (XWPFParagraph para : paragraphs) {
            String text = para.getText().trim();

            if (text.startsWith("本訊息主要功能如下")) {
                foundHeader = true; continue;
            }
            if (foundHeader) {
                boolean isListItem = false;
                String cleanText = text;

                if (para.getNumID() != null) {
                    isListItem = true; cleanText = text;
                } else if (text.matches("^\\d+\\.\\s+.+")) {
                    isListItem = true; cleanText = text.replaceFirst("^\\d+\\.\\s+", "");
                } else if (text.matches("^\\(\\d+\\)\\s+.+")) {
                    isListItem = true; cleanText = text.replaceFirst("^\\(\\d+\\)\\s+", "");
                }

                if (isListItem && !cleanText.trim().isEmpty()) {
                    features.add(cleanText.trim());
                } else if (text.isEmpty()) {
                    continue;
                } else if (text.startsWith("壹、") || text.startsWith("貳、") || text.startsWith("參、")) {
                    break;
                }
            }
        }

        if (features.isEmpty()) {
            features.add("原申報「單證合一進口報單(NX5105)」、「出口報單(N5203)」或「轉運申請書(N5301)」，經海關系統核定為C2 或 C3 者。");
            features.add("C2、C3 通關案件逾期未補報單或相關文件。");
            features.add("原申報之報單與簽審機關資料比對不符，應以人工辦理補正。");
        }

        System.out.println("抽取到 " + features.size() + " 個主要功能項目");
        return features;
    }

    private String extractFullText(XWPFDocument doc) {
        StringBuilder sb = new StringBuilder();
        for (XWPFParagraph para : doc.getParagraphs()) {
            sb.append(para.getText()).append("\n");
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

    private void setParagraphText(XWPFParagraph para, String text) {
        while (para.getRuns().size() > 0) {
            para.removeRun(0);
        }
        XWPFRun run = para.createRun();
        run.setText(text);
    }

    private String getModifiedFileName(String originalName) {
        if (originalName == null || originalName.isEmpty()) return "modified.docx";
        return originalName.replaceAll("\\.docx$", "_modified.docx");
    }

    // ====== 修訂表相關：依表頭尋找與替換 ======
    private XWPFTable findRevisionTable(XWPFDocument doc) {
        List<XWPFTable> tables = doc.getTables();
        if (tables == null || tables.isEmpty()) {
            System.out.println("findRevisionTable: 文件中沒有任何表格");
            return null;
        }

        for (XWPFTable table : tables) {
            XWPFTableRow firstRow = table.getRow(0);
            if (firstRow == null) continue;

            List<XWPFTableCell> cells = firstRow.getTableCells();
            if (cells == null || cells.size() < 5) continue;

            String c0 = getCellText(cells.get(0)).trim();
            String c1 = getCellText(cells.get(1)).trim();
            String c2 = getCellText(cells.get(2)).trim();
            String c3 = getCellText(cells.get(3)).trim();
            String c4 = getCellText(cells.get(4)).trim();

            System.out.println("findRevisionTable header = [" +
                    c0 + "," + c1 + "," + c2 + "," + c3 + "," + c4 + "]");

            if ("版本".equals(c0) &&
                "日期".equals(c1) &&
                "修改摘要".equals(c2) &&
                "修訂人".equals(c3) &&
                "備註".equals(c4)) {
                System.out.println("findRevisionTable: 已找到修訂紀錄表");
                return table;
            }
        }

        System.out.println("findRevisionTable: 未找到符合表頭的修訂紀錄表");
        return null;
    }

    private List<Map<String, String>> extractRevisionTable(XWPFDocument doc) {
        List<Map<String, String>> tableData = new ArrayList<>();

        try {
            XWPFTable table = findRevisionTable(doc);
            if (table == null) {
                System.out.println("extractRevisionTable: 未找到修訂紀錄表");
                return tableData;
            }

            boolean firstRow = true;
            for (XWPFTableRow row : table.getRows()) {
                if (firstRow) { firstRow = false; continue; }

                Map<String, String> rowData = new LinkedHashMap<>();
                List<XWPFTableCell> cells = row.getTableCells();

                String version = cells.size() > 0 ? getCellText(cells.get(0)) : "";
                String date    = cells.size() > 1 ? getCellText(cells.get(1)) : "";
                String summary = cells.size() > 2 ? getCellText(cells.get(2)) : "";
                String owner   = cells.size() > 3 ? getCellText(cells.get(3)) : "";
                String note    = cells.size() > 4 ? getCellText(cells.get(4)) : "";

                rowData.put("version", version);
                rowData.put("date",    date);
                rowData.put("summary", summary);
                rowData.put("owner",   owner);
                rowData.put("note",    note);

                tableData.add(rowData);
            }

            System.out.println("extractRevisionTable: 成功提取 " + tableData.size() + " 行修訂資料");

        } catch (Exception e) {
            System.err.println("extractRevisionTable: 提取修訂表時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

        return tableData;
    }

    private void replaceRevisionTable(XWPFDocument doc, List<Map<String, String>> newTableData) {
        try {
            XWPFTable table = findRevisionTable(doc);
            if (table == null) {
                System.out.println("replaceRevisionTable: 未找到修訂紀錄表，無法替換");
                return;
            }

            System.out.println("replaceRevisionTable: 準備寫入 " + newTableData.size() + " 列");

            while (table.getNumberOfRows() > 1) {
                table.removeRow(1);
            }

            String[] fields = {"version", "date", "summary", "owner", "note"};

            for (int i = 0; i < newTableData.size(); i++) {
                Map<String, String> rowData = newTableData.get(i);
                System.out.println("replaceRevisionTable: 第 " + (i + 1) + " 列資料: " + rowData);

                XWPFTableRow newRow = table.createRow();

                for (int j = 0; j < fields.length; j++) {
                    XWPFTableCell cell = j < newRow.getTableCells().size()
                            ? newRow.getCell(j)
                            : newRow.addNewTableCell();

                    while (cell.getParagraphs().size() > 0) {
                        cell.removeParagraph(0);
                    }

                    String value = rowData.getOrDefault(fields[j], "");
                    XWPFParagraph p = cell.addParagraph();
                    XWPFRun r = p.createRun();
                    r.setText(value);
                    setCellBorders(cell);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyRowStyle(XWPFTableRow targetRow, XWPFTableRow sourceRow) {
        // 已不再使用，保留空實作或簡單樣式拷貝
        if (sourceRow != null && sourceRow.getCtRow().getTrPr() != null) {
            targetRow.getCtRow().setTrPr((CTTrPr) sourceRow.getCtRow().getTrPr().copy());
        }
    }
}
