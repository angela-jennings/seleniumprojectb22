package com.cybertek.tests.office_hours.practice_06_02_2021;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankWithBeforeMethod {
    WebDriver driver;
    Select accountDropDown;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=account-activity.html']")).click();
    }

    @Test
    public void accountActivity1() {

        String expTitle = "Zero - Account Activity";
        Assert.assertEquals(driver.getTitle(), expTitle);

    }
    @Test
    public void accountActivity2() {
        BrowserUtils.sleep(2);
        List<String> expItemsInDropDown = new ArrayList<>(Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage"));
        accountDropDown = new Select(driver.findElement(By.xpath("//select[@id='aa_accountId']")));
        List<WebElement> actualOptions = accountDropDown.getOptions();
        List<String> actItemsInDropDown = new ArrayList<>();

        for (WebElement each : actualOptions) {
            actItemsInDropDown.add(each.getText());
            System.out.println(each.getText());
        }

        Assert.assertEquals(actItemsInDropDown, expItemsInDropDown);
    }

    @Test
    public void accountActivity3(){
        accountDropDown = new Select(driver.findElement(By.xpath("//select[@id='aa_accountId']")));
        accountDropDown.selectByVisibleText("Brokerage");
        WebElement noResults = driver.findElement(By.xpath("//div[@class='well']"));
        Assert.assertEquals(noResults.getText(), "No results.");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
