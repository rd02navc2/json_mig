package com.example.demo.controller;

import com.example.demo.service.JsonModifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/json")
public class JsonModifierController {

    @Autowired
    private JsonModifierService jsonModifierService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Controller is working! Time: " + System.currentTimeMillis();
    }

    @GetMapping({"", "/"})
    public String indexJson() {
        return "indexJson";
    }

    @PostMapping("/upload")
    public String uploadJson(@RequestParam("file") MultipartFile file, Model model) {
        
        try {
            if (file.isEmpty()) {
                model.addAttribute("error", "請選擇文件");
                return "indexJson";
            }

            String jsonContent = new String(file.getBytes(), StandardCharsets.UTF_8);

            if (!jsonModifierService.isValidJson(jsonContent)) {
                model.addAttribute("error", "無效的 JSON 格式");
                return "indexJson";
            }

            String modifiedJson = jsonModifierService.addTW_LimitDateTime2(jsonContent);

            model.addAttribute("success", true);
            model.addAttribute("originalJson", jsonContent);
            model.addAttribute("modifiedJson", modifiedJson);
            model.addAttribute("fileName", file.getOriginalFilename());

            return "resultJson";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "處理失敗: " + e.getMessage());
            return "indexJson";
        }
    }
}