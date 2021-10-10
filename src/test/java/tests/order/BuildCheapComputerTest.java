package tests.order;

import io.qameta.allure.Description;
import models.components.product.CheapComputerEssentialComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.purchasing.ComputerDataObject;
import testdata.url.URL;
import testflows.order.computer.BuyingComputerFlow;
import tests.BaseTest;
import utils.data.ComputerTestDataGenerator;


public class BuildCheapComputerTest extends BaseTest {

    @Test(dataProvider = "cheapCompsDataSet", description = "Buying a cheap computer")
    @Description(value = "Using a set of data with different computer specs and check total price in cart")
    public void testBuildingCheapComputer(ComputerDataObject computerDataObject) {
        WebDriver driver = getDriver();
//        CheapComputerEssentialComponent cheapComputerEssentialComponent = new CheapComputerEssentialComponent(driver);
        BuyingComputerFlow<CheapComputerEssentialComponent> orderingComputerFlow = new BuyingComputerFlow<>(driver);
//        BuyingComputerFlow orderingComputerFlow = new BuyingComputerFlow(driver, cheapComputerEssentialComponent);

        // Go to cheap computer item page
        goTo(URL.CHEAP_COMP_DETAILS);
        orderingComputerFlow.withComputerEssentialComp(CheapComputerEssentialComponent.class);
        orderingComputerFlow.buildComputerNormal(computerDataObject);

        // Go to Shopping cart Page
        goTo(URL.CART);
        orderingComputerFlow.verifyComputerAdded(computerDataObject);

    }

    @DataProvider()
    public ComputerDataObject[] cheapCompsDataSet() {
        ComputerDataObject[] computerTestData =
                ComputerTestDataGenerator
                        .getTestDataFrom("/src/test/java/testdata/purchasing/CheapComputerDataList.json");
        return computerTestData;
    }

}
