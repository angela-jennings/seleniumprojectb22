package com.cybertek.utilities.OfficeHoursUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinArtsUtils {
    static String userName = "KogaIsStinky";
    static String password = "AthenaIsFat";

    public static WebElement userNameBox (WebDriver driver){
        return driver.findElement(By.name("username"));
    }
    public static WebElement passwordBox (WebDriver driver){
        return driver.findElement(By.name("password"));
    }
    public static void addUserTest(WebDriver driver, String url){
        driver.get(url);
        userNameBox(driver).sendKeys(userName);
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='FormsButton2']")).click();
    }
    public static boolean positiveLoginTest (WebDriver driver, String url){
        driver.get(url);
        userNameBox(driver).sendKeys(userName);
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Test Login']")).click();
        WebElement successMessage = driver.findElement(By.xpath("//b[.='**Successful Login**']"));

        return successMessage.isDisplayed();
    }

    public static boolean negativeLoginTest(WebDriver driver, String url){
        driver.get(url);
        userNameBox(driver).sendKeys(userName.substring(1));
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Test Login']")).click();
        WebElement failMessage = driver.findElement(By.xpath("//b[.='**Failed Login**']"));

        return failMessage.isDisplayed();
    }


}
