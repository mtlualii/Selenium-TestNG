package com.cybertek.tests.day16_ddf;

import com.cybertek.base.TestBase;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object [][] userData() {

        ExcelUtil qa2short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA2-short");
        String[][] dataArray = qa2short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String username, String password, String firstname, String lastname) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullname = dashboardPage.getUserName();
        String expectedFullname = firstname+" "+lastname;

        Assert.assertEquals(actualFullname, expectedFullname, "Verify fullname");

    }


}
