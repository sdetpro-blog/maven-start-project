package models.pages.computer;

import models.components.product.SimpleEssentialComponent;
import models.pages.ItemDetailsPage;
import org.openqa.selenium.WebDriver;

public class ComputerItemDetailsPage extends ItemDetailsPage {

    private final WebDriver driver;

    public ComputerItemDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SimpleEssentialComponent computerEssentialComp(){
        return new SimpleEssentialComponent(driver);
    }
}
