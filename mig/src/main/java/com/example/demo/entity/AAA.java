package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "aaa")
public class AAA {
    
    @Id
    @Column(name = "cls", length = 255)
    private String cls;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @Column(name = "car")
    private Integer car;
    
    @Column(name = "boro")
    private Integer boro;
    
    @Column(name = "chn", length = 255)
    private String chn;
    
    public AAA() {
    }
    
    public AAA(String cls, String name, Integer car, Integer boro, String chn) {
        this.cls = cls;
        this.name = name;
        this.car = car;
        this.boro = boro;
        this.chn = chn;
    }
    
    // Getters and Setters
    public String getCls() {
        return cls;
    }
    
    public void setCls(String cls) {
        this.cls = cls;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getCar() {
        return car;
    }
    
    public void setCar(Integer car) {
        this.car = car;
    }
    
    public Integer getBoro() {
        return boro;
    }
    
    public void setBoro(Integer boro) {
        this.boro = boro;
    }
    
    public String getChn() {
        return chn;
    }
    
    public void setChn(String chn) {
        this.chn = chn;
    }
    
    @Override
    public String toString() {
        return "AAA{" +
                "cls='" + cls + '\'' +
                ", name='" + name + '\'' +
                ", car=" + car +
                ", boro=" + boro +
                ", chn='" + chn + '\'' +
                '}';
    }
}