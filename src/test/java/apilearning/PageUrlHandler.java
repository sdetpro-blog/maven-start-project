package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class PageUrlHandler {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("http://demowebshop.tricentis.com/search?q=laptop");

        String pageUrl = driver.getCurrentUrl();
        System.out.println(pageUrl);

        String pathName = "";

        try{
            URL url = new URL(pageUrl);
            pathName = url.getPath();
            System.out.println(url.getQuery());
        }catch (Exception ignored){

        }

        if(pathName.equals("/"))
            System.out.println("No Path name");
        else
            System.out.println(pathName);


        driver.quit();
    }
}
