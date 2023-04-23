package com.example.generate.template;

import java.util.Map;

public interface FileWriter {
  void writer(String template, String filename, Map<String, Object> data);
}
