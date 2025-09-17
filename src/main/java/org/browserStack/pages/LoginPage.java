package org.browserStack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By SIGNIN_BTN = By.id("signin");
    public static final By USER_INPUT = By.id("react-select-2-input");
    public static final By PASSWORD_INPUT = By.id("react-select-3-input");
    public static final By LOGIN_BTN = By.id("login-btn");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnSignIn(){
        click(SIGNIN_BTN);
    }
    public void enterLoginDetails(String username, String password){
        sendKeysAndEnter(username,USER_INPUT);
        sendKeysAndEnter(password,PASSWORD_INPUT);
    }
    public void clickLoginButton(){
        waitForVisibility(LOGIN_BTN,5);
        click(LOGIN_BTN);
    }

}

