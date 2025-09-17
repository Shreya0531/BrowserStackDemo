package org.browserStack.flows;

import org.browserStack.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginFlow {
    LoginPage loginPage;

    public LoginFlow(WebDriver driver){
        this.loginPage = new LoginPage(driver);
    }

    public void login(String username, String password){
        loginPage.clickOnSignIn();
        loginPage.enterLoginDetails(username, password);
        loginPage.clickLoginButton();
    }
}
