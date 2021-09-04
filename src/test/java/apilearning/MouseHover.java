package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

    public static void main(String[] args) throws InterruptedException {
        By menuHeaderComputersSel = By.cssSelector(".top-menu li a[href$=\"computers\"]");
        By menuHeaderDesktopsSel = By.cssSelector(".top-menu li a[href$=\"desktops\"]");


        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");

        // Find element
        WebElement menuHeaderComputersElem = driver.findElement(menuHeaderComputersSel);

        // Mouse Hover
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(menuHeaderComputersElem).perform();

        Thread.sleep(2000);

        // Click on Desktops
        WebElement menuHeaderDesktopsElem = driver.findElement(menuHeaderDesktopsSel);
        menuHeaderDesktopsElem.click();

        Thread.sleep(2000);

        driver.quit();
    }
}
