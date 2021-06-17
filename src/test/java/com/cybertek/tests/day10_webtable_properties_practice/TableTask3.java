package com.cybertek.tests.day10_webtable_properties_practice;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTask3 extends TestBase {
    //1. open browser and go to: http://practice.cybertekschool.com/tables#edit
    //2. locate first table and verify Tim has due amount of "$50"
    //Note: create locator for tim that will be dynamic and doesnt care which row tim is in


    @Test
    public void task3ReturnTimDueAmount(){
        String url = ConfigurationReader.getProperty("dataTablesURL");
        driver.get(url);

        WebElement timDueAmount = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]"));
    // //table[@id='table1']//td[.='Tim']/following-sibling::td[2]

        Assert.assertEquals(timDueAmount.getText(), "$50.00");

    }
}
