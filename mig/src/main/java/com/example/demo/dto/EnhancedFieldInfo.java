package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 增強版欄位資訊 DTO,整合資料庫資料
 */
public class EnhancedFieldInfo {
    
    // ===== 基本資訊 =====
    private String fieldName;              // 目標屬性欄位變數 (對應 Twdens.xmlTagName)
    private List<String> classPath;        // 類別階層路徑 (對應 Twdens.objectClass)
    private int startLine;
    private int endLine;
    private int fieldLineNumber;
    private String originalCode;
    
    // ===== DSREF 資訊 =====
    private DsrefInfo dsref;
    
    // ===== AAA 資訊 =====
    private AaaInfo aaa;
    
    // ===== 資料庫擴充資訊 =====
    private DatabaseEnrichment dbEnrichment;
    
    // Constructors
    public EnhancedFieldInfo() {
        this.classPath = new ArrayList<>();
        this.dsref = new DsrefInfo();
        this.aaa = new AaaInfo();
        this.dbEnrichment = new DatabaseEnrichment();
    }
    
    // Getters and Setters
    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }
    
    public List<String> getClassPath() { return classPath; }
    public void setClassPath(List<String> classPath) { this.classPath = classPath; }
    
    public int getStartLine() { return startLine; }
    public void setStartLine(int startLine) { this.startLine = startLine; }
    
    public int getEndLine() { return endLine; }
    public void setEndLine(int endLine) { this.endLine = endLine; }
    
    public int getFieldLineNumber() { return fieldLineNumber; }
    public void setFieldLineNumber(int fieldLineNumber) { this.fieldLineNumber = fieldLineNumber; }
    
    public String getOriginalCode() { return originalCode; }
    public void setOriginalCode(String originalCode) { this.originalCode = originalCode; }
    
    public DsrefInfo getDsref() { return dsref; }
    public void setDsref(DsrefInfo dsref) { this.dsref = dsref; }
    
    public AaaInfo getAaa() { return aaa; }
    public void setAaa(AaaInfo aaa) { this.aaa = aaa; }
    
    public DatabaseEnrichment getDbEnrichment() { return dbEnrichment; }
    public void setDbEnrichment(DatabaseEnrichment dbEnrichment) { this.dbEnrichment = dbEnrichment; }
    
    // ===== 內部類別 =====
    
    public static class DsrefInfo {
        private String den;     // 對應 Twdens.den
        private String uid;     // 對應 Twids.twid
        private String cls;     // 對應 Twcls.className
        
        public DsrefInfo() {}
        
        public String getDen() { return den; }
        public void setDen(String den) { this.den = den; }
        
        public String getUid() { return uid; }
        public void setUid(String uid) { this.uid = uid; }
        
        public String getCls() { return cls; }
        public void setCls(String cls) { this.cls = cls; }
    }
    
    public static class AaaInfo {
        private List<MsgInfo> msg;
        
        public AaaInfo() {
            this.msg = new ArrayList<>();
        }
        
        public List<MsgInfo> getMsg() { return msg; }
        public void setMsg(List<MsgInfo> msg) { this.msg = msg; }
    }
    
    public static class MsgInfo {
        private String name;
        private String car;
        private String boro;
        private String chn;    // 對應 Twds.chName
        
        public MsgInfo() {}
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getCar() { return car; }
        public void setCar(String car) { this.car = car; }
        
        public String getBoro() { return boro; }
        public void setBoro(String boro) { this.boro = boro; }
        
        public String getChn() { return chn; }
        public void setChn(String chn) { this.chn = chn; }
    }
    
    /**
     * 資料庫擴充資訊
     */
    public static class DatabaseEnrichment {
        // Twdens 相關
        private String xmlTagName;
        private String objectClass;
        private String propertyTerm;
        private String repTerm;
        private String namedComplexType;
        
        // Twds 相關
        private String chNameDef;
        private String enName;
        private String format;
        private String codeList;
        private String sample;
        
        // Twcls 相關
        private List<ClassInfo> classHierarchy;
        
        // Twids 相關
        private String twidEnName;
        private String twidEnDef;
        
        public DatabaseEnrichment() {
            this.classHierarchy = new ArrayList<>();
        }
        
        // Getters and Setters
        public String getXmlTagName() { return xmlTagName; }
        public void setXmlTagName(String xmlTagName) { this.xmlTagName = xmlTagName; }
        
        public String getObjectClass() { return objectClass; }
        public void setObjectClass(String objectClass) { this.objectClass = objectClass; }
        
        public String getPropertyTerm() { return propertyTerm; }
        public void setPropertyTerm(String propertyTerm) { this.propertyTerm = propertyTerm; }
        
        public String getRepTerm() { return repTerm; }
        public void setRepTerm(String repTerm) { this.repTerm = repTerm; }
        
        public String getNamedComplexType() { return namedComplexType; }
        public void setNamedComplexType(String namedComplexType) { this.namedComplexType = namedComplexType; }
        
        public String getChNameDef() { return chNameDef; }
        public void setChNameDef(String chNameDef) { this.chNameDef = chNameDef; }
        
        public String getEnName() { return enName; }
        public void setEnName(String enName) { this.enName = enName; }
        
        public String getFormat() { return format; }
        public void setFormat(String format) { this.format = format; }
        
        public String getCodeList() { return codeList; }
        public void setCodeList(String codeList) { this.codeList = codeList; }
        
        public String getSample() { return sample; }
        public void setSample(String sample) { this.sample = sample; }
        
        public List<ClassInfo> getClassHierarchy() { return classHierarchy; }
        public void setClassHierarchy(List<ClassInfo> classHierarchy) { this.classHierarchy = classHierarchy; }
        
        public String getTwidEnName() { return twidEnName; }
        public void setTwidEnName(String twidEnName) { this.twidEnName = twidEnName; }
        
        public String getTwidEnDef() { return twidEnDef; }
        public void setTwidEnDef(String twidEnDef) { this.twidEnDef = twidEnDef; }
    }
    
    /**
     * 類別階層資訊
     */
    public static class ClassInfo {
        private String objectClass;
        private String classId;
        private String className;
        private String chDef;
        private String enDef;
        private String chName;
        private String enName;
        
        public ClassInfo() {}
        
        // Getters and Setters
        public String getObjectClass() { return objectClass; }
        public void setObjectClass(String objectClass) { this.objectClass = objectClass; }
        
        public String getClassId() { return classId; }
        public void setClassId(String classId) { this.classId = classId; }
        
        public String getClassName() { return className; }
        public void setClassName(String className) { this.className = className; }
        
        public String getChDef() { return chDef; }
        public void setChDef(String chDef) { this.chDef = chDef; }
        
        public String getEnDef() { return enDef; }
        public void setEnDef(String enDef) { this.enDef = enDef; }
        
        public String getChName() { return chName; }
        public void setChName(String chName) { this.chName = chName; }
        
        public String getEnName() { return enName; }
        public void setEnName(String enName) { this.enName = enName; }
    }
}