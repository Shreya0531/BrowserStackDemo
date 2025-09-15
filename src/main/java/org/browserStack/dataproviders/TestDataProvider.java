package org.browserStack.dataproviders;

import org.browserStack.utils.ConfigManager;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    static String environment = System.getProperty("env","qa");

    @DataProvider(name = "checkoutData")
    public static Object[][] getCheckoutData(){
        return new Object[][]{
                {
                    ConfigManager.getCheckoutDetails(environment,"firstname"),
                    ConfigManager.getCheckoutDetails(environment,"lastname"),
                    ConfigManager.getCheckoutDetails(environment,"address"),
                    ConfigManager.getCheckoutDetails(environment,"province"),
                    ConfigManager.getCheckoutDetails(environment,"postalcode")
                }
        };
    }
}
