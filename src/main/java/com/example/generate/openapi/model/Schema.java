package com.example.generate.openapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Schema {
    String ref;
    String type;
    Items items;
}
