package com.cybertek.tests.PracticeAutomation;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.SmartBearUtils;
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

public class SmartBearTasks {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("dataTablesURL");
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void testCase1(){
        SmartBearUtils.smartBearLogin(driver);
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links on page - " + allLinks.size());
        for(WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
        }
    }

    @Test
    public void testCase2(){
        SmartBearUtils.smartBearLogin(driver);
        SmartBearUtils.addItem(driver, "FamilyAlbum", "2");
        SmartBearUtils.inputField(driver);
        SmartBearUtils.paymentInformation(driver);
        Assert.assertEquals(driver.findElement(By.ByXPath.xpath("//strong")).getText(), "New order has been successfully added.");
    }

    @Test
    public void testCase3(){
        SmartBearUtils.smartBearLogin(driver);
        SmartBearUtils.customerOrderDate(driver, "Susan McLaren", "01/05/2010");
    }

    @Test
    public void testCase4(){
        SmartBearUtils.smartBearLogin(driver);
        SmartBearUtils.customerNameVerification(driver, "Susan McLaren");
    }

    @Test
    public void testCase5(){
        SmartBearUtils.smartBearLogin(driver);
        SmartBearUtils.printNamesAndCities(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
