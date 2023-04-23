package com.example.generate.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Controller {
    String name;
    String swaggerTag;
    String packageJson;
    List<Operation> operations;
}
