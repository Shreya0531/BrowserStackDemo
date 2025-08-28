package org.browserStack.tests;

import org.browserStack.base.BaseTest;
import org.browserStack.flows.LoginFlow;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest(){
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(userName,password);
    }

}
