package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.id("green"));

        //how to check any webelement is enabled or not?
        System.out.println("greenRadioButton = " + greenRadioButton.isEnabled());
        Assert.assertFalse(greenRadioButton.isEnabled(), "verfiy green radio button NOT enabled (disabled)");

        greenRadioButton.click();
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.sendKeys("some message");




    }


}
