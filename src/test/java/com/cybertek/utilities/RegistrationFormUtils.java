package com.cybertek.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationFormUtils {
    public static void loginForm(WebDriver driver){
        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='last name']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='username']"));
        userName.sendKeys(faker.harryPotter().house());

        WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder='email@email.com']"));
        emailAddress.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.harryPotter().spell().replace(" ", ""));

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder='571-000-0000']"));
        phoneNumber.sendKeys("123-456-7890");

        WebElement gender = driver.findElement(By.xpath("//input[@value='other']"));
        gender.click();

        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        dateOfBirth.sendKeys("01/01/1990");

        Select department = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        department.selectByVisibleText("Department of Engineering");

        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");

        WebElement languages = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        languages.click();

        WebElement signUpButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//p"));
        Assert.assertEquals(successMessage.getText(), "You've successfully completed registration!");
    }
}
