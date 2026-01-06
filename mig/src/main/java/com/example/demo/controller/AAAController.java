package com.example.demo.controller;

import com.example.demo.entity.AAA;
import com.example.demo.service.AAAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/aaa")
@CrossOrigin(origins = "*")  // 允許跨域請求（開發環境使用）
public class AAAController {
    
    @Autowired
    private AAAService aaaService;
    
    // 查詢所有
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> res = new HashMap<>();
        try {
            List<AAA> list = aaaService.findAll();
            res.put("status", "success");
            res.put("data", list);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "查詢失敗：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    
    // 根據主鍵查詢
    @GetMapping("/{cls}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable String cls) {
        Map<String, Object> res = new HashMap<>();
        try {
            Optional<AAA> opt = aaaService.findById(cls);
            if (!opt.isPresent()) {
                res.put("status", "error");
                res.put("message", "找不到資料：" + cls);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
            }
            res.put("status", "success");
            res.put("data", opt.get());
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "查詢失敗：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    
    // 新增
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody AAA aaa) {
        Map<String, Object> res = new HashMap<>();
        try {
            if (aaa.getCls() == null || aaa.getCls().trim().isEmpty()) {
                res.put("status", "error");
                res.put("message", "請輸入 cls（主鍵）");
                return ResponseEntity.badRequest().body(res);
            }
            
            if (aaaService.existsById(aaa.getCls())) {
                res.put("status", "error");
                res.put("message", "cls 已存在：" + aaa.getCls());
                return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
            }
            
            AAA saved = aaaService.save(aaa);
            res.put("status", "success");
            res.put("message", "新增成功");
            res.put("data", saved);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "新增失敗：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    
    // 完整更新
    @PutMapping("/{cls}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String cls, @RequestBody AAA aaa) {
        Map<String, Object> res = new HashMap<>();
        try {
            if (!aaaService.existsById(cls)) {
                res.put("status", "error");
                res.put("message", "cls 不存在：" + cls);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
            }
            
            aaa.setCls(cls);  // 確保主鍵不變
            AAA updated = aaaService.save(aaa);
            res.put("status", "success");
            res.put("message", "更新成功");
            res.put("data", updated);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "更新失敗：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    
    // 部分更新
    @PatchMapping("/{cls}")
    public ResponseEntity<Map<String, Object>> partialUpdate(@PathVariable String cls, 
                                                              @RequestBody Map<String, Object> updates) {
        Map<String, Object> res = new HashMap<>();
        try {
            Optional<AAA> opt = aaaService.findById(cls);
            if (!opt.isPresent()) {
                res.put("status", "error");
                res.put("message", "cls 不存在：" + cls);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
            }
            
            AAA aaa = opt.get();
            
            // 動態更新欄位
            updates.forEach((field, value) -> {
                switch (field) {
                    case "name":
                        aaa.setName(value != null ? value.toString() : null);
                        break;
                    case "car":
                        aaa.setCar(value != null ? Integer.parseInt(value.toString()) : null);
                        break;
                    case "boro":
                        aaa.setBoro(value != null ? Integer.parseInt(value.toString()) : null);
                        break;
                    case "chn":
                        aaa.setChn(value != null ? value.toString() : null);
                        break;
                }
            });
            
            AAA updated = aaaService.save(aaa);
            res.put("status", "success");
            res.put("message", "更新成功");
            res.put("data", updated);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "更新失敗：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    
    // 刪除
    @DeleteMapping("/{cls}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String cls) {
        Map<String, Object> res = new HashMap<>();
        try {
            if (!aaaService.existsById(cls)) {
                res.put("status", "error");
                res.put("message", "cls 不存在：" + cls);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
            }
            
            aaaService.deleteById(cls);
            res.put("status", "success");
            res.put("message", "刪除成功");
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "刪除失敗：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    
    // 檢查 cls 是否存在
    @GetMapping("/check/{cls}")
    public ResponseEntity<Map<String, Object>> checkExists(@PathVariable String cls) {
        Map<String, Object> result = new HashMap<>();
        result.put("exists", aaaService.existsById(cls));
        return ResponseEntity.ok(result);
    }
    
    // 搜尋
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String chn) {
        Map<String, Object> res = new HashMap<>();
        try {
            List<AAA> list;
            if (name != null && !name.isEmpty()) {
                list = aaaService.searchByName(name);
            } else if (chn != null && !chn.isEmpty()) {
                list = aaaService.searchByChn(chn);
            } else {
                list = aaaService.findAll();
            }
            res.put("status", "success");
            res.put("data", list);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "搜尋失敗：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
}