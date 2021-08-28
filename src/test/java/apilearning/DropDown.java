package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/dropdown");
            By dropdownSel = By.cssSelector("#dropdown");

            Select dropdowElem = new Select(driver.findElement(dropdownSel));

            dropdowElem.selectByValue("1");
            Thread.sleep(1000);
            dropdowElem.selectByValue("2");

            Thread.sleep(1000);

            dropdowElem.selectByIndex(1);
            Thread.sleep(1000);
            dropdowElem.selectByIndex(2);

            Thread.sleep(1000);

            dropdowElem.selectByVisibleText("Option 1");
            Thread.sleep(1000);
            dropdowElem.selectByVisibleText("Option 2");

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}
