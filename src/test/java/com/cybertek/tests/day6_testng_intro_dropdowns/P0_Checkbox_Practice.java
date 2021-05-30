package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P0_Checkbox_Practice {
    public static void main(String[] args) throws InterruptedException {
        //Practice:	Cybertek	Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. Go	to	http://practice.cybertekschool.com/checkboxes
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //2. Confirm	checkbox	#1	is	NOT	selected	by	default
        WebElement checkboxOne = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        System.out.println("checkbox one is selected: " + checkboxOne.isSelected());

        //3. Confirm	checkbox	#2	is	SELECTED	by	default.
        WebElement checkboxTwo = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        System.out.println("checkbox two is selected: " + checkboxTwo.isSelected());
        System.out.println("--------------------");

        //4. Click	checkbox	#1	to	select	it.
        Thread.sleep(2000);
        checkboxOne.click();

        //5. Click	checkbox	#2	to	deselect	it.
        Thread.sleep(2000);
        checkboxTwo.click();

        //6. Confirm	checkbox	#1	is	SELECTED.
        System.out.println("checkbox one is selected: " + checkboxOne.isSelected());

        //7. Confirm	checkbox	#2	is	NOT	selected.
        System.out.println("checkbox two is selected: " + checkboxTwo.isSelected());

        driver.close();
    }
}
