package com.cybertek.reviews.day05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfElementsExample {
        WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod // less Code, closed even if failed,
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        Thread.sleep(1000);

        List<WebElement> elements = driver.findElements(By.cssSelector(".form-check-label"));// Alt+enter
        List<String> actualElementsStrings = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            actualElementsStrings.add(elements.get(i).getText());
        }

        // we did assertion one by one
        /*
        Assert.assertEquals(elements.get(0).getText(),"C++");
        Assert.assertEquals(elements.get(1).getText(),"Java");
        Assert.assertEquals(elements.get(2).getText(),"JavaScript");
        */
        List<String> expectedCodeNames = Arrays.asList("C++","Java","JavaScript"); // Java lazy way of creating a list
        // We did assertion as a List
        Assert.assertEquals(actualElementsStrings,expectedCodeNames); // you can not compare list of string to list of WebElement

    }
}
