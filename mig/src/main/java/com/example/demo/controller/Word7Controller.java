package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import jakarta.servlet.http.HttpServletResponse;


import org.apache.poi.xwpf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.MyConst;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/word7")
public class Word7Controller {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/word-editor7")
    public String wordEditor7() {
        return "word-editor7";
    }

    @PostMapping("/getCodeTables")
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> getCodeTables(
            @RequestParam("file") MultipartFile file) {
        try (InputStream is = file.getInputStream(); 
             XWPFDocument doc = new XWPFDocument(is)) {

            List<Map<String, Object>> codeTables = new ArrayList<>();
            List<IBodyElement> bodyElements = doc.getBodyElements();
            
            String currentSectionName = null;
            int tableIndex = 0;

            for (IBodyElement element : bodyElements) {
                if (element instanceof XWPFParagraph) {
                    XWPFParagraph para = (XWPFParagraph) element;
                    String text = para.getText().trim();
                    
                    if (!text.isEmpty() && 
                        (text.contains("代碼表") || 
                         text.matches(".*[\\d]+\\..*") || 
                         para.getStyle() != null)) { 
                        currentSectionName = text;
                    }
                }
                
                else if (element instanceof XWPFTable) {
                    XWPFTable table = (XWPFTable) element;
                    
                    if (isCodeTable(table)) {
                        tableIndex++;
                        Map<String, Object> tableMap = extractCodeTable(
                            table, 
                            currentSectionName, 
                            tableIndex
                        );
                        
                        if (tableMap != null && !((List<?>) tableMap.get("rows")).isEmpty()) {
                            codeTables.add(tableMap);
                        }
                    }
                }
            }

            System.out.println("成功抓取 " + codeTables.size() + " 個代碼表");
            return ResponseEntity.ok(codeTables);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    private boolean isCodeTable(XWPFTable table) {
        if (table.getRows().size() < 2) return false;
        
        XWPFTableRow headerRow = table.getRow(0);
        if (headerRow.getTableCells().size() < 2) return false;
        
        StringBuilder headerText = new StringBuilder();
        for (XWPFTableCell cell : headerRow.getTableCells()) {
            headerText.append(cell.getText()).append(" ");
        }
        String headerStr = headerText.toString().toLowerCase();
        
        return headerStr.contains("代碼") || 
               headerStr.contains("code") ||
               headerStr.contains("說明") ||
               headerStr.contains("description") ||
               (headerRow.getTableCells().size() == 2); // 兩欄表格
    }

    private Map<String, Object> extractCodeTable(XWPFTable table, 
                                                   String sectionName, 
                                                   int tableIndex) {
        List<XWPFTableRow> rows = table.getRows();
        if (rows.size() < 2) return null;

        XWPFTableRow headerRow = rows.get(0);
        List<XWPFTableCell> headerCells = headerRow.getTableCells();
        
        int codeIndex = -1, descIndex = -1;
        
        for (int i = 0; i < headerCells.size(); i++) {
            String header = headerCells.get(i).getText().trim().toLowerCase();
            if (header.contains("代碼") || header.contains("code")) {
                codeIndex = i;
            }
            if (header.contains("說明") || header.contains("description") || 
                header.contains("名稱") || header.contains("內容")) {
                descIndex = i;
            }
        }

        if (codeIndex == -1 && headerCells.size() >= 1) codeIndex = 0;
        if (descIndex == -1 && headerCells.size() >= 2) descIndex = 1;
        
        if (codeIndex == -1 || descIndex == -1) return null;

        List<Map<String, String>> rowData = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            XWPFTableRow row = rows.get(i);
            List<XWPFTableCell> cells = row.getTableCells();
            
            if (cells.size() > Math.max(codeIndex, descIndex)) {
                String code = cells.get(codeIndex).getText().trim();
                String desc = cells.get(descIndex).getText().trim();
                
                if (!code.isEmpty() || !desc.isEmpty()) {
                    Map<String, String> rowMap = new HashMap<>();
                    rowMap.put("code", code);
                    rowMap.put("description", desc);
                    rowData.add(rowMap);
                }
            }
        }

        if (rowData.isEmpty()) return null;

        Map<String, Object> tableMap = new HashMap<>();
        
        String tableName;
        if (sectionName != null && !sectionName.isEmpty()) {
            tableName = sectionName;
        } else {
            tableName = "代碼表 " + tableIndex;
        }
        
        tableMap.put("tableName", tableName);
        tableMap.put("rows", rowData);
        
        return tableMap;
    }

	@PostMapping(value="/replaceSecondPageXML", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<byte[]> replaceSecondPageXML(
	        @RequestParam("file") MultipartFile file,
	        @RequestParam("codeTables") String codeTablesJson
	) {
	    try (InputStream inputStream = file.getInputStream();
	         XWPFDocument document = new XWPFDocument(inputStream);
	         ByteArrayOutputStream out = new ByteArrayOutputStream()) {
	
	        List<Map<String, Object>> codeTables =
	                objectMapper.readValue(codeTablesJson,
	                        new TypeReference<List<Map<String, Object>>>() {});
	
	        System.out.println("收到 " + codeTables.size() + " 個代碼表要處理");
	
	        List<Map<String, Object>> existingTables = new ArrayList<>();
	        List<Map<String, Object>> newTables = new ArrayList<>();
	
	        for (Map<String, Object> table : codeTables) {
	            Boolean isNew = (Boolean) table.get("isNew");
	            if (Boolean.TRUE.equals(isNew)) {
	                newTables.add(table);
	                System.out.println("新增表格: " + table.get("tableName"));
	            } else {
	                existingTables.add(table);
	                System.out.println("更新表格: " + table.get("tableName"));
	            }
	        }
	
	        if (!existingTables.isEmpty()) {
	            updateCodeTablesInDocument(document, existingTables);
	        }
	
	        if (!newTables.isEmpty()) {
	            appendNewCodeTables(document, newTables);
	        }
	
	        document.write(out);
	        byte[] bytes = out.toByteArray();
	
	        Path docxDir = Paths.get(
	        		MyConst.getWordAllBaseFilePath(), "docx");
	       
	        if (!Files.exists(docxDir)) {
	            Files.createDirectories(docxDir);
	            System.out.println("建立資料夾: " + docxDir.toAbsolutePath());
	        }
	        
	        String originalName = file.getOriginalFilename();
	        if (originalName == null) {
	            originalName = "document.docx";
	        }
	
	        String fileName = originalName.replaceAll("\\.docx$", "") +
	                "_modified" + ".docx";
	
	        Path outputPath = docxDir.resolve(fileName);
	        Files.write(outputPath, bytes);
	
	
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.set(
	                "Content-Disposition",
	                "attachment; filename=\"" + fileName + "\""
	        );
	
	        System.out.println("處理完成: 更新 " + existingTables.size() +
	                " 個, 新增 " + newTables.size() + " 個代碼表");
	
	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(bytes);
	
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return ResponseEntity.badRequest().body(null);
	    }
	}


    private void updateCodeTablesInDocument(XWPFDocument document, 
                                            List<Map<String, Object>> codeTables) {
        List<XWPFTable> tables = document.getTables();
        int codeTableIndex = 0;
        for (XWPFTable table : tables) {
            if (!isCodeTable(table)) continue;
            
            if (codeTableIndex >= codeTables.size()) break;
            Map<String, Object> newTableData = codeTables.get(codeTableIndex);
            List<Map<String, String>> newRows = 
                (List<Map<String, String>>) newTableData.get("rows");
            
            updateTableContent(table, newRows);
            
            codeTableIndex++;
        }
        
        System.out.println("已更新 " + codeTableIndex + " 個現有代碼表");
    }

    private void appendNewCodeTables(XWPFDocument document, 
                                     List<Map<String, Object>> newTables) {
        for (Map<String, Object> tableData : newTables) {
            String tableName = (String) tableData.get("tableName");
            List<Map<String, String>> rows = 
                (List<Map<String, String>>) tableData.get("rows");
            
            XWPFParagraph titlePara = document.createParagraph();
            XWPFRun titleRun = titlePara.createRun();
            titleRun.setText(tableName);
            // titleRun.setBold(true);
            titleRun.setFontFamily("標楷體"); // 標楷體
            titleRun.setFontSize(14); // 14pt
            
            
            XWPFTable newTable = document.createTable(1, 2);
            
            newTable.setWidth("100%");
            
            XWPFTableRow headerRow = newTable.getRow(0);
            XWPFTableCell codeHeaderCell = headerRow.getCell(0);
            codeHeaderCell.removeParagraph(0);
            XWPFParagraph codeHeaderPara = codeHeaderCell.addParagraph();
            codeHeaderPara.setAlignment(ParagraphAlignment.CENTER); // 置中對齊
            XWPFRun codeHeaderRun = codeHeaderPara.createRun();
            codeHeaderRun.setText("代碼");
            codeHeaderRun.setBold(true);
            codeHeaderRun.setFontFamily("標楷體"); 
            codeHeaderRun.setFontSize(12); // 12pt
            codeHeaderCell.setColor("FFFFFF"); 
            setCellBorders(codeHeaderCell);
            
            XWPFTableCell descHeaderCell = headerRow.getCell(1);
            descHeaderCell.removeParagraph(0);
            XWPFParagraph descHeaderPara = descHeaderCell.addParagraph();
            descHeaderPara.setAlignment(ParagraphAlignment.CENTER); 
            XWPFRun descHeaderRun = descHeaderPara.createRun();
            descHeaderRun.setText("說明");
            descHeaderRun.setBold(true);
            descHeaderRun.setFontFamily("標楷體"); 
            descHeaderRun.setFontSize(12); 
            descHeaderCell.setColor("FFFFFF"); 
            setCellBorders(descHeaderCell);
            
            headerRow.setHeight(450); 
            
            for (Map<String, String> rowData : rows) {
                XWPFTableRow dataRow = newTable.createRow();
                
                while (dataRow.getTableCells().size() < 2) {
                    dataRow.addNewTableCell();
                }
                
                String code = rowData.get("code");
                String desc = rowData.get("description");
                
                XWPFTableCell codeCell = dataRow.getCell(0);
                codeCell.removeParagraph(0);
                XWPFParagraph codePara = codeCell.addParagraph();
                codePara.setAlignment(ParagraphAlignment.CENTER); 
                XWPFRun codeRun = codePara.createRun();
                codeRun.setText(code != null ? code : "");
                codeRun.setFontFamily("Times New Roman"); 
                codeRun.setFontSize(12); // 12pt
                codeCell.setColor("FFFFFF"); 
                setCellBorders(codeCell);
                
                XWPFTableCell descCell = dataRow.getCell(1);
                descCell.removeParagraph(0);
                XWPFParagraph descPara = descCell.addParagraph();
                descPara.setAlignment(ParagraphAlignment.LEFT); 
                XWPFRun descRun = descPara.createRun();
                descRun.setText(desc != null ? desc : "");
                descRun.setFontFamily("標楷體"); 
                descRun.setFontSize(12);
                descCell.setColor("FFFFFF"); 
                setCellBorders(descCell);
                
                dataRow.setHeight(450); 
            }
            
            document.createParagraph();
        }
        
        System.out.println("已新增 " + newTables.size() + " 個代碼表");
    }

    private void setCellBorders(XWPFTableCell cell) {
        CTTcPr tcpr = cell.getCTTc().addNewTcPr();
        CTTcBorders borders = tcpr.addNewTcBorders();
        
        CTBorder topBorder = borders.addNewTop();
        topBorder.setVal(STBorder.SINGLE);
        topBorder.setSz(BigInteger.valueOf(4)); 
        topBorder.setColor("000000"); 
        
        CTBorder bottomBorder = borders.addNewBottom();
        bottomBorder.setVal(STBorder.SINGLE);
        bottomBorder.setSz(BigInteger.valueOf(4));
        bottomBorder.setColor("000000");
        
        CTBorder leftBorder = borders.addNewLeft();
        leftBorder.setVal(STBorder.SINGLE);
        leftBorder.setSz(BigInteger.valueOf(4));
        leftBorder.setColor("000000");
        
        CTBorder rightBorder = borders.addNewRight();
        rightBorder.setVal(STBorder.SINGLE);
        rightBorder.setSz(BigInteger.valueOf(4));
        rightBorder.setColor("000000");
    }

    private void overrideCell(XWPFTableCell cell, String text) {
        while (cell.getParagraphs().size() > 0) {
            cell.removeParagraph(0);
        }
        
        XWPFParagraph paragraph = cell.addParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontFamily("標楷體"); 
        run.setFontSize(12);
        
        cell.setColor("FFFFFF");
        
        setCellBorders(cell);
    }

    private void updateTableContent(XWPFTable table, List<Map<String, String>> newRows) {
        int rowCount = table.getNumberOfRows();
        for (int i = rowCount - 1; i > 0; i--) {
            table.removeRow(i);
        }
        
        for (Map<String, String> rowData : newRows) {
            XWPFTableRow dataRow = table.createRow();
            
            while (dataRow.getTableCells().size() < 2) {
                dataRow.addNewTableCell();
            }
            
            String code = rowData.get("code");
            String desc = rowData.get("description");
            
            XWPFTableCell codeCell = dataRow.getCell(0);
            codeCell.removeParagraph(0);
            XWPFParagraph codePara = codeCell.addParagraph();
            codePara.setAlignment(ParagraphAlignment.CENTER); 
            XWPFRun codeRun = codePara.createRun();
            codeRun.setText(code != null ? code : "");
            codeRun.setFontFamily("Times New Roman"); 
            codeRun.setFontSize(12); // 12pt
            codeCell.setColor("FFFFFF");
            setCellBorders(codeCell);
            
            XWPFTableCell descCell = dataRow.getCell(1);
            descCell.removeParagraph(0);
            XWPFParagraph descPara = descCell.addParagraph();
            descPara.setAlignment(ParagraphAlignment.LEFT); 
            XWPFRun descRun = descPara.createRun();
            descRun.setText(desc != null ? desc : "");
            descRun.setFontFamily("標楷體"); 
            descRun.setFontSize(12); // 12pt
            descCell.setColor("FFFFFF");
            setCellBorders(descCell);
            
            dataRow.setHeight(450);
        }
    }
    private void updateHeaderFields(XWPFDocument document, Map<String, String> fields) {
        XWPFTable table = findHeaderTable(document);
        if (table == null) {
            System.out.println("找不到表頭表格");
            return;
        }

        Map<String, String> fieldMapping = new HashMap<>();
        fieldMapping.put("案號", "案號");
        fieldMapping.put("申請日期", "申請日期");

        updateTableFields(table, fields, fieldMapping);
    }

    private XWPFTable findHeaderTable(XWPFDocument doc) {
        for (XWPFTable table : doc.getTables()) {
            String text = table.getText();
            if (text.contains("案號") || text.contains("申請日期")) {
                return table;
            }
        }
        return null;
    }

    private void updateDetailFields(XWPFDocument document, Map<String, String> fields) {
        XWPFTable table = findDetailTable(document);
        if (table == null) {
            System.out.println("找不到明細表格");
            return;
        }

        Map<String, String> fieldMapping = new HashMap<>();
        fieldMapping.put("項次", "d_index");
        fieldMapping.put("應補辦事項代碼", "d_code");
        fieldMapping.put("輸出入規定", "d_rule");

        updateTableFields(table, fields, fieldMapping);
    }

    private XWPFTable findDetailTable(XWPFDocument doc) {
        for (XWPFTable table : doc.getTables()) {
            String txt = table.getText();
            if (txt.contains("項次") && txt.contains("應補辦事項代碼") && txt.contains("輸出入規定")) {
                return table;
            }
        }
        return null;
    }

    private void updateTableFields(XWPFTable table,
                                   Map<String, String> fields,
                                   Map<String, String> mapRules) {
        for (XWPFTableRow row : table.getRows()) {
            if (row.getTableCells().size() < 2) continue;

            XWPFTableCell keyCell = row.getCell(0);
            XWPFTableCell valCell = row.getCell(1);
            String key = keyCell.getText().trim();

            for (String keyword : mapRules.keySet()) {
                if (key.contains(keyword)) {
                    String fieldName = mapRules.get(keyword);
                    String value = fields.get(fieldName);
                    if (value != null) {
                        overrideCell(valCell, value);
                    }
                }
            }
        }
    }
}