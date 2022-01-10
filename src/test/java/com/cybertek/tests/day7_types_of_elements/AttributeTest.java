package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        blueRadioButton.getAttribute("value");

        //get the value of type attribute
        System.out.println(blueRadioButton.getAttribute("type"));
        //get the value of name attribute
        System.out.println(blueRadioButton.getAttribute("name"));
        //since checked attribute does not keep any value, it will return true or false based on ..
        System.out.println(blueRadioButton.getAttribute("checked"));

        //trying to get attribute that does not exist
        System.out.println(blueRadioButton.getAttribute("href")); // it returns null

        System.out.println(blueRadioButton.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("Inner HTML: " + button2.getAttribute("innerHTML"));

        driver.quit();


    }

}
