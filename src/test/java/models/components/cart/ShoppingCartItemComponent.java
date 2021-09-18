package models.components.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartItemComponent {

    private final WebDriver driver;
    private final By itemTotalPriceSel = By.className("product-subtotal");

    public ShoppingCartItemComponent(WebDriver driver) {
        this.driver = driver;
    }

    public Double itemTotalPrice(){
        String itemTotalPriceStr = driver.findElement(itemTotalPriceSel).getText();
        return Double.parseDouble(itemTotalPriceStr);
    }
}
