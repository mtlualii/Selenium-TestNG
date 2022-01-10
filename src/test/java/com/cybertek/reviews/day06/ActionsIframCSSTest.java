package com.cybertek.reviews.day06;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsIframCSSTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod // less Code, closed even if failed,
    public void tearDown() throws InterruptedException {

        // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        //2. Switch to iframe.
        //3. Double click on the text “Double-click me to change my text color.”
        //4. Assert: Text’s “style” attribute value contains “red”.

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        driver.findElement(By.id("accept-choices")).click();

        //2. Switch to iframe.
        driver.switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”

        Actions action = new Actions(driver);

        WebElement text = driver.findElement(By.id("demo"));

        action.doubleClick(text).perform();
        Thread.sleep(2000);

        String expectedStyle = "red";
        String actualStyle = text.getAttribute("style");

        //4. Assert: Text’s “style” attribute value contains “red”.
        Assert.assertTrue(actualStyle.contains(expectedStyle));

    }

}
