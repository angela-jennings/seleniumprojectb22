package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_xpath_MultipleButtons {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com/multiple_buttons
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //3. Click on Button 1
        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        buttonOne.click();

        //4. Verify text displayed is as expected:
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String expText = "Clicked on button one!";
        String actText = resultText.getText();

        if(actText.equals(expText)){
            System.out.println("result text verification passed");
        }else{
            System.out.println("result text verification failed");
        }
        //Expected: “Clicked on button one!”
    }
}
