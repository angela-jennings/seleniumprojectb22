package com.cybertek.tests.day5_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P0_FindElements {
    public static void main(String[] args) {

        // FIND ELEMENTS:
        //1. OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //if web element not found, this will let the page wait for up to 15 seconds
        //if element found before the time is up, it will continue

        //2. GO TO HTTPS://PRACTICE.CYBERTEKSCHOOL.COM/FORGOT_PASSWORD
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //need to create a locator that finds all the links on the page
        //   //body//a --> this locator will return all elements on the page

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        //storing all of the links that are returned by findElements method

        //3. PRINT OUT THE TEXTS OF ALL THE LINKS
        for (WebElement listOfLink : listOfLinks) {
            System.out.println(listOfLink.getText()); //need to use .getText() to display actual text of link
            System.out.println(listOfLink.getAttribute("href")); //prints the string of the link
        }
            
        //for each loop shortcut --> "iter" and enter - points to latest array list and creates for each loop for you

        //4. PRINT OUT HOW MANY TOTAL LINKS
        int numOfLinks = listOfLinks.size();
        System.out.println("numOfLinks = " + numOfLinks);

    }
}
