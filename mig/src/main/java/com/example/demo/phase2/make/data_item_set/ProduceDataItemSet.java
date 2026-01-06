package com.example.demo.phase2.make.data_item_set;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.example.demo.MyConst;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

public class ProduceDataItemSet {

    private XWPFDocument document = null;
    private final String file;

    private static final String FONT_NAME = "標楷體";

    private static final String HEADER_COLOR = "FFFF00"; // 黃色

    public ProduceDataItemSet() {
        this("");
    }

    public ProduceDataItemSet(String file) {
        this.file = file;
    }

    public void openDoc() {
        try {
            if (document == null) {
                document = new XWPFDocument();

                CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
                CTPageSz pageSize = sectPr.addNewPgSz();
                pageSize.setW(BigInteger.valueOf(16838));
                pageSize.setH(BigInteger.valueOf(11906));
                pageSize.setOrient(STPageOrientation.LANDSCAPE);

                CTPageMar pageMar = sectPr.addNewPgMar();
                pageMar.setLeft(BigInteger.valueOf(700));
                pageMar.setRight(BigInteger.valueOf(700));
                pageMar.setTop(BigInteger.valueOf(1000));
                pageMar.setBottom(BigInteger.valueOf(1000));

                Path outputPath = Paths.get(file).getParent();
                if (outputPath != null && !Files.exists(outputPath)) {
                    Files.createDirectories(outputPath);
                } else {
                }

            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeDoc() {
        if (document != null) {
            try (FileOutputStream out = new FileOutputStream(file)) {
                document.write(out);
                document.close();
                
                // 驗證檔案
                Path filePath = Paths.get(file);
                if (Files.exists(filePath)) {
                    long fileSize = Files.size(filePath);
                } else {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        }
    }

    private void addTableHeader(XWPFTable table, String[] headers, int[] widths) {
        XWPFTableRow headerRow = table.getRow(0);
        if (headerRow == null) headerRow = table.createRow();

        for (int i = 0; i < headers.length; i++) {
            XWPFTableCell cell = (i == 0) ? headerRow.getCell(0) : headerRow.addNewTableCell();
            setCellText(cell, headers[i], 14, true, ParagraphAlignment.CENTER);

            if (widths != null && i < widths.length) {
                CTTblWidth cellWidth = cell.getCTTc().addNewTcPr().addNewTcW();
                cellWidth.setType(STTblWidth.PCT);
                cellWidth.setW(BigInteger.valueOf(widths[i] * 50));
            }
        }
    }

    private void setCellText(XWPFTableCell cell, String text, int fontSize, boolean isHeader, ParagraphAlignment align) {
        if (cell == null) return;

        if (cell.getParagraphs().size() > 0) cell.removeParagraph(0);

        XWPFParagraph para = cell.addParagraph();
        para.setAlignment(align);

        XWPFRun run = para.createRun();
        run.setText(text != null ? text : "");
        run.setFontFamily(FONT_NAME);
        run.setFontSize(fontSize);

        if (isHeader) {
            run.setBold(true);
            CTShd shd = cell.getCTTc().addNewTcPr().addNewShd();
            shd.setFill(HEADER_COLOR);
        }

        CTVerticalJc vAlign = cell.getCTTc().addNewTcPr().addNewVAlign();
        vAlign.setVal(STVerticalJc.CENTER);
    }

    private void mergeCellsHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
        XWPFTableRow tableRow = table.getRow(row);
        if (tableRow == null) return;

        for (int colIndex = fromCol; colIndex <= toCol; colIndex++) {
            XWPFTableCell cell = tableRow.getCell(colIndex);
            if (cell == null) cell = tableRow.addNewTableCell();

            CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();

            if (colIndex == fromCol) tcPr.addNewHMerge().setVal(STMerge.RESTART);
            else tcPr.addNewHMerge().setVal(STMerge.CONTINUE);
        }
    }

    private void addPageBreak() {
        XWPFParagraph para = document.createParagraph();
        XWPFRun run = para.createRun();
        run.addBreak(BreakType.PAGE);
    }

    public void outTWDS2Doc() {
        try {
            ReadTWDatasetExcel reader = new ReadTWDatasetExcel();
            
            reader.readDens();
            
            reader.enrichDS();

            @SuppressWarnings("unchecked")
            List<WCOBaseDS> dataList = reader.arTWDS;
            
            
            if (dataList == null || dataList.isEmpty()) {
                return;
            }
            
            if (dataList.size() > 0) {
                WCOBaseDS first = dataList.get(0);
            }

            XWPFParagraph title = document.createParagraph();
            XWPFRun titleRun = title.createRun();
            titleRun.setText("壹、關港貿資料項目集");
            titleRun.setFontFamily(FONT_NAME);
            titleRun.setFontSize(14);
            titleRun.setBold(true);

            XWPFTable table = document.createTable();
            CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
            tblWidth.setType(STTblWidth.PCT);
            tblWidth.setW(BigInteger.valueOf(5000));

            String[] headers = {"序號", "中文名稱", "英文名稱", "中文定義", "英文定義",
                    "WCO/TW\nID", "Code Remark", "屬性及\n長度", "WCO\nSAFE", "訊息別", "備\n註"};
            addTableHeader(table, headers, new int[]{3, 10, 10, 13, 13, 5, 16, 5, 5, 19, 3});
            int rowCount = 0;
            for (WCOBaseDS item : dataList) {
                XWPFTableRow row = table.createRow();
                setCellText(row.getCell(0), item.sn, 12, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(1), item.chnname, 12, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(2), item.name, 12, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(3), item.chndef, 12, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(4), item.def, 12, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(5), item.wcoid, 12, false, ParagraphAlignment.CENTER);
                setCellText(row.getCell(6), item.codeRemarks, 12, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(7), item.format, 12, false, ParagraphAlignment.CENTER);
                setCellText(row.getCell(8), item.safe, 12, false, ParagraphAlignment.CENTER);
                setCellText(row.getCell(9), item.usedByMsgs, 12, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(10), item.starFlag, 12, false, ParagraphAlignment.CENTER);
                rowCount++;
                
            }

            addPageBreak();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outWCOClass2Doc() {
        try {
            ReadWCOBaseExcel reader = new ReadWCOBaseExcel();
            
            reader.readWCODens();
            
            reader.findUsedCls();

            @SuppressWarnings("unchecked")
            List<WCOBaseClass> classList = reader.arWCOClass;
            
            
            if (classList == null || classList.isEmpty()) {
                System.err.println("[outWCOClass2Doc] 警告: arWCOClass 資料為空!");
                return;
            }
            
            // 顯示第一筆資料
            if (classList.size() > 0) {
                WCOBaseClass first = classList.get(0);
            }

            XWPFParagraph title = document.createParagraph();
            XWPFRun titleRun = title.createRun();
            titleRun.setText("一、WCO Data Model Classes");
            titleRun.setFontFamily(FONT_NAME);
            titleRun.setFontSize(14);
            titleRun.setBold(true);

            XWPFTable table = document.createTable();
            CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
            tblWidth.setType(STTblWidth.PCT);
            tblWidth.setW(BigInteger.valueOf(5000));

            String[] headers = {"類別\n代碼", "類別英文名稱", "類別中文名稱", "類別英文定義", "類別中文定義", "本國\n使用"};
            addTableHeader(table, headers, new int[]{10, 10, 20, 20, 20, 20});

            for (WCOBaseClass item : classList) {
                XWPFTableRow row = table.createRow();
                setCellText(row.getCell(0), item.wcoid, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(1), item.objcls, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(2), item.chnname, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(3), item.def, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(4), item.chndef, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(5), item.usedByTW, 14, false, ParagraphAlignment.CENTER);
            }

            addPageBreak();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outTWClass2Doc() {
        try {
            ReadTWDatasetExcel reader = new ReadTWDatasetExcel();
            
            reader.readDens();
            
            @SuppressWarnings("unchecked")
            List<WCOBaseClass> classList = reader.arTWClass;
            

            if (classList == null || classList.isEmpty()) {
                System.err.println("[outTWClass2Doc] arTWClass 資料為空!");
                System.err.println("[outTWClass2Doc] ==> 檢查 ReadTWDatasetExcel.readDens() 方法");
                return;
            }
            
            if (classList.size() > 0) {
                WCOBaseClass first = classList.get(0);
            }

            XWPFParagraph title = document.createParagraph();
            XWPFRun titleRun = title.createRun();
            titleRun.setText("二、TW Data Model Classes");
            titleRun.setFontFamily(FONT_NAME);
            titleRun.setFontSize(14);
            titleRun.setBold(true);

            XWPFTable table = document.createTable();
            CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
            tblWidth.setType(STTblWidth.PCT);
            tblWidth.setW(BigInteger.valueOf(5000));

            String[] headers = {"類別\n代碼", "類別英文名稱", "類別中文名稱", "類別英文定義", "類別中文定義"};
            addTableHeader(table, headers, new int[]{10, 15, 25, 25, 25});

            for (WCOBaseClass item : classList) {
                XWPFTableRow row = table.createRow();
                setCellText(row.getCell(0), item.wcoid, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(1), item.objcls, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(2), item.chnname, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(3), item.def, 14, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(4), item.chndef, 14, false, ParagraphAlignment.LEFT);
            }

            addPageBreak();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outWCODens2Doc() {
        try {
            ReadWCOBaseExcel reader = new ReadWCOBaseExcel();
            
            reader.readWCODens();
            
            reader.findUsedDens();

            @SuppressWarnings("unchecked")
            List<WCOBaseDens> densList = reader.arWCODens;
            
            
            if (densList == null || densList.isEmpty()) {
                System.err.println("[outWCODens2Doc] arWCODens 資料為空!");
                return;
            }

            XWPFParagraph title = document.createParagraph();
            XWPFRun titleRun = title.createRun();
            titleRun.setText("一、WCO DENs");
            titleRun.setFontFamily(FONT_NAME);
            titleRun.setFontSize(14);
            titleRun.setBold(true);

            XWPFTable table = document.createTable();
            CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
            tblWidth.setType(STTblWidth.PCT);
            tblWidth.setW(BigInteger.valueOf(5000));

            // 第一行表頭
            XWPFTableRow headerRow1 = table.getRow(0);
            if (headerRow1 == null) headerRow1 = table.createRow();
            mergeCellsHorizontally(table, 0, 0, 2);
            setCellText(headerRow1.getCell(0), "WCO Detail", 10, true, ParagraphAlignment.CENTER);
            mergeCellsHorizontally(table, 0, 3, 9);
            setCellText(headerRow1.getCell(3), "WCO XML Detail", 10, true, ParagraphAlignment.CENTER);
            setCellText(headerRow1.getCell(10), "", 10, true, ParagraphAlignment.CENTER);

            // 第二行表頭
            XWPFTableRow headerRow2 = table.createRow();
            String[] headers = {"WCO\nID", "Name", "Definition", "Class\nID", "WCO Dictionary Entry Name",
                    "Object Class Term", "Property Term", "Representation Term",
                    "Named Complex Type", "XML Tag Name", "本\n國\n使\n用"};
            for (int i = 0; i < headers.length; i++) {
                setCellText(headerRow2.getCell(i), headers[i], 8, true, ParagraphAlignment.CENTER);
            }

            for (WCOBaseDens item : densList) {
                XWPFTableRow row = table.createRow();
                setCellText(row.getCell(0), item.wcoid, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(1), item.name, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(2), item.def, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(3), item.clsId, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(4), item.den, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(5), item.objcls, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(6), item.propertyTerm, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(7), item.representationTerm, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(8), item.namedComplexType, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(9), item.xmlTagName, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(10), item.usedByTW, 8, false, ParagraphAlignment.CENTER);
            }

            addPageBreak();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outTWDens2Doc() {
        try {
            ReadTWDatasetExcel reader = new ReadTWDatasetExcel();
            
            reader.readDens();

            @SuppressWarnings("unchecked")
            List<WCOBaseDens> densList = reader.arTWDens;
            
            
            if (densList == null || densList.isEmpty()) {
                System.err.println("[outTWDens2Doc] arTWDens 資料為空!");
                return;
            }

            XWPFParagraph title = document.createParagraph();
            XWPFRun titleRun = title.createRun();
            titleRun.setText("二、TW DENs");
            titleRun.setFontFamily(FONT_NAME);
            titleRun.setFontSize(14);
            titleRun.setBold(true);

            XWPFTable table = document.createTable();
            CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
            tblWidth.setType(STTblWidth.PCT);
            tblWidth.setW(BigInteger.valueOf(5000));

            XWPFTableRow headerRow1 = table.getRow(0);
            if (headerRow1 == null) headerRow1 = table.createRow();
            mergeCellsHorizontally(table, 0, 0, 2);
            setCellText(headerRow1.getCell(0), "TW Detail", 10, true, ParagraphAlignment.CENTER);
            mergeCellsHorizontally(table, 0, 3, 9);
            setCellText(headerRow1.getCell(3), "TW XML Detail", 10, true, ParagraphAlignment.CENTER);

            XWPFTableRow headerRow2 = table.createRow();
            String[] headers = {"TW\nID", "Name", "Definition", "Class\nID", "TW Dictionary Entry Name",
                    "Object Class Term", "Property Term", "Representation Term",
                    "Named Complex Type", "XML Tag Name"};
            for (int i = 0; i < headers.length; i++) {
                setCellText(headerRow2.getCell(i), headers[i], 8, true, ParagraphAlignment.CENTER);
            }

            for (WCOBaseDens item : densList) {
                XWPFTableRow row = table.createRow();
                setCellText(row.getCell(0), item.wcoid, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(1), item.name, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(2), item.def, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(3), item.clsId, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(4), item.den, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(5), item.objcls, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(6), item.propertyTerm, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(7), item.representationTerm, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(8), item.namedComplexType, 8, false, ParagraphAlignment.LEFT);
                setCellText(row.getCell(9), item.xmlTagName, 8, false, ParagraphAlignment.LEFT);
            }

            addPageBreak();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===========================================================
    // 執行主程式
    // ===========================================================
    public static void run() {
    
        long startTime = System.currentTimeMillis();
        
        try {
            String outputPath = MyConst.getDataItemSetTemplatePath();
            
            if (outputPath == null || outputPath.isEmpty()) {
                return;
            }

            ProduceDataItemSet producer = new ProduceDataItemSet(outputPath);
            
            producer.openDoc();

            producer.outTWDS2Doc();

            producer.outWCOClass2Doc();

            producer.outTWClass2Doc();

            producer.outWCODens2Doc();

            producer.outTWDens2Doc();

            producer.closeDoc();

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
