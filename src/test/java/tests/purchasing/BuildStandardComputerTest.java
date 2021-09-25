package tests.purchasing;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.purchasing.ComputerDataObject;
import testflows.order.computer.OrderingComputerFlow;
import utils.data.ComputerTestDataGenerator;

public class BuildStandardComputerTest {

    @Test(dataProvider = "standardCompsDataSet")
    public void testBuildingStandardComputer(ComputerDataObject computerDataObject) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            OrderingComputerFlow orderingComputerFlow = new OrderingComputerFlow(driver);

            // Go to cheap computer item page
            driver.get("http://demowebshop.tricentis.com/build-your-own-computer");
            orderingComputerFlow.buildStandardComputer(computerDataObject);

            // Go to Shopping cart Page
            driver.get("http://demowebshop.tricentis.com/cart");
            orderingComputerFlow.verifyCheapComputerAdded(computerDataObject);
        } finally {
            driver.quit();
        }
    }

    @DataProvider()
    public ComputerDataObject[] standardCompsDataSet() {
        ComputerDataObject[] computerTestData =
                ComputerTestDataGenerator
                        .getTestDataFrom("/src/test/java/testdata/purchasing/StandardComputerDataList.json");
        return computerTestData;
    }

}
