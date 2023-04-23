package com.example.generate.yaml;

import com.example.generate.configuration.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JacksonLoader implements YamlLoader<Configuration> {
    @Override
    public Configuration load(String filename) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());

        // Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());

// Mapping the employee from the YAML file to the Employee class
        Configuration configuration = null;
        try {
            configuration = om.readValue(file, Configuration.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configuration;
    }
}
