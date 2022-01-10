package com.cybertek.reviews.day03;

//1. Navigate to: https://moneygaming.qa.gameaccount.com/sign-up.shtml
//2. Enter your first name and surname in the form
//3. Verify the text of Checkbox with text 'I accept the Terms and Conditions and certify that I am over the age of 18.'
//4. Check and verify if it is selected
//4. Submit the form by clicking the JOIN NOW button
//5. Validate that a validation message with text ‘ This field is required’ appears under the date of
//   birth box

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoneyGaming {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://moneygaming.qa.gameaccount.com/sign-up.shtml");

        WebElement firstnameBox = driver.findElement(By.id("forename"));
        firstnameBox.sendKeys("ali");

        WebElement surnameBox = driver.findElement(By.name("map(lastName)"));
        surnameBox.sendKeys("mutlu");

        String expectedText = "I accept the Terms and Conditions and certify that I am over the age of 18.";
        WebElement actualText = driver.findElement(By.id("termsCheckbox"));

        Assert.assertTrue(actualText.getText().equals(expectedText),"sorun 1");

        WebElement checkBox = driver.findElement(By.xpath("//input[@name='map(terms)']"));
        checkBox.click();

        Assert.assertTrue(checkBox.isSelected(), "sorun 2");

        WebElement joinNowButton = driver.findElement(By.id("form"));
        joinNowButton.click();

        WebElement needText = driver.findElement(By.xpath("//label[@for='dob']"));
        String existingText = "Dieses Feld ist erforderlich";

        System.out.println(needText.getText());
        System.out.println(existingText);
        Assert.assertTrue(needText.getText().equals(existingText), "sorun 3");







    }

}


