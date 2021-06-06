package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.LibraryUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_Library_Login {
    //Task#1: Librarysoftware link verification
    // 1.Open browser
    // 2.Go to website: http://librarycybertekschool.com/login.html
    // 3.Enter username: “”
    // 4.Enter password: “”
    // 5.Click to Login button
    // 6.Print out count of all the links on landing page
    // 7.Print out each link text on this page

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://library1.cybertekschool.com/login.html");
    }


    @Test
    public void loginLinkCountTest() {

        LibraryUtils.loginToLibrary(driver);

        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println(allLinks.size());

        for(WebElement each : allLinks){
            int count = 1;
            System.out.println("Link " + count++ + ": " + each.getText());
        }


    }

}
