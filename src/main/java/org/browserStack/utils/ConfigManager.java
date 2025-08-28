package org.browserStack.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    static Properties properties = new Properties();

    static {
        try(InputStream input = ConfigManager
                .class
                .getClassLoader()
                .getResourceAsStream("config.properties")){
            if (input == null){
                throw new RuntimeException("config.properties not loading");
            }
            properties.load(input);
        }

        catch (Exception e){
            throw new RuntimeException("config.properties not found");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static String getUsername(String environment){
       return getProperty(environment +".demouser");
    }

    public static String getPassword(String environment){
        return getProperty(environment + ".password");
    }


}

