package tests.testng;

import org.testng.annotations.*;

public class TestNGHooks {

//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("beforeMethod");
//    }
//
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("afterMethod");
//    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest 001");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass 001");
    }

    @Test
    public void test1(){
        System.out.println("Test Method 01>>>>>>");
    }

    @Test
    public void test2(){
        System.out.println("Test Method 02>>>>>>");
    }

}
