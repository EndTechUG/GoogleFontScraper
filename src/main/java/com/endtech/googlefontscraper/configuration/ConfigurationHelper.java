package com.endtech.googlefontscraper.configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfigurationHelper {
    public static String getProperty(String key){
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties("application.properties");
            return config.getString(key);
        } catch (ConfigurationException e) {
            return null;
        }
    }
}
