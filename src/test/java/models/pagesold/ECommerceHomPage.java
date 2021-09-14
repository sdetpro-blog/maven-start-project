package models.pagesold;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ECommerceHomPage {

    private final WebDriver driver;
    private final By searchTxtBxSel = By.cssSelector("#small-searchterms");
    private final By searchBtnSel = By.cssSelector("form[action='/search'] .search-box-button");

    public ECommerceHomPage(WebDriver driver) {
        this.driver = driver;
    }

    // Service Method
    public void inputProductNameAndSearch(String productName){
        this.inputSearchKeywords(productName);
        this.clickOnSearchBtn();
    }

    // Support Methods
    private void inputSearchKeywords(String productName) {
        this.driver.findElement(searchTxtBxSel).sendKeys(productName);
    }

    private void clickOnSearchBtn() {
        this.driver.findElement(searchBtnSel).click();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();

        driver.get("http://demowebshop.tricentis.com/");
        ECommerceHomPage eCommerceHomPage = new ECommerceHomPage(driver);
        eCommerceHomPage.inputProductNameAndSearch("Laptop");
    }

}
