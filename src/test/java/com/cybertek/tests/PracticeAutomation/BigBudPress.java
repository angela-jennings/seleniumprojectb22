package com.cybertek.tests.PracticeAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BigBudPress {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bigbudpress.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("thermal - white" + Keys.ENTER);
        driver.findElement(By.linkText("Thermal - Vintage Off-White")).click();
        //driver.findElement(By.id("SingleOptionSelector-product-0")).click();

        WebElement testDropDown = driver.findElement(By.id("SingleOptionSelector-product-0"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(2);

        driver.findElement(By.id("AddToCart-product")).click();


        WebElement checkout = driver.findElement(By.linkText("CHECK OUT"));
        checkout.submit();




    }
}
