package com.mahadsiddiqui.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * WebDriver configuration and management class
 * Handles browser setup, driver management, and configuration
 */
public class WebDriverConfig {
    
    private static Properties properties;
    private static WebDriver driver;
    
    static {
        loadProperties();
    }
    
    /**
     * Load configuration properties
     */
    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/config/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading configuration file: " + e.getMessage());
            setDefaultProperties();
        }
    }
    
    /**
     * Set default properties if config file is not found
     */
    private static void setDefaultProperties() {
        properties.setProperty("browser.name", "chrome");
        properties.setProperty("browser.headless", "false");
        properties.setProperty("browser.window.maximize", "true");
        properties.setProperty("base.url", "https://demoqa.com");
        properties.setProperty("implicit.wait", "10");
        properties.setProperty("explicit.wait", "20");
        properties.setProperty("page.load.timeout", "30");
    }
    
    /**
     * Get property value by key
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    /**
     * Get property value with default
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    /**
     * Get integer property value
     */
    public static int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key, "0"));
    }
    
    /**
     * Get boolean property value
     */
    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key, "false"));
    }
    
    /**
     * Initialize WebDriver based on configuration
     */
    public static WebDriver initializeDriver() {
        String browserName = getProperty("browser.name", "chrome").toLowerCase();
        boolean headless = getBooleanProperty("browser.headless");
        boolean maximize = getBooleanProperty("browser.window.maximize");
        
        switch (browserName) {
            case "chrome":
                driver = createChromeDriver(headless);
                break;
            case "firefox":
                driver = createFirefoxDriver(headless);
                break;
            case "edge":
                driver = createEdgeDriver(headless);
                break;
            case "safari":
                driver = createSafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        
        if (maximize) {
            driver.manage().window().maximize();
        }
        
        // Set timeouts
        driver.manage().timeouts().implicitlyWait(getIntProperty("implicit.wait"), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(getIntProperty("page.load.timeout"), TimeUnit.SECONDS);
        
        return driver;
    }
    
    /**
     * Create Chrome WebDriver
     */
    private static WebDriver createChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        if (headless) {
            options.addArguments("--headless");
        }
        
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        
        return new ChromeDriver(options);
    }
    
    /**
     * Create Firefox WebDriver
     */
    private static WebDriver createFirefoxDriver(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        
        if (headless) {
            options.addArguments("--headless");
        }
        
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        
        return new FirefoxDriver(options);
    }
    
    /**
     * Create Edge WebDriver
     */
    private static WebDriver createEdgeDriver(boolean headless) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        
        if (headless) {
            options.addArguments("--headless");
        }
        
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        
        return new EdgeDriver(options);
    }
    
    /**
     * Create Safari WebDriver
     */
    private static WebDriver createSafariDriver() {
        SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }
    
    /**
     * Get current WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }
    
    /**
     * Quit WebDriver and clean up
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    /**
     * Get base URL
     */
    public static String getBaseUrl() {
        return getProperty("base.url");
    }
    
    /**
     * Get test URL
     */
    public static String getTestUrl() {
        return getProperty("test.url", getBaseUrl());
    }
    
    /**
     * Get explicit wait timeout
     */
    public static int getExplicitWaitTimeout() {
        return getIntProperty("explicit.wait");
    }
    
    /**
     * Get implicit wait timeout
     */
    public static int getImplicitWaitTimeout() {
        return getIntProperty("implicit.wait");
    }
}
