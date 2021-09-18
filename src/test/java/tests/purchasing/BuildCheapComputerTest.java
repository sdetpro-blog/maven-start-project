package tests.purchasing;

import driver.DriverFactory;
import models.components.cart.ShoppingCartItemComponent;
import models.components.product.ComputerEssentialComponent;
import models.components.product.ProductEssentialComponent;
import models.pages.ItemDetailsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.purchasing.ComputerSpec;

public class BuildCheapComputerTest {

    @Test(groups = "smoke")
    public void testBuildComputer() throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("http://demowebshop.tricentis.com/build-your-cheap-own-computer");

            ComputerEssentialComponent specComponent = new ComputerEssentialComponent(driver);
            specComponent.selectProcessorType(ComputerSpec.PROCESSOR_FAST.value());
            specComponent.selectRAM(ComputerSpec.RAM_8GB.value());
            specComponent.selectHDD(ComputerSpec.HDD_400GB.value());

            ProductEssentialComponent productEssentialComponent = new ProductEssentialComponent(driver);
            productEssentialComponent.clickOnAddToCartBtn();

            ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
            if (itemDetailsPage.isMyItemAddedToCart()) {
                driver.get("http://demowebshop.tricentis.com/cart");
                ShoppingCartItemComponent shoppingCartItemComponent = new ShoppingCartItemComponent(driver);
                double currentItemTotalPrice = shoppingCartItemComponent.itemTotalPrice();

                final double simpleComputerFixedPrice = 800.00;
                double expectedTotalCompPrice =
                        simpleComputerFixedPrice
                                + ComputerSpec.PROCESSOR_FAST.additionPrice()
                                + ComputerSpec.RAM_8GB.additionPrice()
                                + ComputerSpec.HDD_400GB.additionPrice();
                Assert.assertEquals(expectedTotalCompPrice, currentItemTotalPrice, "[ERR] Total Item price is wrong");
            } else {
                Assert.fail("[ERR] Item was not added to cart successfully!");
            }

            Thread.sleep(3000);
        } finally {
            driver.quit();
        }

    }
}
