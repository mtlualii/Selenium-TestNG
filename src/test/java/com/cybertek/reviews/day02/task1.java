package com.cybertek.reviews.day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class task1 {

    //   - Basic login authentication
    //   Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //   Verify title equals: String expectedTitle = "Web Orders Login"
    //   Enter username: Tester
    //   Enter password: test
    //   Click “Sign In” button
    //   Verify title equals: String expectedHomePageTitle = "Web Orders"

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equalsIgnoreCase(expectedTitle)) {
            System.out.println("PASSED");
        }

        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");

        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

        actualTitle = driver.getTitle();
        String expectedHomePageTitle = "Web Orders";

        if(actualTitle.equalsIgnoreCase(expectedHomePageTitle)) {
            System.out.println("PASSED");
        }

        driver.close();










    }
}

