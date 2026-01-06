package com.example.demo;

import java.util.List;

class FieldConfig {
    private String name;
    private String type;
    private List<MappingRule> Mappings;
    
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public List<MappingRule> getMappings() {
        return Mappings;
    }
    
    public void setMappings(List<MappingRule> Mappings) {
        this.Mappings = Mappings;
    }
}