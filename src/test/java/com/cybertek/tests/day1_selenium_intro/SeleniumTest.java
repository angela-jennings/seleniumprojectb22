package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {
        //1 - set up web driver
        WebDriverManager.chromedriver().setup();

        //2 - create instance of the chrome driver
        // this is the line that opens the browser
        WebDriver driver = new ChromeDriver();

        //3 - test if driver is working
        driver.get("https://www.google.com");

    }
}
