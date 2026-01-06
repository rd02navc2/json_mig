package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.MyConst;

@Controller
@RequestMapping("/word3")
public class Word3Controller {

    @GetMapping("/word-editor3")
    public String wordEditor3() {
        return "word-editor3";
    }

    @PostMapping("/replaceCategoryImage")
    @ResponseBody
    public void replaceCategoryImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("image") MultipartFile imageFile,
            HttpServletResponse response) {

        try {
            System.out.println("上傳的檔案: " + file.getOriginalFilename() + " (" + file.getSize() + " bytes)");
            System.out.println("上傳的圖片: " + imageFile.getOriginalFilename() + " (" + imageFile.getSize() + " bytes)");
            
            XWPFDocument document = new XWPFDocument(file.getInputStream());
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            System.out.println("文件段落總數: " + paragraphs.size());

            // 2️⃣ 讀入新圖片
            byte[] imgBytes = imageFile.getBytes();
            System.out.println("圖片讀取成功，大小: " + imgBytes.length + " bytes");
            
            // 圖片尺寸 (POI 使用像素，需要轉換)
            // 36.65cm ≈ 520 像素 (按 72 DPI 計算，可調整)
            // 20cm ≈ 283 像素
            int widthPixels = 520;   // 約 36.65cm
            int heightPixels = 283;  // 約 20cm
            System.out.println("設定圖片尺寸: 寬=" + widthPixels + " 像素, 高=" + heightPixels + " 像素");

            // 判斷圖片類型
            int pictureType = getPictureType(imageFile.getOriginalFilename());
            System.out.println("圖片類型: " + pictureType);

            boolean replaced = false;
            int paragraphIndex = 0;
            int targetParagraphIndex = -1;

            System.out.println("\n--- 開始搜尋目標段落 ---");
            
            // 第一步：找到標題段落的索引
            for (int i = 0; i < paragraphs.size(); i++) {
                XWPFParagraph para = paragraphs.get(i);
                paragraphIndex++;
                
                String text = para.getText().trim();
                
                // 顯示所有段落
                System.out.println("段落 " + paragraphIndex + ": \"" + text + "\" (Runs數:" + para.getRuns().size() + ")");
                
                // 找到標題段落
                if (text.contains("貳") || text.contains("訊息架構圖")) {
                    targetParagraphIndex = i + 1; // 圖片在下一段
                    break;
                }
            }
            
            // 第二步：在標題後的段落中替換圖片
            if (targetParagraphIndex >= 0 && targetParagraphIndex < paragraphs.size()) {
                XWPFParagraph targetPara = paragraphs.get(targetParagraphIndex);
                System.out.println("\n>>> 處理圖片段落：第 " + (targetParagraphIndex + 1) + " 段");
                System.out.println(">>> 段落 Runs 數: " + targetPara.getRuns().size());
                
                List<XWPFRun> runs = targetPara.getRuns();
                
                // 詳細顯示段落內容
                for (int i = 0; i < runs.size(); i++) {
                    XWPFRun run = runs.get(i);
                    System.out.println("  - Run " + i + ": 圖片數=" + run.getEmbeddedPictures().size());
                }
                
                // 尋找並替換圖片
                boolean foundPicture = false;
                for (int i = runs.size() - 1; i >= 0; i--) {
                    XWPFRun run = runs.get(i);
                    
                    // 檢查是否有圖片
                    if (!run.getEmbeddedPictures().isEmpty() || hasDrawing(run)) {
                        foundPicture = true;
                        
                        // 移除舊的 run
                        targetPara.removeRun(i);
                    }
                }
                
                // 添加新圖片
                XWPFRun newRun = targetPara.createRun();
                try (ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes)) {
                    newRun.addPicture(bis, pictureType, imageFile.getOriginalFilename(), 
                                     Units.toEMU(widthPixels), Units.toEMU(heightPixels));
                    replaced = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            } else if (targetParagraphIndex == -1) {
                System.out.println("\n警告：未找到「貳、訊息類別圖」標題段落");
            } else {
                System.out.println("\n警告：標題後沒有段落了");
            }
            
            if (!replaced) {
                System.out.println("\n警告：未找到「貳、訊息類別圖」段落");
                System.out.println("將在文件末尾創建新段落");
                
                XWPFParagraph newPara = document.createParagraph();
                XWPFRun newRun = newPara.createRun();
                
                try (ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes)) {
                    newRun.addPicture(bis, pictureType, imageFile.getOriginalFilename(), 
                                     Units.toEMU(widthPixels), Units.toEMU(heightPixels));
                } catch (Exception e) {
                    System.err.println("插入圖片時發生錯誤: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            System.out.println("\n--- 開始保存文件 ---");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.write(baos);
            document.close();
            byte[] outputBytes = baos.toByteArray();
            
            sendAndSaveDocx(response, outputBytes, file.getOriginalFilename());

        } catch (Exception e) {
            e.printStackTrace();
            
            try {
                response.reset();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.setContentType("text/plain; charset=UTF-8");
                response.getWriter().write("替換圖片失敗：" + e.getMessage());
                response.getWriter().flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

	private void sendAndSaveDocx(
	        HttpServletResponse response,
	        byte[] fileBytes,
	        String originalFilename) throws Exception {
	
	    String outputName = originalFilename.replace(".docx", "_modified.docx");
	
	    // 1️優先嘗試 ClassPathResource（只在 IDE 可用）
	    File dir;
	    try {
	        ClassPathResource resource = new ClassPathResource("template/docx");
	        dir = resource.getFile(); // ❗ jar 內會丟 exception
	    } catch (Exception e) {
	        // 2️jar / production fallback → 系統暫存目錄
	        dir = new File(MyConst.getWordAllBaseFilePath(), "docx");
	    }
	
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	
	    // 3️ 寫入本地檔案
	    File outFile = new File(dir, outputName);
	    try (FileOutputStream fos = new FileOutputStream(outFile)) {
	        fos.write(fileBytes);
	    }
	
	    // 4️ 提供下載
	    response.reset();
	    response.setContentType(
	        "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	    response.setContentLength(fileBytes.length);
	    response.setHeader(
	        "Content-Disposition",
	        "attachment; filename=\"" +
	        URLEncoder.encode(outputName, StandardCharsets.UTF_8) + "\"");
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "0");
	
	    response.getOutputStream().write(fileBytes);
	    response.getOutputStream().flush();
	}

    private int getPictureType(String filename) {
        if (filename == null) {
            return XWPFDocument.PICTURE_TYPE_PNG;
        }
        
        String lower = filename.toLowerCase();
        if (lower.endsWith(".png")) {
            return XWPFDocument.PICTURE_TYPE_PNG;
        } else if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) {
            return XWPFDocument.PICTURE_TYPE_JPEG;
        } else if (lower.endsWith(".gif")) {
            return XWPFDocument.PICTURE_TYPE_GIF;
        } else if (lower.endsWith(".bmp")) {
            return XWPFDocument.PICTURE_TYPE_BMP;
        } else if (lower.endsWith(".emf")) {
            return XWPFDocument.PICTURE_TYPE_EMF;
        } else if (lower.endsWith(".wmf")) {
            return XWPFDocument.PICTURE_TYPE_WMF;
        } else if (lower.endsWith(".tif") || lower.endsWith(".tiff")) {
            return XWPFDocument.PICTURE_TYPE_TIFF;
        }
        return XWPFDocument.PICTURE_TYPE_PNG; // 默認
    }
    
    private boolean hasDrawing(XWPFRun run) {
        try {
            if (run.getCTR() != null && run.getCTR().getDrawingList() != null) {
                List<CTDrawing> drawings = run.getCTR().getDrawingList();
                return !drawings.isEmpty();
            }
        } catch (Exception e) {
            
        }
        return false;
    }
}