package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }

}
