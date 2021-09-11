package tests.dataprovider;

import driver.DriverFactory;
import models.pages.TheInternetAuthenticationPage;
import models.pages.UserDashBoardPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleDataProvider {

    @Test(dataProvider = "loginCredsQaEnv")
    public void testLogin(String username, String password) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            TheInternetAuthenticationPage loginPage = new TheInternetAuthenticationPage(driver);
            driver.get("https://the-internet.herokuapp.com/login");
            loginPage.inputUsername(username).inputPassword(password).clickLoginBtn();
            if (username.equals("incorrect")) {
                loginPage.verifyLoginErrMsg();
            } else {
                UserDashBoardPage userDashBoardPage = new UserDashBoardPage(driver);
                userDashBoardPage.verifyUserOnDashBoardPage();
            }
        } finally {
            driver.quit();
        }
    }

    @DataProvider(name = "loginCredsQaEnv")
    public Object[][] generateLoginCredsQaEnv() {
        Object[][] loginData = new Object[2][2];
        loginData[0][0] = "tomsmith";
        loginData[0][1] = "SuperSecretPassword!";
        loginData[1][0] = "incorrect";
        loginData[1][1] = "SuperSecretPassword!";
        return loginData;
    }

    @DataProvider(name = "loginCredsStaggingEnv")
    public Object[][] generateLoginCredsStaggingEnv() {
        Object[][] loginData = new Object[2][2];
        loginData[0][0] = "tomsmith";
        loginData[0][1] = "SuperSecretPassword!";
        loginData[1][0] = "tomsmith_";
        loginData[1][1] = "SuperSecretPassword!";
        return loginData;
    }

}