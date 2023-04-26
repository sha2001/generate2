package com.example.generate.openapi.model;

import lombok.Data;

@Data
public class Parameter {
    String ref;
    String name;
    String in;
    String description;
    String type;
    boolean required;
    String format;
    String _default;
    String minimum;
    String maximum;

    public void setDefault(String value) {
        _default = value;
    }
}
