package tests.testng;

import driver.DriverFactory;
import models.pagesold.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage {

    @Test
    void testLoginWithCorrectCreds() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.username().sendKeys("tomsmith");
            loginPage.password().sendKeys("SuperSecretPassword!");
            loginPage.loginBtn().click();

            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://the-internet.herokuapp.com/secure";
            Assert.assertEquals(currentUrl, expectedUrl, "[ERR] Wrong url after login");
        } finally {
            driver.quit();
        }
    }


    // Will be failed
    @Test
    void testLoginWithIncorrectCreds() {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.username().sendKeys("username_wrong");
            loginPage.password().sendKeys("password");
            loginPage.loginBtn().click();

            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://the-internet.herokuapp.com/secure";

            Assert.assertEquals(currentUrl, expectedUrl, "[ERR] Wrong url after login");
        } finally {
            driver.quit();
        }
    }
}
