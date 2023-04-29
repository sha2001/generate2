package com.example.generate.openapi.model;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class Property {
    String description;
    Id id;
    Items items;
    Type type;
    Source source;
    String ref;
    String format;
    String minimum;
    String maximum;
    Map<String, Property> properties;
    String pattern;
    String _default;
    boolean readOnly;
    List<String> _enum;

    public void setEnum(List<String> _enum) {
        this._enum = _enum;
    }

    public void setDefault(String _default) {
        this._default = _default;
    }
}
