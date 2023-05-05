package com.example.generate.generator;

import com.example.generate.GenerateConfiguration;
import com.example.generate.configuration.Configuration;
import com.example.generate.template.FileWriter;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ServiceGenerator extends AbstractGenerator{
    public ServiceGenerator(FileWriter fileWriter, GenerateConfiguration generateConfiguration) {
        super(fileWriter, generateConfiguration);
    }

    @Override
    public GeneratorTemplate getGeneratorTemplate() {
        return GeneratorTemplate.SERVICE;
    }

    @Override
    public Map<String, Object> getData(Configuration configuration) {
        return null;
    }
}
