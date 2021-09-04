package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsExecutor {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(3000);

        driver.quit();
    }
}
