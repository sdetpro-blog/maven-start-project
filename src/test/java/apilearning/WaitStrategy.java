package apilearning;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitStrategy {

    public static void main(String[] args) {
        WebDriver driver = Driver.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");
            By usernameSel = By.cssSelector("#username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("#login > button");
            By flashMsgSel = By.cssSelector("#flash");
            By flashMsgSelWrong = By.cssSelector("#flash_");

            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);

            usernameElem.sendKeys("dfasfasf");
            passwordElem.sendKeys("dfasfasf");
            driver.findElement(loginBtnSel).click();


//            WebElement flashMsgElement = driver.findElement(flashMsgSel);


//            driver.navigate().refresh();

            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            driver.findElement(loginBtnSel).click();

//            flashMsgElement.getText();



//
//            boolean needRetry = false;
//
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//
//            try {
//                wait.until(ExpectedConditions.visibilityOfElementLocated(flashMsgSelWrong));
//            } catch (NoSuchElementException e){
//                needRetry = true;
//            }
//
//            if(needRetry) {
//                wait = new WebDriverWait(driver, 120);
//                wait.until(ExpectedConditions.visibilityOfElementLocated(flashMsgSelWrong));
//            }



            // Implicit: WebDriver scope -> find
            // Explicit: WebElement -> find -> specific conditions


            // 1(30s) -> 2 -> 3 -> 4: 50000 rows (2 mins)  Explicit Wait (120s)

            System.out.println(driver.findElement(flashMsgSel).getText());

        } finally {
            driver.quit();
        }


    }
}
