package org.browserStack.tests;

import org.browserStack.base.BaseTest;
import org.browserStack.dataproviders.TestDataProvider;
import org.browserStack.flows.AddToCartFlow;
import org.browserStack.flows.CheckoutFlow;
import org.browserStack.flows.LoginFlow;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @BeforeMethod
    public void loginAndAddProductsToCart(){
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(userName,password);

        AddToCartFlow addToCartFlow = new AddToCartFlow(driver);
        addToCartFlow.addRandomProductsToCart(2);
        addToCartFlow.proceedToCheckout();
    }

    @Test(dataProvider = "checkoutData", dataProviderClass = TestDataProvider.class)
    public void checkoutProducts(String firstName, String lastName,
                                 String address, String province, String postCode){
        CheckoutFlow checkoutFlow = new CheckoutFlow(driver);
        checkoutFlow.enterCheckoutDetailsAndClickSubmit(firstName,lastName,address,province,postCode);
        Assert.assertTrue(driver.getCurrentUrl().contains("/confirmation"));

    }
}
