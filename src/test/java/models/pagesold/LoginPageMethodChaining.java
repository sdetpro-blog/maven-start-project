package models.pagesold;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMethodChaining {

    // Attributes
    private final WebDriver driver;
    private final By usernameSel = By.cssSelector("#username");
    private final By passwordSel = By.cssSelector("#password");
    private final By loginBtnSel = By.cssSelector("#login > button");


    // Constructor
    public LoginPageMethodChaining(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageMethodChaining inputUsername(String username) {
        this.driver.findElement(usernameSel).sendKeys(username);
        return this;
    }

    public LoginPageMethodChaining inputPassword(String password) {
        this.driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public void clickOnLoginBtn() {
        this.driver.findElement(loginBtnSel).click();
    }
}
