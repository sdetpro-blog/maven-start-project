package tests.order;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.purchasing.ComputerDataObject;
import testdata.url.URL;
import testflows.order.computer.BuyingComputerFlow;
import tests.BaseTest;
import utils.data.ComputerTestDataGenerator;

import java.security.SecureRandom;

public class BuildCheapComputerTest extends BaseTest {

    @Test(dataProvider = "cheapCompsDataSet", description = "Buying a cheap computer")
    @Description(value = "Using a set of data with different computer specs and check total price in cart")
    public void testBuildingCheapComputer(ComputerDataObject computerDataObject) {
        WebDriver driver = getDriver(null);
        BuyingComputerFlow orderingComputerFlow = new BuyingComputerFlow(driver);

        // Go to cheap computer item page
        goTo(URL.CHEAP_COMP_DETAILS);
        orderingComputerFlow.buildCheapComputer(computerDataObject);

        // Go to Shopping cart Page
        goTo(URL.CART);
        orderingComputerFlow.verifyComputerAdded(computerDataObject);

    }

    @Test
    @Parameters({"browser"})
    public void testBuildingCheapComputerCrossBrowser(String browser) {
        ComputerDataObject[] computerTestData =
                ComputerTestDataGenerator
                        .getTestDataFrom("/src/test/java/testdata/purchasing/CheapComputerDataList.json");
        ComputerDataObject computerDataObject = computerTestData[new SecureRandom().nextInt(computerTestData.length)];

        WebDriver driver = getDriver(browser);
        BuyingComputerFlow orderingComputerFlow = new BuyingComputerFlow(driver);

        // Go to cheap computer item page
        goTo(URL.CHEAP_COMP_DETAILS);
        orderingComputerFlow.buildCheapComputer(computerDataObject);

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
