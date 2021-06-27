package com.cybertek.tests.office_hours.practice_06_09_2021;

import com.cybertek.utilities.OfficeHoursUtilities.AdidasPracticeMethods;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://demoblaze.com/index.html");
    }

    @Test
    public void adidasTest(){
        AdidasPracticeMethods.productAdder(driver, "Laptops", "Sony vaio i5");
        AdidasPracticeMethods.productAdder(driver,"Phones", "Samsung galaxy s6");
        AdidasPracticeMethods.productAdder(driver,"Monitors", "Apple monitor 24");

        AdidasPracticeMethods.productRemover(driver, "Apple monitor 24");
        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        AdidasPracticeMethods.formFillOut(driver);

        String confirmation = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        System.out.println("Confirmation:\n" + confirmation);

        String[] confirmationArray = confirmation.split("\n");
        String orderID = confirmationArray[0];
        int actualAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
        int expAmount = 1150;

        Assert.assertEquals(actualAmount, expAmount);




    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

