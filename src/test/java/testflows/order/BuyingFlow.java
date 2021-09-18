package testflows.order;

import org.openqa.selenium.WebDriver;

public class BuyingFlow {

    private final WebDriver driver;

    public BuyingFlow(WebDriver driver) {
        this.driver = driver;
    }

    public BuyingFlow buyItem(){
        return this;
    }

    public void verifyBuyItemSuccessfully(){

    }
}

