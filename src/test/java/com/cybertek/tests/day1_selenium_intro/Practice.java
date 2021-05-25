package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
   public static void main(String[] args) throws InterruptedException{

/**
 * 1.Open Chrome browser
 * 2.Go to https://practice.cybertekschool.com
 * 3.Verify URL containsExpected: cybertekschool
 * 4.Verify title: Expected: Practice
 */


       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://google.com");

       String expectedURL = "google";
       if(driver.getCurrentUrl().contains(expectedURL)){
           System.out.println("expected url found");
       }else{
           System.out.println("url not found");
       }

       String expectedTitle = "Google";
       if (driver.getTitle().equals(expectedTitle)){
           System.out.println("expected title found");
       }else{
           System.out.println("title not found");
       }


        driver.close();

   }

}
