package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class c_verifyConfirmationMessage {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "mike@smith.com";

        emailInputBox.sendKeys(expectedEmail);

       
        emailInputBox.getAttribute("value");

        //somehow we should get text from email box
        // --> two main ways to get txt from webelements
        //     --> 1.getText() - it will work %99 and it will return string
        //     --> 2.getAttribute("value") -->x second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        //verify that email is displayed in the input box
        if(expectedEmail.equals(actualEmail)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        //click on retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that confirmation message says 'Your e-mail's been sent'
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        System.out.println(actualConfirmationMessage.getText());

        //save expected message
        String expectedMessage = "Your e-mail's been sent!";
        //save actual message to variable
        String actualMessage = actualConfirmationMessage.getText();

        if(expectedMessage.equals(actualMessage)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        //close browser
        driver.quit();



    }

}
