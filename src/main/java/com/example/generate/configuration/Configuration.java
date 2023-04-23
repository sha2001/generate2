package com.example.generate.configuration;

import lombok.Data;

import java.util.List;

@Data
public class Configuration {

  private String name;
  private String packageName;
  private Repository repository;
  private Entity entity;
  private Service service;
  private Controller controller;
  private List<Method> methods;

}
