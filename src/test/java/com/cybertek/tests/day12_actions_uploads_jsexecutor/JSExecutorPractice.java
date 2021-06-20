package com.cybertek.tests.day12_actions_uploads_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorPractice {
    @Test
    public void scrollUsingJSExecutorTask1(){
        //get the page "http://practice.cybertekschool.com/infinite_scroll"
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //down casting our driver type to JavaScriptExecutor
        //this way we can reach methods in this interface
        //((JavascriptExecutor) Driver.getDriver()).executeScript("");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //this method capable of accepting js functions and apply that into our java+selenium code
        for(int i = 0; i < 10; i++){
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0, 750)"); //<-- the 750 refers to how many pixels on y axis. 0 is on x axis
        }
    }
    @Test
    public void scrollUsingJSExecutorTask2(){
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement cybertekSchoolLLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //use js executor with different scrolling js function
        //scroll down to cybertekschool link
        BrowserUtils.sleep(1);

        js.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLLink);

        //scroll up to home link
        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);
    }
}
