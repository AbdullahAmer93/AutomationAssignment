package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

    private static WebDriver driver;
    private static Properties prop;

    // Method to load the properties file and initialize WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                // Load configuration properties
                prop = new Properties();
                FileInputStream file = new FileInputStream("src/test/resources/config.properties");
                prop.load(file);

                // Get the browser selection from config file
                String browser = prop.getProperty("browser");
                if (browser.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\AmerA3\\Desktop\\webdrivers\\chromedriver.exe"); // Update this path
                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "path/to/geckodriver"); // Update this path
                    driver = new FirefoxDriver();
                } else {
                    throw new RuntimeException("Browser not supported: " + browser);
                }

                // Maximize the window
                driver.manage().window().maximize();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error reading the config.properties file or setting up WebDriver.", e);
            }
        }
        return driver;
    }

    // Method to quit the WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset the driver instance after quitting
        }
    }
}
