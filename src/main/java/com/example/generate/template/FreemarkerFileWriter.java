package com.example.generate.template;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

@AllArgsConstructor
@Component
public class FreemarkerFileWriter implements FileWriter {

  private FreemarkerConfiguration freemarkerConfiguration;

  @Override
  public void writer(String templateName, String filename, Map<String, Object> data) {
    try {
      Template template = freemarkerConfiguration.getFreemarkerConfiguration().getTemplate(templateName);
      FileOutputStream fileOutputStream =
          new FileOutputStream(filename);
      Writer out = new OutputStreamWriter(fileOutputStream);
      template.process(data, out);
      fileOutputStream.close();
    } catch (IOException | TemplateException e) {
      throw new RuntimeException(e);
    }
  }
}
