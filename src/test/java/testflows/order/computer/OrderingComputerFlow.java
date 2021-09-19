package testflows.order.computer;

import models.pages.ComputerItemDetailsPage;
import models.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.purchasing.CheapComputer;
import testdata.purchasing.ComputerSpec;

public class OrderingComputerFlow {

    private final WebDriver driver;

    public OrderingComputerFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void buildSimpleComputer(CheapComputer compData) {
        ComputerItemDetailsPage detailsPage = new ComputerItemDetailsPage(driver);

        // Build Comp specs
        detailsPage.computerEssentialComp().selectProcessorType(compData.getProcessorType());
        detailsPage.computerEssentialComp().selectRAM(compData.getRam());
        detailsPage.computerEssentialComp().selectHDD(compData.getHdd());

        // Add To cart
        detailsPage.computerEssentialComp().clickOnAddToCartBtn();
        try {
            detailsPage.waitUntilItemAddedToCart();
        }catch (Exception e){
            throw new Error("[ERR] Item is not added after 15s!");
        }

    }

    public void verifySimpleComputerAdded(CheapComputer simpleComputer){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        // Get fixed price for this computer type
        final double fixedPrice = 800.0;

        // Get additional fee
        double additionalFees = 0.0;
        if(simpleComputer.getProcessorType().equals(ComputerSpec.PROCESSOR_FAST.value()))
            additionalFees += ComputerSpec.PROCESSOR_FAST.additionPrice();
        if(simpleComputer.getProcessorType().equals(ComputerSpec.PROCESSOR_MEDIUM.value()))
            additionalFees += ComputerSpec.PROCESSOR_MEDIUM.additionPrice();

        if(simpleComputer.getRam().equals(ComputerSpec.RAM_4GB.value()))
            additionalFees += ComputerSpec.RAM_4GB.additionPrice();
        if(simpleComputer.getRam().equals(ComputerSpec.RAM_8GB.value()))
            additionalFees += ComputerSpec.RAM_8GB.additionPrice();

        if(simpleComputer.getHdd().equals(ComputerSpec.HDD_320GB.value()))
            additionalFees += ComputerSpec.HDD_320GB.additionPrice();
        if(simpleComputer.getHdd().equals(ComputerSpec.HDD_400GB.value()))
            additionalFees += ComputerSpec.HDD_400GB.additionPrice();

        // Get Total current price for computer
        double currentCompPrice = fixedPrice + additionalFees;

        // Compare
        double itemTotalPrice = shoppingCartPage.shoppingCartItemComp().itemTotalPrice();
        Assert.assertEquals(itemTotalPrice, currentCompPrice, "[ERR] Total price is not correct!");
    }
}
