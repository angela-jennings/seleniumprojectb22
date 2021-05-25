package com.cybertek.tests.day3_reviews_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_IncorrectLoginTitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //go to facebook.com
        driver.get("https://www.facebook.com");

        //locating web element using id locator and storing it in web element type
        //entering incorrect username
        WebElement inputUserName = driver.findElement(By.id("email"));
        inputUserName.sendKeys("angela@gmail.com");

        //location web element using id locator and storing it in web element type
        //entering incorrect password
        WebElement inputPassword = driver.findElement(By.id("pass"));
        inputPassword.sendKeys("abc123" + Keys.ENTER);

        String expTitle = "Log into Facebook";
        String actTitle = driver.getTitle();

        if(actTitle.equals(expTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }
    }
}
