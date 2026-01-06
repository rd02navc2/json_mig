package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TWIDS")
@SuppressWarnings("unused") // 避免 getter/setter 未使用警告
public class Twids {

    @Id
    @Column(name = "TWID", nullable = false, length = 40)
    private String twid = "";

    @Column(name = "SRC", length = 8)
    private String src = "";

    @Column(name = "ENNAME", length = 120)
    private String enName = "";

    @Column(name = "ENDEF", length = 400)
    private String enDef = "";

    // JPA 要求的無參構造器
    public Twids() {}

    // Getter/Setter
    public String getTwid() { return twid; }
    public void setTwid(String twid) { this.twid = twid; }

    public String getSrc() { return src; }
    public void setSrc(String src) { this.src = src; }

    public String getEnName() { return enName; }
    public void setEnName(String enName) { this.enName = enName; }

    public String getEnDef() { return enDef; }
    public void setEnDef(String enDef) { this.enDef = enDef; }
}
