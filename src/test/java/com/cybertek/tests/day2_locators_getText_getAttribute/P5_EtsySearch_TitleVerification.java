package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsySearch_TitleVerification {
    public static void main(String[] args) {

//TC #1: Etsy Title Verification
//1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
//3. Search for “wooden spoon”
        //need to locate the search bar, then we enter search value, then we press enter
        driver.findElement(By.id("global-enhancements-search-query"))
                .sendKeys("wooden spoon" + Keys.ENTER);  //concatenating search and hitting enter
//4. Verify title:
//Expected: “Wooden spoon | Etsy”
        String expTitle = "Wooden spoon | Etsy";
        String actTitle = driver.getTitle();
        if(actTitle.equals(expTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }


        driver.close();
    }
}
