package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static constants.TestConstants.CONFIG_PROPERTIES;

@Slf4j
public class ConfigUtils {
    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(CONFIG_PROPERTIES)) {
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