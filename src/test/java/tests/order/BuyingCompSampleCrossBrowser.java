package tests.order;

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

public class BuyingCompSampleCrossBrowser extends BaseTest {

    @Test
    @Parameters({"browser"})
    public void testBuildingCheapComputer(String browser) {
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

}
