package com.example.generate.openapi;

import com.example.generate.configuration.Configuration;
import com.example.generate.configuration.ObjectDefinition;
import com.example.generate.configuration.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class SwaggerMapper {

    private final SwaggerObjectMapper swaggerObjectMapper;


    public List<Operation> mapOperations(final Map swagger, final Configuration configuration) {

        var paths = (Map<String, Map>) swagger.get("paths");
        var swaggerOperations = paths.values();

        List<Map> test = new ArrayList<>();
        swaggerOperations.forEach(o -> test.addAll(o.values()));

        ArrayList<Operation> controllerOperations = new ArrayList<>();

        test.forEach(i -> {
            List<String> s = (List<String>) i.get("tags");
            if (s.contains(configuration.getController().getSwaggerTag())) {
                controllerOperations.add(swaggerObjectMapper.mapOperation(i));
            }
        });
        return controllerOperations;
    }

    public void mapObjects(Map<String, Map<String, Map>> swaggerObjects, Configuration configuration) {


       configuration.setObjects(  swaggerObjects.get("definitions").entrySet().stream()
                .map(entry -> mapObject(entry.getKey(), entry.getValue()))
                 .collect(Collectors.toMap(ObjectDefinition::getName, Function.identity()))
       );



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
                case "integer"-> definition.setType("int");
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
