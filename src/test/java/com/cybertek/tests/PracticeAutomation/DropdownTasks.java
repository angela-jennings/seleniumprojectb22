package com.cybertek.tests.PracticeAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void tc003(){
//TC #3: Selecting date on dropdown and verifying
// 1.Open Chrome browser
// 2.Go to http://practice.cybertekschool.com/dropdown
// 3.Select “December 1st, 1922” and verify it is selected.
        // Select year using: visible text
        // Select month using: value attribute
        // Select day using: index number


        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.id("day")));

        yearDropdown.selectByVisibleText("1922");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);
    }

    @Test
    public void tc004(){
       //TC #4: Selecting value from multiple select dropdown
       // 1.Open Chrome browser
       // 2.Go to http://practice.cybertekschool.com/dropdown
       // 3.Select all the options from multiple select dropdown.
       // 4.Print out all selected values.
       // 5.Deselect all values.

        Select multiSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptions = multiSelectDropdown.getOptions();
        for (WebElement allOption : allOptions) {
            allOption.click();
            System.out.println(allOption.getText());
            Assert.assertTrue(allOption.isSelected());
        }

        multiSelectDropdown.deselectAll();

        for (WebElement allOption : allOptions) {
            Assert.assertFalse(allOption.isSelected());
        }



    }

    @Test
    public void tc005(){
        //TC #5: Selecting value from non-select dropdown
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // 3.Click to non-select dropdown
        // 4.Select Facebook from dropdown
        // 5.Verify title is “Facebook -Log In or Sign Up”

     WebElement dropdownLink = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
     dropdownLink.click();

     WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
     facebookLink.click();

     String expTitle = "Facebook - Log In or Sign Up";
     String actTitle = driver.getTitle();

     Assert.assertEquals(actTitle, expTitle, "Title is not as expected");






    }
}
