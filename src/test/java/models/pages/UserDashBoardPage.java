package models.pages;

import core.element.ActionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDashBoardPage extends ActionBase {

    private WebDriver driver;
    private final By titleSel = By.tagName("h2");

    public UserDashBoardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyUserOnDashBoardPage(){
        final String expectedTitle = "Secure Area";
        String currentTitle = getText().from(titleSel);
        checkThat(currentTitle).is(expectedTitle).ifNot("[ERR] Title is incorrect");
    }

}
