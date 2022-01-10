package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/* VERIFY RADIO BUTTONS

    Open Chrome Browser
    Login as Driver
    Go to Activities --> Calendar Events
    Click on create calendar evetns
    Click on repeat
    Verify that repeat every days is checked
    Verify that repeat weekday is not checked
    */

public class RepeatOptionsTests extends TestBase {

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent, 5);
        calendarEventsPage.createCalendarEvent.click();


        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "verify every days is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "verify weekdays is not checked");

    }

    @Test
    public void test2() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent, 5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();

        List<WebElement> actualOptions =  repeatsDropdown.getOptions();
        /*List<String> actualList = new ArrayList<>();
        for (WebElement options : actualOptions) {
            actualList.add(options.getText());
        }
        */

        List<String> actualList = BrowserUtils.getElementsText(actualOptions);

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        Assert.assertEquals(actualList,expectedList, "verify dropdown list");






    }

}
