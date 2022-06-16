package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFactory {
    private Properties properties;
    //private final String propertyFilePath= "src//test//resources//Configuration.properties";
    private final String propertyFilePath = getPropertyFilePath();


    private String getPropertyFilePath() {
        String profileId = System.getProperty("profileId");
        if (profileId == null) profileId = "staging";
        return "src//test//resources//profiles//" + profileId + "//config.properties";
    }

    public void configFileReader() {
        BufferedReader reader;
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
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }
}
