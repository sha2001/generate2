package com.example.generate.configuration;

import lombok.Data;

import java.util.List;

@Data
public class Service {
    private String name;
    private List<Method> methods;
}
