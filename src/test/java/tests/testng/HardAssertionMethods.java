package tests.testng;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HardAssertionMethods {

    @Test
    public void test01(){
        // .getText()
        String currentWelcomeMsg = "hello";

        // Get from Test data
        String expectedWelcomeMsg = "hello";

        Assert.assertEquals(currentWelcomeMsg, expectedWelcomeMsg, "[ERR] Wrong welcome message!");


        List<WebElement> popularTags = new ArrayList<>();
        if(popularTags.isEmpty())
            Assert.fail("[ERR] There is NO popular tags");

        boolean isListEmpty = popularTags.isEmpty();
        Assert.assertFalse(isListEmpty, "[ERR] There is NO popular tags");

        // Randomly click
    }
}
