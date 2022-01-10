package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //verify username inputbox is not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(), "verify username button is not displayed");

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        Thread.sleep(7000);

        Assert.assertTrue(usernameInput.isDisplayed(), "verify username button is displayed");

        Thread.sleep(2000);

        driver.quit();


    }

}
