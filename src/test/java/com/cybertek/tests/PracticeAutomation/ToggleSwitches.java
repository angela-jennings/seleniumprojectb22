package com.cybertek.tests.PracticeAutomation;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ToggleSwitches {
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("http://te.dev.secureci.com/Exercise2.html");
    }
    @Test
    public void switchAllToggles() throws InterruptedException {
        List<WebElement> sliders = Driver.getDriver().findElements(By.xpath("//div[@class='slider round']"));
        for(WebElement each : sliders){
            each.click();
        }
    }
}
