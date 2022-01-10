package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

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
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=bbaba");

        // Click confirm button
        driver.findElement(By.xpath("//button[.='Confirm']")).click();
        // Click "No" button
        driver.findElement(By.xpath("//button[.='No']")).click();




    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        // click "Click for JS AlertButton"
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        // click "Click for JS Confirm"
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        // click "Click for JS Prompt"
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        // Send keys to JS Prompt then confirm it
        alert.sendKeys("Wololo");
        alert.accept();

    }
}
