package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = WebDriverFactory.getDriver("Chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/tables");
        }

        @AfterMethod // less Code, closed even if failed,
        public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }

        @Test
        public void printTable() throws InterruptedException {

            // Locating table 1
            WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
            // Printing it
            System.out.println(table.getText());
            // Verifying it with contain method but we are not going to use it - I think -
            Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

        }

        @Test
        public void getAllHeaders() throws InterruptedException {

            //how many columns we have?
            List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
            System.out.println("headers.size() = " + headers.size());

            //getting headers name
            for (WebElement header : headers) {
                System.out.println(header.getText());
            }



        }

        @Test
        public void printTableSize() throws InterruptedException {

            List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            System.out.println("allRowsWithoutHeaders = " + allRowsWithoutHeaders.size());

        }

        @Test
        public void getRow() throws InterruptedException {

            //getting second row
            WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
            System.out.println("secondRow: " + secondRow.getText());

            System.out.println("===================================");

            //getting all rows dynamically
            List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

            for(int i = 1; i <= allRows.size(); i++) {
                WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
                System.out.println(i + "-" + row.getText());
            }


        }

        @Test
        public void getAllCellinOneRow() throws InterruptedException  {

            List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
            for (WebElement element : allCellsInOneRow) {
                System.out.println(element.getText());
            }


        }

        @Test
        public void getASingleCellinOneRow() throws InterruptedException  {

            WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
            System.out.println("singleCell: " + singleCell.getText());

        }

        @Test
        public void printallCellsByIndex() {

            int rowNumber = getNumberOfRows();
            System.out.println("rowNumber = " + rowNumber);
            int colNumber = getNumberOfColumns();
            System.out.println("colNumber = " + colNumber);

            System.out.println("==================");

            for (int i = 1; i <= rowNumber; i++) {
                for (int j = 1; j <= colNumber; j++) {
                    String cellXpatH = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                    WebElement cell = driver.findElement(By.xpath(cellXpatH));
                    System.out.println(cell.getText());
                }

                System.out.println("=================");

            }
        }

        @Test
        public void getCellInRelationToAnotherCellInSameRow() {

            String firstName = "Jason";

            String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
            WebElement email = driver.findElement(By.xpath(xpath));
            System.out.println(email.getText());




        }


    private int getNumberOfColumns() {

        //how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        return headers.size();
    }

    private int getNumberOfRows() {

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        return allRows.size();
    }
}
