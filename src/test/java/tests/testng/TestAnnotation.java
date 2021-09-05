package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnotation {


    @Test(priority = 2)
    public void z(){
        System.out.println(">>>> testAnnotation ZZZZZ");
        // Verify sth

        // Verify another thing

        Assert.fail();
    }

    @Test(priority = 1, dependsOnMethods = {"z"}, alwaysRun = true)
    public void a(){
        System.out.println(">>>> test2ndAnnotation AAAAA");
    }

}
