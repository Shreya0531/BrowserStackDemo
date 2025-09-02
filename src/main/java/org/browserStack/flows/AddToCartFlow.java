package org.browserStack.flows;

import org.browserStack.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class AddToCartFlow {
    HomePage homePage;

   public AddToCartFlow(WebDriver driver){
        this.homePage = new HomePage(driver);
    }

    public void addToCart(String product1, String product2){
        homePage.clickOnProductAddToCart(product1);
        homePage.clickOnProductAddToCart(product2);
        homePage.clickOnCheckoutbutton();
    }

}
