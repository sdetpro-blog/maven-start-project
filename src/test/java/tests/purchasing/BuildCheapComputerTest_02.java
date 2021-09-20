package tests.purchasing;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        // Get the data as RAM_8GB to reuse from a question from a question in class
        if(referenceCompData == null && computerDataObject.getRam().equals(ComputerSpec.valueOf("RAM_8GB").name())){
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
        if(referenceCompData !=null){
            System.out.println("2ND TEST: " + referenceCompData.getRam());
        } else {
            Assert.fail("Test data is not ready!!");
        }
    }

    @DataProvider()
    public CheapComputer[] cheapCompsDataSet() {
        CheapComputer[] computerTestData =
                ComputerTestDataGenerator
                        .getTestDataFrom("/src/test/java/testdata/purchasing/CheapComputerDataList.json");
        return computerTestData;
    }

}
