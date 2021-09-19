package tests.purchasing;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.purchasing.CheapComputer;
import testdata.purchasing.ComputerSpec;
import testflows.order.computer.OrderingComputerFlow;
import utils.data.ComputerTestDataGenerator;

public class BuildCheapComputerTest_02 {

    private CheapComputer referenceCompData;

    @Test(dataProvider = "cheapCompsDataSet")
    public void testBuildingCheapComputer(CheapComputer computerDataObject) {
        if(referenceCompData == null && computerDataObject.getRam().equals(ComputerSpec.RAM_8GB.value())){
            referenceCompData = computerDataObject;
        }
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            OrderingComputerFlow orderingComputerFlow = new OrderingComputerFlow(driver);

            // Go to cheap computer item page
            driver.get("http://demowebshop.tricentis.com/build-your-cheap-own-computer");
            orderingComputerFlow.buildSimpleComputer(computerDataObject);

            // Go to Shopping cart Page
            driver.get("http://demowebshop.tricentis.com/cart");
            orderingComputerFlow.verifySimpleComputerAdded(computerDataObject);
        } finally {
            driver.quit();
        }
    }

    @Test(dependsOnMethods = "testBuildingCheapComputer")
    public void testBuildingCheapComputer_02() {
        System.out.println("2ND TEST: " + referenceCompData.getRam());
    }

    @DataProvider()
    public CheapComputer[] cheapCompsDataSet() {
        CheapComputer[] computerTestData =
                ComputerTestDataGenerator
                        .getTestDataFrom("/src/test/java/testdata/purchasing/CheapComputerDataList.json");
        return computerTestData;
    }

}
