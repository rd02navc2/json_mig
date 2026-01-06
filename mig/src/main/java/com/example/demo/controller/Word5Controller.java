package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.MyConst;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/word5")
@CrossOrigin(origins = "*")
public class Word5Controller {

    @GetMapping("/word-editor5")
    public String wordEditor5() {
        return "word-editor5";
    }

    @PostMapping("/parseLite")
    public ResponseEntity<Map<String, Object>> parseLite(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            String fullText = parseDocxText(file);
            result.put("success", true);
            result.put("fullText", fullText);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        
        return ResponseEntity.ok(result);
    }

	@PostMapping(value = "/exportLite", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> exportLite(@RequestParam("file") MultipartFile file) {
	    try {
	        byte[] modifiedDocx = processDocx(file);
	
	        String originalName = file.getOriginalFilename();
	        String modifiedName = (originalName != null ? originalName.replaceAll("\\.docx$", "_modified.docx") : "result_modified.docx");
	
	     // 改成一定可寫的目錄（系統暫存目錄）
	        File dir = new File(MyConst.getWordAllBaseFilePath(), "docx");

	        if (!dir.exists()) {
	            dir.mkdirs();
	        }

	        File outFile = new File(dir, modifiedName);
	        try (FileOutputStream fos = new FileOutputStream(outFile)) {
	            fos.write(modifiedDocx);
	        }

	        return ResponseEntity.ok()
	            .header(
	                "Content-Disposition",
	                "attachment; filename=\"" +
	                URLEncoder.encode(modifiedName, StandardCharsets.UTF_8) + "\"")
	            .contentType(
	                MediaType.parseMediaType(
	                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
	            .contentLength(modifiedDocx.length)
	            .body(modifiedDocx);
	
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.internalServerError().build();
	    }
	}


    private String parseDocxText(MultipartFile file) throws IOException {
        try (InputStream is = file.getInputStream();
             XWPFDocument document = new XWPFDocument(is)) {

            StringBuilder fullText = new StringBuilder();
            
            // 遍歷所有段落
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                String paraText = paragraph.getText();
                if (paraText != null && !paraText.trim().isEmpty()) {
                    fullText.append(paraText).append("\n\n");
                }
            }
            
            // 遍歷所有表格
            for (XWPFTable table : document.getTables()) {
                fullText.append("[表格內容]\n");
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        String cellText = cell.getText();
                        if (cellText != null && !cellText.trim().isEmpty()) {
                            fullText.append(cellText).append(" | ");
                        }
                    }
                    fullText.append("\n");
                }
                fullText.append("\n");
            }
            
            return fullText.toString().trim();
        }
    }

    private byte[] processDocx(MultipartFile file) throws IOException {
        try (InputStream is = file.getInputStream();
             XWPFDocument document = new XWPFDocument(is);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");
            String currentTime = now.format(formatter);

            XWPFParagraph lastPara = document.createParagraph();
            XWPFRun lastRun = lastPara.createRun();
            lastRun.setText("【財政部關務署 DOCX 編輯系統】\n");
            lastRun.setFontFamily("標楷體");
            lastRun.setFontSize(14);
            
            XWPFParagraph timePara = document.createParagraph();
            XWPFRun timeRun = timePara.createRun();
            timeRun.setText("處理時間：" + currentTime + "\n");
            timeRun.setFontFamily("標楷體");
            timeRun.setFontSize(12);
            timeRun.setColor("666666"); // 灰色

            document.write(baos);
            return baos.toByteArray();
            
        }
    }
}
