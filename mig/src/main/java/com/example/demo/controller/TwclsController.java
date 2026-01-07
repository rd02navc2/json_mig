package com.example.demo.controller;

import com.example.demo.TwclsService;
import com.example.demo.entity.Twcls;
import com.example.demo.repository.TwclsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/twcls")
public class TwclsController {

    @Autowired
    private TwclsRepository repo;

    @Autowired
    private TwclsService service;

    // 顯示列表頁
    @GetMapping
    public String list(Model model) {
        List<Twcls> classes = repo.findAll();
        model.addAttribute("classes", classes);
        model.addAttribute("newClass", new Twcls());
        return "twcls_list";
    }

    // Ajax 新增
    @PostMapping("/ajax/add")
    @ResponseBody
    @Transactional
    public Map<String, Object> ajaxAdd(@RequestBody  Twcls twcls) {
        Map<String, Object> res = new HashMap<>();
        try {
            if (twcls.getObjectClass() == null || twcls.getObjectClass().trim().isEmpty()) {
                res.put("status", "error");
                res.put("message", "請輸入 ObjectClass");
                return res;
            }
            if (repo.existsById(twcls.getObjectClass())) {
                res.put("status", "error");
                res.put("message", "ObjectClass 已存在");
                return res;
            }

            service.save(twcls);

            res.put("status", "success");
            res.put("message", "新增成功");
            res.put("data", twcls);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "新增失敗：" + e.getMessage());
        }
        return res;
    }

    // Ajax 更新
	@PatchMapping("/ajax/update/{objectClass}")
	@ResponseBody
	@Transactional
	public Map<String, Object> updateFieldAjax(@PathVariable String objectClass, 
	                                           @RequestBody Map<String, String> updates) {
	    Map<String, Object> res = new HashMap<>();
	    try {
	        Optional<Twcls> opt = repo.findById(objectClass);
	        if (!opt.isPresent()) {
	            res.put("status", "error");
	            res.put("message", "ObjectClass 不存在：" + objectClass);
	            return res;
	        }
	        
	        Twcls twcls = opt.get();
	        
	        // 動態更新欄位
	        updates.forEach((field, value) -> {
	            switch (field) {
	                case "className":
	                    twcls.setClassName(value);
	                    break;
	                case "chName":
	                    twcls.setChName(value);
	                    break;
	                case "enName":
	                    twcls.setEnName(value);
	                    break;
	                case "chDef":
	                    twcls.setChDef(value);
	                    break;
	                case "enDef":
	                    twcls.setEnDef(value);
	                    break;
	                case "objectClass":
	                    // 如果要更新 objectClass，需要特別處理（因為是主鍵）
	                    break;
	            }
	        });
	        
	        repo.save(twcls);
	        
	        res.put("status", "success");
	        res.put("message", "更新成功");
	    } catch (Exception e) {
	        res.put("status", "error");
	        res.put("message", "更新失敗：" + e.getMessage());
	    }
	    return res;
	}
    
    // Ajax 刪除
    @DeleteMapping("/ajax/{objectClass}")
    @ResponseBody
    @Transactional
    public Map<String, Object> deleteClassAjax(@PathVariable String objectClass) {
        Map<String, Object> res = new HashMap<>();
        try {
            Optional<Twcls> opt = repo.findById(objectClass);
            if (!opt.isPresent()) {
                res.put("status", "error");
                res.put("message", "ObjectClass 不存在：" + objectClass);
                return res;
            }

            repo.deleteById(objectClass);

            res.put("status", "success");
            res.put("message", "刪除成功");
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "刪除失敗：" + e.getMessage());
        }
        return res;
    }

    // Ajax 檢查是否存在
    @GetMapping("/ajax/check/{objectClass}")
    @ResponseBody
    public Map<String, Object> checkClassId(@PathVariable String objectClass) {
        boolean exists = repo.existsById(objectClass);
        Map<String, Object> result = new HashMap<>();
        result.put("exists", exists);
        return result;
    }
}


