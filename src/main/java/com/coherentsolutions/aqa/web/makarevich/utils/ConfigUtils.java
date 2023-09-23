package com.coherentsolutions.aqa.web.makarevich.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ConfigUtils {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("The config file is not found", e);
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}