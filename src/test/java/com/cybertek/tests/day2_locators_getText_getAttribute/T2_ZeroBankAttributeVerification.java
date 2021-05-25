package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankAttributeVerification {
    public static void main(String[] args) {
        //TC #2: Zero Bank link text verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //LOCATE THE LINK AND STORE INSIDE THE OF WEB ELEMENT
        WebElement zeroBankLinkText = driver.findElement(By.className("brand"));

        //3. Verify link text from top left:
        //Expected: “Zero Bank”
        String expLinkText = "Zero Bank";
        String actualLinkTex = zeroBankLinkText.getText();

        if(actualLinkTex.equals(expLinkText)){
            System.out.println("Link test verification passed");
        }else{
            System.out.println("Link test verification failed");
        }

        //4. Verify link href attribute value contains:
        //Expected: “index.html”
        String expHrefValue = "index.html";
        String actHrefValue = zeroBankLinkText.getAttribute("href");

        if(actHrefValue.contains(expHrefValue)){
            System.out.println("href attribute value verification passed");
        }else{
            System.out.println("href value value verification failed");
        }



        //System.out.println("actHrefValue = " + actHrefValue);;





    }
}
