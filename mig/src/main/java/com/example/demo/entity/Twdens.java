package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TWDENS")
@SuppressWarnings("unused") // 避免 getter/setter 未使用警告
public class Twdens {

    @Id
    @Column(name = "DEN", nullable = false, length = 200)
    private String den = "";

    @Column(name = "SRC", length = 8)
    private String src = "";

    @Column(name = "OBJECTCLASS", length = 80)
    private String objectClass = "";

    @Column(name = "PROPERTYTERM", length = 80)
    private String propertyTerm = "";

    @Column(name = "REPTERM", length = 80)
    private String repTerm = "";

    @Column(name = "NAMEDCOMPLEXTYPE", length = 100)
    private String namedComplexType = "";

    @Column(name = "XMLTAGNAME", length = 80)
    private String xmlTagName = "";

    // JPA 要求的無參構造器
    public Twdens() {}

    // Getter/Setter
    public String getDen() { return den; }
    public void setDen(String den) { this.den = den; }

    public String getSrc() { return src; }
    public void setSrc(String src) { this.src = src; }

    public String getObjectClass() { return objectClass; }
    public void setObjectClass(String objectClass) { this.objectClass = objectClass; }

    public String getPropertyTerm() { return propertyTerm; }
    public void setPropertyTerm(String propertyTerm) { this.propertyTerm = propertyTerm; }

    public String getRepTerm() { return repTerm; }
    public void setRepTerm(String repTerm) { this.repTerm = repTerm; }

    public String getNamedComplexType() { return namedComplexType; }
    public void setNamedComplexType(String namedComplexType) { this.namedComplexType = namedComplexType; }

    public String getXmlTagName() { return xmlTagName; }
    public void setXmlTagName(String xmlTagName) { this.xmlTagName = xmlTagName; }
}
