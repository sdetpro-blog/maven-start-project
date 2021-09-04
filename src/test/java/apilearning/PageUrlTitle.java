package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class PageUrlTitle {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");


        String pageUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        System.out.println(pageTitle);
        System.out.println(pageUrl);

        driver.quit();
    }
}
