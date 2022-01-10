package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUploadTest {

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
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //sending file with sendKeys method

        //creating document path dynamically
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath + "/" + filePath;

        chooseFile.sendKeys(fullPath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the name of file
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFileName, "textfile.txt");


    }
}
