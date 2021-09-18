package models.components.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductEssentialComponent {

    private final WebDriver driver;
    private final By addToCartBtnSel = By.cssSelector("[id^='add-to-cart-button']");

    public ProductEssentialComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddToCartBtn(){
        driver.findElement(addToCartBtnSel).click();
    }

}
