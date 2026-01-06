package com.example.demo;

public class MappingRule {

    private String name;
    private String car;
    private String boro;
    private String chn;
	private String rule; 

    public MappingRule() {}
    
    public MappingRule(String rule) {
        this.rule = rule;
    }

    public MappingRule(String name, String car, String boro, String chn) {
        this.name = name;
        this.car = car;
        this.boro = boro;
        this.chn = chn;
    }

    // getters
    public String getName() { return name; }
    public String getCar() { return car; }
    public String getBoro() { return boro; }
    public String getChn() { return chn; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setCar(String car) { this.car = car; }
    public void setBoro(String boro) { this.boro = boro; }
    public void setChn(String chn) { this.chn = chn; }

    @Override
    public String toString() {
        return "MappingRule{" +
                "name='" + name + '\'' +
                ", car='" + car + '\'' +
                ", boro='" + boro + '\'' +
                ", chn='" + chn + '\'' +
                '}';
    }
}
