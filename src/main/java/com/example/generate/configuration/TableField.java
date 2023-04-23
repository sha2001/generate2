package com.example.generate.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TableField extends Property {
    @JsonProperty(defaultValue = "false")
    private boolean id;
    private String column;
}
