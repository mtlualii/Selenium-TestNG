package com.cybertek.reviews.day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class task2 {

    /* http://practice.cybertekschool.com/multiple_buttons

        - click on botton1 with xpath locator
        Verify Expected: Clicked on button one!

        */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.manage().window().maximize();
        String expectedMessage = "Clicked on button one!";

        WebElement button1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        button1.click();


        WebElement confirmationMessageGetter = driver.findElement(By.id("result"));
        String confirmationMessage = confirmationMessageGetter.getText();

        if(confirmationMessage.equals(expectedMessage)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }






    }
}
