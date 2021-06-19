package com.cybertek.tests.OfficeHours.Practice_06_16_2021;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.OfficeHoursUtilities.FinArtsUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FinArts {
    WebDriver driver;
    String browser = ConfigurationReader.getProperty("browser");
    String addUserUrl = ConfigurationReader.getProperty("finArtsAddUserUrl");
    String loginUrl = ConfigurationReader.getProperty("finArtsLoginUrl");

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTests(){
        //adding user test
        FinArtsUtils.addUserTest(driver, addUserUrl);
        BrowserUtils.sleep(3);

        //positive login test
        Assert.assertTrue(FinArtsUtils.positiveLoginTest(driver, loginUrl));

        //negative login test
        Assert.assertTrue(FinArtsUtils.negativeLoginTest(driver, loginUrl));
    }

    @Test
    public void textTests(){
        driver.get(loginUrl);
        String expectedTitle = "Login example page to test the PHP MySQL online system";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualHeader = driver.findElement(By.xpath("(//strong)[3]")).getText();
        String expectedHeader = "4. Login";
        Assert.assertEquals(actualHeader, expectedHeader);

        String actualLongText = driver.findElement(By.xpath("//p[contains(., 'login details you added')]")).getText();
        String expectedLongText = "Enter your login details you added on the previous page and test the login.\n" +
                "The success or failure will be shown above.";
        Assert.assertEquals(actualLongText, expectedLongText);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
