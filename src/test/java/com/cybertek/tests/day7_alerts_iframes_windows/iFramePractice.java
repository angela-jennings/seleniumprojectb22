package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFramePractice {
    WebDriver driver;

    //TC #4 : Iframe practice
    //1. Create a new class called: IframePractice
    //2. Create new test and make set ups
    //3. Go to: http://practice.cybertekschool.com/iframe
    //4. Assert: “Your content goes here.” Text is displayed.
    //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void iframeTest(){
        //#1 - changing to iframe by index: we pass index number
        //driver.switchTo().frame(0);

        //#2 - locate as a web element to switch
        //find and locate <iframe> web element from the page
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //driver.switchTo().frame(iframe);

        //#3 - if <iframe> tag has id or name attribute, we can pass its attribute value as a string into .switchTo()         .frame() method directly
        driver.switchTo().frame("mce_0_ifr");

        //locating web element text
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed(), "this will only be displayed if test fails");
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
        //both do same job ^^

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        WebElement headerText = driver.findElement(By.xpath("//h3"));
        String actHeaderText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(headerText.getText(), actHeaderText, "this will only be displayed if test fails");



    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
