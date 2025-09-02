package org.browserStack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class HomePage extends BasePage {
    By CHECKOUT_BTN = By.xpath("//div[text()='Checkout']");
    By USERNAME_ELEMENT = By.className("username");
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getUsernameText() {
        return getText(USERNAME_ELEMENT);
    }
    public By getProductAddedToCart(String productName){
        return By.xpath("//p[text()='"+ productName +"']/following-sibling::div[text()='Add to cart']");
    }
    public void clickOnProductAddToCart(String productName){
        click(By.xpath("//p[text()='"+ productName +"']/following-sibling::div[text()='Add to cart']"));
    }
    public void clickOnCheckoutbutton(){
        click(CHECKOUT_BTN);
    }
}
