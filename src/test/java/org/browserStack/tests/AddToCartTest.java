package org.browserStack.tests;

import org.browserStack.base.BaseTest;
import org.browserStack.flows.AddToCartFlow;
import org.browserStack.flows.LoginFlow;
import org.browserStack.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddToCartTest extends BaseTest {
    AddToCartFlow addToCartFlow;
    HomePage homePage;

    @BeforeMethod
    public void loginBeforeTest() {
        LoginFlow loginFlow = new LoginFlow(driver);
        homePage = new HomePage(driver);
        loginFlow.login(userName, password);
        addToCartFlow = new AddToCartFlow(driver);
    }

    @Test
    public void addRandomProductsToCartAndCheckout() throws InterruptedException {

        String product = homePage.getRandomProductName();
        System.out.println(product);
        homePage.clickOnProduct(product);
        homePage.clickOnCheckoutButton();

//        new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(ExpectedConditions.urlContains("/checkout"));
//        Assert.assertTrue(driver.getCurrentUrl().contains("/checkout"));

    }

}
