package com.cybertek.tests.day15_review;

import com.cybertek.base.TestBase;
import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void test() {

        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesMng();
        extentLogger.info("username: " + ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("password: " + ConfigurationReader.get("salesmanager_password"));
        extentLogger.info("Login as a Sales Manager");

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to --> Customers > Contacts");
        dashboardPage.navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verifying informations");
        Assert.assertEquals(actualFullName,expectedFullName,"verify full name");
        Assert.assertEquals(contactInfoPage.email.getText(), "mbrackstone9@example.com", "Verify email");
        Assert.assertEquals(contactInfoPage.phone.getText(), "+18982323434", "verfiy phone number ");


        extentLogger.pass("PASSED");


    }





}
