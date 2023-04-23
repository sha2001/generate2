package com.example.generate.yaml;

import java.io.FileNotFoundException;

public interface YamlLoader<T> {
    T load(String filename) throws FileNotFoundException;
}
