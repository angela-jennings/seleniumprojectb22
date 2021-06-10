package com.cybertek.tests.day10_webtable_properties_practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TableTask4 {
    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verifyOrder in TableUtils class.
    // •Method takes WebDriver object and String(name).
    // •Method should verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("dataTablesURL");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void tableTask4(){
        TableUtils.verifyOrder(driver, "Frank");
        TableUtils.verifyOrder(driver, "Angela");
    }
}
