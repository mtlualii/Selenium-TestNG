package com.cybertek.tests.day7_testNG;

import org.apache.commons.compress.compressors.zstandard.ZstdUtils;
import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void beforeClass() {
        System.out.println("i am the powerful one");
    }

    @Test
    public void test1() {
        System.out.println("First Test Case");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Case");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("WebDriver, Opening Browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser, Quit");
    }

    @AfterClass
    public void tearDownAll() {
        System.out.println("I am the weakest one");
    }

}
