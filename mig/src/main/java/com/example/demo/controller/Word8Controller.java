package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletResponse;


import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.MyConst;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/word8")
public class Word8Controller {

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/word-editor8")
    public String wordEditor() {
        return "word-editor8";
    }

    @PostMapping("/parse")
    @ResponseBody
    public Map<String, Object> parseDocx(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        XWPFDocument document = null;

        try {
            document = new XWPFDocument(file.getInputStream());
            Map<String, Object> tableResult = extractRevisionTableWithColumns(document);

            @SuppressWarnings("unchecked")
            List<Map<String, Object>> revisionTableData = (List<Map<String, Object>>) tableResult.get("data");

            normalizeSeaAirCellsWithDropdown(revisionTableData);

            result.put("success", true);
            result.put("revisionTableData", revisionTableData);
            result.put("columns", tableResult.get("columns"));
            result.put("headerRows", tableResult.get("headerRows"));

            String jsonDebug = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            System.out.println("===== JSON DEBUG =====");
            System.out.println(jsonDebug);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("error", e.getMessage());

            try {
                String jsonDebugError = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
                System.out.println("===== JSON DEBUG (ERROR) =====");
                System.out.println(jsonDebugError);
            } catch (Exception jsonEx) {
                jsonEx.printStackTrace();
            }

        } finally {
            if (document != null) try { document.close(); } catch (Exception e) { e.printStackTrace(); }
        }

        return result;
    }

    @PostMapping("/replace")
    public void replaceDocx(@RequestParam("file") MultipartFile file,
                             @RequestParam(value = "revisionTable", required = false) String revisionTableJson,
                             @RequestParam(value = "columns", required = false) String columnsJson,
                             HttpServletResponse response) {

        XWPFDocument document = null;
        try {
            List<Map<String, Object>> revisionTable = null;
            List<Map<String, Object>> columns = null;

            if (revisionTableJson != null && !revisionTableJson.isEmpty()) {
                revisionTable = objectMapper.readValue(revisionTableJson,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class));
            }
            if (columnsJson != null && !columnsJson.isEmpty()) {
                columns = objectMapper.readValue(columnsJson,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class));
            }

            document = new XWPFDocument(file.getInputStream());

            if (revisionTable != null && !revisionTable.isEmpty() && columns != null) {
                normalizeSeaAirCellsWithDropdown(revisionTable);
                replaceRevisionTableWithDynamicRows(document, revisionTable, columns);
            }

            String rawName = getModifiedFileName(file.getOriginalFilename());

            // 只保留檔名，移除任何路徑（Windows / Linux 都適用）
            String outFilename = Paths.get(rawName).getFileName().toString();

            // File dir = new File("./docx/");
            File dir = new File(MyConst.getWordAllBaseFilePath(), "docx");
            
            if (!dir.exists()) dir.mkdirs();

