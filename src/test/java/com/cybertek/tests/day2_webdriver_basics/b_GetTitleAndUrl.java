package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class b_GetTitleAndUrl {

    public static void main(String[] args) {

        // Task open chrome and navgiate to http://practice.cybertekschool.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://practice.cybertekschool.com");

        // Getting title with Selenium
        // Shortcut for creating variable
        // Option or ALt + enter enter
        // getTitle()--> get yoi the titel of the page  //soutv + enter to print variable name and value
        String title = driver.getTitle();
        System.out.println("title = " + title);

        //getCurrentUrl --> get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource() --> gets the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);





    }

}
