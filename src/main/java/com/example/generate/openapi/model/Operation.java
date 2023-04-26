package com.example.generate.openapi.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Operation {
    List<String> tags;
    String summary;
    String operationId;
    List<String> produces;
    List<Parameter> parameters;
    List<Response> responses;
}
