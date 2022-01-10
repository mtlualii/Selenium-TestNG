package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object [][] testData() {

        String [][] data = {
                {"Person of Interest", "10"},
                {"Sherlock", "9"},
                {"Breaking Bad", "9"},
                {"Office", "5"},
                {"Westworld", "4"},
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String tvshow, String rating) {
        System.out.println("Tv show: "+ tvshow + " has rating " + rating);
    }


}
