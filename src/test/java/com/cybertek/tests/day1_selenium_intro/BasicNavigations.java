package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //1 - set up browser driver
        WebDriverManager.chromedriver().setup();

        //2 - create instance of selenium web driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3 - get the page for google.com
        driver.get("https://google.com");
        String currentURL = driver.getCurrentUrl(); //assign to a string and can reuse
        System.out.println("current url --> " + currentURL);

        // putting 3 seconds of wait time
        Thread.sleep(1000);

        // going back using navigations
        driver.navigate().back();
        Thread.sleep(1000);

        //going forward using navigations
        driver.navigate().forward();

        //refreshing the page
        driver.navigate().refresh();
        Thread.sleep(1000);

        //changing url
        driver.navigate().to("https://www.etsy.com");

        System.out.println("current title --> " + driver.getTitle());
        System.out.println("current url --> " + driver.getCurrentUrl());


        //driver.close() closes current browser/tab
        driver.close();

        //driver.quit() will close all of the open browsers/tabs within the same session
        driver.quit();

    }
}
