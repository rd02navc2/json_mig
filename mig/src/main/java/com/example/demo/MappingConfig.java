package com.example.demo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MappingConfig {

    private String name;              // class name
    private String cls;               // DSREF.cls
    private List<String> messages;    // AAA.msg names

    private Map<String, FieldConfig> fields = new LinkedHashMap<>();
    private Map<String, MappingConfig> children = new LinkedHashMap<>();

    /* ================= getters ================= */

    public String getName() {
        return name;
    }

    public String getCls() {
        return cls;
    }

    public List<String> getMessages() {
        return messages;
    }

    public Map<String, FieldConfig> getFields() {
        return fields;
    }

    public Map<String, MappingConfig> getChildren() {
        return children;
    }

    /* ================= setters ================= */

    public void setName(String name) {
        this.name = name;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void setFields(Map<String, FieldConfig> fields) {
        this.fields = fields;
    }

    public void setChildren(Map<String, MappingConfig> children) {
        this.children = children;
    }
    
    @Override
    public String toString() {
        return "MappingConfig{" +
                "name='" + name + '\'' +
                ", cls='" + cls + '\'' +
                ", messages=" + messages +
                ", fields=" + fields.keySet() +
                ", children=" + children.keySet() +
                '}';
    }

}
