package apilearning;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = Driver.getChromeDriver();
        try {
            // Open url
            driver.get("https://the-internet.herokuapp.com/login");

            // Input username
            driver.findElement(By.id("username")).sendKeys("username");

            // Another strategy
            WebElement usernameElementCss = driver.findElement(By.cssSelector("#username"));
            usernameElementCss.clear();
            usernameElementCss.sendKeys("username - css");

            // Input password
            WebElement passwordElement = driver.findElement(By.id("password"));
            passwordElement.sendKeys("password");

            // Click on Login btn
            WebElement loginBtn = driver.findElement(By.cssSelector("#login > button"));
            loginBtn.click();

            driver.navigate().refresh();
            loginBtn.click();

            // Wait a little
            Thread.sleep(3000);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
