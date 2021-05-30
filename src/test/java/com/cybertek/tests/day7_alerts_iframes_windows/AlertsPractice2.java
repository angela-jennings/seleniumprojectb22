package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractice2 {

    //TC #3: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    //3. Click to “Click for JS Prompt” button
    //4. Send “hello” text to alert
    //5. Click to OK button from the alert
    //6. Verify “You entered: hello” text is displayed.

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void alertButtons() throws InterruptedException {

        //3. Click to “Click for JS Prompt” button
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptButton.click();
        Thread.sleep(2000);

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(2000);

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        String expText = "You entered: hello";
        WebElement actText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(actText.isDisplayed(), "text not displayed - test failed");
        Assert.assertEquals(actText.getText(), expText, "text does not match - test failed");

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
