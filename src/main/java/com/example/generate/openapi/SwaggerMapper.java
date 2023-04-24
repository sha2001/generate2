package com.example.generate.openapi;

import com.example.generate.configuration.Configuration;
import com.example.generate.configuration.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class SwaggerMapper {

    private final SwaggerObjectMapper swaggerObjectMapper;


    public List<Operation> mapOperations(final Map swagger, final Configuration configuration) {

        var paths = (Map<String, Map>) swagger.get("paths");
        var swaggerOperations = paths.values();

        List<Map> test   = new ArrayList<>();
        swaggerOperations.forEach(o -> test.addAll(o.values()));

        ArrayList<Operation> controllerOperations = new ArrayList<>();

        test.forEach(i->{
            List<String> s = (List<String>) i.get("tags");
            if (s.contains(configuration.getController().getSwaggerTag())) {


                controllerOperations.add(swaggerObjectMapper.mapOperation(i));
            }
        });
        return controllerOperations;
    }
}
