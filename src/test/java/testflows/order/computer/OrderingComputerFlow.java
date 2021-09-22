package testflows.order.computer;

import models.pages.computer.CheapComputerItemDetailsPage;
import models.pages.cart.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.purchasing.CheapComputer;
import testdata.purchasing.ComputerSpec;

public class OrderingComputerFlow {

    private final WebDriver driver;

    public OrderingComputerFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void buildCheapComputer(CheapComputer compData) {
        CheapComputerItemDetailsPage detailsPage = new CheapComputerItemDetailsPage(driver);

        // Build Comp specs
        detailsPage.computerEssentialComp().selectProcessorType(compData.getProcessorType());
        detailsPage.computerEssentialComp().selectRAM(compData.getRam());
        detailsPage.computerEssentialComp().selectHDD(compData.getHdd());

        // Add To cart
        detailsPage.computerEssentialComp().clickOnAddToCartBtn();
        try {
            detailsPage.waitUntilItemAddedToCart();
        } catch (Exception e) {
            throw new Error("[ERR] Item is not added after 15s!");
        }

    }

    public void verifyCheapComputerAdded(CheapComputer simpleComputer) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        // Get fixed price for this computer type
        final double fixedPrice = 800.0;

        // Get additional fee
        double additionalFees = 0.0;
        additionalFees += ComputerSpec.valueOf(simpleComputer.getProcessorType()).additionPrice();
        additionalFees += ComputerSpec.valueOf(simpleComputer.getRam()).additionPrice();
        additionalFees += ComputerSpec.valueOf(simpleComputer.getHdd()).additionPrice();

        // Get Total current price for computer
        double currentCompPrice = fixedPrice + additionalFees;

        // Compare
        double itemTotalPrice = shoppingCartPage.shoppingCartItemComp().itemTotalPrice();
        Assert.assertEquals(itemTotalPrice, currentCompPrice, "[ERR] Total price is not correct!");
    }
}
