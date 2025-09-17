package org.browserStack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage{
    By firstNameInput = By.id("firstNameInput");
    By lastNameInput = By.id("lastNameInput");
    By addressInput = By.id("addressLine1Input");
    By provinceInput = By.id("provinceInput");
    By postCodeInput = By.id("postCodeInput");
    By submit_Btn = By.id("checkout-shipping-continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutDetails(String firstName, String lastName,
                                     String address, String province, String postCode){
        sendKeys(firstName,firstNameInput);
        sendKeys(lastName,lastNameInput);
        sendKeys(address,addressInput);
        sendKeys(province,provinceInput);
        sendKeys(postCode,postCodeInput);
    }

    public void clickOnSubmitButton(){
        click(submit_Btn);
    }

}
