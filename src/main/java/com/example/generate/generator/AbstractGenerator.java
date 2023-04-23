package com.example.generate.generator;

import com.example.generate.GenerateConfiguration;
import com.example.generate.template.FileWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class AbstractGenerator implements Generator {

    private final FileWriter fileWriter;
    private final GenerateConfiguration generateConfiguration;


}
