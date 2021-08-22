package components.global;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class FooterTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testHomePageFooter(driver);
            testCategoryPageFooter(driver);
            testProductItemPageFooter(driver);
            testAboutUsPageFooter(driver);
        } finally {
            driver.quit();
        }

    }

    public static void testHomePageFooter(WebDriver driver) {
        // Navigate to About Us page
        driver.get("http://demowebshop.tricentis.com/");

        // Verification points
        footerInformationColumnTest(driver);
        footerCustomerServiceColumnTest(driver);
        footerMyAccountColumnTest(driver);
        footerFollowUsColumnTest(driver);
        footerPoweredByTest(driver);
        footerDisclaimerTest(driver);
    }

    public static void testCategoryPageFooter(WebDriver driver) {
        // Navigate to Category Page
    }

    public static void testProductItemPageFooter(WebDriver driver) {
    }

    public static void testAboutUsPageFooter(WebDriver driver) {

    }


    private static void footerInformationColumnTest(WebDriver driver){

    }

    private static void footerCustomerServiceColumnTest(WebDriver driver){


    }

    private static void footerMyAccountColumnTest(WebDriver driver){

    }

    private static void footerFollowUsColumnTest(WebDriver driver){

    }

    private static void footerPoweredByTest(WebDriver driver){

    }

    private static void footerDisclaimerTest(WebDriver driver){

    }
}
