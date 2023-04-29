package com.example.generate.openapi.model;

import lombok.Data;

@Data
public class Type {
    String description;
    String ref;
    String type;

    public Type(String type) {
        this.type = type;
    }
}
