package models.pagesold;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMainInterActions {

    // Attributes
    private final WebDriver driver;
    private final By usernameSel = By.cssSelector("#username");
    private final By passwordSel = By.cssSelector("#password");
    private final By loginBtnSel = By.cssSelector("#login > button");


    // Constructor
    public LoginPageMainInterActions(WebDriver driver) {
        this.driver = driver;
    }


    public void inputUsername(String username) {
        this.driver.findElement(usernameSel).sendKeys(username);
    }

    public void inputPassword(String password) {
        this.driver.findElement(passwordSel).sendKeys(password);
    }

    public void clickOnLoginBtn() {
        this.driver.findElement(loginBtnSel).click();
    }
}
