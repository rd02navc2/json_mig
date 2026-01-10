package com.example.demo.dto;

import java.util.List;
import java.util.ArrayList;

/**
 * 增強型欄位資訊 DTO
 */
public class EnhancedFieldInfo {
    
    // 基本資訊
    private String fieldName;              // 欄位名稱
    private List<String> classPath;        // 類別路徑（從外到內）
    private String originalCode;           // 原始程式碼
    
    // @DSREF 註解
    private DsrefInfo dsref;
    
    // @AAA 註解
    private AaaInfo aaa;
    
    // 資料庫擴充資訊 (相容兩種命名)
    private DatabaseEnrichment dbEnrichment;
    
    // ===== Getters and Setters =====
    
    public String getFieldName() {
        return fieldName;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public List<String> getClassPath() {
        if (classPath == null) {
            classPath = new ArrayList<>();
        }
        return classPath;
    }
    
    public void setClassPath(List<String> classPath) {
        this.classPath = classPath;
    }
    
    public String getOriginalCode() {
        return originalCode;
    }
    
    public void setOriginalCode(String originalCode) {
        this.originalCode = originalCode;
    }
    
    public DsrefInfo getDsref() {
        if (dsref == null) {
            dsref = new DsrefInfo();
        }
        return dsref;
    }
    
    public void setDsref(DsrefInfo dsref) {
        this.dsref = dsref;
    }
    
    public AaaInfo getAaa() {
        if (aaa == null) {
            aaa = new AaaInfo();
        }
        return aaa;
    }
    
    public void setAaa(AaaInfo aaa) {
        this.aaa = aaa;
    }
    
    public DatabaseEnrichment getDbEnrichment() {
        if (dbEnrichment == null) {
            dbEnrichment = new DatabaseEnrichment();
        }
        return dbEnrichment;
    }
    
    public void setDbEnrichment(DatabaseEnrichment dbEnrichment) {
        this.dbEnrichment = dbEnrichment;
    }
    
    // ===== 內部類別 =====
    
    /**
     * @DSREF 註解資訊
     */
    public static class DsrefInfo {
        private String den;
        private String uid;
        private String cls;
        
        public String getDen() {
            return den;
        }
        
        public void setDen(String den) {
            this.den = den;
        }
        
        public String getUid() {
            return uid;
        }
        
        public void setUid(String uid) {
            this.uid = uid;
        }
        
        public String getCls() {
            return cls;
        }
        
        public void setCls(String cls) {
            this.cls = cls;
        }
    }
    
    /**
     * @AAA 註解資訊
     */
    public static class AaaInfo {
        private List<MsgInfo> msg;
        
        public AaaInfo() {
            this.msg = new ArrayList<>();
        }
        
        public List<MsgInfo> getMsg() {
            if (msg == null) {
                msg = new ArrayList<>();
            }
            return msg;
        }
        
        public void setMsg(List<MsgInfo> msg) {
            this.msg = msg;
        }
    }
    
    /**
     * msg 資訊
     */
    public static class MsgInfo {
        private String name;
        private String car;
        private String boro;
        private String chn;
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getCar() {
            return car;
        }
        
        public void setCar(String car) {
            this.car = car;
        }
        
        public String getBoro() {
            return boro;
        }
        
        public void setBoro(String boro) {
            this.boro = boro;
        }
        
        public String getChn() {
            return chn;
        }
        
        public void setChn(String chn) {
            this.chn = chn;
        }
    }
    
    /**
     * 資料庫擴充資訊（TWDENS, TWDS, TWCLS, TWIDS）
     */
    public static class DatabaseEnrichment {
        // TWDENS 欄位
        private String src;                    // 來源 (例如: EDIFACT)
        private String xmlTagName;             // XML 標籤名稱
        private String objectClass;            // Object Class
        private String propertyTerm;           // Property Term
        private String repTerm;                // Representation Term
        private String namedComplexType;       // Named Complex Type
        
        // TWCLS 類別階層
        private List<ClassInfo> classHierarchy;
        
        // TWIDS 資料
        private String twidEnName;             // TWID 英文名稱
        private String twidEnDef;              // TWID 英文定義
        
        // TWDS 資料
        private String chNameDef;              // 中文名稱定義
        private String enName;                 // 英文名稱
        private String format;                 // 格式
        private String codeList;               // 代碼清單
        private String sample;                 // 範例
        
        public DatabaseEnrichment() {
            this.classHierarchy = new ArrayList<>();
        }
        
        // Getters and Setters
        
        public String getSrc() {
            return src;
        }
        
        public void setSrc(String src) {
            this.src = src;
        }
        
        public String getXmlTagName() {
            return xmlTagName;
        }
        
        public void setXmlTagName(String xmlTagName) {
            this.xmlTagName = xmlTagName;
        }
        
        public String getObjectClass() {
            return objectClass;
        }
        
        public void setObjectClass(String objectClass) {
            this.objectClass = objectClass;
        }
        
        public String getPropertyTerm() {
            return propertyTerm;
        }
        
        public void setPropertyTerm(String propertyTerm) {
            this.propertyTerm = propertyTerm;
        }
        
        public String getRepTerm() {
            return repTerm;
        }
        
        public void setRepTerm(String repTerm) {
            this.repTerm = repTerm;
        }
        
        public String getNamedComplexType() {
            return namedComplexType;
        }
        
        public void setNamedComplexType(String namedComplexType) {
            this.namedComplexType = namedComplexType;
        }
        
        public List<ClassInfo> getClassHierarchy() {
            if (classHierarchy == null) {
                classHierarchy = new ArrayList<>();
            }
            return classHierarchy;
        }
        
        public void setClassHierarchy(List<ClassInfo> classHierarchy) {
            this.classHierarchy = classHierarchy;
        }
        
        public String getTwidEnName() {
            return twidEnName;
        }
        
        public void setTwidEnName(String twidEnName) {
            this.twidEnName = twidEnName;
        }
        
        public String getTwidEnDef() {
            return twidEnDef;
        }
        
        public void setTwidEnDef(String twidEnDef) {
            this.twidEnDef = twidEnDef;
        }
        
        public String getChNameDef() {
            return chNameDef;
        }
        
        public void setChNameDef(String chNameDef) {
            this.chNameDef = chNameDef;
        }
        
        public String getEnName() {
            return enName;
        }
        
        public void setEnName(String enName) {
            this.enName = enName;
        }
        
        public String getFormat() {
            return format;
        }
        
        public void setFormat(String format) {
            this.format = format;
        }
        
        public String getCodeList() {
            return codeList;
        }
        
        public void setCodeList(String codeList) {
            this.codeList = codeList;
        }
        
        public String getSample() {
            return sample;
        }
        
        public void setSample(String sample) {
            this.sample = sample;
        }
    }
    
    /**
     * 類別資訊（TWCLS）
     */
    public static class ClassInfo {
        private String objectClass;
        private String classId;
        private String className;
        private String chDef;
        private String enDef;
        private String chName;
        private String enName;
        private int level;
        
        public String getObjectClass() {
            return objectClass;
        }
        
        public void setObjectClass(String objectClass) {
            this.objectClass = objectClass;
        }
        
        public String getClassId() {
            return classId;
        }
        
        public void setClassId(String classId) {
            this.classId = classId;
        }
        
        public String getClassName() {
            return className;
        }
        
        public void setClassName(String className) {
            this.className = className;
        }
        
        public String getChDef() {
            return chDef;
        }
        
        public void setChDef(String chDef) {
            this.chDef = chDef;
        }
        
        public String getEnDef() {
            return enDef;
        }
        
        public void setEnDef(String enDef) {
            this.enDef = enDef;
        }
        
        public String getChName() {
            return chName;
        }
        
        public void setChName(String chName) {
            this.chName = chName;
        }
        
        public String getEnName() {
            return enName;
        }
        
        public void setEnName(String enName) {
            this.enName = enName;
        }
        
        public int getLevel() {
            return level;
        }
        
        public void setLevel(int level) {
            this.level = level;
        }
    }
}

    