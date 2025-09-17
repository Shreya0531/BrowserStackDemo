package org.browserStack.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(By locator, int timeout){
        new WebDriverWait(driver,Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        logger.info("Clicking on element: {}",locator);
        WebElement element = driver.findElement(locator);
        element.click();
    }


    public void sendKeys(String text, By locator){
        logger.info("Entering text: {} into element: {}",text,locator);
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }
    public void sendKeysAndEnter(String text, By locator){
        logger.info("Entering text: {} into element: {}",text,locator);
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public String getText(By locator){
        logger.info("Getting text from element: {}",locator);
        return  driver.findElement(locator).getText();
    }
}
