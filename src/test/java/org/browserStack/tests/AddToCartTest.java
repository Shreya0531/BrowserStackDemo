package org.browserStack.tests;

import org.browserStack.base.BaseTest;
import org.browserStack.flows.AddToCartFlow;
import org.browserStack.flows.LoginFlow;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseTest {
    AddToCartFlow addToCartFlow;
    @BeforeMethod
    public void loginBeforeTest(){
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(userName,password);
        addToCartFlow = new AddToCartFlow(driver);
    }

    @Test
    public void addRandomProductsToCartAndCheckout() {
        addToCartFlow.addRandomProductsToCart(4);
        addToCartFlow.proceedToCheckout();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("/checkout"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/checkout"));

    }

}
