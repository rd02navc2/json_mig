package com.example.demo.phase2.make.item_desc_tbl;

import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.example.demo.MyConst;
import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;
import com.example.demo.annotations.DSREF;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

public class Worker4ItemDescription {

    private static int cnt = 1;
    private XWPFDocument document = null;
    private static String msgName = "NA";
    private final String file;

    private static final String BORDER_COLOR = "AAAAAA"; // 灰色
    private static final String FONT_NAME = "標楷體";

    public Worker4ItemDescription() {
        this.file = "";
    }

    public Worker4ItemDescription(String msgName) {
        Worker4ItemDescription.msgName = msgName;
        this.file = MyConst.getDataItemDescriptionPath() + msgName + "_資料項目說明.docx";
    }

    // ===== Public 方法，供 XsdDomNavigator 使用 =====
    public TWDENS_DAO getCls(String cls) {
        XmaDB db = new XmaDB();
        TWDENS_DAO densds = db.getClsResult(cls);
        return densds != null ? densds : new TWDENS_DAO();
    }

    public String getmc(String cardinality) {
        if (cardinality == null || cardinality.isEmpty()) return "M";
        return cardinality.startsWith("0") ? "C" : "M";
    }

    public TWDENS_DAO getProp(DSAnnotationRef o) {
        XmaDB db = new XmaDB();
        String uid = o.uid;
        if ("*".equals(o.boro)) uid = o.uid + "*";
        if (uid != null && (uid.endsWith("+") || uid.endsWith("#"))) {
            uid = uid.substring(0, uid.length() - 1);
        }
        TWDENS_DAO densds = db.getDsResult(o.chn, o.den, uid);
        return densds != null ? densds : new TWDENS_DAO();
    }

    public String compare(String chname, String enname, String fmt, String remark) {
        ItemTblItem itemTblItem = ReadItemTblDoc.getItemTblItem(chname);
        return itemTblItem != null ? itemTblItem.remark : "";
    }

    public String getType(String den) {
        if (den == null) return "";
        int n = den.lastIndexOf(".");
        return n < 0 ? den : den.substring(n + 1).trim();
    }

