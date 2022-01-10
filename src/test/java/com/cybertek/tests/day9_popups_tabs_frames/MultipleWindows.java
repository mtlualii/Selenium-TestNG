package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void SwitchWindowsTest() {

        driver.get("http://practice.cybertekschool.com/windows");

        // get title and print it
        System.out.println("Title before new window: " + driver.getTitle());

        // click "Click Here"
        driver.findElement(By.linkText("Click Here")).click();

        // get new title and print it
        System.out.println("Title after new window: " + driver.getTitle());

        // get newest title and print it
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle()); // it gives the same. We need the other windows title!

        String currentWindowHandle = driver.getWindowHandle(); // get the handle of currentwindow

        Set<String> windowHandles = driver.getWindowHandles(); // get the all handle of all windows

        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(currentWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }

        // get newest title and print it. NOW it gives the true title!
        System.out.println("Title after new window: " + driver.getTitle());

    }

    @Test
    public void moreThan2Window() {

        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Before switch: " + driver.getTitle());
        
        Set<String> windowHandles = driver.getWindowHandles(); // get the all handle of all windows

        // loop through each window
        for (String windowHandle : windowHandles) {
            //one by one change it
            driver.switchTo().window(windowHandle);

            //whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")) {
                //stop on that window
                break;
            }
        }

        System.out.println("After Switch: " + driver.getTitle());
        
    }
}
