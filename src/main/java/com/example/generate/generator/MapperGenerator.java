package com.example.generate.generator;

import com.example.generate.GenerateConfiguration;
import com.example.generate.template.FileWriter;
import com.example.generate.configuration.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapperGenerator extends AbstractGenerator {


  public MapperGenerator(FileWriter fileWriter, GenerateConfiguration generateConfiguration) {
    super(fileWriter, generateConfiguration);
  }

  @Override
  public GeneratorTemplate getGeneratorTemplate() {
    return GeneratorTemplate.MAPPER;
  }

  @Override
  public Map<String, Object> getData(Configuration configuration) {
    Map<String, Object> root = new HashMap<>();
    root.put("name", configuration.getName());
    root.put("package", configuration.getPackageName());
    return root;
  }
}
