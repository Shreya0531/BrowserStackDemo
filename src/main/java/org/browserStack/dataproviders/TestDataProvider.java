package org.browserStack.dataproviders;

import org.browserStack.utils.ConfigManager;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    static String environment = System.getProperty("env","qa");

    @DataProvider(name = "productData")
    public static Object[][] getProductData(){
        return new Object[][]{
                {
                        ConfigManager.getProducts(environment, "product1"),
                        ConfigManager.getProducts(environment, "product2")
                }
        };
    }

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
