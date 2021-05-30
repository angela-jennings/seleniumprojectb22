package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractice {
   //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    //3. Click to “Click for JS Alert” button
    //4. Click to OK button from the alert
    //5. Verify “You successfully clicked an alert” text is displayed.

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    @Test
    public void informationAlertPractice(){

        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        //3. Click to “Click for JS Alert” button
        informationAlertButton.click();

        //4. Click to OK button from the alert
        //switching drivers focus to alert so we can click on ok
        Alert alert = driver.switchTo().alert();
        //this allows us to accept and click ok
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String expTextForPopUp = "You successfuly clicked an alert"; //this has a typo on purpose
        WebElement actTextForPopUp = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(actTextForPopUp.isDisplayed(), "result text is not displayed on the page");

        Assert.assertEquals(actTextForPopUp.getText(), expTextForPopUp, "text match failed");
        //Assert.assertTrue(actTextForPopUp.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
