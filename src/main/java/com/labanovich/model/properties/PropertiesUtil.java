package com.labanovich.model.properties;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private PropertiesUtil() {
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
