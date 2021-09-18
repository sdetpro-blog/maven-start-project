package models.components.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputerEssentialComponent extends ProductEssentialComponent {

    private final WebDriver driver;

    public ComputerEssentialComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectProcessorType(String type) {
        selectCompSpecOption(type);
    }

    public void selectRAM(String type) {
        selectCompSpecOption(type);
    }

    public void selectHDD(String type) {
        selectCompSpecOption(type);
    }

    public void selectSoftware(String type) {
        selectCompSpecOption(type);
    }

    private void selectCompSpecOption(String option){
        String selectorString = "//label[contains(text(), \"" + option + "\")]";
        By optionSel = By.xpath(selectorString);
        driver.findElement(optionSel).click();
    }
}
