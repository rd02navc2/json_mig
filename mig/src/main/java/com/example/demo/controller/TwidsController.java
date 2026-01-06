package com.example.demo.controller;

import com.example.demo.entity.Twids;
import com.example.demo.repository.TwidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/twids")
public class TwidsController {

    @Autowired
    private TwidsRepository twidsRepository;

    // 1️⃣ 進入列表頁面
    @GetMapping
    public String listPage(Model model) {
        List<Twids> twidsList = twidsRepository.findAll();
        model.addAttribute("twidsList", twidsList);
        return "twids_list"; // 對應 twids_list.html
    }

    // 2️⃣ AJAX 新增
    @PostMapping("/ajax/add")
    @ResponseBody
    public Map<String, Object> addTwids(@RequestParam String twid,
                                        @RequestParam(required = false) String src,
                                        @RequestParam(required = false) String enName,
                                        @RequestParam(required = false) String enDef) {
        Map<String, Object> res = new HashMap<>();
        try {
            if(twidsRepository.existsById(twid)) {
                res.put("status", "error");
                res.put("message", "TWID 已存在");
                return res;
            }

            Twids tw = new Twids();
            tw.setTwid(twid);
            tw.setSrc(src);
            tw.setEnName(enName);
            tw.setEnDef(enDef);

            twidsRepository.save(tw);

            res.put("status", "success");
            res.put("message", "新增成功");
            res.put("data", tw);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
        }
        return res;
    }

    // 3️⃣ AJAX 刪除
    @DeleteMapping("/ajax/{twid}")
    @ResponseBody
    public Map<String, Object> deleteTwids(@PathVariable String twid) {
        Map<String, Object> res = new HashMap<>();
        try {
            if (!twidsRepository.existsById(twid)) {
                res.put("status", "error");
                res.put("message", "TWID 不存在");
                return res;
            }
            twidsRepository.deleteById(twid);
            res.put("status", "success");
            res.put("message", "刪除成功");
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
        }
        return res;
    }

    // 4️⃣ AJAX 編輯
    @PatchMapping("/ajax/update/{twid}")
    @ResponseBody
    public Map<String, Object> updateTwids(@PathVariable String twid,
                                           @RequestBody Map<String, String> updates) {
        Map<String, Object> res = new HashMap<>();
        try {
            Twids tw = twidsRepository.findById(twid).orElse(null);
            if (tw == null) {
                res.put("status", "error");
                res.put("message", "TWID 不存在");
                return res;
            }

            // 更新欄位
            updates.forEach((key, value) -> {
                switch (key) {
                    case "src": tw.setSrc(value); break;
                    case "enName": tw.setEnName(value); break;
                    case "enDef": tw.setEnDef(value); break;
                    // twid 本身不建議修改，如果要修改需要特別處理
                }
            });

            twidsRepository.save(tw);
            res.put("status", "success");
            res.put("message", "更新成功");
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
        }
        return res;
    }
}

