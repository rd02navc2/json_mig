package com.example.demo.controller;

import com.example.demo.entity.Twds;
import com.example.demo.repository.TwdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/twds")
public class TwdsController {

    @Autowired
    private TwdsRepository twdsRepository;

    // ===== 列表頁面 =====
    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("twdsList", twdsRepository.findAll());
        return "twds_list"; // Thymeleaf 頁面
    }

    // ===== AJAX 新增 =====
    @PostMapping("/ajax/add")
    @ResponseBody
    public Map<String, Object> addTwds(@RequestBody Twds twds) {
        Map<String, Object> res = new HashMap<>();
        if (twdsRepository.existsById(twds.getChName())) {
            res.put("status", "error");
            res.put("message", "CH Name 已存在");
            return res;
        }
        Twds saved = twdsRepository.save(twds);
        res.put("status", "success");
        res.put("message", "新增成功");
        res.put("data", saved);
        return res;
    }

    // ===== AJAX 編輯 =====
@PatchMapping("/ajax/update/{chName}")
@ResponseBody
public Map<String, Object> updateTwds(@PathVariable String chName, @RequestBody Map<String, Object> updates) {
    Map<String, Object> res = new HashMap<>();

    Optional<Twds> optional = twdsRepository.findById(chName);
    if (!optional.isPresent()) {
        res.put("status", "error");
        res.put("message", "CH Name 不存在：" + chName);
        return res;
    }

    Twds twds = optional.get();

    // 單欄位更新（前端有傳才更新）
    if (updates.containsKey("sn"))
        twds.setSn((String) updates.get("sn"));
    if (updates.containsKey("enName"))
        twds.setEnName((String) updates.get("enName"));
    if (updates.containsKey("chDef"))
        twds.setChDef((String) updates.get("chDef"));
    if (updates.containsKey("enDef"))
        twds.setEnDef((String) updates.get("enDef"));
    if (updates.containsKey("format"))
        twds.setFormat((String) updates.get("format"));
    if (updates.containsKey("codeList"))
        twds.setCodeList((String) updates.get("codeList"));
    if (updates.containsKey("sample"))
        twds.setSample((String) updates.get("sample"));

    twdsRepository.save(twds);

    res.put("status", "success");
    res.put("message", "更新成功");
    return res;
}


    // ===== AJAX 刪除 =====
    @DeleteMapping("/ajax/{chName}")
    @ResponseBody
    public Map<String, Object> deleteTwds(@PathVariable String chName) {
        Map<String, Object> res = new HashMap<>();
        Optional<Twds> optional = twdsRepository.findById(chName);
        if (!optional.isPresent()) {
            res.put("status", "error");
            res.put("message", "CH Name 不存在：" + chName);
            return res;
        }
        twdsRepository.delete(optional.get());
        res.put("status", "success");
        res.put("message", "刪除成功");
        return res;
    }
}

