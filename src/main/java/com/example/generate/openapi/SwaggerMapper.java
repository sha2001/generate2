package com.example.generate.openapi;

import com.example.generate.configuration.Configuration;
import com.example.generate.configuration.ObjectDefinition;
import com.example.generate.configuration.Operation;
import com.example.generate.configuration.Parameter;
import com.example.generate.openapi.model.Definition;
import com.example.generate.openapi.model.Path;
import com.example.generate.openapi.model.Swagger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class SwaggerMapper {

    private final SwaggerObjectMapper swaggerObjectMapper;


    public List<Operation> mapOperations(final Swagger swagger, final Configuration configuration) {

        var paths = (Map<String, Path>) swagger.getPaths();
        Collection<Path> swaggerOperations = paths.values();

        List<Operation> controllerOperations = new ArrayList<>();
        swaggerOperations.forEach(path ->
            path.getOperations().forEach(op->map(op, configuration).ifPresent(controllerOperations::add)));


        return controllerOperations;
    }

    private Optional<Operation> map(com.example.generate.openapi.model.Operation put, Configuration configuration) {

        if (put == null) {
            return Optional.empty();
        }
        if (put.getTags().contains(configuration.getController().getSwaggerTag())) {
            Operation operation = new Operation();

            operation.setOperationId(put.getOperationId());
            operation.setParameters(put.getParameters().stream().map(this::mapParameter).collect(Collectors.toList()));
            return Optional.of(operation);

        } else {
            return Optional.empty();
        }

    }

    private Parameter mapParameter(com.example.generate.openapi.model.Parameter parameter) {
        Parameter param = new Parameter();

        param.setType(parameter.getType());
        param.setName(parameter.getName());
        param.setRequired(param.isRequired());
        return param;
    }

    public void mapObjects(Swagger swaggerObjects, Configuration configuration) {

/*
        configuration.setObjects(swaggerObjects.getDefinitions().entrySet().stream()
                .map(entry -> mapObject(entry.getKey(), entry.getValue()))
                .collect(Collectors.toMap(ObjectDefinition::getName, Function.identity()))
        );
        */


    }

    private ObjectDefinition mapObject(String key, Definition value) {
        return null;
    }

    private ObjectDefinition mapObject(String name, Map<String, Object> d) {
        ObjectDefinition definition = new ObjectDefinition();

        definition.setName(name);
        String type = (String) d.get("type");

        if (type != null) {
            switch (type) {
                case "object" -> {
                    definition.setProperties(new HashSet<>());
                    Map properties = (Map) d.get("properties");
                    properties.forEach((key, value) ->
                            {
                                definition.getProperties().add(mapObject((String) key, (Map<String, Object>) value));
                            }
                    );
                }
                case "array" -> {
                    Map itemps = (Map) d.get("items");
                    definition.setType(getType(itemps));
                    definition.setCollection(true);
                }
                case "string" -> definition.setType("String");
                case "boolean" -> definition.setType("boolean");
                case "integer" -> definition.setType("int");
                default -> log.info("default : {}", type);
            }
        }
        definition.setComment((String) d.get("description"));

        log.info("Definition : {}", definition);

        return definition;
    }

    private String getType(Map items) {

        String ref = (String) items.get("$ref");
        String[] array = ref.split("/");
        return array[array.length - 1];
    }
}
