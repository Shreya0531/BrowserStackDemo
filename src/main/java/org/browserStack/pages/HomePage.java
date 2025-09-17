package org.browserStack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage {
    By PRODUCT_NAMES = By.cssSelector(".shelf-container .shelf-item__title");
    By PRODUCT_ADD_BUTTONS = By.cssSelector(".shelf-container .shelf-item__buy-btn");
    By CHECKOUT_BTN = By.cssSelector(".buy-btn");
    By USERNAME_ELEMENT = By.cssSelector(".username");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By getProductAddToCartButton(String productName) {
        return By.xpath("//p[text()='" + productName + "']/following-sibling::div[text()='Add to cart']");
    }

    public List<WebElement> getAllProductNames() {
        return driver.findElements(PRODUCT_NAMES);
    }

    public List<String> getAllProductsNamesInString() {
        List<String> products = new ArrayList<>();
        for (WebElement product : getAllProductNames()) {
            products.add(product.getText());
        }
        return products;
    }

    public String getRandomProductName() {
        List<String> products = getAllProductsNamesInString();
        Collections.shuffle(products);
        return products.get(0);
    }

    public void clickOnProduct(String product) {
        click(getProductAddToCartButton(product));
    }

    public String getUsernameText() {
        return getText(USERNAME_ELEMENT);
    }

    public void clickOnCheckoutButton() {
        waitForClickable(CHECKOUT_BTN, 10);
        click(CHECKOUT_BTN);
    }
}
