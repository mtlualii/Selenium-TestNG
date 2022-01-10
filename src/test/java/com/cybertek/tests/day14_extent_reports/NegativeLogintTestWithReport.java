package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogintTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username: user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click login Button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong password Test is Passed");

    }

    @Test
    public void wrongUsernameTest() {

        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter Username: someuusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Etner Password: UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("Click login Button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Username Test is Passed");
    }

}
