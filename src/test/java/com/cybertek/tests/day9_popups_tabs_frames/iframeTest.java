package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

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

        driver.get("http://practice.cybertekschool.com/iframe");

        // How to switch frames
        // 1. Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        // clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);

        // sendkeys now
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        // first way to goes back to first frame (main HTML)
        // goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        // 2. Switching with INDEX
        driver.switchTo().frame(0);  // we are not counting the main iframe!!! Thats why we have just 1, index 0.

        // clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with INDEX");

        // second way to switch parent
        driver.switchTo().parentFrame();

        // 3. Using WebElement
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with INDEX");
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/nested_frames");

        // switching to frame top
        driver.switchTo().frame("frame-top");
        // top has 3 frame under left middle and right
        // switch to frame middle
        driver.switchTo().frame("frame-middle");

        // Getting Text
        System.out.println(driver.findElement(By.id("content")).getText());

        //goes back to top frame - YOU GO to PARENT frame
        driver.switchTo().parentFrame();

        // switching right with index
        driver.switchTo().frame(2);

        // Getting Text
        System.out.println(driver.findElement(By.tagName("body")).getText());

        // goes back to default frame - YOU GO ALL THE WAY UP
        driver.switchTo().defaultContent();

        // switching to frame bottom
        driver.switchTo().frame(1);

        // Getting Text
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }

}
