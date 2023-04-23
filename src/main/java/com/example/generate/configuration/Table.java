package com.example.generate.configuration;

import lombok.Data;

import java.util.List;

@Data
public class Table {
    private String name;
    private List<TableField> tableFields;

}
