package com.example.generate.generator;

import com.example.generate.GenerateConfiguration;
import com.example.generate.configuration.Configuration;
import com.example.generate.template.FileWriter;

import java.util.Map;

public interface Generator {
  GeneratorTemplate getGeneratorTemplate();

  Map<String, Object> getData(Configuration configuration);


  default void generate(Configuration configuration) {
    String filename = getGenerateConfiguration().getOutDirectory() + "/" + configuration.getName() + getGeneratorTemplate().getSuffix();
    getFileWriter().writer(getGeneratorTemplate().getTemplate(), filename, getData(configuration));
  }

  FileWriter getFileWriter();

  GenerateConfiguration getGenerateConfiguration();
}
