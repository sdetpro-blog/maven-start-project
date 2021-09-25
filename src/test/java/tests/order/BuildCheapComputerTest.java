package tests.order;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.purchasing.ComputerDataObject;
import testflows.order.computer.OrderingComputerFlow;
import tests.BaseTest;
import utils.data.ComputerTestDataGenerator;

public class BuildCheapComputerTest extends BaseTest {

    @Test(dataProvider = "cheapCompsDataSet")
    public void testBuildingCheapComputer(ComputerDataObject computerDataObject) {
        WebDriver driver = getDriver();
        OrderingComputerFlow orderingComputerFlow = new OrderingComputerFlow(driver);

        // Go to cheap computer item page
        driver.get("http://demowebshop.tricentis.com/build-your-cheap-own-computer");
        orderingComputerFlow.buildCheapComputer(computerDataObject);

        // Go to Shopping cart Page
        driver.get("http://demowebshop.tricentis.com/cart");
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