package com.cybertek.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtils {
    public static void smartBearLogin(WebDriver driver){
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
    }
    public static void inputField(WebDriver driver){
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(faker.harryPotter().character());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys("12345");
    }

    public static void addItem(WebDriver driver, String product, String itemAmount){
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();
        Select productSelect = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        productSelect.selectByVisibleText(product);
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys(Keys.DELETE);
        quantity.sendKeys(itemAmount);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public static void paymentInformation(WebDriver driver){
        Faker faker = new Faker();
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")).sendKeys(faker.finance().creditCard().replace("-", ""));
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys("02/24");
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
    }

    public static void customerOrderDate(WebDriver driver, String customer, String orderDate){
        driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();
        WebElement customerOrderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='"+customer+"']/../td[5]"));
        Assert.assertEquals(customerOrderDate.getText(), orderDate);
    }

    public static void customerNameVerification(WebDriver driver, String customerName){
        driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();
        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[2]"));
        for (WebElement each : firstNames){
            if(each.getText().equals(customerName)){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.assertTrue(false, "Given name does not match records");
    }

    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[2]"));
        int count;

        for (WebElement each : firstNames){
            count = 1;
            System.out.println("Name" + count++ + ":" + each.getText());
        }
        System.out.println();

        List<WebElement> cities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[7]"));
        for (WebElement each : cities){
            count = 1;
            System.out.println("City" + count++ + ":" + each.getText());
        }
    }
}
