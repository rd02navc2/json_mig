package com.example.demo.service;

import com.example.demo.dto.EnhancedFieldInfo;
import com.example.demo.entity.Twcls;
import com.example.demo.entity.Twdens;
import com.example.demo.entity.Twds;
import com.example.demo.entity.Twids;
import com.example.demo.repository.TwclsRepository;
import com.example.demo.repository.TwdensRepository;
import com.example.demo.repository.TwdsRepository;
import com.example.demo.repository.TwidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 欄位資料庫擴充服務
 */
@Service
public class FieldEnrichmentService {
    
    @Autowired
    private TwdensRepository twdensRepository;
    
    @Autowired
    private TwdsRepository twdsRepository;
    
    @Autowired
    private TwclsRepository twclsRepository;
    
    @Autowired
    private TwidsRepository twidsRepository;
    
    /**
     * 擴充欄位資訊 - 從資料庫查詢相關資料
     */
    @Transactional(readOnly = true)
    public void enrichFieldInfo(EnhancedFieldInfo fieldInfo) {
        
        EnhancedFieldInfo.DatabaseEnrichment dbEnrichment = new EnhancedFieldInfo.DatabaseEnrichment();
        
        // 1. 根據 DEN 查詢 Twdens
        String den = fieldInfo.getDsref().getDen();
        if (den != null && !den.isEmpty()) {
            Optional<Twdens> twdensOpt = twdensRepository.findByDen(den);
            if (twdensOpt.isPresent()) {
                Twdens twdens = twdensOpt.get();
                dbEnrichment.setXmlTagName(twdens.getXmlTagName());
                dbEnrichment.setObjectClass(twdens.getObjectClass());
                dbEnrichment.setPropertyTerm(twdens.getPropertyTerm());
                dbEnrichment.setRepTerm(twdens.getRepTerm());
                dbEnrichment.setNamedComplexType(twdens.getNamedComplexType());
                
                // 更新 fieldName 為 xmlTagName (如果有的話)
                if (twdens.getXmlTagName() != null && !twdens.getXmlTagName().isEmpty()) {
                    fieldInfo.setFieldName(twdens.getXmlTagName());
                }
            }
        }
        
        // 2. 根據 UID 查詢 Twids
        String uid = fieldInfo.getDsref().getUid();
        if (uid != null && !uid.isEmpty()) {
            Optional<Twids> twidsOpt = twidsRepository.findByTwid(uid);
            if (twidsOpt.isPresent()) {
                Twids twids = twidsOpt.get();
                dbEnrichment.setTwidEnName(twids.getEnName());
                dbEnrichment.setTwidEnDef(twids.getEnDef());
            }
        }
        
        // 3. 根據 CLS 查詢 Twcls
        String cls = fieldInfo.getDsref().getCls();
        if (cls != null && !cls.isEmpty()) {
            Optional<Twcls> twclsOpt = twclsRepository.findByClassName(cls);
            if (twclsOpt.isPresent()) {
                Twcls twcls = twclsOpt.get();
                EnhancedFieldInfo.ClassInfo classInfo = new EnhancedFieldInfo.ClassInfo();
                classInfo.setObjectClass(twcls.getObjectClass());
                classInfo.setClassId(twcls.getClassId());
                classInfo.setClassName(twcls.getClassName());
                classInfo.setChDef(twcls.getChDef());
                classInfo.setEnDef(twcls.getEnDef());
                classInfo.setChName(twcls.getChName());
                classInfo.setEnName(twcls.getEnName());
                dbEnrichment.getClassHierarchy().add(classInfo);
            }
        }
        
        // 4. 根據類別路徑查詢所有相關 Twcls
        List<String> classPath = fieldInfo.getClassPath();
        if (classPath != null && !classPath.isEmpty()) {
            for (String className : classPath) {
                Optional<Twcls> twclsOpt = twclsRepository.findByClassName(className);
                if (twclsOpt.isPresent()) {
                    Twcls twcls = twclsOpt.get();
                    
                    // 避免重複添加
                    boolean exists = dbEnrichment.getClassHierarchy().stream()
                        .anyMatch(ci -> className.equals(ci.getClassName()));
                    
                    if (!exists) {
                        EnhancedFieldInfo.ClassInfo classInfo = new EnhancedFieldInfo.ClassInfo();
                        classInfo.setObjectClass(twcls.getObjectClass());
                        classInfo.setClassId(twcls.getClassId());
                        classInfo.setClassName(twcls.getClassName());
                        classInfo.setChDef(twcls.getChDef());
                        classInfo.setEnDef(twcls.getEnDef());
                        classInfo.setChName(twcls.getChName());
                        classInfo.setEnName(twcls.getEnName());
                        dbEnrichment.getClassHierarchy().add(classInfo);
                    }
                }
            }
        }
        
        // 5. 根據 AAA msg 中的 chn 查詢 Twds
        if (fieldInfo.getAaa() != null && fieldInfo.getAaa().getMsg() != null) {
            for (EnhancedFieldInfo.MsgInfo msg : fieldInfo.getAaa().getMsg()) {
                String chn = msg.getChn();
                if (chn != null && !chn.isEmpty()) {
                    Optional<Twds> twdsOpt = twdsRepository.findByChName(chn);
                    if (twdsOpt.isPresent()) {
                        Twds twds = twdsOpt.get();
                        // 存儲第一個找到的詳細資訊
                        if (dbEnrichment.getChNameDef() == null) {
                            dbEnrichment.setChNameDef(twds.getChDef());
                            dbEnrichment.setEnName(twds.getEnName());
                            dbEnrichment.setFormat(twds.getFormat());
                            dbEnrichment.setCodeList(twds.getCodeList());
                            dbEnrichment.setSample(twds.getSample());
                        }
                    }
                }
            }
        }
        
        fieldInfo.setDbEnrichment(dbEnrichment);
    }
    
