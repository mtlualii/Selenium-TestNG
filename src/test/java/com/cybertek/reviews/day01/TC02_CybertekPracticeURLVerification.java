package com.cybertek.reviews.day01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC02_CybertekPracticeURLVerification {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // to maximize web page
        driver.manage().window().maximize();

        // go to website
        driver.get("http://practice.cybertekschool.com");

       String expectedInUrl = "cybertekschool";

       String actualUrl = driver.getCurrentUrl();

       if(actualUrl.contains(expectedInUrl)) {
           System.out.println("URL verification is passed");
       } else {
           System.out.println("URL verification FAILED");
       }

       driver.quit();






    }
}
