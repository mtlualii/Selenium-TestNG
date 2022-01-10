package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class a_verifyURLnotChanged {

    public static void main(String[] args) {

        /* Verify URL not changed
            -open chrome Browser
            -go to http://practice.cybertekschool.com/forgot_password Links to an external source
            -click on Retrieve password
            -verify that url did not change
         */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to link
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save exprected url before clicking button
        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //save actual url after clicking button
        String actualURL = driver.getCurrentUrl();

        //verify that url did not change
        if(expectedUrl.equals(actualURL)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        //close
        driver.quit();


    }
}