package apilearning;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {

    public static void main(String[] args) {

        WebDriver driver = Driver.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/checkboxes");

            By checkboxesSel = By.cssSelector("#checkboxes input");

            final int CHECKBOX_1_INDEX = 0;
            final int CHECKBOX_2_INDEX = 1;
            List<WebElement> checboxesElems = driver.findElements(checkboxesSel);
            WebElement checkBox01 = checboxesElems.get(CHECKBOX_1_INDEX);
            WebElement checkBox02 = checboxesElems.get(CHECKBOX_2_INDEX);

            System.out.println("========STATUS =========");

            System.out.println("Checkbox 01: " + checkBox01.isSelected());
            System.out.println("Checkbox 02: " + checkBox02.isSelected());

            checboxesElems.forEach(checkbox -> {
                if (!checkbox.isSelected())
                    checkbox.click();
            });

            Thread.sleep(3000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
