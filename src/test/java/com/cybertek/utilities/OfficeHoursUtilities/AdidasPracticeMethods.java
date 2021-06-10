package com.cybertek.utilities.OfficeHoursUtilities;

import com.cybertek.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdidasPracticeMethods {

        public static void productAdder(WebDriver driver, String category, String product){
            driver.findElement(By.xpath("//a[.='"+category+"']")).click();
            BrowserUtils.sleep(1);
            driver.findElement(By.xpath("//a[.='"+product+"']")).click();
            BrowserUtils.sleep(1);
            driver.findElement(By.xpath("//a[.='Add to cart']")).click();
            BrowserUtils.sleep(1);

            Alert alert = driver.switchTo().alert();
            alert.accept();
            BrowserUtils.sleep(1);

            driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();

        }

        public static void productRemover(WebDriver driver, String product){
            //   //tbody//tr//td[.='Apple monitor 24']/..//td[.='Delete']/a <-- apple monitor is easily located and each item has the same locator path because each item has the link text of the item

            driver.findElement(By.xpath("//a[.='Cart']")).click();
            BrowserUtils.sleep(1);
            driver.findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[.='Delete']/a")).click();
            BrowserUtils.sleep(3);

        }

        public static void formFillOut(WebDriver driver){
            Faker faker = new Faker();
            driver.findElement(By.id("name")).sendKeys(faker.harryPotter().character());
            BrowserUtils.sleep(2);
            driver.findElement(By.id("country")).sendKeys(faker.country().name());
            BrowserUtils.sleep(2);
            driver.findElement(By.id("city")).sendKeys(faker.address().city());
            BrowserUtils.sleep(2);
            driver.findElement(By.id("card")).sendKeys(faker.finance().creditCard());
            BrowserUtils.sleep(2);
            driver.findElement(By.id("month")).sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
            BrowserUtils.sleep(2);
            driver.findElement(By.id("year")).sendKeys(String.valueOf(faker.number().numberBetween(2021, 2026)));
            BrowserUtils.sleep(2);
            driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();


    }
}
