package com.example.generate.generator;

import lombok.Getter;

@Getter
public enum GeneratorTemplate {
  MAPPER("mapper.ftlh", "Mappper.java"),
  ENTITY("entity.ftlh", ".java"),
  CONTROLLER("controller.ftlh", "Controller.java"),
  REPOSITORY("repository.ftlh", "Repository.java"),
  CREATE_TABLE("create_table.ftlh","_create_table.sql");


  private final String template;
  private final String suffix;

  GeneratorTemplate(String template, String suffix) {
    this.template = template;
    this.suffix = suffix;
  }
}
