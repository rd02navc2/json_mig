package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TWCLS")
@SuppressWarnings("unused") // 避免 getter/setter 未使用警告
public class Twcls {

    @Id
    @Column(name = "OBJECTCLASS", nullable = false, length = 80)
    private String objectClass = "";

    @Column(name = "CLASSID", length = 20)
    private String classId = "";

    @Column(name = "CLASSNAME", length = 40)
    private String className = "";

    @Column(name = "CHDEF", length = 800)
    private String chDef = "";

    @Column(name = "ENDEF", length = 800)
    private String enDef = "";

    @Column(name = "CHNAME", length = 80)
    private String chName = "";

    @Column(name = "ENNAME", length = 80)
    private String enName = "";

    // JPA 要求的無參構造器
    public Twcls() {}

    // Getter/Setter
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
