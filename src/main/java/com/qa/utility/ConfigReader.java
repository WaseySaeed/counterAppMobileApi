package com.qa.utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;

    public ConfigReader()
    {
        properties = new Properties();
        String fileName = "src/main/resources/application.properties";

        try{
            InputStream input = new FileInputStream(fileName);
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
