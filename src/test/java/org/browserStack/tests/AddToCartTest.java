package org.browserStack.tests;

import org.browserStack.base.BaseTest;
import org.browserStack.flows.LoginFlow;
import org.browserStack.pages.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @BeforeMethod
    public void loginBeforeTest(){
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(userName,password);
    }

    @Test
    public void addProductToCartAndCheckout(){
        ProductPage productPage = new ProductPage(driver);

        String product1 = "iPhone 12";
        String product2 = "iPhone 12 Mini";

        productPage.clickOnProductAddToCart(product1);
        productPage.getProductAddToCart(product2);
        productPage.clickOnCheckoutbutton();
    }
}
