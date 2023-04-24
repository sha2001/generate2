package com.example.generate.openapi;

import com.example.generate.configuration.Operation;
import com.example.generate.configuration.Parameter;
import com.example.generate.openapi.model.SwaggerObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class SwaggerObjectMapper {

    public static final String REF = "$ref";

    public List<SwaggerObject> mapObjects(Map swagger) {
        return null;
    }

    public Operation mapOperation(Map<String, Object> map) {


        Operation operation = new Operation();
        operation.setOperationId((String) map.get("operationId"));
        List<Map<String,String>> parameters = (List<Map<String, String>>) map.get("parameters");

        operation.setParameters(new ArrayList<>());
        parameters.forEach(p->{

            Parameter parameter = new Parameter();
            if (p.containsKey(REF)) {
                parameter.setName(p.get("get from definition"));
            } else {
                parameter.setName( p.get("name"));
                parameter.setType("string");
            }
            log.info("parameter : {} {}",p, parameter);
            operation.getParameters().add(parameter);
        });
        return operation;
    }
}
