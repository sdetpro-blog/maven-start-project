package testflows.order.computer;

import models.components.product.ComputerEssentialComponent;
import models.pages.ItemDetailsPage;
import models.pages.computer.CheapComputerItemDetailsPage;
import models.pages.cart.ShoppingCartPage;
import models.pages.computer.StandardComputerItemDetailsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.purchasing.ComputerDataObject;
import testdata.purchasing.ComputerSpec;

import java.lang.reflect.InvocationTargetException;

public class BuyingComputerFlow<T extends ComputerEssentialComponent> {

    private final WebDriver driver;
    private T essentialCompGeneric;
    ComputerEssentialComponent essentialComponentNormal;

    public BuyingComputerFlow(WebDriver driver) {
        this.driver = driver;
    }

//    public BuyingComputerFlow(WebDriver driver, ComputerEssentialComponent essentialComponentNormal) {
//        this.driver = driver;
//        this.essentialComponentNormal = essentialComponentNormal;
//    }

    public BuyingComputerFlow<T> withComputerEssentialComp(Class<T> computerType) {
        try {
            essentialCompGeneric = computerType.getConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return this;
    }

    public void buildComputerNormal(ComputerDataObject compData) {
        ItemDetailsPage detailsPage = new ItemDetailsPage(driver);

        // Build Comp specs
        essentialComponentNormal.selectProcessorType(compData.getProcessorType());
        essentialComponentNormal.selectRAM(compData.getRam());
        essentialComponentNormal.selectHDD(compData.getHdd());

        // Add To cart
        essentialComponentNormal.clickOnAddToCartBtn();
        try {
            detailsPage.waitUntilItemAddedToCart();
        } catch (Exception e) {
            throw new Error("[ERR] Item is not added after 15s!");
        }
    }

    public void buildComputerGeneric(ComputerDataObject compData) {
        if (essentialCompGeneric == null) {
            throw new RuntimeException("Please call withComputerType to specify computer type!");
        }
        ItemDetailsPage detailsPage = new ItemDetailsPage(driver);

        // Build Comp specs
        essentialCompGeneric.selectProcessorType(compData.getProcessorType());
        essentialCompGeneric.selectRAM(compData.getRam());
        essentialCompGeneric.selectHDD(compData.getHdd());

        // Add To cart
        essentialCompGeneric.clickOnAddToCartBtn();
        try {
            detailsPage.waitUntilItemAddedToCart();
        } catch (Exception e) {
            throw new Error("[ERR] Item is not added after 15s!");
        }
    }

    // TODO: Below are duplicated code and we will comeback to refactor later
    public void buildStandardComputer(ComputerDataObject compData) {
        StandardComputerItemDetailsPage detailsPage = new StandardComputerItemDetailsPage(driver);

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

    public void verifyComputerAdded(ComputerDataObject simpleComputer) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        // TODO: need to handle this price
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
