package com.cybertek.tests.PracticeAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCaseOneTruckDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        /**
         * First test case: Truck Driver logs in successfully
         */

        driver.get("https://qa3.vytrack.com/user/login");

        WebElement usernameField = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        usernameField.sendKeys("User1");

        WebElement passwordField = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        passwordField.sendKeys("UserUser123");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);

        String expTitle = "Dashboard";
        String actTitle = driver.getTitle();

        if(actTitle.equals(expTitle)){
            System.out.println("Login page successfully reached");
        }else{
            System.out.println("Login page failed");
        }


    }
}
