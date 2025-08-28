package org.browserStack.flows;

import org.browserStack.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class AddToCartFlow {
    ProductPage productPage;

   public AddToCartFlow(WebDriver driver){
        this.productPage = new ProductPage(driver);
    }

    public void addToCart(String product1, String product2){
        productPage.clickOnProductAddToCart(product1);
        productPage.clickOnProductAddToCart(product2);
        productPage.clickOnCheckoutbutton();
    }
}
