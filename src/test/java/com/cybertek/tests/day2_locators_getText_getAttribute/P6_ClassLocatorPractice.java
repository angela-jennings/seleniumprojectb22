package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_ClassLocatorPractice {
    public static void main(String[] args) throws InterruptedException {
//TC #6: Practice Cybertek – Class locator practice
//1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//2. Go to http://practice.cybertekschool.com/inputs
        driver.get("http://practice.cybertekschool.com/inputs");
        Thread.sleep(2000);
//3. Click “Home” button
        driver.findElement(By.className("navbar-nav")).click();
//4. Verify title as expected:
//Expected: Practice
        String expTitle = "Practice";
        String actTitle = driver.getTitle();
        if(actTitle.equals(expTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }

    driver.close();
    }
}
