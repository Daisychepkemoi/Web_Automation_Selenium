package dataAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {
    private Properties properties;
    private static ConfigData configFileReader;

    private ConfigData() {
        BufferedReader reader;
        String propertyFilePath = "Config//config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigData getInstance() {
        if (configFileReader == null) {
            configFileReader = new ConfigData();
        }
        return configFileReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("BaseUrl");
        if (baseUrl != null)
            return baseUrl;
        else
            throw new RuntimeException("BaseUrl not specified in the Configuration.properties file.");
    }

  
}
