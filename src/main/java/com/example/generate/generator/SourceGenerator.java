package com.example.generate.generator;

import com.example.generate.configuration.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SourceGenerator {

  private final List<Generator> generators;

  public void generate(Configuration configuration) {
    generators.forEach(g->g.generate(configuration));
  }

}
