package org.browserStack.tests;

import org.browserStack.base.BaseTest;
import org.browserStack.dataproviders.TestDataProvider;
import org.browserStack.flows.AddToCartFlow;
import org.browserStack.flows.LoginFlow;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @BeforeMethod
    public void loginBeforeTest(){
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(userName,password);
    }

    @Test(dataProvider = "productData", dataProviderClass = TestDataProvider.class)
    public void addProductToCartAndCheckout(String product1, String product2) {
        AddToCartFlow addToCartFlow = new AddToCartFlow(driver);
        addToCartFlow.addToCart(product1,product2);




    }
}
