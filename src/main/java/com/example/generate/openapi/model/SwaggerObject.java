package com.example.generate.openapi.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SwaggerObject {

    String ref;
    String name;
    TypeOperationParameter typeOperationParameter;
    String description;
    TypeParameter type;
    boolean required;
    String defaultValue;
}
