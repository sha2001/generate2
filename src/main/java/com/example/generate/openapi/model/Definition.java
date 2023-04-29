package com.example.generate.openapi.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Definition {
    String description;
    String type;
    Map<String,Property> properties;
    boolean readOnly;
    List<String> required;
    List<String> _enum;

    public void setEnum(List<String> _enum) {
        this._enum = _enum;
    }
}
