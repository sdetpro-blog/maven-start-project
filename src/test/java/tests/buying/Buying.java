package tests.buying;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testflows.authentication.LoginFlow;
import testflows.buying.BuyingFlow;

public class Buying {

    @BeforeMethod
    void login() {
        WebDriver driver = DriverFactory.getChromeDriver();
        final String username = "tomsmith";
        final String password = "SuperSecretPassword!";
        driver.get("https://the-internet.herokuapp.com/login");
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.loginWithCorrectCreds(username, password);
    }

    @Test(groups = {"regression", "smoke"})
    public void buyingSth() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            BuyingFlow buyingFlow = new BuyingFlow(driver);
            buyingFlow.buyItem().verifyBuyItemSuccessfully();

        } finally {
            driver.quit();
        }
    }
}
