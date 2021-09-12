package tests.authentication;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testflows.authentication.LoginFlow;

public class Login {

    @Test(groups = {"regression", "smoke"})
    public void loginWithCorretCreds() {
        WebDriver driver = DriverFactory.getChromeDriver();
        final String username = "tomsmith";
        final String password = "SuperSecretPassword!";
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            LoginFlow loginFlow = new LoginFlow(driver);
            loginFlow.verifyUserLoginSuccessFully(username, password);
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {"regression"}, dataProvider = "wrongLoginData")
    public void loginWithIncorrectCreds(String username, String password) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get("https://the-internet.herokuapp.com/login");
            LoginFlow loginFlow = new LoginFlow(driver);
            loginFlow.verifyUserLoginUnsuccessfully(username, password);
        } finally {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] wrongLoginData() {
        Object[][] loginData = new Object[2][2];
        loginData[0][0] = "";
        loginData[0][1] = "SuperSecretPassword!";
        loginData[1][0] = "tomsmith";
        loginData[1][1] = "";
        return loginData;
    }
}