    /**
     * 批次擴充多個欄位資訊
     */
    @Transactional(readOnly = true)
    public void enrichFieldInfoList(List<EnhancedFieldInfo> fieldInfoList) {
        for (EnhancedFieldInfo fieldInfo : fieldInfoList) {
            enrichFieldInfo(fieldInfo);
        }
    }
    
    /**
     * 根據 fieldName 從資料庫推薦相關資料
     */
    @Transactional(readOnly = true)
    public EnhancedFieldInfo suggestFromDatabase(String fieldName) {
        EnhancedFieldInfo fieldInfo = new EnhancedFieldInfo();
        fieldInfo.setFieldName(fieldName);
        
        // 根據 xmlTagName 查詢
        Optional<Twdens> twdensOpt = twdensRepository.findByXmlTagName(fieldName);
        if (twdensOpt.isPresent()) {
            Twdens twdens = twdensOpt.get();
            
            // 填充 DSREF 資訊
            EnhancedFieldInfo.DsrefInfo dsref = new EnhancedFieldInfo.DsrefInfo();
            dsref.setDen(twdens.getDen());
            fieldInfo.setDsref(dsref);
            
            // 根據 objectClass 查詢 Twcls
            if (twdens.getObjectClass() != null) {
                Optional<Twcls> twclsOpt = twclsRepository.findByObjectClass(twdens.getObjectClass());
                if (twclsOpt.isPresent()) {
                    Twcls twcls = twclsOpt.get();
                    dsref.setCls(twcls.getClassName());
                }
            }
            
            // 擴充完整資訊
            enrichFieldInfo(fieldInfo);
        }
        
        return fieldInfo;
    }
    
    /**
     * 驗證並同步資料到資料庫
     */
    @Transactional
    public void syncToDatabase(EnhancedFieldInfo fieldInfo) {
        // 1. 更新或創建 Twdens
        String den = fieldInfo.getDsref().getDen();
        if (den != null && !den.isEmpty()) {
            Optional<Twdens> twdensOpt = twdensRepository.findByDen(den);
            Twdens twdens;
            
            if (twdensOpt.isPresent()) {
                twdens = twdensOpt.get();
            } else {
                twdens = new Twdens();
                twdens.setDen(den);
            }
            
            // 更新欄位
            twdens.setXmlTagName(fieldInfo.getFieldName());
            
            if (!fieldInfo.getClassPath().isEmpty()) {
                twdens.setObjectClass(fieldInfo.getClassPath().get(0));
            }
            
            twdensRepository.save(twdens);
        }
        
        // 2. 驗證 Twids (UID)
        String uid = fieldInfo.getDsref().getUid();
        if (uid != null && !uid.isEmpty()) {
            Optional<Twids> twidsOpt = twidsRepository.findByTwid(uid);
            if (!twidsOpt.isPresent()) {
                System.out.println("警告: UID " + uid + " 在 TWIDS 表中不存在");
            }
        }
        
        // 3. 驗證 Twcls (CLS)
        String cls = fieldInfo.getDsref().getCls();
        if (cls != null && !cls.isEmpty()) {
            Optional<Twcls> twclsOpt = twclsRepository.findByClassName(cls);
            if (!twclsOpt.isPresent()) {
                System.out.println("警告: CLS " + cls + " 在 TWCLS 表中不存在");
            }
        }
        
        // 4. 驗證 Twds (CHN)
        if (fieldInfo.getAaa() != null && fieldInfo.getAaa().getMsg() != null) {
            for (EnhancedFieldInfo.MsgInfo msg : fieldInfo.getAaa().getMsg()) {
                String chn = msg.getChn();
                if (chn != null && !chn.isEmpty()) {
                    Optional<Twds> twdsOpt = twdsRepository.findByChName(chn);
                    if (!twdsOpt.isPresent()) {
                        System.out.println("警告: CHN " + chn + " 在 TWDS 表中不存在");
                    }
                }
            }
        }
    }
}