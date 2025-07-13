package org.example;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    public static void load() {
        String env = System.getProperty("env", "dev");
        String path = "src/main/resources/application-" + env + ".properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config for env: " + env, e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
