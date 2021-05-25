package com.cybertek.tests.day3_reviews_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F1_TitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        String expTitle = "Facebook - Log In or Sign Up";
        String actTitle = driver.getTitle();

        if(actTitle.equals(expTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }


    }
}
