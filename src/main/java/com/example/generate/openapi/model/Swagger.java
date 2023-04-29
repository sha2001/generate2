package com.example.generate.openapi.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Swagger {
    String swagger;
    Information info;
    List<Tag> tags;
    Map<String, Path> paths;
    Map<String, Definition> definitions;
    Map<String, Parameter> parameters;
}
