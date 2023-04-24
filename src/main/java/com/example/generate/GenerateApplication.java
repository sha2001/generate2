package com.example.generate;

import com.example.generate.configuration.Configuration;
import com.example.generate.configuration.Operation;
import com.example.generate.generator.SourceGenerator;
import com.example.generate.openapi.SwaggerMapper;
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
   // private final JacksonLoader jacksonLoader;

    @Override
    public void run(String... args) throws FileNotFoundException {

        String configurationFile= "./"+ args[0];
        String swaggerOperationsFiles = "./" + args[1];
        String swaggerOjectsFiles = "./"+args[2];

        YamlLoader<Configuration> snakeLoader = new SnakeLoader<>(Configuration::new);
        YamlLoader<Object> swaggerOperationLoader = new SnakeLoader<>(LinkedHashMap::new);
        Map<String, Map> swaggerOperations = (Map<String, Map>) swaggerOperationLoader.load(swaggerOperationsFiles);
        Map<String, Map> swaggerObjects = (Map<String, Map>) swaggerOperationLoader.load(swaggerOjectsFiles);


        Configuration configuration = snakeLoader.load(configurationFile);


        configuration.getController().setOperations(swaggerMapper.mapOperations(swaggerOperations, configuration));

        log.info("{}",configuration);

        sourceGenerator.generate(configuration);

    }


}
