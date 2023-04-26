package com.example.generate;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class GenerateConfiguration {

  @Value("${out.directory}")
  private String outDirectory;

  @Value("${in.directory}")
  private String inDirectory;
}
