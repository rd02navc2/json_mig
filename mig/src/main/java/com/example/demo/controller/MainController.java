package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.example.demo.HarmoService;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private HarmoService harmoService;
    
    @Value("${template.target.dirname:template}")
    private String targetDirName;
    
    private Path tempDir;
    private Path mappingFilePath;
    private Path recoveryFilePath;
    
    private static final Path DEV_MAPPING_FILE = Paths.get("src/main/java/com/example/demo/MyMapping.java");
    private static final Path DEV_RECOVERY_FILE = Paths.get("backup/MyMapping.java");

    @PostConstruct
    public void init() {
        try {
            tempDir = Paths.get(System.getProperty("java.io.tmpdir"), "demo-app");
            if (!Files.exists(tempDir)) {
                Files.createDirectories(tempDir);
                System.out.println("建立臨時目錄: " + tempDir);
            }
            
            mappingFilePath = tempDir.resolve("MyMapping.java");
            
            Path recoveryDir = tempDir.resolve("backup");
            if (!Files.exists(recoveryDir)) {
                Files.createDirectories(recoveryDir);
            }
            recoveryFilePath = recoveryDir.resolve("MyMapping.java");
            
            copyFromDevEnvironmentIfExists();
            
            if (!Files.exists(mappingFilePath)) {
                copyResourceToTempIfExists("MyMapping.java", mappingFilePath);
            }
            if (!Files.exists(recoveryFilePath)) {
                copyResourceToTempIfExists("backup/MyMapping.java", recoveryFilePath);
            }
            
            System.out.println("初始化完成:");
            System.out.println("  - 臨時目錄: " + tempDir);
            System.out.println("  - Mapping 檔案: " + mappingFilePath + " (存在: " + Files.exists(mappingFilePath) + ")");
            System.out.println("  - Recovery 檔案: " + recoveryFilePath + " (存在: " + Files.exists(recoveryFilePath) + ")");
            
        } catch (Exception e) {
            System.err.println("初始化失敗: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void copyFromDevEnvironmentIfExists() {
        try {
            if (Files.exists(DEV_MAPPING_FILE) && !Files.exists(mappingFilePath)) {
                Files.copy(DEV_MAPPING_FILE, mappingFilePath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("已從開發環境複製: " + DEV_MAPPING_FILE + " -> " + mappingFilePath);
            }
            
            if (Files.exists(DEV_RECOVERY_FILE) && !Files.exists(recoveryFilePath)) {
                Files.copy(DEV_RECOVERY_FILE, recoveryFilePath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("已從開發環境複製: " + DEV_RECOVERY_FILE + " -> " + recoveryFilePath);
            }
        } catch (Exception e) {
            System.out.println("從開發環境複製失敗(可能不在開發環境): " + e.getMessage());
        }
    }
    
    private void copyResourceToTempIfExists(String resourcePath, Path targetPath) {
        try {
            ClassPathResource resource = new ClassPathResource(resourcePath);
            
            if (resource.exists()) {
                try (InputStream is = resource.getInputStream()) {
                    Files.copy(is, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("已從 classpath 複製: " + resourcePath + " -> " + targetPath);
                }
            }
        } catch (Exception e) {
            System.out.println("從 classpath 複製失敗: " + resourcePath + " - " + e.getMessage());
        }
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/mig";
    }

    @GetMapping("/mig")
    public String home(Model model) {
        model.addAttribute("currentPage", "home");
        Map<String, Object> fileStatus = new HashMap<>();

        try {
            Path checkPath = Files.exists(DEV_MAPPING_FILE) ? DEV_MAPPING_FILE : mappingFilePath;
            
            if (Files.exists(checkPath)) {
                fileStatus.put("exists", true);
                fileStatus.put("lines", Files.readAllLines(checkPath).size());
                fileStatus.put("lastModified", new Date(Files.getLastModifiedTime(checkPath).toMillis()));
                fileStatus.put("path", checkPath.toString());
                fileStatus.put("location", Files.exists(DEV_MAPPING_FILE) ? "開發環境" : "臨時目錄");
            } else {
                System.out.println("DEBUG: MAPPING_FILE 不存在");
                fileStatus.put("exists", false);
                fileStatus.put("lines", 0);
                fileStatus.put("lastModified", null);
                fileStatus.put("path", "檔案不存在");
                fileStatus.put("location", "無");
            }

            fileStatus.put("error", "");
            fileStatus.put("tempDir", tempDir != null ? tempDir.toString() : "未初始化");

        } catch (Exception e) {
            System.out.println("DEBUG: 例外發生: " + e.getMessage());
            fileStatus.put("exists", false);
            fileStatus.put("lines", 0);
            fileStatus.put("error", e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("fileStatus", fileStatus);
        return "index";
    }
    
    @PostMapping("/mig/copyTemplate")
    @ResponseBody
    public Map<String, Object> copyTemplate() {
        Map<String, Object> response = new HashMap<>();
        
        Path targetDir = Paths.get(System.getProperty("user.home"), "Downloads", targetDirName);

        int copiedCount = 0;
        int failedCount = 0;

        try {
            System.out.println("DEBUG: Target directory: " + targetDir.toAbsolutePath());

            if (!Files.exists(targetDir)) {
                System.out.println("DEBUG: 建立目標資料夾: " + targetDir);
                Files.createDirectories(targetDir);
            }

            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:template/**/*");

            System.out.println("DEBUG: 找到 " + resources.length + " 個資源");

            for (Resource resource : resources) {
                try {
                    if (!resource.isReadable()) {
                        continue;
                    }
                    
                    String resourceUrl = resource.getURL().toString();
                    
                    if (resourceUrl.endsWith("/")) {
                        continue;
                    }

                    int baseIndex = resourceUrl.indexOf("template/");
                    if (baseIndex == -1) {
                        continue;
                    }
                    
                    String relativePath = resourceUrl.substring(baseIndex + "template/".length());
                    
                    if (relativePath.isEmpty()) {
                        continue;
                    }

                    Path targetFile = targetDir.resolve(relativePath);
                    
                    System.out.println("DEBUG: 複製資源: " + relativePath + " -> " + targetFile);

                    Files.createDirectories(targetFile.getParent());

                    try (InputStream is = resource.getInputStream()) {
                        Files.copy(is, targetFile, StandardCopyOption.REPLACE_EXISTING);
                        copiedCount++;
                    }

                } catch (Exception e) {
                    System.out.println("DEBUG: 複製失敗: " + resource.getFilename() + 
                                     " , 原因: " + e.getMessage());
                    failedCount++;
                    e.printStackTrace();
                }
            }

            System.out.println("DEBUG: 複製完成，成功 " + copiedCount + " 個，失敗 " + failedCount + " 個");

            if (copiedCount == 0 && failedCount == 0) {
                response.put("success", false);
                response.put("message", "找不到任何模板檔案");
            } else {
                response.put("success", true);
                response.put("message", "成功複製 " + copiedCount + " 個檔案到下載目錄: " + targetDir);
                response.put("copiedCount", copiedCount);
                response.put("failedCount", failedCount);
                response.put("targetPath", targetDir.toString());
            }

        } catch (Exception e) {
            System.out.println("DEBUG: 例外發生: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "複製失敗: " + e.getMessage());
        }

        return response;
    }
    
    @GetMapping("/test/listResources")
    @ResponseBody
    public Map<String, Object> listResources() {
        Map<String, Object> result = new HashMap<>();
        List<String> resourceList = new ArrayList<>();
        
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:template/**/*");
            
            result.put("count", resources.length);
            
            for (Resource resource : resources) {
                try {
                    String url = resource.getURL().toString();
                    resourceList.add(url);
                } catch (Exception e) {
                    resourceList.add("Error reading resource: " + e.getMessage());
                }
            }
            
            result.put("success", true);
            result.put("resources", resourceList);
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }
    
    @GetMapping("/test/tempDirInfo")
    @ResponseBody
    public Map<String, Object> getTempDirInfo() {
        Map<String, Object> info = new HashMap<>();
        
        info.put("tempDir", tempDir != null ? tempDir.toString() : "未初始化");
        info.put("mappingFilePath", mappingFilePath != null ? mappingFilePath.toString() : "未初始化");
        info.put("recoveryFilePath", recoveryFilePath != null ? recoveryFilePath.toString() : "未初始化");
        
        info.put("devMappingFileExists", Files.exists(DEV_MAPPING_FILE));
        info.put("devRecoveryFileExists", Files.exists(DEV_RECOVERY_FILE));
        info.put("tempMappingFileExists", mappingFilePath != null && Files.exists(mappingFilePath));
        info.put("tempRecoveryFileExists", recoveryFilePath != null && Files.exists(recoveryFilePath));
        
        try {
            Path activeFile = Files.exists(DEV_MAPPING_FILE) ? DEV_MAPPING_FILE : mappingFilePath;
            if (Files.exists(activeFile)) {
                info.put("activeFileSize", Files.size(activeFile));
                info.put("activeFileLines", Files.readAllLines(activeFile).size());
                info.put("activeFilePath", activeFile.toString());
            }
        } catch (Exception e) {
            info.put("activeFileError", e.getMessage());
        }
        
        return info;
    }

    @GetMapping("/harmo/loadMymapping")
    @ResponseBody
    public String loadMymapping() {
        try {
            // 優先讀取開發環境的檔案
            if (Files.exists(DEV_MAPPING_FILE)) {
                String content = Files.readString(DEV_MAPPING_FILE, StandardCharsets.UTF_8);
                System.out.println("從開發環境讀取: " + DEV_MAPPING_FILE);
                return content;
            }
            
            if (Files.exists(mappingFilePath)) {
                String content = Files.readString(mappingFilePath, StandardCharsets.UTF_8);
                System.out.println("從臨時目錄讀取: " + mappingFilePath);
                return content;
            }
            
            ClassPathResource resource = new ClassPathResource("MyMapping.java");
            if (resource.exists()) {
                try (InputStream is = resource.getInputStream()) {
                    String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                    Files.writeString(mappingFilePath, content, StandardCharsets.UTF_8);
                    System.out.println("從 classpath 讀取並保存到臨時目錄");
                    return content;
                }
            }
            
            return "// 檔案不存在";
            
        } catch (Exception e) {
            e.printStackTrace();
            return "// 讀取失敗：" + e.getMessage();
        }
    }

    @GetMapping("/harmo/recoveryMymapping")
    @ResponseBody
    public String recoveryMymapping() {
        try {
            if (Files.exists(DEV_RECOVERY_FILE)) {
                return Files.readString(DEV_RECOVERY_FILE, StandardCharsets.UTF_8);
            }
            
            if (Files.exists(recoveryFilePath)) {
                return Files.readString(recoveryFilePath, StandardCharsets.UTF_8);
            }
            
            ClassPathResource resource = new ClassPathResource("backup/MyMapping.java");
            if (resource.exists()) {
                try (InputStream is = resource.getInputStream()) {
                    return new String(is.readAllBytes(), StandardCharsets.UTF_8);
                }
            }
            
            return "// 檔案不存在";
            
        } catch (Exception e) {
            return "// 讀取失敗：" + e.getMessage();
        }
    }

    @PostMapping("/harmo/saveMymapping")
    @ResponseBody
    public String saveMymapping(@RequestBody Map<String, String> payload) {
        try {
            String code = payload.get("code");
            if (code == null) {
                return "❌ 無程式碼";
            }
            
            if (Files.exists(DEV_MAPPING_FILE.getParent())) {
                Files.writeString(DEV_MAPPING_FILE, code, StandardCharsets.UTF_8);
                System.out.println("檔案已保存到開發環境: " + DEV_MAPPING_FILE);
                return "✅ 已保存到開發環境: " + DEV_MAPPING_FILE;
            }
            
            Files.writeString(mappingFilePath, code, StandardCharsets.UTF_8);
            System.out.println("檔案已保存到臨時目錄: " + mappingFilePath);
            return "✅ 已保存到臨時目錄: " + mappingFilePath;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "❌ 保存失敗：" + e.getMessage();
        }
    }

    @PostMapping("/admin/clearTempDir")
    @ResponseBody
    public Map<String, Object> clearTempDir() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            if (tempDir != null && Files.exists(tempDir)) {
                Files.walk(tempDir)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            System.err.println("無法刪除: " + path);
                        }
                    });
                
                Files.createDirectories(tempDir);
                
                response.put("success", true);
                response.put("message", "臨時目錄已清除");
            } else {
                response.put("success", false);
                response.put("message", "臨時目錄不存在");
            }
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "清除失敗: " + e.getMessage());
        }
        
        return response;
    }
    
    @GetMapping("/harmo/runNX")
    public String showNXForm() {
        return "runNX";
    }

    @PostMapping("/harmo/runNX")
    public String runNX(@RequestParam String nxInput, Model model) throws Throwable {
        try {
            List<String> nxLines = Arrays.asList(nxInput.split("\\r?\\n"));
            String result = harmoService.runMultipleNX(nxLines);

            model.addAttribute("result", result.replaceAll("\n", "<br/>"));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result", "Error: " + e.getMessage());
        }
        return "runNX";
    }
}