package com.example.generate.openapi.model;

public enum TypeParameter {
    STRING("string", "String");


    private final String swaggerType;
    private final String javaType;


    TypeParameter(String swaggerType, String javaType) {
        this.swaggerType = swaggerType;
        this.javaType = javaType;
    }
}
