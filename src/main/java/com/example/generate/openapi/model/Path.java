package com.example.generate.openapi.model;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class Path {
   Operation get;
   Operation post;
   Operation put;
   Operation delete;


}
