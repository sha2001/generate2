package com.example.generate.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Method {
    String id;
    String returnType;
    List<Rule> rules;
    List<Parameter> parameters;
}
