package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod // less Code, closed even if failed,
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. Locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        // 2. Create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());

        // Print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. Locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        // 2. Create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        // Verify that first selection is "Select a State"
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        // How to select options from dropdown. 3 Options
        // 1. Select using visible text
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        // 2. Select using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        // 3. Select by Value
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");

        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

    }



}
