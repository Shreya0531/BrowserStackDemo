package org.browserStack.flows;

import org.browserStack.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AddToCartFlow {
    HomePage homePage;

    public AddToCartFlow(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }

    public void proceedToCheckout() {
        homePage.clickOnCheckoutButton();
    }

    public List<String> getAllProductsList() {
        return homePage.getAllProductsNamesInString();
    }

}
