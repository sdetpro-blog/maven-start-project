package tests.order;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.purchasing.ComputerDataObject;
import testflows.order.computer.OrderingComputerFlow;
import tests.BaseTest;
import utils.data.ComputerTestDataGenerator;

public class BuildStandardComputerTest extends BaseTest {

    @Test(dataProvider = "standardCompsDataSet")
    public void testBuildingStandardComputer(ComputerDataObject computerDataObject) {
        WebDriver driver = getDriver();
        OrderingComputerFlow orderingComputerFlow = new OrderingComputerFlow(driver);

        // Go to cheap computer item page
        driver.get("http://demowebshop.tricentis.com/build-your-own-computer");
        orderingComputerFlow.buildStandardComputer(computerDataObject);

        // Go to Shopping cart Page
        driver.get("http://demowebshop.tricentis.com/cart");
        orderingComputerFlow.verifyComputerAdded(computerDataObject);
    }

    @DataProvider()
    public ComputerDataObject[] standardCompsDataSet() {
        ComputerDataObject[] computerTestData =
                ComputerTestDataGenerator
                        .getTestDataFrom("/src/test/java/testdata/purchasing/StandardComputerDataList.json");
        return computerTestData;
    }

}
