package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod // less Code, closed even if failed,
    public void tearDown() throws InterruptedException {
        // Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        // How to wait Explicitly?
        // create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("Mike Smith");
        Thread.sleep(1000);

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.xpath("//*[.='Enable']")).click();

        //finding inputBox
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        // creating object to use WebDriverWait Class
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // giving wait condition
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("MikeSmith");
        Thread.sleep(1000);

    }
}
