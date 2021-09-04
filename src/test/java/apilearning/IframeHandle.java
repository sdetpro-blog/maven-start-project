package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframeHandle {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = DriverFactory.getChromeDriver();
            driver.get("https://the-internet.herokuapp.com/iframe");

            By iframeSel = By.id("mce_0_ifr");
            By iframeInputSel = By.id("tinymce");

            // Switch to iframe
            driver.switchTo().frame(driver.findElement(iframeSel));

            // Clear current text & input
            WebElement iframeInputElem = driver.findElement(iframeInputSel);
            iframeInputElem.clear();
            Thread.sleep(1000);
            iframeInputElem.sendKeys("New content");
            Thread.sleep(1000);

            driver.switchTo().parentFrame();
            System.out.println(driver.findElement(By.tagName("h3")).getText());

            driver.quit();
        }
}
