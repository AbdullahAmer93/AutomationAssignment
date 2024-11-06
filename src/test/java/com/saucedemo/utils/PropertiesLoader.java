package com.saucedemo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private Properties properties;

    // Constructor to load properties from the specified file
    public PropertiesLoader(String fileName) throws IOException {
        properties = new Properties();

        // Attempt to load from the classpath (src/test/resources)
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        // If the file is not found in the classpath, attempt to load from a local file
        if (inputStream == null) {
            inputStream = new FileInputStream(fileName);  // Fallback to filesystem
        }

        properties.load(inputStream);
        inputStream.close();
    }

    // Method to get the browser value from config.properties
    public String getBrowser() {
        return properties.getProperty("browser", "chrome");  // Default to "chrome" if not specified
    }

    // Method to get the URL value from config.properties
    public String getUrl() {
        return properties.getProperty("url");
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        try {
            // Load config.properties
            PropertiesLoader configLoader = new PropertiesLoader("config.properties");
            String browser = configLoader.getBrowser();
            String url = configLoader.getUrl();

            // Print the browser and URL values
            System.out.println("Selected Browser: " + browser);
            System.out.println("Application URL: " + url);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

