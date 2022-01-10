package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1() {

        System.out.println("Open browser");

        System.out.println("First Assertion");
        Assert.assertEquals("title", "tiTle");  // it fails and does not execute more. !!!

        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test2() {
        System.out.println("Second Assertion");
    }

    @Test
    public void test3() {
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");
    }

    @Test
    public void test4() {
        //verify email contains @ sign
        String email = "mikesmith.com";  //
        Assert.assertTrue(email.contains("@"),  "vefiy email contains @");      // it is false, so error!
    }

    @Test
    public void test5() {
        Assert.assertFalse(0>1, "verfiy that 0 is not greater than 1"); // it is false, so no error!
    }

    @Test
    public void test6() {
        Assert.assertNotEquals("one","one"); // it fails, so  it gives error!

    }



    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }


}
