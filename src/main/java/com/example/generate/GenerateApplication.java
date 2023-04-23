package com.example.generate;

import com.example.generate.configuration.Configuration;
import com.example.generate.configuration.Operation;
import com.example.generate.generator.SourceGenerator;
import com.example.generate.yaml.JacksonLoader;
import com.example.generate.yaml.SnakeLoader;
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
    private final JacksonLoader jacksonLoader;

    @Override
    public void run(String... args) throws FileNotFoundException {

        String configurationFile= "./"+ args[0];
        String swaggerOperationsFiles = "./" + args[1];

        SnakeLoader<Configuration> snakeLoader = new SnakeLoader<>(Configuration::new);
        SnakeLoader<Object> swaggerOperationLoader = new SnakeLoader<>(LinkedHashMap::new);

        Configuration configuration = snakeLoader.load(configurationFile);

        log.info("{}",configuration);

        Map<String, Map> swagger = (Map<String, Map>) swaggerOperationLoader.load(swaggerOperationsFiles);
        Map<String, Map> paths = (Map<String, Map>) swagger.get("paths");
        Collection<Map> operations = paths.values();

        List<Map> test   = new ArrayList<>();
        operations.forEach(o -> test.addAll(o.values()));


        configuration.getController().setOperations(new ArrayList<>());
        test.forEach(i->{
            List<String> s = (List<String>) i.get("tags");


            if (s.contains(configuration.getController().getSwaggerTag())) {


                Operation operation = new Operation();
                String operationId = (String) i.get("operationId");
                operation.setOperationId(operationId);
                log.info("{}",i.get("parameters"));
                log.info("{}", operationId);
                configuration.getController().getOperations().add(operation);
            }
        });

        sourceGenerator.generate(configuration);

    }


}
