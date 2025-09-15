package org.browserStack.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }


    public void sendKeys(String text, By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }
    public void sendKeysAndEnter(String text, By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public String getText(By locator){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
