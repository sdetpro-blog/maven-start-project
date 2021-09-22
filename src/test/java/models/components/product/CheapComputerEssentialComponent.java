package models.components.product;

import org.openqa.selenium.WebDriver;

public class CheapComputerEssentialComponent extends ComputerEssentialComponent {

    private final WebDriver driver;

    public CheapComputerEssentialComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectProcessorType(String type) {
        selectCompSpecOption(type);
    }

    public void selectRAM(String type) {
        selectCompSpecOption(type);
    }

}
