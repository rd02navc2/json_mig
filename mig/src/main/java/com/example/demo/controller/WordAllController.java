package com.example.demo.controller;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.MyConst;

import java.io.*;
import java.net.URLEncoder;

@Controller
public class WordAllController {

   //  @Value("${template.target.dirname:docx}")
    private String targetDirName;

    private static final String LEGEND_KEYWORD = "M：必要型"; // 用於判斷 Legend 文字

    @GetMapping("/wordall")
    public String wordall() {
        return "wordall"; // 對應 src/main/resources/templates/wordall.html
    }

    @PostMapping("/api/word/export")
    @ResponseBody
    public ResponseEntity<byte[]> exportWord() {
        String[] inputFiles = {
                "Ch1_template_modified.docx", "Ch2_template_modified.docx", "Ch3_template_modified.docx",
                "Ch4_template_modified.docx", "Ch5_template_modified.docx", "Ch6_template_modified.docx",
                "Ch7_template_modified.docx", "Ch8_template_modified.docx"
        };

	try {
	    // 1️ 第一個檔案
	    File firstFile = new File(MyConst.getWordAllBaseFilePath(), "docx/" + inputFiles[0]);
	    try (InputStream fis = new FileInputStream(firstFile);
	         XWPFDocument targetDoc = new XWPFDocument(fis)) {
	
	        // 2️ 後續檔案合併
	        for (int i = 1; i < inputFiles.length; i++) {
	            File sourceFile = new File(MyConst.getWordAllBaseFilePath(), "docx/" + inputFiles[i]);
	
	            try (InputStream fisSource = new FileInputStream(sourceFile);
	                 XWPFDocument sourceDoc = new XWPFDocument(fisSource)) {
	
	                // 換頁
	                XWPFParagraph pageBreak = targetDoc.createParagraph();
	                pageBreak.setPageBreak(true);
	
	                boolean isFirstDoc = (i == 1);
	
	                // 段落
	                for (XWPFParagraph p : sourceDoc.getParagraphs()) {
	                    if (!isFirstDoc && isLegendParagraph(p)) continue;
	
	                    XWPFParagraph newP = targetDoc.createParagraph();
	                    copyParagraph(p, newP, targetDoc);
	                }
	
	                // 表格
	                for (XWPFTable tbl : sourceDoc.getTables()) {
	                    XWPFTable newTbl = targetDoc.createTable();
	                    copyTable(tbl, newTbl, targetDoc, isFirstDoc);
	                }
	            }
	        }
	
	        // 3️ 下載給前端（不再落地 ClassPathResource）
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	        targetDoc.write(outStream);
	
	        HttpHeaders headers = new HttpHeaders();
	        headers.add(HttpHeaders.CONTENT_TYPE,
	                "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	        headers.add(HttpHeaders.CONTENT_DISPOSITION,
	                "attachment; filename*=UTF-8''" +
	                        URLEncoder.encode("merged.docx", "UTF-8").replaceAll("\\+", "%20"));
	
	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(outStream.toByteArray());
	    }
	
	} catch (Exception e) {
	    e.printStackTrace();
	    return ResponseEntity.status(500).body(null);
	}

    }

    // 判斷是否為 Legend 段落
    private boolean isLegendParagraph(XWPFParagraph p) {
        String text = p.getText();
        return text != null && text.contains(LEGEND_KEYWORD);
    }

    private void copyParagraph(XWPFParagraph source, XWPFParagraph target, XWPFDocument targetDoc) {
        if (source.getCTP().getPPr() != null) {
            target.getCTP().setPPr(source.getCTP().getPPr());
        }

        for (XWPFRun run : source.getRuns()) {
            XWPFRun newRun = target.createRun();

            // 文字樣式
            if (run.getCTR().getRPr() != null) {
                newRun.getCTR().setRPr(run.getCTR().getRPr());
            }

            // 文字內容
            for (int i = 0; i < run.getCTR().sizeOfTArray(); i++) {
                newRun.setText(run.getText(i), i);
            }

            // 處理圖片
            for (XWPFPicture pic : run.getEmbeddedPictures()) {
                XWPFPictureData picData = pic.getPictureData();
                try (InputStream picIs = new ByteArrayInputStream(picData.getData())) {
                    long cx = pic.getCTPicture().getSpPr().getXfrm().getExt().getCx();
                    long cy = pic.getCTPicture().getSpPr().getXfrm().getExt().getCy();
                    newRun.addPicture(
                            picIs,
                            picData.getPictureType(),
                            picData.getFileName(),
                            (int) cx,
                            (int) cy
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyTable(XWPFTable source, XWPFTable target, XWPFDocument targetDoc, boolean isFirstDoc) {
        target.getCTTbl().setTblPr(source.getCTTbl().getTblPr());
        target.getCTTbl().setTblGrid(source.getCTTbl().getTblGrid());

        target.removeRow(0);

        for (XWPFTableRow row : source.getRows()) {
            XWPFTableRow newRow = target.createRow();
            newRow.getCtRow().setTrPr(row.getCtRow().getTrPr());

            for (int i = 0; i < row.getTableCells().size(); i++) {
                XWPFTableCell cell = row.getCell(i);
                XWPFTableCell newCell;

                if (i < newRow.getTableCells().size()) {
                    newCell = newRow.getCell(i);
                } else {
                    newCell = newRow.createCell();
                }

                copyCell(cell, newCell, targetDoc, isFirstDoc);
            }
        }
    }

    private void copyCell(XWPFTableCell source, XWPFTableCell target, XWPFDocument targetDoc, boolean isFirstDoc) {
        target.getCTTc().setTcPr(source.getCTTc().getTcPr());
        target.removeParagraph(0);

        for (XWPFParagraph p : source.getParagraphs()) {
            // 過濾 Legend
            if (!isFirstDoc && isLegendParagraph(p)) {
                continue;
            }
            XWPFParagraph newP = target.addParagraph();
            copyParagraph(p, newP, targetDoc);
        }
    }
}
