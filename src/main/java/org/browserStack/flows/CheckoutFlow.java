package org.browserStack.flows;

import org.browserStack.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;

public class CheckoutFlow {
    CheckoutPage checkoutPage;

    public CheckoutFlow(WebDriver driver){
        this.checkoutPage = new CheckoutPage(driver);
    }

    public void enterCheckoutDetailsAndClickSubmit(String firstName, String lastName,
                                                   String address, String province, String postCode){
        checkoutPage.enterCheckoutDetails(firstName,lastName,address,province,postCode);
        checkoutPage.clickOnSubmitButton();
    }
}
