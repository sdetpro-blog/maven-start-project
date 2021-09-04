package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WindowHandle {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = DriverFactory.getChromeDriver();
            driver.get("https://the-internet.herokuapp.com/windows");

            By clickHereLinkText = By.linkText("Click Here");
            WebElement linkTextElem = driver.findElement(clickHereLinkText);
            linkTextElem.click();

            List<String> windowIds = new ArrayList<>(driver.getWindowHandles());
            final int FIRST_WINDOW = 0;
            final int SECOND_WINDOW = 1;
            driver.switchTo().window(windowIds.get(SECOND_WINDOW));

            System.out.println("Second Window URL: " + driver.getCurrentUrl());
            System.out.println("Second Window Title: " + driver.getTitle());

            // Switch back to the first window
            driver.switchTo().parentFrame();
//            driver.switchTo().window(windowIds.get(FIRST_WINDOW));
            System.out.println("1st Window URL: " + driver.getCurrentUrl());
            System.out.println("1st Window Title: " + driver.getTitle());

            // Close the second window
            driver.switchTo().window(windowIds.get(SECOND_WINDOW));
            driver.close();

            // Switch to the 1st one
            driver.switchTo().window(windowIds.get(FIRST_WINDOW));
            windowIds = new ArrayList<>(driver.getWindowHandles());
            System.out.println("Current Windows number: " + windowIds.size());

            driver.quit();
        }
}
