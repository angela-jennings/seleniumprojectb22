package com.cybertek.tests.day3_reviews_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F4_AttributeValueVerification {
    public static void main(String[] args) {
        //TC #4: Facebook header verification

        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // 3.Verify “Create a page” link href value contains text: Expected: “registration_form”

        WebElement createPageLink = driver.findElement(By.linkText("Create a Page"));

        String expHrefValue = "registration_form";
        String actualHrefValue = createPageLink.getAttribute("href");

        if(actualHrefValue.contains(expHrefValue)){
            System.out.println("href value match");
        }else{
            System.out.println("href value does not match");
        }

    }
}
