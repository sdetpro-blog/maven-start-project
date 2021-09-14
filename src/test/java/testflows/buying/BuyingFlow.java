package testflows.buying;

import org.openqa.selenium.WebDriver;
import testflows.authentication.LoginFlow;

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

