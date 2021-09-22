package models.components.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.purchasing.ComputerSpec;

public abstract class ComputerEssentialComponent {

    private final WebDriver driver;
    private final By addToCartBtnSel = By.cssSelector("[id^='add-to-cart-button']");

    public ComputerEssentialComponent(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void selectProcessorType(String type);
    public abstract void selectRAM(String type);

    public void selectHDD(String type) {
        selectCompSpecOption(type);
    }

    public void selectSoftware(String type) {
        selectCompSpecOption(type);
    }

    protected void selectCompSpecOption(String option){
        String optionValue =  ComputerSpec.valueOf(option).value();
        String selectorString = "//label[contains(text(), \"" + optionValue + "\")]";
        By optionSel = By.xpath(selectorString);
        driver.findElement(optionSel).click();
    }

    public void clickOnAddToCartBtn(){
        driver.findElement(addToCartBtnSel).click();
    }

}
