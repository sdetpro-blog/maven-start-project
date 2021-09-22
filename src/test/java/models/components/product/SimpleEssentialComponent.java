package models.components.product;

import org.openqa.selenium.WebDriver;

public class SimpleEssentialComponent extends ComputerEssentialComponent {

    private final WebDriver driver;

    public SimpleEssentialComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectProcessorType(String type) {
        selectCompSpecOptionDropdown(type);
    }

    public void selectRAM(String type) {
        selectCompSpecOptionDropdown(type);
    }

    private void selectCompSpecOptionDropdown(String type){

    }

}
