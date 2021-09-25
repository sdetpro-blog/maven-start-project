package apilearning;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class DropDownMultiple {

    public static void main(String[] args) {

        WebDriver driver = Driver.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/dropdown");
            By dropdownSel1 = By.cssSelector("#dropdown");
            By dropdownSel2 = By.cssSelector("#dropdown");

            Select dropdownElem1 = new Select(driver.findElement(dropdownSel1));
            Select dropdownElem2 = new Select(driver.findElement(dropdownSel2));

            String firstOption = "High";
            dropdownElem1.selectByVisibleText(firstOption);

            if(firstOption.equals("High")){
                dropdownElem2.selectByVisibleText("Most Relevant");
            } else {
                dropdownElem2.selectByVisibleText("Sth else");
            }

            Map<String, Map<String, String>> selectPatterns = new HashMap<>();

            Map<String, String> firstPattern = new HashMap<>();
            firstPattern.put("option_01", "Select 01");
            firstPattern.put("option_02", "Select 02");

            Map<String, String> secondPattern = new HashMap<>();
            secondPattern.put("option_01", "Select 01_01");
            secondPattern.put("option_02", "Select 02_02");

            selectPatterns.put("pattern_01", firstPattern);
            selectPatterns.put("pattern_02", secondPattern);

            Map<String, String> selectedPattern = selectPatterns.get("pattern_01");
            dropdownElem1.selectByVisibleText(selectedPattern.get("option_01"));
            dropdownElem1.selectByVisibleText(selectedPattern.get("option_02"));


            // Drop 01: 1-1
            // Drop 02: 2-1
            //
            // Drop 01: 1-2
            // Drop 02: 2-2



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}
