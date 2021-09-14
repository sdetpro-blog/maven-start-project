package core.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ActionBase {

    private final WebDriver driver;
    private ActionType actionType;
    private AssertionType assertionType;
    private By element;
    private String inputText;
    private String cssType;
    private String currentText;
    private String expectedText;
    private String containText;

    public ActionBase(WebDriver driver) {
        this.driver = driver;
    }

    /*
    * ELEMENT ACTION SCOPE
    * */

    public ActionBase input(String inputText){
        this.inputText = inputText;
        return this;
    }

    public void into(By element){
        this.element = element;
        performAction(ActionType.INPUT);
    }

    public void clickOn(By element){
        this.element = element;
        performAction(ActionType.CLICK);
    }

    public ActionBase getText(){
        this.actionType = ActionType.GET_TEXT;
        return this;
    }

    public ActionBase getCSS(String cssType){
        this.cssType = cssType;
        this.actionType = ActionType.GET_CSS;
        return this;
    }

    public String from(By element){
        String returnText = "";
        this.element = element;
        if(actionType.equals(ActionType.GET_TEXT))
            returnText = driver.findElement(element).getText();
        if(actionType.equals(ActionType.GET_CSS))
            returnText = driver.findElement(element).getCssValue(cssType);
        return returnText;
    }

    private void performAction(ActionType actionType) {
        if(actionType.equals(ActionType.INPUT))
            driver.findElement(element).sendKeys(inputText);
        if (actionType.equals(ActionType.CLICK))
            driver.findElement(element).click();
    }

    private enum ActionType {
        CLICK,
        INPUT,
        GET_TEXT,
        GET_CSS,
    }


    /*
    * BASE ASSERTION METHODs
    * */

    public ActionBase checkThat(String currentText){
        this.currentText = currentText;
        return this;
    }

    public ActionBase is(String expectedText){
        this.assertionType = AssertionType.EQUAL;
        this.expectedText = expectedText;
        return this;
    }

    public ActionBase contains(String containText){
        this.assertionType = AssertionType.CONTAINS;
        this.containText = containText;
        return this;
    }

    public void ifNot(String errMsg){
        if(assertionType.equals(AssertionType.EQUAL))
            Assert.assertEquals(currentText, expectedText, errMsg);
        if(assertionType.equals(AssertionType.CONTAINS)){
            boolean hasTheText = currentText.contains(containText);
            Assert.assertTrue(hasTheText, errMsg);
        }
    }

    private enum AssertionType {
        EQUAL,
        CONTAINS
    }

}
