package com.cybertek.reviews.day06;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Scrolling_Text {

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

            driver.quit();
        }

        @Test
        public void testWithActionClass() throws InterruptedException {

            // Elementi bulup, onun oldugu yere kadar gitme metodu

            // Scroll down to "Powered By Cybertek School"
            Actions actions = new Actions(driver);

            // Locate the element that you will scrool to
            WebElement cybertekSchoolElement = driver.findElement(By.linkText("Cybertek School"));

            //scroll using the actions object, using moveToElement method

            actions.moveToElement(cybertekSchoolElement).perform();

            Thread.sleep(2000);

            actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

            Thread.sleep(2000);

            actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        }

        @Test
        public void scrollTestWithJSE() throws  InterruptedException {

            // JSE kullanarak scroll metodu

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //going all the way down
            jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
            Thread.sleep(2000);

            //going all the way up
            jse.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
            Thread.sleep(2000);
        }
}
