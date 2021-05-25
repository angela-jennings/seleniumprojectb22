package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_cssSelector_Cybertek {
    public static void main(String[] args) {
        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));
        System.out.println("home link is displayed - " + homeLink.isDisplayed());

        //b. “Forgot password” header
        WebElement passwordHeader = driver.findElement(By.tagName("h2"));
        System.out.println("password header is displayed - " + passwordHeader.isDisplayed());

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println("email text is displayed - " + emailText.isDisplayed());

        //d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println("email input box is displayed - " + emailInputBox.isDisplayed());

        //e. “Retrieve password” button
        WebElement retrievePassword = driver.findElement(By.cssSelector("button[id='form_submit']"));
        System.out.println("retrieve password button is displayed - " + retrievePassword.isDisplayed());

        //f. “Powered by Cybertek School” text
        WebElement cybertekText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        System.out.println("powered by cybertek text displayed - " + cybertekText.isDisplayed());

        //4. Verify all WebElements are displayed.
    }
}
