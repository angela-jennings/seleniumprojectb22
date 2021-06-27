package com.cybertek.tests.office_hours.practice_05_26_2021;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC001 {
    WebDriver driver;

        @BeforeClass
        public void setUp(){
        // 1. Navigate to: https://moneygaming.qa.gameaccount.com/
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://moneygaming.qa.gameaccount.com/");
    }
        @Test
        public void tc001() {
        // 2. Click the JOIN NOW button to open the registration page
        WebElement joinNowButton = driver.findElement(By.xpath("//a[@class='newUser green']"));
        joinNowButton.click();
    }

        @Test
         public void tc002(){
         // 3. Select a title value from the dropdown
            Select titleDropDown = new Select(driver.findElement(By.xpath("//select[@class='title required']")));
            titleDropDown.selectByIndex(2);
        }
        @Test
        public void tc003() throws InterruptedException {
        // 4. Enter your first name and surname in the form
            WebElement firstNameField = driver.findElement(By.xpath("//input[@name='map(firstName)']"));
            firstNameField.sendKeys("Angela");
            WebElement lastNameField = driver.findElement(By.xpath("//input[@name='map(lastName)']"));
            lastNameField.sendKeys("Jennings");
            Thread.sleep(2000);
        }
        @Test
        public void tc004(){
        // 5. Check the tickbox with text 'I accept the Terms and Conditions and certify that I am over the age of 18.'
            WebElement iAmOver18 = driver.findElement(By.xpath("//input[@name='map(terms)']"));
            iAmOver18.click();
        }

        @Test
        public void tc005(){
        // 6. Submit the form by clicking the JOIN NOW button
            WebElement formJoinNowButton = driver.findElement(By.xpath("//input[@id='form']"));
            formJoinNowButton.click();
        }

        @Test
        public void tc006(){
        // 7. Validate that a validation message with text ‘ This field is required’ appears under the date of
        //    birth box
            WebElement dateOfBirthBox = driver.findElement(By.xpath("//label[@for='dob']"));
            Assert.assertEquals(dateOfBirthBox.getText(), "This field is required");
        }

        @AfterClass
        public void tearDown(){
        driver.close();
        }

    }