    public void openDoc() {
        try {
            if (document == null) {
                document = new XWPFDocument();

                CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
                CTPageSz pageSize = sectPr.addNewPgSz();
                pageSize.setW(BigInteger.valueOf(11906));
                pageSize.setH(BigInteger.valueOf(16838));

                CTPageMar pageMar = sectPr.addNewPgMar();
                pageMar.setLeft(BigInteger.valueOf(1300));
                pageMar.setRight(BigInteger.valueOf(1400));
                pageMar.setTop(BigInteger.valueOf(1000));
                pageMar.setBottom(BigInteger.valueOf(1000));

                Path outputPath = Paths.get(file).getParent();
                if (outputPath != null && !Files.exists(outputPath)) {
                    Files.createDirectories(outputPath);
                }

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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	public void out2Doc(Itemtable itemtable) {
	    try {
	        // 標題
	        XWPFParagraph titlePara = document.createParagraph();
	        XWPFRun titleRun = titlePara.createRun();
	        titleRun.setText("<" + itemtable.classname + ">");
	        titleRun.setFontFamily(FONT_NAME);
	        titleRun.setFontSize(14);
	
	        // 建立表格
	        XWPFTable table = document.createTable();
	        CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
	        tblWidth.setType(STTblWidth.PCT);
	        tblWidth.setW(BigInteger.valueOf(5000));
	
	        // 第一列
	        XWPFTableRow row1 = table.getRow(0);
	        for (int i = 0; i < 10; i++) if (i > 0) row1.addNewTableCell();
	
	        mergeCellsHorizontally(table, 0, 0, 7);
	        setCellText(row1.getCell(0), itemtable.classname, 12, false, ParagraphAlignment.LEFT);
	        setCellText(row1.getCell(8), itemtable.mc, 12, false, ParagraphAlignment.LEFT);
	        setCellText(row1.getCell(9), itemtable.cardinality, 12, false, ParagraphAlignment.LEFT);
	
	        // 類別階層列(如果需要)
	        int currentRow = 0;
	        if (!itemtable.clsHiarachy.trim().equalsIgnoreCase(itemtable.classname.trim())) {
	            XWPFTableRow row2 = table.createRow();
	            currentRow++;
	            mergeCellsHorizontally(table, currentRow, 0, 9);
	            setCellText(row2.getCell(0), itemtable.clsHiarachy, 12, false, ParagraphAlignment.LEFT);
	        }
	
	        // 功能說明列
	        XWPFTableRow row3 = table.createRow();
	        currentRow++;
	        mergeCellsHorizontally(table, currentRow, 0, 2);
	        setCellText(row3.getCell(0), "功能說明", 12, false, ParagraphAlignment.LEFT);
	
	        mergeCellsHorizontally(table, currentRow, 3, 9);
	        String funcDesc = itemtable.functionDescription.trim();
	        if (funcDesc.endsWith(".") && !funcDesc.endsWith("No.")) {
	            funcDesc = funcDesc.substring(0, funcDesc.length() - 1);
	        }
	        setCellText(row3.getCell(3), funcDesc, 12, false, ParagraphAlignment.LEFT);
	
	        // 表頭列
	        XWPFTableRow headerRow = table.createRow();
	        currentRow++;
	        
	        mergeCellsHorizontally(table, currentRow, 0, 2);
	        mergeCellsHorizontally(table, currentRow, 4, 5);
	        mergeCellsHorizontally(table, currentRow, 7, 9);
	        
	        setCellText(headerRow.getCell(0), "資料項目", 12, false, ParagraphAlignment.CENTER);
	        setCellText(headerRow.getCell(3), "M/C", 12, false, ParagraphAlignment.CENTER);
	        setCellText(headerRow.getCell(4), "Data\nType", 12, false, ParagraphAlignment.CENTER);
	        setCellText(headerRow.getCell(6), "長度", 12, false, ParagraphAlignment.CENTER);
	        setCellText(headerRow.getCell(7), "備註", 12, false, ParagraphAlignment.CENTER);
	
			for (Item item : itemtable.items) {
			    XWPFTableRow dataRow = table.createRow();
			    currentRow++;
			
			    String itemStr = item.itemString.replace("---", "\n");
			    
			    
			    setCellText(dataRow.getCell(0), itemStr, 12, false, ParagraphAlignment.LEFT);
			    setCellText(dataRow.getCell(3), item.mc, 12, false, ParagraphAlignment.CENTER);
			    setCellText(dataRow.getCell(4), item.datatype, 12, false, ParagraphAlignment.CENTER);
			    setCellText(dataRow.getCell(6), item.length, 12, false, ParagraphAlignment.CENTER);
			    
			    setCellText(dataRow.getCell(7), item.rmk, 12, false, ParagraphAlignment.LEFT);
			    
			    // 再進行合併
			    mergeCellsHorizontally(table, currentRow, 0, 2);
			    mergeCellsHorizontally(table, currentRow, 4, 5);
			    
			    mergeCellsHorizontally(table, currentRow, 7, 9);
			    
			    XWPFTableCell cell7 = dataRow.getCell(7);
	}
	
	        if (itemtable.descriptions != null && !itemtable.descriptions.isEmpty()) {
	            addDescriptionSections("【說明】：", itemtable.descriptions);
	        }
	
	        // 新增【範例】區塊
	        if (itemtable.sampleLines != null && !itemtable.sampleLines.isEmpty()) {
	            addDescriptionSections("【範例】：", itemtable.sampleLines);
	        }
	
	        // 分頁
	        addPageBreak();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

    // 新增方法：設定儲存格文字並將垂直對齊設為頂端
    private void setCellTextWithTopAlign(XWPFTableCell cell, String text, int fontSize, boolean isBold, ParagraphAlignment align) {
        // 清除所有現有段落
        while (cell.getParagraphs().size() > 0) {
            cell.removeParagraph(0);
        }
        
        // 建立新段落並設定內容
        XWPFParagraph para = cell.addParagraph();
        para.setAlignment(align);

        XWPFRun run = para.createRun();
        run.setText(text != null ? text : "");
        run.setFontFamily(FONT_NAME);
        run.setFontSize(fontSize);
        run.setBold(isBold);

        // 設定儲存格邊框
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
        CTTcBorders borders = tcPr.isSetTcBorders() ? tcPr.getTcBorders() : tcPr.addNewTcBorders();
        setBorderColor(borders.addNewTop());
        setBorderColor(borders.addNewBottom());
        setBorderColor(borders.addNewLeft());
        setBorderColor(borders.addNewRight());

        // 設定垂直對齊為頂端
        CTVerticalJc vAlign = tcPr.isSetVAlign() ? tcPr.getVAlign() : tcPr.addNewVAlign();
        vAlign.setVal(STVerticalJc.TOP);
    }

    // 新增方法：加入說明或範例區塊(處理 ArrayList)
    private void addDescriptionSections(String title, ArrayList<String> contentList) {
        if (contentList == null || contentList.isEmpty()) {
            return;
        }
        
        // 建立第一個段落,包含標題和第一行內容
        XWPFParagraph firstPara = document.createParagraph();
        
        // 標題部分(粗體)
        XWPFRun titleRun = firstPara.createRun();
        titleRun.setText(title);
        titleRun.setFontFamily(FONT_NAME);
        titleRun.setFontSize(12);
        titleRun.setBold(true);
        
        // 第一行內容(非粗體)
        if (!contentList.isEmpty()) {
            XWPFRun firstContentRun = firstPara.createRun();
            firstContentRun.setText(contentList.get(0));
            firstContentRun.setFontFamily(FONT_NAME);
            firstContentRun.setFontSize(12);
            firstContentRun.setBold(false);
        }
        
        // 其餘行內容,每行一個段落
        for (int i = 1; i < contentList.size(); i++) {
            XWPFParagraph para = document.createParagraph();
            XWPFRun run = para.createRun();
            run.setText(contentList.get(i));
            run.setFontFamily(FONT_NAME);
            run.setFontSize(12);
            run.setBold(false);
        }
        
        // 加入空行
        XWPFParagraph emptyPara = document.createParagraph();
    }

    // 原有的單一字串版本方法(保留以備不時之需)
    private void addDescriptionSection(String title, String content) {
        // 建立段落
        XWPFParagraph para = document.createParagraph();
        
        // 標題部分(粗體)
        XWPFRun titleRun = para.createRun();
        titleRun.setText(title);
        titleRun.setFontFamily(FONT_NAME);
        titleRun.setFontSize(12);
        titleRun.setBold(true);
        
        // 內容部分(非粗體)
        XWPFRun contentRun = para.createRun();
        contentRun.setText(content);
        contentRun.setFontFamily(FONT_NAME);
        contentRun.setFontSize(12);
        contentRun.setBold(false);
        
        // 加入空行
        XWPFParagraph emptyPara = document.createParagraph();
    }

    private void setCellText(XWPFTableCell cell, String text, int fontSize, boolean isBold, ParagraphAlignment align) {
        // 清除所有現有段落
        while (cell.getParagraphs().size() > 0) {
            cell.removeParagraph(0);
        }
        
        // 建立新段落並設定內容
        XWPFParagraph para = cell.addParagraph();
        para.setAlignment(align);

        XWPFRun run = para.createRun();
        run.setText(text != null ? text : "");
        run.setFontFamily(FONT_NAME);
        run.setFontSize(fontSize);
        run.setBold(isBold);

        // 設定儲存格邊框
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
        CTTcBorders borders = tcPr.isSetTcBorders() ? tcPr.getTcBorders() : tcPr.addNewTcBorders();
        setBorderColor(borders.addNewTop());
        setBorderColor(borders.addNewBottom());
        setBorderColor(borders.addNewLeft());
        setBorderColor(borders.addNewRight());

        // 設定垂直置中
        CTVerticalJc vAlign = tcPr.isSetVAlign() ? tcPr.getVAlign() : tcPr.addNewVAlign();
        vAlign.setVal(STVerticalJc.CENTER);
    }

    private void setBorderColor(CTBorder border) {
        border.setVal(STBorder.SINGLE);
        border.setSz(BigInteger.valueOf(4));
        border.setColor(BORDER_COLOR);
    }

    private void mergeCellsHorizontally(XWPFTable table, int rowIndex, int fromCol, int toCol) {
        XWPFTableRow row = table.getRow(rowIndex);
        if (row == null) return;

        // 確保有足夠的儲存格
        for (int i = row.getTableCells().size(); i <= toCol; i++) {
            row.createCell();
        }

        // 設定合併 - 只設定合併屬性,不清除內容
        for (int colIndex = fromCol; colIndex <= toCol; colIndex++) {
            XWPFTableCell cell = row.getCell(colIndex);
            if (cell == null) continue;

            CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
            
            // 只處理 hMerge,不要動到其他屬性
            CTHMerge hMerge = tcPr.isSetHMerge() ? tcPr.getHMerge() : tcPr.addNewHMerge();
            
            if (colIndex == fromCol) {
                hMerge.setVal(STMerge.RESTART);
            } else {
                hMerge.setVal(STMerge.CONTINUE);
            }
        }
    }

    private void addPageBreak() {
        XWPFParagraph para = document.createParagraph();
        XWPFRun run = para.createRun();
        run.addBreak(BreakType.PAGE);
    }
}

