package models.pages;

import core.element.ActionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TheInternetAuthenticationPage extends ActionBase {

    private final WebDriver driver;
    private final By errMsgBanner = By.cssSelector("#flash");
    private final By usernameTxtBx = By.cssSelector("#username");
    private final By passwordTxtBx = By.cssSelector("#password");
    private final By loginBtn = By.cssSelector("#login button");

    public TheInternetAuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public TheInternetAuthenticationPage inputUsername(String username) {
        input(username).into(usernameTxtBx);
        return this;
    }

    public TheInternetAuthenticationPage inputPassword(String password) {
        input(password).into(passwordTxtBx);
        return this;
    }

    public void clickLoginBtn() {
        clickOn(loginBtn);
    }

    public String getErrMsgBannerColor(){
        return driver.findElement(errMsgBanner).getCssValue("background-color");
    }

    public String getErrMsg(){
        return driver.findElement(errMsgBanner).getText();
    }


    public void verifyLoginErrMsg() {
        SoftAssert softAssert = new SoftAssert();

        String errMsgBannerColor = getCSS("background-color").from(errMsgBanner);
//        checkThat(errMsgBannerColor).is("rgba(198, 15, 19, 2)").ifNot("[ERR] Err msg is not rgba(198, 15, 19, 1)");
        softAssert.assertEquals(errMsgBannerColor, "rgba(198, 15, 19, 1)", "[ERR] Err msg is not rgba(198, 15, 19, 1)");


        // Get flash msg
        String errMsgText = getText().from(errMsgBanner);
//        checkThat(errMsgText).contains("is invalid").ifNot("[ERR] Err msg incorrect!");
        softAssert.assertTrue(errMsgText.contains("is invalid"), "[ERR] Err msg incorrect!");

        softAssert.assertAll();


        System.out.println("GOING HERE");

    }

}