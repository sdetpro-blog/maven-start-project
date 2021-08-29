package tests.pageobject;

import driver.DriverFactory;
import models.pagesold.LoginPageMethodChaining;
import org.openqa.selenium.WebDriver;

public class TestLoginPageMethodChaining {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        TestLoginPageMethodChaining testLoginPage = new TestLoginPageMethodChaining();

        driver.get("https://the-internet.herokuapp.com/login");
        testLoginPage.testLoginWithIncorrectCreds(driver);
        Thread.sleep(3000);
        testLoginPage.testLoginWithCorrectCreds(driver);
    }

    void testLoginWithCorrectCreds(WebDriver driver){
        LoginPageMethodChaining loginPage = new LoginPageMethodChaining(driver);
        loginPage
                .inputUsername("tomsmith")
                .inputPassword("SuperSecretPassword!")
                .clickOnLoginBtn();
    }

    void testLoginWithIncorrectCreds(WebDriver driver){
        LoginPageMethodChaining loginPage = new LoginPageMethodChaining(driver);
        loginPage
                .inputUsername("tomsmith__")
                .inputPassword("SuperSecretPassword!__")
                .clickOnLoginBtn();
    }
}
