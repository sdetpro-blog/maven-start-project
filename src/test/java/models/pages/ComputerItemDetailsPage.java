package models.pages;

import models.components.product.ComputerEssentialComponent;
import org.openqa.selenium.WebDriver;

public class ComputerItemDetailsPage extends ItemDetailsPage {

    private final WebDriver driver;
    private ComputerEssentialComponent computerEssentialComp;

    public ComputerItemDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ComputerEssentialComponent computerEssentialComp(){
        return new ComputerEssentialComponent(driver);
    }
}
