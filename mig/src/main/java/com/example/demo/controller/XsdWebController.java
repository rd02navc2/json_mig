package com.example.demo.controller;

import com.example.demo.service.XsdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.MyConst;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/xsd")
public class XsdWebController {

    @Autowired
    private XsdGeneratorService xsdGeneratorService;

    private static final String XSD_DIR = "C:\\Users\\user\\Downloads\\template\\harmo_prod\\Schema\\maindoc";

    /**
     * 顯示 XSD 管理頁面
     */
    @GetMapping("/manage")
    public String managePage(Model model) {
        try {
            Path dirPath = Paths.get(XSD_DIR);
            if (!Files.exists(dirPath)) Files.createDirectories(dirPath);

            List<String> files = listXsdFiles();
            if (!files.isEmpty()) {
                Collections.sort(files, Collections.reverseOrder());
                model.addAttribute("latest", files.get(0));
                model.addAttribute("history", files.size() > 1 ? files.subList(1, files.size()) : Collections.emptyList());
            } else {
                model.addAttribute("latest", null);
                model.addAttribute("history", Collections.emptyList());
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("statusMessage", "讀取檔案列表失敗: " + e.getMessage());
        }
        return "xsd_page";
    }

    /**
     * 生成 XSD
     */
    @GetMapping("/generate")
    public String generateXsd(
            //@RequestParam(defaultValue = "mapping.json") String mappingJsonPath,
            // @RequestParam(defaultValue = "Response") String rootElementName,
            // @RequestParam(defaultValue = "N5107") String msgName,
            RedirectAttributes redirectAttributes) 
    {
    	for (int i = 0; i < MyConst.msg.length; i++) 
    	{
				String msgName = MyConst.msg[i][0];
				String rootElementName = MyConst.msg[i][1];
				String mappingJsonPath = MyConst.msg[i][0]+ ".json";
			
        	try {      		
	            ClassPathResource mappingResource = new ClassPathResource(mappingJsonPath);
	
	            if (!mappingResource.exists()) {
	                redirectAttributes.addFlashAttribute("statusMessage",
	                        "Mapping JSON 檔案不存在: " + mappingJsonPath);
	                return "redirect:/xsd/manage";
	            }
	
	            Path outputDir = Paths.get(XSD_DIR);
	            if (!Files.exists(outputDir)) Files.createDirectories(outputDir);
	
	            String filename = msgName + ".xsd";
	            File outputXsd = outputDir.resolve(filename).toFile();
	
	            // 使用 InputStream 版本生成 XSD（jar-safe）
	            try (InputStream is = mappingResource.getInputStream()) {
	                xsdGeneratorService.generateXsdFromJson(is, outputXsd, rootElementName, msgName);
	            }
	
	            redirectAttributes.addFlashAttribute("statusMessage", "XSD 檔案生成成功: " + filename);
	
	        } catch (Exception e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("statusMessage", "生成 XSD 失敗: " + e.getMessage());
	        }
    	}
        return "redirect:/xsd/manage";
        
    }

    /**
     * 下載 XSD
     */
    @GetMapping("/download/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> downloadXsd(@PathVariable String filename) {
        try {
            if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            Path filePath = Paths.get(XSD_DIR + filename);
            File file = filePath.toFile();
            if (!file.exists() || !file.isFile()) return ResponseEntity.notFound().build();

            Resource resource = new FileSystemResource(file);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
            headers.setContentType(MediaType.APPLICATION_XML);

            return ResponseEntity.ok().headers(headers).contentLength(file.length()).body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * 刪除 XSD
     */
    @DeleteMapping("/delete/{filename}")
    @ResponseBody
    public ResponseEntity<String> deleteXsd(@PathVariable String filename) {
        try {
            if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("非法的檔案名稱");
            }

            Path filePath = Paths.get(XSD_DIR + filename);
            File file = filePath.toFile();

            if (!file.exists()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("檔案不存在: " + filename);
            return file.delete() ? ResponseEntity.ok("檔案刪除成功: " + filename)
                    : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("檔案刪除失敗: " + filename);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("刪除檔案時發生錯誤: " + e.getMessage());
        }
    }

    /**
     * API: 列出 XSD 檔案
     */
    @GetMapping("/api/list")
    @ResponseBody
    public ResponseEntity<List<String>> apiListXsdFiles() {
        try {
            return ResponseEntity.ok(listXsdFiles());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    /** 列出所有 XSD 檔案 */
    private List<String> listXsdFiles() throws IOException {
        Path dirPath = Paths.get(XSD_DIR);
        if (!Files.exists(dirPath)) Files.createDirectories(dirPath);

        File[] files = dirPath.toFile().listFiles((dir, name) -> name.toLowerCase().endsWith(".xsd"));
        if (files == null || files.length == 0) return Collections.emptyList();

        return Arrays.stream(files)
                .map(File::getName)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}
