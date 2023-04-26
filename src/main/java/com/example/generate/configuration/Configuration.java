package com.example.generate.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Configuration {

    String name;
    String packageName;
    Repository repository;
    Entity entity;
    Service service;
    Controller controller;
    List<Method> methods;
    Map<String,ObjectDefinition> objects;

}
