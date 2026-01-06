package com.example.demo.controller;

import com.example.demo.entity.Twdens;
import com.example.demo.repository.TwdensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/twdens")
public class TwdensController {

    @Autowired
    private TwdensRepository twdensRepository;

    // 頁面列表
    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("twdensList", twdensRepository.findAll());
        return "twdens_list"; // 對應 Thymeleaf 頁面 twdens_list.html
    }

    // AJAX 新增
    @PostMapping("/ajax/add")
    @ResponseBody
    public Map<String, Object> addTwdens(@ModelAttribute Twdens twdens) {
        Map<String, Object> res = new HashMap<>();
        if (twdensRepository.existsById(twdens.getDen())) {
            res.put("status", "error");
            res.put("message", "DEN 已存在");
            return res;
        }
        Twdens saved = twdensRepository.save(twdens);
        res.put("status", "success");
        res.put("message", "新增成功");
        res.put("data", saved);
        return res;
    }

    // AJAX 編輯
    @PatchMapping("/ajax/update/{den}")
    @ResponseBody
    public Map<String, Object> updateTwdens(@PathVariable String den, @RequestBody Map<String, Object> updates) {
        Map<String, Object> res = new HashMap<>();
        Optional<Twdens> optional = twdensRepository.findById(den);
        if (!optional.isPresent()) {
            res.put("status", "error");
            res.put("message", "DEN 不存在：" + den);
            return res;
        }

        Twdens twdens = optional.get();
        updates.forEach((field, value) -> {
            String val = value != null ? value.toString() : null;
            switch (field) {
                case "src": twdens.setSrc(val); break;
                case "objectClass": twdens.setObjectClass(val); break;
                case "propertyTerm": twdens.setPropertyTerm(val); break;
                case "repTerm": twdens.setRepTerm(val); break;
                case "namedComplexType": twdens.setNamedComplexType(val); break;
                case "xmlTagName": twdens.setXmlTagName(val); break;
                case "den": twdens.setDen(val); break;
                default: break;
            }
        });

        twdensRepository.save(twdens);
        res.put("status", "success");
        res.put("message", "更新成功");
        return res;
    }

    // AJAX 刪除
    @DeleteMapping("/ajax/{den}")
    @ResponseBody
    public Map<String, Object> deleteTwdens(@PathVariable String den) {
        Map<String, Object> res = new HashMap<>();
        Optional<Twdens> optional = twdensRepository.findById(den);
        if (!optional.isPresent()) {
            res.put("status", "error");
            res.put("message", "DEN 不存在：" + den);
            return res;
        }
        twdensRepository.delete(optional.get());
        res.put("status", "success");
        res.put("message", "刪除成功");
        return res;
    }
}

