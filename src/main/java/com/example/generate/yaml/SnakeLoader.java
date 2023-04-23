package com.example.generate.yaml;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class SnakeLoader<T> implements YamlLoader<T> {


    @Override
    public T load(String filename) throws FileNotFoundException {

        log.info("Load file {}", filename);
        InputStream stream = new FileInputStream(filename);
        LoaderOptions loadingConfig = new LoaderOptions();

        Yaml yaml = new Yaml(new Constructor(createContents().getClass(), loadingConfig));
        T object = yaml.load(stream);
        log.info("SNAKE : {}", object.getClass());
        return object;
    }



    private Supplier<T> supplier;

    public SnakeLoader(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    T createContents() {
        return supplier.get();
    }
}
