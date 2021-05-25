package com.cybertek.tests.PracticeAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCaseTwoTruckDriver {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Test Case Two: truck driver enters correct username and incorrect password - login should fail
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://qa3.vytrack.com/user/login");

        WebElement usernameField = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        usernameField.sendKeys("user1");
        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        passwordField.sendKeys("wrongPassword");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement incorrectCredentials = driver.findElement(By.cssSelector("div[class='alert alert-error']"));
        if(incorrectCredentials.getText().equals("Invalid user name or password.")){
            System.out.println("login did not pass - test pass");
        }else{
            System.out.println("login passed - test failed");
        }

//        usernameField.sendKeys("USER1");
//        passwordField.sendKeys("UserUser123");
//        submitButton.click();
//        if(incorrectCredentials.getText().equals("Invalid user name or password.")){
//            System.out.println("login did not pass - test pass");
//        }else{
//            System.out.println("login passed - test failed");
//        }



    }
}
