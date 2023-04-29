package com.example.generate;

import com.example.generate.configuration.Configuration;
import com.example.generate.configuration.Operation;
import com.example.generate.generator.SourceGenerator;
import com.example.generate.openapi.SwaggerMapper;
import com.example.generate.openapi.model.Swagger;
import com.example.generate.yaml.JacksonLoader;
import com.example.generate.yaml.SnakeLoader;
import com.example.generate.yaml.YamlLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.util.*;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class GenerateApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
    }

    private final SourceGenerator sourceGenerator;
    private final SwaggerMapper swaggerMapper;
    private final GenerateConfiguration generateConfiguration;
    // private final JacksonLoader jacksonLoader;

    @Override
    public void run(String... args) throws FileNotFoundException {

        String configurationFile = generateConfiguration.getInDirectory() + args[0];
        String swaggerOperationsFiles = generateConfiguration.getInDirectory() + args[1];
        String swaggerObjectsFiles = generateConfiguration.getInDirectory() + args[2];

        YamlLoader<Configuration> snakeLoader = new SnakeLoader<>(Configuration::new);
        YamlLoader<Swagger> swaggerLoader = new SnakeLoader<>(Swagger::new);
        Swagger swaggerOperations =  swaggerLoader.load(swaggerOperationsFiles);
        Swagger swaggerObjects = swaggerLoader.load(swaggerObjectsFiles);

        Configuration configuration = snakeLoader.load(configurationFile);
        swaggerMapper.mapObjects(swaggerObjects, configuration);

        configuration.getController().setOperations(swaggerMapper.mapOperations(swaggerOperations, configuration));

 //       log.info("{}", swaggerOperations);

        sourceGenerator.generate(configuration);

    }


}
