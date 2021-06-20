package com.cybertek.tests.day12_actions_uploads_jsexecutor;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simpleGoogleSearchTest(){
        //1. Go to google.com
        //Driver.getDriver() = driver --> creates driver instance and ready to use
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //2. Search for a value
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        //send the search value and press enter
        String searchValue = ConfigurationReader.getProperty("searchValue");
        searchBox.sendKeys(searchValue + Keys.ENTER);


        //3. Verify value is contained in the title
        String expTitle = searchValue + " - Google Search";
        String actTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actTitle.contains(expTitle));

        //will terminate the session and will assign driver value to null
        Driver.closeDriver();

        Driver.getDriver().get("https://etsy.com");


    }
}
