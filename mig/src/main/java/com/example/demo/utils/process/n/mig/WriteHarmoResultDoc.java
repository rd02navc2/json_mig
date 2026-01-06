package com.example.demo.utils.process.n.mig;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import com.example.demo.MyConst;

public class WriteHarmoResultDoc {

    static XWPFDocument document = null;
    static String file = "";

    public WriteHarmoResultDoc() {
    }

    public WriteHarmoResultDoc(String file) {
        this.file = file;
    }

    // ******************************************************************************************************
    public static void openDoc() {
        if (document == null) {
            document = new XWPFDocument();
        }
    }

    public static void closeDoc() {
        try (FileOutputStream out = new FileOutputStream(file)) {
            if (document != null) {
                document.write(out);
                document.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outTWDS2Doc(int n, String msgName) {
        try {
            ProcessFileReader processFileReader = new ProcessFileReader();
            processFileReader.getContent(msgName);

            writeT1(Abraic2Chinese.doConvert(n + "") + "、" + msgName + "-" + MyConst.getMsgName(msgName));

            ArrayList ar = processFileReader.getTableRows();
            outOneTable(msgName, " (一) 新舊資料項目對照表" + "(" + msgName + ")", ar);

            ArrayList arNew = processFileReader.getNewMsgRows();
            outOneTable(msgName, "(二) 新增資料項目表" + "(" + msgName + ")", arNew);

            ArrayList arCancelled = processFileReader.getCancelled();
            outOneTable(msgName, "(三) 刪除資料項目表" + "(" + msgName + ")", arCancelled);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeT1(String title) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setStyle("Heading1");
        
        XWPFRun run = paragraph.createRun();
        run.setText(title);
        run.setFontSize(18);
        run.setFontFamily("標楷體");
        run.setBold(true);
    }

    static void writeT2(String title) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setStyle("Heading2");
        
        XWPFRun run = paragraph.createRun();
        run.setText("\t" + title);
        run.setFontSize(16);
        run.setFontFamily("標楷體");
        run.setBold(true);
    }

    public static void outOneTable(String msgName, String title, ArrayList ar) {
        try {
            writeT2(title);

            int numRows = ar.size() + 2; 
            XWPFTable table = document.createTable(numRows, 15);
            
            CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
            tblWidth.setType(STTblWidth.PCT);
            tblWidth.setW(BigInteger.valueOf(5000));

            int[] widths = {3, 3, 3, 3, 10, 10, 6, 3, 9, 15, 10, 10, 6, 3, 6};
            setColumnWidths(table, widths);

            XWPFTableRow row0 = table.getRow(0);
            int colIdx = 0;
            
            mergeCellVertically(table, 0, 1, 0);
            setCellText(row0.getCell(0), "項次", 12, true, true, "FFD700");
            colIdx++;

            String tableTitle = msgName + " 資料項目表";
            if (title.contains("新增")) {
                tableTitle = msgName + " 資料項目表(新增項目)";
            }
            mergeCellHorizontally(row0, 1, 8);
            setCellText(row0.getCell(1), tableTitle, 12, true, true, "FFD700");
            colIdx += 8;

            mergeCellVertically(table, 0, 1, 9);
            setCellText(row0.getCell(9), "修正內容", 12, true, true, "FFD700");
            colIdx++;

            String oldDataTitle = "原海空運資料";
            if (title.contains("刪除")) {
                oldDataTitle = "原海空運資料(刪除項目)";
            }
            mergeCellHorizontally(row0, 10, 14);
            setCellText(row0.getCell(10), oldDataTitle, 12, true, true, "FFD700");

            XWPFTableRow row1 = table.getRow(1);
            String[] headers2 = {"層次", "", "", "中文名稱", "英文名稱", "屬性及長度", "M/C", "WCO/TW\nID", 
                               "", "中文名稱", "英文名稱", "屬性及\n長度", "M/C", "海/空"};
            
            mergeCellHorizontally(row1, 1, 3);
            setCellText(row1.getCell(1), "層次", 12, true, true, "FFD700");
            
            int[] singleCols = {4, 5, 6, 7, 8, 10, 11, 12, 13, 14};
            String[] singleHeaders = {"中文名稱", "英文名稱", "屬性及長度", "M/C", "WCO/TW\nID", 
                                     "中文名稱", "英文名稱", "屬性及\n長度", "M/C", "海/空"};
            for (int i = 0; i < singleCols.length; i++) {
                setCellText(row1.getCell(singleCols[i]), singleHeaders[i], 12, true, true, "FFD700");
            }

            for (int i = 0; i < ar.size(); i++) {
                X item = (X) ar.get(i);
                XWPFTableRow row = table.getRow(i + 2);
                
                int col = 0;
                setCellText(row.getCell(col++), String.valueOf(i), 12, false, true, null);
                
                String sVal = item.newS;
                String gVal = item.newG;
                String eVal = item.newE;
                if (title.contains("新增") || title.contains("刪除")) {
                    sVal = gVal = eVal = "";
                }
                if (!item.newE.trim().equals("")) {
                    gVal = "";
                }
                setCellText(row.getCell(col++), sVal, 12, false, true, null);
                setCellText(row.getCell(col++), gVal, 12, false, true, null);
                setCellText(row.getCell(col++), eVal, 12, false, true, null);
                
                setCellTextWithColor(row.getCell(col++), item.newChnName, 12, false, true, 
                                    item.diffChnName ? "0000FF" : null);
                setCellTextWithColor(row.getCell(col++), item.newEngName, 12, false, true, 
                                    item.diffEnName ? "00FF00" : null);
                setCellTextWithColor(row.getCell(col++), item.newFormat, 12, true, true, 
                                    item.diffLen ? "FF0000" : null);
                setCellText(row.getCell(col++), item.newMC, 12, true, true, null);
                setCellText(row.getCell(col++), item.newWCOID, 12, false, true, null);
                
                setCellText(row.getCell(col++), item.changedContent, 12, false, false, null);
                
                setCellText(row.getCell(col++), item.oldChnName, 12, false, true, null);
                setCellText(row.getCell(col++), item.oldEngName, 12, false, true, null);
                setCellTextWithColor(row.getCell(col++), item.oldFormat, 12, true, true, 
                                    item.diffLen ? "FF0000" : null);
                setCellText(row.getCell(col++), item.oldMC, 12, true, true, null);
                setCellText(row.getCell(col++), item.oldSeaAir, 12, true, true, null);
            }

            document.createParagraph().setPageBreak(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setColumnWidths(XWPFTable table, int[] widths) {
        for (XWPFTableRow row : table.getRows()) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (int i = 0; i < cells.size() && i < widths.length; i++) {
                XWPFTableCell cell = cells.get(i);
                CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
                CTTblWidth cellWidth = tcPr.isSetTcW() ? tcPr.getTcW() : tcPr.addNewTcW();
                cellWidth.setType(STTblWidth.PCT);
                cellWidth.setW(BigInteger.valueOf(widths[i] * 50)); // 比例轉換
            }
        }
    }

    private static void mergeCellHorizontally(XWPFTableRow row, int fromCol, int toCol) {
        for (int i = fromCol; i <= toCol; i++) {
            XWPFTableCell cell = row.getCell(i);
            CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
            if (i == fromCol) {
                tcPr.addNewHMerge().setVal(STMerge.RESTART);
            } else {
                tcPr.addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    private static void mergeCellVertically(XWPFTable table, int fromRow, int toRow, int col) {
        for (int i = fromRow; i <= toRow; i++) {
            XWPFTableCell cell = table.getRow(i).getCell(col);
            CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
            if (i == fromRow) {
                tcPr.addNewVMerge().setVal(STMerge.RESTART);
            } else {
                tcPr.addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    private static void setCellText(XWPFTableCell cell, String text, int fontSize, 
                                   boolean centered, boolean vCentered, String bgColor) {
        setCellTextWithColor(cell, text, fontSize, centered, vCentered, null, bgColor);
    }

    private static void setCellTextWithColor(XWPFTableCell cell, String text, int fontSize, 
                                            boolean centered, boolean vCentered, String textColor) {
        setCellTextWithColor(cell, text, fontSize, centered, vCentered, textColor, null);
    }

    private static void setCellTextWithColor(XWPFTableCell cell, String text, int fontSize, 
                                            boolean centered, boolean vCentered, 
                                            String textColor, String bgColor) {
        if (cell.getParagraphs().size() > 0) {
            XWPFParagraph para = cell.getParagraphs().get(0);
            para.getRuns().forEach(run -> para.removeRun(0));
        }
        
        XWPFParagraph para = cell.getParagraphs().get(0);
        if (centered) {
            para.setAlignment(ParagraphAlignment.CENTER);
        } else {
            para.setAlignment(ParagraphAlignment.LEFT);
        }
        
        XWPFRun run = para.createRun();
        run.setText(text);
        run.setFontSize(fontSize);
        run.setFontFamily("標楷體");
        
        if (textColor != null) {
            run.setColor(textColor);
        }
        
        if (vCentered) {
            CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
            tcPr.addNewVAlign().setVal(STVerticalJc.CENTER);
        }
        
        if (bgColor != null) {
            CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
            CTShd shd = tcPr.isSetShd() ? tcPr.getShd() : tcPr.addNewShd();
            shd.setFill(bgColor);
        }
        
        // 設定邊框
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
        CTTcBorders borders = tcPr.isSetTcBorders() ? tcPr.getTcBorders() : tcPr.addNewTcBorders();
        
        STBorder.Enum borderStyle = STBorder.SINGLE;
        BigInteger borderSize = BigInteger.valueOf(4);
        String borderColor = "000000";
        
        if (borders.getLeft() == null) borders.addNewLeft();
        borders.getLeft().setVal(borderStyle);
        borders.getLeft().setSz(borderSize);
        borders.getLeft().setColor(borderColor);
        
        if (borders.getRight() == null) borders.addNewRight();
        borders.getRight().setVal(borderStyle);
        borders.getRight().setSz(borderSize);
        borders.getRight().setColor(borderColor);
        
        if (borders.getTop() == null) borders.addNewTop();
        borders.getTop().setVal(borderStyle);
        borders.getTop().setSz(borderSize);
        borders.getTop().setColor(borderColor);
        
        if (borders.getBottom() == null) borders.addNewBottom();
        borders.getBottom().setVal(borderStyle);
        borders.getBottom().setSz(borderSize);
        borders.getBottom().setColor(borderColor);
    }

    public static void run() {
        file = MyConst.getDataHarmoResultTemplateLocation();
        openDoc();

        for (int i = 0; i < MyConst.msg.length; i++) {
            String msgName = MyConst.msg[i][0];
            String rootEleName = MyConst.msg[i][1];
            String schemaFile = MyConst.msg[i][2];

            outTWDS2Doc(i + 1, msgName);
        }

        closeDoc();

        System.out.println("產生資料調和結果模板 ok --->" + file);
    }

    /*
    public static void main(String[] args) throws IOException {
        WriteHarmoResultDoc.run();
    }
    */
}
