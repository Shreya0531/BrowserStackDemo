package org.browserStack.base;

import org.browserStack.utils.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
public class BaseTest {
    public WebDriver driver;
    String baseUrl;
    String environment;
    protected String userName;
    protected String password;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp(){
        driver = new SafariDriver();
        driver.manage().window().maximize();

        environment = System.getProperty("env","qa");

        baseUrl = ConfigManager.getProperty(environment + ".url");
        if (baseUrl == null){
            throw new RuntimeException("base url not configured");
        }
        logger.debug("Navigating to URL: {}",baseUrl);
        driver.get(baseUrl);

        userName = ConfigManager.getUsername(environment);
        password = ConfigManager.getPassword(environment);
        if (userName == null || password == null){
            throw new RuntimeException("Credentials are not configured for environment: " + environment);
        }
    }

    @AfterMethod
    public void tearDown(){
        if (driver!= null){
            logger.info("Closing the browser");
            driver.quit();
        }
    }
}
