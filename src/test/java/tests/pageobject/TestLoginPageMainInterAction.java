package tests.pageobject;

import driver.Driver;
import models.pagesold.LoginPageMainInterActions;
import org.openqa.selenium.WebDriver;

public class TestLoginPageMainInterAction {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getChromeDriver();
        TestLoginPageMainInterAction testLoginPage = new TestLoginPageMainInterAction();

        driver.get("https://the-internet.herokuapp.com/login");
        testLoginPage.testLoginWithIncorrectCreds(driver);
        Thread.sleep(3000);
        testLoginPage.testLoginWithCorrectCreds(driver);
    }

    void testLoginWithCorrectCreds(WebDriver driver){
        LoginPageMainInterActions loginPage = new LoginPageMainInterActions(driver);
        loginPage.inputUsername("tomsmith");
        loginPage.inputPassword("SuperSecretPassword!");
        loginPage.clickOnLoginBtn();
    }

    void testLoginWithIncorrectCreds(WebDriver driver){
        LoginPageMainInterActions loginPage = new LoginPageMainInterActions(driver);
        loginPage.inputUsername("tomsmith__");
        loginPage.inputPassword("SuperSecretPassword!__");
        loginPage.clickOnLoginBtn();
    }
}
