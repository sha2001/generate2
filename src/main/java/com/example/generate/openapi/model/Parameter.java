package com.example.generate.openapi.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
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
    Schema schema;
    String minLength;
    String maxLenght;
    List<String> _enum;
    Map<String, Parameter> properties;
    List<Parameter> items;

    public void setDefault(String value) {
        _default = value;
    }
    public void setEnum(List<String> values) {_enum=values;}
}
