package org.browserStack.base;

import org.browserStack.utils.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
public class BaseTest {
    public WebDriver driver;
    String baseUrl;
    String environment;
    protected String userName;
    protected String password;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        environment = System.getProperty("env","qa");

        baseUrl = ConfigManager.getProperty(environment + ".url");
        if (baseUrl == null){
            throw new RuntimeException("base url not configured");
        }
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
            driver.quit();
        }
    }
}
