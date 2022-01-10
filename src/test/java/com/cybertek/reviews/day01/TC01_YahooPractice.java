package com.cybertek.reviews.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_YahooPractice {

    public static void main(String[] args) throws InterruptedException {

        //1.Open Chrome Browser
        //setup browser
        WebDriverManager.chromedriver().setup();
        //initialize driver object
        WebDriver driver = new ChromeDriver();

        //2. Go to https://www.yahoo.com

        driver.get("https://www.yahoo.com");

        //expected String
        String expectedTitle = "Yahoo";

        //actual String
        String actualTitle = driver.getTitle();

        //verification

        if(actualTitle.contains(expectedTitle)) {
            System.out.println("Title is as expected. Verification passed");
        } else {
            System.out.println("Title is not as expected. Verification did NOT passed");
        }

        Thread.sleep(2000);

        driver.close();







    }

}
