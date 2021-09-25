package apilearning;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.SecureRandom;
import java.util.List;

public class DropDownMore {

    public static void main(String[] args) {

        WebDriver driver = Driver.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/dropdown");
            By dropdownSel = By.cssSelector("#dropdown");

            Select dropdownElem = new Select(driver.findElement(dropdownSel));

            List<WebElement> allOptions = dropdownElem.getOptions();
            System.out.println("Option Numbers: " + allOptions.size());

            // Randomly
            int myRandomIndex = new SecureRandom().nextInt(allOptions.size());
            System.out.println("Random is: " + myRandomIndex);

            dropdownElem.selectByIndex(myRandomIndex);

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}
