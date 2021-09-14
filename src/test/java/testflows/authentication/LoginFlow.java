package testflows.authentication;

import models.pages.TheInternetAuthenticationPage;
import models.pages.UserDashBoardPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginFlow {

    private final WebDriver driver;

    public LoginFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void loginWithCorrectCreds(String username, String password){
        TheInternetAuthenticationPage loginPage = new TheInternetAuthenticationPage(driver);
        loginPage.inputUsername(username).inputPassword(password).clickLoginBtn();
    }

    public void verifyUserLoginSuccessFully(String username, String password) {
        loginWithCorrectCreds(username, password);
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage(driver);
        String currentTitle = userDashBoardPage.getTitle();
        String expectedTitle = "Secure Area";
        Assert.assertEquals(currentTitle, expectedTitle, "[ERR] Login successfully with WRONG msg!");
    }

    public void verifyUserLoginUnsuccessfully(String username, String password) {
        TheInternetAuthenticationPage loginPage = new TheInternetAuthenticationPage(driver);
        if (username.isEmpty()) {
            loginPage.inputPassword(password).clickLoginBtn();
            verifyErrWithWrongCred();
        }
        if (password.isEmpty()) {
            loginPage.inputUsername(username).clickLoginBtn();
            verifyErrWithWrongCred();
        }
        if (username.isEmpty() && password.isEmpty()) {
            loginPage.clickLoginBtn();
            verifyErrWithWrongCred();
        }
    }

    private void verifyErrWithWrongCred() {
        TheInternetAuthenticationPage loginPage = new TheInternetAuthenticationPage(driver);
        SoftAssert softAssert = new SoftAssert();
        String errMsgBannerColor = loginPage.getErrMsgBannerColor();
        String errMsgText = loginPage.getErrMsg();
        softAssert.assertEquals(errMsgBannerColor, "rgba(198, 15, 19, 1)", "[ERR] Err msg is not rgba(198, 15, 19, 1)");
        softAssert.assertTrue(errMsgText.contains("is invalid"), "[ERR] Err msg does not contain 'invalid'");
        softAssert.assertAll();
    }

}
