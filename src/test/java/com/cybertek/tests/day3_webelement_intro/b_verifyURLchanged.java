package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class b_verifyURLchanged {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //open chrome browser
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys() --> send keyboard action to the webelement
        emailInputBox.sendKeys("mike@smith.com");

        //click on retrieve password
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        //veriy that url changed
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(expectedUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }





    }


}
