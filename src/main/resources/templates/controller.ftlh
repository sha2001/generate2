package ${configuration.packageName};

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor

public class ${configuration.name}Controller implements ${configuration.name}Api {



<#list configuration.controller.operations as operation>
    @Override
    public ${operation.operationId}(
    <#list operation.parameters as parameter>
        <#if parameter.type??>${parameter.type}</#if> <#if parameter.type??>${parameter.name}</#if>
    </#list>
    ) {
    }
</#list>

}