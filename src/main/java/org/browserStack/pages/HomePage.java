package org.browserStack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    By PRODUCT_NAMES = By.cssSelector(".shelf-container .shelf-item__title");
    By PRODUCT_ADD_BUTTONS = By.cssSelector(".shelf-container .shelf-item__buy-btn");
    By CHECKOUT_BTN = By.cssSelector(".buy-btn");
    By USERNAME_ELEMENT = By.className("username");
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<String> getAllProductNames(){
        List<WebElement> productElements = driver.findElements(PRODUCT_NAMES);
        return productElements.stream()
                .map(WebElement::getText)
                .toList();
    }

    public void addRandomProductToCart(){
        List<WebElement> addToCartButtons = driver.findElements(PRODUCT_ADD_BUTTONS);
        if(addToCartButtons.isEmpty()){
            throw new RuntimeException("No products found");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(addToCartButtons.size());
        clickElement(addToCartButtons.get(randomIndex));
    }

    public void addMultipleRandomProductsToCart(int count){
        for (int i = 0; i < count; i++) {
            addRandomProductToCart();
        }
    }

    private void clickElement(WebElement element){
        wait.until(driver1 -> {
            try {
                element.click();
                return true;
            }
            catch (Exception e){
                return false;
            }
        });
    }
    public String getUsernameText() {
        return getText(USERNAME_ELEMENT);
    }

    public void clickOnCheckoutbutton(){
        click(CHECKOUT_BTN);
    }
}
