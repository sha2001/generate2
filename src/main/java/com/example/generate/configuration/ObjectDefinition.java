package com.example.generate.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObjectDefinition {

    String type;
    String name;
    String comment;
    boolean collection;
    Set<ObjectDefinition> properties;
}
