package com.example.generate.openapi.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Information {
    String version;
    String title;
    String description;
    Contact contact;
}
