package apilearning;

import driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertLearning {

    public static void main(String[] args) {
        WebDriver driver = Driver.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            By jsAlertSel = By.cssSelector("[onclick='jsAlert()']");
            By jsAlertConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
            By jsAlertPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");

            WebElement jsAlertElem = driver.findElement(jsAlertSel);
            WebElement jsAlertConfirmElem = driver.findElement(jsAlertConfirmSel);
            WebElement jsAlertPromptElem = driver.findElement(jsAlertPromptSel);
            WebDriverWait wait = new WebDriverWait(driver, 30);

            // Play with jsAlertElem
            jsAlertElem.click();
            Thread.sleep(1000);
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            jsAlert.accept();
            Thread.sleep(2000);

            // Play with jsAlertConfirmElem
            jsAlertConfirmElem.click();
            Thread.sleep(1000);
            Alert jsAlertConfirm = wait.until(ExpectedConditions.alertIsPresent());
            jsAlertConfirm.dismiss();
            Thread.sleep(2000);

            // Play with jsAlertConfirmElem
            jsAlertPromptElem.click();
            Thread.sleep(1000);
            Alert jsAlertPrompt = wait.until(ExpectedConditions.alertIsPresent());
            jsAlertPrompt.sendKeys("Tui la teo!");
            Thread.sleep(2000);
            jsAlertPrompt.accept();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
