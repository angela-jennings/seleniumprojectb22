package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LibraryUtils {

    public static void loginToLibrary(WebDriver driver){
        WebElement usernameField = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        BrowserUtils.sleep(2);
        usernameField.sendKeys("student11@library");
        passwordField.sendKeys("tScBPCUr");
        submitButton.click();
    }
}
