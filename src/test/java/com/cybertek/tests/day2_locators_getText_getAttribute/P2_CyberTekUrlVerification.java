package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CyberTekUrlVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/");

        String expectedURL = "cybertekschool";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("actual title found - passed");
        }else{
            System.out.println("title not found - failed");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(expectedTitle.contains(actualTitle)){
            System.out.println("actual title passed");
        }else{
            System.out.println("title failed");
        }
    }
}
