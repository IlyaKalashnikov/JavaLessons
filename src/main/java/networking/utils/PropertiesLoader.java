package networking.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private final Properties properties = new Properties();

    public PropertiesLoader() {
        try {
            InputStream resourceAsStream =
                    PropertiesLoader.class.getClassLoader().getResourceAsStream("application.yaml");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
