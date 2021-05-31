package com.cybertek.tests.PracticeAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebElementVerification {
    WebDriver driver;

    //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/forgot_password
    // 3. Locate all the WebElements on the page using XPATH locator only (total of 6) a. “Home” linkb. “Forgot           password” headerc. “E-mail” textd. E-mail input boxe. “Retrieve password” buttonf. “Powered byCybertek School” text
    // 4. Verify all WebElements are displayed.

    @BeforeMethod
    public void setUp(){
        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        // 1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/forgot_password
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/forgot_password");
    }

    @Test
    public void tc001(){
        // 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
            // a.“Home” link
             WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

            // b.“Forgot password” header
            WebElement forgotPassword = driver.findElement(By.xpath("//h2"));

            // c. “E-mail” text
            WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));

            // d. E-mail input box
            WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text']"));

            // e. “Retrieve password” button
            WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));

            // f. “Powered byCybertek School” text
            WebElement poweredByCybertekText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        // 4. Verify all WebElements are displayed.
        System.out.println(homeLink.isDisplayed());
        System.out.println(forgotPassword.isDisplayed());
        System.out.println(emailText.isDisplayed());
        System.out.println(emailInputBox.isDisplayed());
        System.out.println(retrievePasswordButton.isDisplayed());
        System.out.println(poweredByCybertekText.isDisplayed());
    }


}
