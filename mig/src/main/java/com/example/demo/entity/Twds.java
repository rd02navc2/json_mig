package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TWDS")
@SuppressWarnings("unused") // 避免 getter/setter 未使用警告
public class Twds {

    @Id
    @Column(name = "CHNAME", nullable = false, length = 80)
    private String chName = "";

    @Column(name = "SN", length = 40)
    private String sn = "";

    @Column(name = "ENNAME", length = 80)
    private String enName = "";

    @Column(name = "CHDEF", length = 400)
    private String chDef = "";

    @Column(name = "ENDEF", length = 400)
    private String enDef = "";

    @Column(name = "FORMAT", length = 40)
    private String format = "";

    @Column(name = "CODELIST", length = 400)
    private String codeList = "";

    @Column(name = "SAMPLE", length = 400)
    private String sample = "";

    // JPA 要求的無參構造器
    public Twds() {}

    // Getter/Setter
    public String getChName() { return chName; }
    public void setChName(String chName) { this.chName = chName; }

    public String getSn() { return sn; }
    public void setSn(String sn) { this.sn = sn; }

    public String getEnName() { return enName; }
    public void setEnName(String enName) { this.enName = enName; }

    public String getChDef() { return chDef; }
    public void setChDef(String chDef) { this.chDef = chDef; }

    public String getEnDef() { return enDef; }
    public void setEnDef(String enDef) { this.enDef = enDef; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public String getCodeList() { return codeList; }
    public void setCodeList(String codeList) { this.codeList = codeList; }

    public String getSample() { return sample; }
    public void setSample(String sample) { this.sample = sample; }
}
