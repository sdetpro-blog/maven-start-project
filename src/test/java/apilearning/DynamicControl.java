package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicControl {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = DriverFactory.getChromeDriver();
            driver.get("https://the-internet.herokuapp.com/windows");


            driver.quit();
        }
}
