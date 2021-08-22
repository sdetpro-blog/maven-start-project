package components.global;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class HeaderTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testHomePageHeader(driver);
            testCategoryPageHeader(driver);
            testProductItemPageHeader(driver);
            testAboutUsPageHeader(driver);
        } finally {
            driver.quit();
        }

    }

    public static void testHomePageHeader(WebDriver driver) {
        // Navigate to About Us page
        driver.get("http://demowebshop.tricentis.com/");

        // Verification points
        commonHeaderTest(driver);
    }

    public static void testCategoryPageHeader(WebDriver driver) {
        driver.get("http://demowebshop.tricentis.com/");
        List<WebElement> topMenuItem = driver.findElements(By.cssSelector(".header-menu .top-menu > li"));
        WebElement randomMenuItem = topMenuItem.get(new SecureRandom().nextInt(topMenuItem.size()));

        System.out.println(randomMenuItem.getText());

        // Verification points
        commonHeaderTest(driver);
    }

    public static void testProductItemPageHeader(WebDriver driver) {
    }

    public static void testAboutUsPageHeader(WebDriver driver) {

    }

    private static void commonHeaderTest(WebDriver driver) {
        // Locate WebElement
        WebElement headerLogo = driver.findElement(By.cssSelector(".header .header-logo img"));
//        WebElement searchInputField = driver.findElement(By.cssSelector(""));
//        WebElement searchBtn = driver.findElement(By.cssSelector(""));
        List<WebElement> headerLinks = driver.findElements(By.cssSelector(".header-links li a"));

        // sample Verification points
        System.out.println("Is logo displayed: " + headerLogo.isDisplayed());

        for (WebElement link : headerLinks) {
            System.out.println(link.getText().isEmpty());
            System.out.println(link.getAttribute("href").isEmpty());
        }
    }
}
