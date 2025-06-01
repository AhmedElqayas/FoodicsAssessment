package api.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    public static String readProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private static void loadProperties() {
        try (InputStream stream = PropertiesUtils.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(stream);
        } catch (Exception e) {
            System.out.println("There is a problem in reading the properties.");
        }
    }
}
