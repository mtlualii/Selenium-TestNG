package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons
        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        System.out.println(blueRadioButton.isSelected());
        System.out.println(redRadioButton.isSelected());

        System.out.println("blueRadioButton = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton = " + redRadioButton.isSelected());

        //verify blue is selected, red is not selected
        Assert.assertTrue(blueRadioButton.isSelected(), "verify that blue is selected"); // blue true
        Assert.assertFalse(redRadioButton.isSelected(), "verify that red is not selected"); // not red true, red false

        // now clicking red button
        redRadioButton.click();

        Assert.assertFalse(blueRadioButton.isSelected(), "verify that blue is not selected"); // not blue true, blue false
        Assert.assertTrue(redRadioButton.isSelected(), "verify that red is selected"); // red true

        Thread.sleep(3000);
        driver.quit();


    }

}
