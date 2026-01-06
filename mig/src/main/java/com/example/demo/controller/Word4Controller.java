package com.example.demo.controller;

import com.example.demo.MyConst;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/word4")
public class Word4Controller {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/word-editor4")
    public String wordEditor4() {
        return "word-editor4";
    }

    @PostMapping("/api/previewTable")
    @ResponseBody
    public List<Map<String, Object>> previewTable(@RequestParam("excel") MultipartFile excel) throws Exception {
        Sheet sheet = getExcelSheet(excel);
        return extractTableData(sheet);
    }

    @PostMapping("/api/replaceTable")
    public ResponseEntity<byte[]> replaceTable(
            @RequestParam("word") MultipartFile word,
            @RequestParam("tableJson") String tableJson
    ) throws Exception {

        List<Map<String, Object>> tableList =
                objectMapper.readValue(tableJson, new TypeReference<List<Map<String, Object>>>() {});
        System.out.println("解析到 " + tableList.size() + " 行資料");

        try (InputStream is = word.getInputStream();
             XWPFDocument doc = new XWPFDocument(is)) {

            List<XWPFTable> tables = doc.getTables();
            if (tables.isEmpty()) throw new RuntimeException("Word 內找不到表格");

            XWPFTable table = tables.get(0);
            System.out.println("找到表格，原始行數: " + table.getRows().size());

            while (table.getNumberOfRows() > 0) {
                table.removeRow(table.getNumberOfRows() - 1);
            }

            // 建立表頭
            XWPFTableRow header = table.createRow();
            ensureCellCount(header, 6);
            setCellText(header.getCell(0), "迴圈");
            setCellText(header.getCell(1), "M/C");
            setCellText(header.getCell(2), "WCO/TW Class ID");
            setCellText(header.getCell(3), "WCO/TW ID");
            setCellText(header.getCell(4), "XML Tag Name");
            setCellText(header.getCell(5), "中文名稱");

            // 填入資料
            for (int i = 0; i < tableList.size(); i++) {
                Map<String, Object> r = tableList.get(i);
                XWPFTableRow tr = table.createRow();
                ensureCellCount(tr, 6);

                setCellText(tr.getCell(0), getValueOrEmpty(r, "loop"));
                setCellText(tr.getCell(1), getValueOrEmpty(r, "mc"));
                setCellText(tr.getCell(2), getValueOrEmpty(r, "classId"));
                setCellText(tr.getCell(3), getValueOrEmpty(r, "id"));
                setCellText(tr.getCell(4), getValueOrEmpty(r, "tag"));
                setCellText(tr.getCell(5), getValueOrEmpty(r, "name"));

                if ((i + 1) % 10 == 0) {
                    System.out.println("已處理 " + (i + 1) + " 行");
                }
            }

            String originalFilename = word.getOriginalFilename();
            String outputName = (originalFilename != null
                    ? originalFilename.replace(".docx", "_modified.docx")
                    : "result.docx");

            // 1️ 選擇一個「一定可寫」的輸出目錄
            File  dir = new File(MyConst.getWordAllBaseFilePath(), "docx");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 2️ 寫入本地檔案（可選：若你真的需要存）
            File outFile = new File(dir, outputName);
            try (FileOutputStream fos = new FileOutputStream(outFile)) {
                doc.write(fos);
            }

            // 3️ 寫入記憶體，用來下載
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            doc.write(bos);
            byte[] bytes = bos.toByteArray();

            // 4️ 回傳下載
            return ResponseEntity.ok()
                    .header(
                        "Content-Disposition",
                        "attachment; filename=\"" +
                        URLEncoder.encode(outputName, StandardCharsets.UTF_8) + "\"")
                    .header("Cache-Control", "no-cache, no-store, must-revalidate")
                    .header("Pragma", "no-cache")
                    .header("Expires", "0")
                    .contentType(
                        MediaType.parseMediaType(
                            "application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
                    .contentLength(bytes.length)
                    .body(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void ensureCellCount(XWPFTableRow row, int cellCount) {
        if (row == null) return;
        while (row.getTableCells().size() < cellCount) {
            row.addNewTableCell();
        }
    }

    private void setCellText(XWPFTableCell cell, String text) {
        if (cell == null) return;
        // 清空原有段落
        while (cell.getParagraphs().size() > 0) {
            cell.removeParagraph(0);
        }
        XWPFParagraph para = cell.addParagraph();
        XWPFRun run = para.createRun();
        run.setText(text != null ? text : "");
    }

    private String getValueOrEmpty(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value == null ? "" : value.toString();
    }

    private Sheet getExcelSheet(MultipartFile excel) throws Exception {
        try (InputStream is = excel.getInputStream()) {
            Workbook workbook;
            String filename = excel.getOriginalFilename();
            if (filename != null && filename.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(is);
            } else if (filename != null && filename.endsWith(".xls")) {
                workbook = new HSSFWorkbook(is);
            } else {
                throw new RuntimeException("只支援 xls/xlsx 檔案");
            }
            return workbook.getSheetAt(0);
        }
    }

    private List<Map<String, Object>> extractTableData(Sheet sheet) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        Row headerRow = sheet.getRow(1);

        final String[] EXPECTED_HEADERS = {
                "迴圈", "M/C", "Class ID", "WCOID", "群組/資料元或組合資料元名稱", "中文名稱"
        };
        final String[] JSON_KEYS = {"loop", "mc", "classId", "id", "tag", "name"};

        Map<String, Integer> headerIndexMap = new HashMap<>();
        for (int i = 0; i < EXPECTED_HEADERS.length; i++) {
            Cell cell = findCellByValue(headerRow, EXPECTED_HEADERS[i]);
            if (cell != null) headerIndexMap.put(JSON_KEYS[i], cell.getColumnIndex());
        }

        for (int i = 2; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Map<String, Object> rowMap = new HashMap<>();
            boolean isEmpty = true;
            for (String key : JSON_KEYS) {
                if (headerIndexMap.containsKey(key)) {
                    int col = headerIndexMap.get(key);
                    Cell cell = row.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String value = getCellValue(cell);
                    rowMap.put(key, value);
                    if (!value.isEmpty()) isEmpty = false;
                }
            }
            if (!isEmpty) dataList.add(rowMap);
        }
        return dataList;
    }

    private Cell findCellByValue(Row row, String value) {
        if (row == null) return null;
        for (Cell cell : row) {
            if (getCellValue(cell).trim().equals(value.trim())) return cell;
        }
        return null;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new SimpleDateFormat("yyyy/MM/dd").format(cell.getDateCellValue());
                } else {
                    return new DecimalFormat("#.######").format(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }

    @Deprecated
    private XWPFTable buildTableFromMappingTree(List<Map<String, Object>> rows, XWPFDocument doc) {
        XWPFTable table = doc.createTable();

        XWPFTableRow header = table.getRow(0);
        header.getCell(0).setText("迴圈");
        header.addNewTableCell().setText("M/C");
        header.addNewTableCell().setText("WCO/TW Class ID");
        header.addNewTableCell().setText("WCO/TW ID");
        header.addNewTableCell().setText("XML Tag Name");
        header.addNewTableCell().setText("中文名稱");

        for (Map<String, Object> r : rows) {
            XWPFTableRow tr = table.createRow();
            tr.getCell(0).setText(r.get("loop") == null ? "" : r.get("loop").toString());
            tr.getCell(1).setText(r.get("mc") == null ? "" : r.get("mc").toString());
            tr.getCell(2).setText(r.get("classId") == null ? "" : r.get("classId").toString());
            tr.getCell(3).setText(r.get("id") == null ? "" : r.get("id").toString());
            tr.getCell(4).setText(r.get("tag") == null ? "" : r.get("tag").toString());
            tr.getCell(5).setText(r.get("name") == null ? "" : r.get("name").toString());
        }

        return table;
    }
}
