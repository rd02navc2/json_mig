package com.example.demo.utils.cpt.code.set;

/*
 * 單一窗口g2g訊息資料項目與調和資料之對應表寫出
 * 使用 Apache POI XWPF 產生 Word 文件 (.docx)
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

public class WriteSwitchedDoc {

    private XWPFDocument document = null;
    private List<MyRow> tableRows = new ArrayList<>();
    
    private String file = "d:/temp/switchResult.docx";

    public WriteSwitchedDoc() {
    }

    /*
    public static void main(String[] args) throws Exception {
        WriteSwitchedDoc o = new WriteSwitchedDoc();
        o.openDoc();
        o.outTWDS2Doc();
        o.closeDoc();
    }
    */

    public void setInput(ArrayList<MyRow> tableRows) {
        this.tableRows = tableRows;
    }

    public void openDoc() {
        if (document == null) {
            document = new XWPFDocument();
        }
    }

    public void closeDoc() {
        try (FileOutputStream out = new FileOutputStream(file)) {
            if (document != null) {
                document.write(out);
                document.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outTWDS2Doc() throws Exception {
        if (document == null) {
            throw new IllegalStateException("Document not opened");
        }

        XWPFTable table = document.createTable(tableRows.size(), 1);
        
        CTTblWidth tblWidth = table.getCTTbl().addNewTblPr().addNewTblW();
        tblWidth.setType(STTblWidth.PCT);
        tblWidth.setW(java.math.BigInteger.valueOf(5000)); // 100% = 5000

        for (int i = 0; i < tableRows.size(); i++) {
            MyRow r = tableRows.get(i);
            XWPFTableRow row = table.getRow(i);
            
            // 第一欄
            XWPFTableCell cell = row.getCell(0);
            setCellText(cell, r.lines[0], true); // 第二個參數控制是否置中
            setCellVerticalAlignment(cell, STVerticalJc.CENTER);
            
            /*
            // 第二欄
            if (row.getTableCells().size() < 2) {
                cell = row.createCell();
            } else {
                cell = row.getCell(1);
            }
            setCellText(cell, r.lines[1], false);
            setCellVerticalAlignment(cell, STVerticalJc.CENTER);
            
            // 第三欄
            if (row.getTableCells().size() < 3) {
                cell = row.createCell();
            } else {
                cell = row.getCell(2);
            }
            setCellText(cell, r.lines[2], true);
            setCellVerticalAlignment(cell, STVerticalJc.CENTER);
            */
        }

        document.createParagraph().setPageBreak(true);
    }

    private void setCellText(XWPFTableCell cell, String text, boolean centered) {
        // 清除現有內容
        if (cell.getParagraphs().size() > 0) {
            XWPFParagraph paragraph = cell.getParagraphs().get(0);
            paragraph.getRuns().forEach(run -> paragraph.removeRun(0));
        } else {
            cell.addParagraph();
        }
        
        XWPFParagraph paragraph = cell.getParagraphs().get(0);
        if (centered) {
            paragraph.setAlignment(ParagraphAlignment.CENTER);
        }
        
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontSize(12);
        run.setFontFamily("標楷體"); 
    }

    private void setCellVerticalAlignment(XWPFTableCell cell, STVerticalJc.Enum align) {
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr() : cell.getCTTc().addNewTcPr();
        tcPr.addNewVAlign().setVal(align);
    }
}
