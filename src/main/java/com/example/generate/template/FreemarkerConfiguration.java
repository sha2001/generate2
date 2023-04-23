package com.example.generate.template;

import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FreemarkerConfiguration {

  @Bean
  public freemarker.template.Configuration getFreemarkerConfiguration() throws IOException {
    freemarker.template.Configuration cfg =
        new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_32);
    cfg.setClassLoaderForTemplateLoading(Thread.currentThread().getContextClassLoader(), "/templates");
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
    return cfg;
  }

}
