package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class OpenWebPage {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();

        // Open an url
        driver.get("https://the-internet.herokuapp.com/login");

        // Thread.sleep
        Thread.sleep(2000);

        // Quit browser
        driver.quit();
    }
}
