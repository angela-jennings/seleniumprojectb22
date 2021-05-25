package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_PartialLinkText {
    public static void main(String[] args) {
        //    TC #4:	Google	search
//1- Open	a	chrome	browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//2- Go	to:	https://google.com
        driver.get("https://google.com");

//            3- Write	“apple”	in	search	box
        //4- Click	google	search	button
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

//5- Verify title:
//    Expected:	Title	should	start	with	“apple”	word
        String expInTitle = "apple";
        String actualTitle = driver.getTitle();

        if(actualTitle.startsWith(expInTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }
        driver.close();
    }


}
