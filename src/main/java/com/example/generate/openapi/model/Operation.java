package com.example.generate.openapi.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Operation {
    String description;
    boolean deprecated;
    List<String> tags;
    String summary;
    String operationId;
    List<String> produces;
    List<String> consumes;
    List<Parameter> parameters;
    Map<String,Response> responses;
    Headers headers;
}
