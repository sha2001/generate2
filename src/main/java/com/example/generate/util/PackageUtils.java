package com.example.generate.util;

public class PackageUtils {

    static public String packageToPath(String packageName){
        return packageName.replaceAll("\\.","/");
    }
}
