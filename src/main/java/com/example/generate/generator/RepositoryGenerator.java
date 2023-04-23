package com.example.generate.generator;

import com.example.generate.GenerateConfiguration;
import com.example.generate.template.FileWriter;
import com.example.generate.configuration.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component

public class RepositoryGenerator extends AbstractGenerator {


  public RepositoryGenerator(FileWriter fileWriter, GenerateConfiguration generateConfiguration) {
    super(fileWriter, generateConfiguration);
  }

  @Override
  public GeneratorTemplate getGeneratorTemplate() {
    return GeneratorTemplate.REPOSITORY;
  }

  @Override
  public Map<String, Object> getData(Configuration configuration) {
    Map<String, Object> root = new HashMap<>();
    root.put("name", configuration.getEntity().getName());
    root.put("package", configuration.getPackageName());
    return root;
  }
}
