package com.example.generate.openapi.model;

import lombok.Data;

@Data
public class Response {
    String description;
    Schema schema;
    Headers headers;
}
