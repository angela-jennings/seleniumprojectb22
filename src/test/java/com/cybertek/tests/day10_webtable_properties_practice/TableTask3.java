package com.cybertek.tests.day10_webtable_properties_practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TableTask3 {
    //1. open browser and go to: http://practice.cybertekschool.com/tables#edit
    //2. locate first table and verify Tim has due amount of "$50"
    //Note: create locator for tim that will be dynamic and doesnt care which row tim is in

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("dataTablesURL");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void task3ReturnTimDueAmount(){
        WebElement timDueAmount = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]"));
    // //table[@id='table1']//td[.='Tim']/following-sibling::td[2]

        Assert.assertEquals(timDueAmount.getText(), "$50.00");

    }
}