            File outFile = new File(dir, outFilename);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                document.write(baos);
                FileOutputStream fos = new FileOutputStream(outFile);
                try { baos.writeTo(fos); } finally { fos.close(); }

                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                response.setHeader("Content-Disposition",
                        "attachment; filename=\"" + URLEncoder.encode(outFilename, "UTF-8") + "\"");
                baos.writeTo(response.getOutputStream());
                response.getOutputStream().flush();
            } finally { baos.close(); }

        } catch (Exception e) {
            e.printStackTrace();
            try { response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "處理失敗：" + e.getMessage()); }
            catch (Exception ex) { ex.printStackTrace(); }
        } finally {
            if (document != null) try { document.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    private Map<String, Object> extractRevisionTableWithColumns(XWPFDocument document) throws Exception {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, String>> tableData = new ArrayList<>();
        List<Map<String, Object>> columns = new ArrayList<>();
        List<String> headerRowTexts = new ArrayList<>();

        List<XWPFTable> tables = document.getTables();
        if (tables == null || tables.isEmpty()) {
            result.put("data", tableData);
            result.put("columns", columns);
            result.put("headerRows", headerRowTexts);
            return result;
        }

        XWPFTable table = tables.get(0);
        List<XWPFTableRow> allRows = table.getRows();
        if (allRows.isEmpty()) {
            result.put("data", tableData);
            result.put("columns", columns);
            result.put("headerRows", headerRowTexts);
            return result;
        }

        MergeCellTracker tracker = new MergeCellTracker(allRows);

        XWPFTableRow firstRow = allRows.get(0);
        List<CellInfo> firstRowCells = extractCellsWithMergeInfo(firstRow, 0, tracker);
        for (int i = 0; i < firstRowCells.size(); i++) {
            CellInfo cellInfo = firstRowCells.get(i);
            Map<String, Object> col = new HashMap<>();
            String title = cellInfo.text == null ? "" : cellInfo.text.trim();
            if (title.isEmpty()) title = "欄位" + (i + 1);

            col.put("title", title);
            col.put("field", "col_" + i);
            col.put("width", title.length() > 5 ? 3 : 1);
            col.put("gridSpan", cellInfo.gridSpan);
            col.put("vMerge", cellInfo.vMergeType);
            if (i == 9 || i == 10 || i == 12) {
                col.put("options", Arrays.asList("-", "M", "C"));
            }
            columns.add(col);
        }
        headerRowTexts.add(getRowText(firstRow));

        for (int rowIdx = 1; rowIdx < allRows.size(); rowIdx++) {
            XWPFTableRow row = allRows.get(rowIdx);
            List<CellInfo> cells = extractCellsWithMergeInfo(row, rowIdx, tracker);
            Map<String, String> rowData = new LinkedHashMap<>();
            for (int colIdx = 0; colIdx < columns.size(); colIdx++) {
                String field = "col_" + colIdx;
                String text = "";
                int gSpan = 1;
                String vMerge = "";

                if (colIdx < cells.size()) {
                    CellInfo cellInfo = cells.get(colIdx);
                    text = cellInfo.text;
                    gSpan = cellInfo.gridSpan;
                    vMerge = cellInfo.vMergeType;
                }
                rowData.put(field, text);
                rowData.put(field + "_gridSpan", String.valueOf(gSpan));
                rowData.put(field + "_vMerge", vMerge);
            }
            tableData.add(rowData);
        }

        result.put("data", tableData);
        result.put("columns", columns);
        result.put("headerRows", headerRowTexts);
        return result;
    }

    private void normalizeSeaAirCellsWithDropdown(List<Map<String, Object>> tableData) {
        List<String> targetCols = Arrays.asList("col_9", "col_10", "col_12"); // 第 10、11、13 欄
        List<String> allowedValues = Arrays.asList("-", "M", "C");


        for (int rowIdx = 0; rowIdx < tableData.size(); rowIdx++) {
            Map<String, Object> row = tableData.get(rowIdx);

            for (String col : targetCols) {
                Object valObj = row.get(col);
                String val = valObj == null ? "" : valObj.toString().trim();
                
                row.put(col, val);

                row.put(col + "_options", allowedValues);

            }
        }

    }

    private void replaceRevisionTableWithDynamicRows(XWPFDocument document,
                                                      List<Map<String, Object>> newTableData,
                                                      List<Map<String, Object>> columns) throws Exception {
        List<XWPFTable> tables = document.getTables();
        if (tables == null || tables.isEmpty()) return;

        XWPFTable table = tables.get(0);
        List<XWPFTableRow> originalRows = table.getRows();
        if (originalRows.size() <= 1) return;

        int originalDataRowCount = originalRows.size() - 1;
        int newDataRowCount = newTableData.size();

        int rowsToUpdate = Math.min(newDataRowCount, originalDataRowCount);
        for (int r = 0; r < rowsToUpdate; r++) {
            Map<String, Object> rowObj = newTableData.get(r);
            Map<String, String> rowData = convertRowData(rowObj);
            XWPFTableRow targetRow = originalRows.get(r + 1);
            updateRowCells(targetRow, rowData, columns);
        }

        if (newDataRowCount > originalDataRowCount) {
            int templateRowIndex = Math.min(5, originalRows.size() - 1); // 確保不超出範圍
            XWPFTableRow templateRow = originalRows.get(templateRowIndex);
            
            for (int r = originalDataRowCount; r < newDataRowCount; r++) {
                XWPFTableRow newRow = cloneTableRow(table, templateRow);
                clearVMergeInRow(newRow);
                Map<String, Object> rowObj = newTableData.get(r);
                Map<String, String> rowData = convertRowData(rowObj);
                updateRowCells(newRow, rowData, columns);
            }
        } 
        else if (newDataRowCount < originalDataRowCount) {
            for (int r = originalRows.size() - 1; r > newDataRowCount; r--) {
                table.removeRow(r);
            }
        }
        
        applyVMergeFromData(table, newTableData, columns);
        validateAndFixVMerge(table, columns);
    }

    private void updateRowCells(XWPFTableRow row, Map<String, String> rowData,
                            List<Map<String, Object>> columns) {
    List<XWPFTableCell> cells = row.getTableCells();
    int logicalColIndex = 0;
    int physicalCellIndex = 0;


    while (logicalColIndex < columns.size()) {
        String field = "col_" + logicalColIndex;
        String gridSpanKey = field + "_gridSpan";
        
        // 讀取資料中的 gridSpan
        int dataGridSpan = 1;
        if (rowData.containsKey(gridSpanKey)) {
            try {
                String gsStr = rowData.get(gridSpanKey);
                dataGridSpan = Integer.parseInt(gsStr);
            } catch (NumberFormatException e) {
                dataGridSpan = 1;
            }
        }
        
        if (dataGridSpan == 0) {
            System.out.println("   跳過虛擬欄位: col_" + logicalColIndex + " (gridSpan=0)");
            logicalColIndex++;
            continue;
        }

        if (physicalCellIndex >= cells.size()) {
            System.out.println("   實體儲存格已用盡，邏輯欄位: col_" + logicalColIndex);
            break;
        }

        XWPFTableCell cell = cells.get(physicalCellIndex);
        
        CTTcPr tcPr = cell.getCTTc().getTcPr();
        int existingGridSpan = 1;
        if (tcPr != null && tcPr.getGridSpan() != null) {
            existingGridSpan = tcPr.getGridSpan().getVal().intValue();
        }

        if (rowData.containsKey(field)) {
            String text = rowData.get(field);
            setCellText(cell, text);
            System.out.println("   設定 col_" + logicalColIndex + " (實體索引:" + physicalCellIndex + ") = '" + text + "' (gridSpan=" + dataGridSpan + ")");
        }

        if (dataGridSpan > 0 && dataGridSpan != existingGridSpan) {
            updateCellGridSpan(cell, dataGridSpan);
            System.out.println("   更新 gridSpan: col_" + logicalColIndex + " 從 " + existingGridSpan + " 改為 " + dataGridSpan);
        }

        
        logicalColIndex++;
        physicalCellIndex++;
    }
    
}

    private XWPFTableRow cloneTableRow(XWPFTable table, XWPFTableRow sourceRow) {
        XWPFTableRow newRow = table.createRow();
        
        CTRow ctSourceRow = sourceRow.getCtRow();
        CTRow ctNewRow = newRow.getCtRow();
        
        if (ctSourceRow.getTrPr() != null) {
            if (ctNewRow.getTrPr() == null) {
                ctNewRow.addNewTrPr();
            }
            CTTrPr sourceTrPr = ctSourceRow.getTrPr();
            CTTrPr newTrPr = ctNewRow.getTrPr();
            
            if (sourceTrPr.addNewTrHeight() != null) {
            	XWPFTableRow row = table.getRow(0);
            	CTTrPr trPr = row.getCtRow().isSetTrPr() ? row.getCtRow().getTrPr() : row.getCtRow().addNewTrPr();

            	CTHeight newHeight = trPr.addNewTrHeight();
            	newHeight.setVal(BigInteger.valueOf(500));  
            	newHeight.setHRule(STHeightRule.EXACT);     
                newHeight.setVal(sourceTrPr.addNewTrHeight().getVal());
                if (sourceTrPr.addNewTrHeight().getHRule() != null) {
                    newHeight.setHRule(sourceTrPr.addNewTrHeight().getHRule());
                }
            }
        }
        
        List<XWPFTableCell> sourceCells = sourceRow.getTableCells();
        List<XWPFTableCell> newCells = newRow.getTableCells();
        
        System.out.println("複製列：來源實體儲存格數 = " + sourceCells.size());
        
        while (newCells.size() < sourceCells.size()) {
            newRow.createCell();
            newCells = newRow.getTableCells();
        }
        
        while (newCells.size() > sourceCells.size()) {
            int lastIndex = newCells.size() - 1;
            newRow.getTableCells().remove(lastIndex);
            newCells = newRow.getTableCells();
        }
        
        for (int i = 0; i < sourceCells.size(); i++) {
            XWPFTableCell sourceCell = sourceCells.get(i);
            XWPFTableCell newCell = newCells.get(i);
            cloneTableCell(sourceCell, newCell);
        }
        
        System.out.println("列複製完成，新列實體儲存格數 = " + newRow.getTableCells().size());
        return newRow;
    }

    private void cloneTableCell(XWPFTableCell sourceCell, XWPFTableCell newCell) {
        CTTc ctSourceCell = sourceCell.getCTTc();
        CTTc ctNewCell = newCell.getCTTc();
        
        // 複製儲存格屬性
        if (ctSourceCell.getTcPr() != null) {
            if (ctNewCell.getTcPr() == null) {
                ctNewCell.addNewTcPr();
            }
            
            CTTcPr sourceTcPr = ctSourceCell.getTcPr();
            CTTcPr newTcPr = ctNewCell.getTcPr();
            
            if (sourceTcPr.isSetGridSpan()) {
                CTDecimalNumber newGridSpan = newTcPr.isSetGridSpan() ? newTcPr.getGridSpan() : newTcPr.addNewGridSpan();
                newGridSpan.setVal(sourceTcPr.getGridSpan().getVal());
                System.out.println("複製 gridSpan = " + sourceTcPr.getGridSpan().getVal());
            }
            
            if (newTcPr.isSetVMerge()) {
                newTcPr.unsetVMerge();
            }
            
            if (sourceTcPr.isSetTcW()) {
                CTTblWidth newTcW = newTcPr.isSetTcW() ? newTcPr.getTcW() : newTcPr.addNewTcW();
                newTcW.setW(sourceTcPr.getTcW().getW());
                newTcW.setType(sourceTcPr.getTcW().getType());
            }
            
            if (sourceTcPr.isSetVAlign()) {
                CTVerticalJc newVAlign = newTcPr.isSetVAlign() ? newTcPr.getVAlign() : newTcPr.addNewVAlign();
                newVAlign.setVal(sourceTcPr.getVAlign().getVal());
            }
            
            if (sourceTcPr.isSetShd()) {
                CTShd sourceShd = sourceTcPr.getShd();
                CTShd newShd = newTcPr.isSetShd() ? newTcPr.getShd() : newTcPr.addNewShd();
                if (sourceShd.getFill() != null) {
                    newShd.setFill(sourceShd.getFill());
                }
                if (sourceShd.getVal() != null) {
                    newShd.setVal(sourceShd.getVal());
                }
            }
            
            if (sourceTcPr.isSetTcBorders()) {
                if (!newTcPr.isSetTcBorders()) {
                    newTcPr.addNewTcBorders();
                }
            }
        }
        
        List<XWPFParagraph> sourceParagraphs = sourceCell.getParagraphs();
        List<XWPFParagraph> newParagraphs = newCell.getParagraphs();
        
        for (int i = newParagraphs.size() - 1; i >= 0; i--) {
            newCell.removeParagraph(i);
        }
        
        if (sourceParagraphs != null && !sourceParagraphs.isEmpty()) {
            for (int i = 0; i < sourceParagraphs.size(); i++) {
                XWPFParagraph sourcePara = sourceParagraphs.get(i);
                XWPFParagraph newPara = newCell.addParagraph();
                
                newPara.setAlignment(sourcePara.getAlignment());
                
                if (sourcePara.getStyle() != null) {
                    newPara.setStyle(sourcePara.getStyle());
                }
                
                List<XWPFRun> sourceRuns = sourcePara.getRuns();
                if (sourceRuns != null && !sourceRuns.isEmpty()) {
                    XWPFRun sourceRun = sourceRuns.get(0);
                    XWPFRun newRun = newPara.createRun();
                    
                    if (sourceRun.getFontFamily() != null) {
                        newRun.setFontFamily(sourceRun.getFontFamily());
                    }
                    if (sourceRun.getFontSize() > 0) {
                        newRun.setFontSize(sourceRun.getFontSize());
                    }
                    newRun.setBold(sourceRun.isBold());
                    newRun.setItalic(sourceRun.isItalic());
                    
                    newRun.setText("", 0);
                }
            }
        } else {
            newCell.addParagraph();
        }
    }

    private void clearVMergeInRow(XWPFTableRow row) {
        List<XWPFTableCell> cells = row.getTableCells();
        for (int i = 0; i < cells.size(); i++) {
            XWPFTableCell cell = cells.get(i);
            CTTcPr tcPr = cell.getCTTc().getTcPr();
            if (tcPr != null && tcPr.isSetVMerge()) {
                tcPr.unsetVMerge();
            }
        }
    }

    private void validateAndFixVMerge(XWPFTable table, List<Map<String, Object>> columns) {
        List<XWPFTableRow> rows = table.getRows();
        if (rows.size() <= 1) return;

        for (int colIdx = 0; colIdx < columns.size(); colIdx++) {
            boolean inMerge = false;
            boolean hasRestart = false;
            
            for (int rowIdx = 1; rowIdx < rows.size(); rowIdx++) {
                XWPFTableRow row = rows.get(rowIdx);
                List<XWPFTableCell> cells = row.getTableCells();
                
                int physicalCellIdx = getPhysicalCellIndex(row, colIdx);
                if (physicalCellIdx < 0 || physicalCellIdx >= cells.size()) continue;
                
                XWPFTableCell cell = cells.get(physicalCellIdx);
                CTTcPr tcPr = cell.getCTTc().getTcPr();
                
                if (tcPr != null && tcPr.isSetVMerge()) {
                    STMerge.Enum vMerge = tcPr.getVMerge().getVal();
                    String vMergeType = (vMerge == null || vMerge == STMerge.RESTART) ? "restart" : "continue";
                    
                    if (vMergeType.equals("restart")) {
                        inMerge = true;
                        hasRestart = true;
                    } else if (vMergeType.equals("continue")) {
                        if (!inMerge) {
                            System.out.println("修正：列 " + rowIdx + " 欄 " + colIdx + " 的 vMerge 不一致（continue 無 restart）");
                            tcPr.unsetVMerge();
                        }
                    }
                } else {
                    inMerge = false;
                    hasRestart = false;
                }
            }
        }
    }

    private int getPhysicalCellIndex(XWPFTableRow row, int logicalColIndex) {
        List<XWPFTableCell> cells = row.getTableCells();
        int currentLogicalCol = 0;
        
        for (int i = 0; i < cells.size(); i++) {
            XWPFTableCell cell = cells.get(i);
            CTTcPr tcPr = cell.getCTTc().getTcPr();
            int gridSpan = 1;
            if (tcPr != null && tcPr.isSetGridSpan()) {
                gridSpan = tcPr.getGridSpan().getVal().intValue();
            }
            
            if (currentLogicalCol == logicalColIndex) {
                return i;
            }
            
            currentLogicalCol += gridSpan;
        }
        
        return -1;
    }

    private void applyVMergeFromData(XWPFTable table, List<Map<String, Object>> newTableData, List<Map<String, Object>> columns) {
        if (table == null || newTableData == null || columns == null) return;
        List<XWPFTableRow> rows = table.getRows();
        
        // header row is rows.get(0), data rows start at index 1
        for (int dataRowIdx = 0; dataRowIdx < newTableData.size(); dataRowIdx++) {
            int tableRowIdx = dataRowIdx + 1; // mapping
            if (tableRowIdx >= rows.size()) break;
            
            XWPFTableRow tableRow = rows.get(tableRowIdx);
            Map<String, Object> rowObj = newTableData.get(dataRowIdx);
            
            for (int logicalCol = 0; logicalCol < columns.size(); logicalCol++) {
                String field = "col_" + logicalCol;
                String vMergeKey = field + "_vMerge";
                Object vmObj = rowObj.get(vMergeKey);
                String vmValue = vmObj == null ? "" : vmObj.toString();

                int physicalIndex = getPhysicalCellIndex(tableRow, logicalCol);
                if (physicalIndex < 0) continue;
                
                List<XWPFTableCell> cells = tableRow.getTableCells();
                if (physicalIndex >= cells.size()) continue;
                
                XWPFTableCell cell = cells.get(physicalIndex);
                updateCellVMerge(cell, vmValue);
            }
        }
    }

    private void updateCellVMerge(XWPFTableCell cell, String vMergeType) {
        if (vMergeType == null || vMergeType.trim().isEmpty()) {
            CTTcPr existingTcPr = cell.getCTTc().getTcPr();
            if (existingTcPr != null && existingTcPr.isSetVMerge()) {
                existingTcPr.unsetVMerge();
            }
            return;
        }

        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
        CTVMerge vMerge = tcPr.isSetVMerge() ? tcPr.getVMerge() : tcPr.addNewVMerge();

        if (vMergeType.equalsIgnoreCase("restart") || vMergeType.equalsIgnoreCase("start") || vMergeType.equalsIgnoreCase("r")) {
            vMerge.setVal(STMerge.RESTART);
        } else if (vMergeType.equalsIgnoreCase("continue") || vMergeType.equalsIgnoreCase("cont") || vMergeType.equalsIgnoreCase("c")) {
            vMerge.setVal(STMerge.CONTINUE);
        } else {
            if (tcPr.isSetVMerge()) {
                tcPr.unsetVMerge();
            }
        }
    }

    private void updateCellGridSpan(XWPFTableCell cell, int gridSpan) {
        if (gridSpan <= 0) return;
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
        CTDecimalNumber gridSpanObj = tcPr.isSetGridSpan() ? tcPr.getGridSpan() : tcPr.addNewGridSpan();
        gridSpanObj.setVal(BigInteger.valueOf(gridSpan));
    }

    private void setCellText(XWPFTableCell cell, String text) {
        List<XWPFParagraph> paragraphs = cell.getParagraphs();
        if (paragraphs != null && !paragraphs.isEmpty()) {
            XWPFParagraph para = paragraphs.get(0);
            List<XWPFRun> runs = para.getRuns();
            if (runs != null && !runs.isEmpty()) {
                XWPFRun run = runs.get(0);
                run.setText(text == null ? "" : text, 0);
                for (int i = runs.size() - 1; i > 0; i--) {
                    para.removeRun(i);
                }
            } else {
                XWPFRun run = para.createRun();
                run.setText(text == null ? "" : text);
            }
            for (int i = paragraphs.size() - 1; i > 0; i--) {
                cell.removeParagraph(i);
            }
        } else {
            XWPFParagraph para = cell.addParagraph();
            XWPFRun run = para.createRun();
            run.setText(text == null ? "" : text);
        }
    }

    private Map<String, String> convertRowData(Map<String, Object> rowObj) {
        Map<String, String> rowData = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : rowObj.entrySet()) {
            rowData.put(entry.getKey(), entry.getValue() == null ? "" : String.valueOf(entry.getValue()));
        }
        return rowData;
    }

    private static class MergeCellTracker {
        private Map<String, String> vMergeStatus;
        private Map<String, Integer> gridSpanMap;

        public MergeCellTracker(List<XWPFTableRow> rows) {
            this.vMergeStatus = new HashMap<String, String>();
            this.gridSpanMap = new HashMap<String, Integer>();
            analyzeTable(rows);
        }

        private void analyzeTable(List<XWPFTableRow> rows) {
            for (int rowIdx = 0; rowIdx < rows.size(); rowIdx++) {
                XWPFTableRow row = rows.get(rowIdx);
                List<XWPFTableCell> cells = row.getTableCells();
                int logicalCol = 0;
                for (XWPFTableCell cell : cells) {
                    CTTcPr tcPr = cell.getCTTc().getTcPr();
                    int gridSpan = 1;
                    if (tcPr != null && tcPr.isSetGridSpan()) {
                        gridSpan = tcPr.getGridSpan().getVal().intValue();
                    }
                    gridSpanMap.put(rowIdx + "_" + logicalCol, Integer.valueOf(gridSpan));

                    if (tcPr != null && tcPr.isSetVMerge()) {
                        STMerge.Enum vMerge = tcPr.getVMerge().getVal();
                        String vMergeType = (vMerge == null || vMerge == STMerge.RESTART) ? "restart" : "continue";
                        vMergeStatus.put(rowIdx + "_" + logicalCol, vMergeType);
                    }

                    logicalCol += gridSpan;
                }
            }
        }

    }

    private static class CellInfo {
        String text;
        int gridSpan;
        String vMergeType;
        boolean isVirtual;

        public CellInfo(String text, int gridSpan, String vMergeType, boolean isVirtual) {
            this.text = text == null ? "" : text;
            this.gridSpan = gridSpan;
            this.vMergeType = vMergeType == null ? "" : vMergeType;
            this.isVirtual = isVirtual;
        }
    }

    private List<CellInfo> extractCellsWithMergeInfo(XWPFTableRow row, int rowIdx, MergeCellTracker tracker) {
        List<CellInfo> result = new ArrayList<CellInfo>();
        List<XWPFTableCell> physicalCells = row.getTableCells();
        int logicalCol = 0;
        int physicalCellIdx = 0;

        int maxLogicalCols = 0;
        for (XWPFTableCell cell : physicalCells) {
            CTTcPr tcPr = cell.getCTTc().getTcPr();
            int span = tcPr != null && tcPr.isSetGridSpan() ? tcPr.getGridSpan().getVal().intValue() : 1;
            maxLogicalCols += span;
        }

        while (logicalCol < maxLogicalCols && physicalCellIdx < physicalCells.size()) {
            XWPFTableCell cell = physicalCells.get(physicalCellIdx);
            CTTcPr tcPr = cell.getCTTc().getTcPr();
            int gridSpan = 1;
            if (tcPr != null && tcPr.isSetGridSpan()) {
                gridSpan = tcPr.getGridSpan().getVal().intValue();
            }

            String vMergeType = "";
            if (tcPr != null && tcPr.isSetVMerge()) {
                STMerge.Enum vMerge = tcPr.getVMerge().getVal();
                vMergeType = (vMerge == null || vMerge == STMerge.RESTART) ? "restart" : "continue";
            }

            String text = cell.getText();
            result.add(new CellInfo(text, gridSpan, vMergeType, false));

            for (int i = 1; i < gridSpan; i++) {
                result.add(new CellInfo("", 0, vMergeType, true));
            }

            logicalCol += gridSpan;
            physicalCellIdx++;
        }

        return result;
    }

    private String getRowText(XWPFTableRow row) {
        StringBuilder sb = new StringBuilder();
        List<XWPFTableCell> cells = row.getTableCells();
        for (int i = 0; i < cells.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(cells.get(i).getText());
        }
        return sb.toString().trim();
    }

    private String getModifiedFileName(String originalName) {
        if (originalName == null || originalName.isEmpty()) {
            return "modified.docx";
        }
        return originalName.replaceAll("\\.docx$", "_modified.docx");
    }
}
