package com.example.generate.generator;

import com.example.generate.GenerateConfiguration;
import com.example.generate.configuration.Configuration;
import com.example.generate.template.FileWriter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EntityGenerator extends AbstractGenerator {


  public EntityGenerator(FileWriter fileWriter, GenerateConfiguration generateConfiguration) {
    super(fileWriter, generateConfiguration);
  }

  @Override
  public GeneratorTemplate getGeneratorTemplate() {
    return GeneratorTemplate.ENTITY;
  }

  @Override
  public Map<String, Object> getData(Configuration configuration) {

    Map<String, Object> root = new HashMap<>();
    root.put("configuration", configuration);
    return root;
  }
}
