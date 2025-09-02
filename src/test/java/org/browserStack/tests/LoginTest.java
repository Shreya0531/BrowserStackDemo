package org.browserStack.tests;

import org.browserStack.base.BaseTest;
import org.browserStack.flows.LoginFlow;
import org.browserStack.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest(){
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(userName,password);

        HomePage homePage = new HomePage(driver);
        String actualUsername = homePage.getUsernameText();
        Assert.assertEquals(actualUsername,userName);
    }
}
