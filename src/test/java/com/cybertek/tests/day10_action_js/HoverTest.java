package com.cybertek.tests.day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {

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
    public void oneImage() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(driver);

        WebElement img1 = driver.findElement(By.tagName("img"));

        Thread.sleep(1000);
        actions.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(), "verify text 1 is displayed");

    }

    @Test
    public void threeImage() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(driver);

        for (int i = 1; i <= 3; i++) {
            String xpathImg = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(xpathImg));

            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String xpathText = "//h5[.='name: user" + i + "']";
            WebElement text = driver.findElement(By.xpath(xpathText));

            Assert.assertTrue(text.isDisplayed(), "verify user "+i+" is displayed");

        }





    }



}
