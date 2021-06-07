package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SiblingParentPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @Test
    public void parentSiblingTest(){
        //P1 - locate example 1 table web element
        WebElement exampleOneTable = driver.findElement(By.xpath("//table[@id='table1']"));
        Assert.assertTrue(exampleOneTable.isDisplayed());

        //Create a locator that returns all of the rows in the table:
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        Assert.assertEquals(allRows.size(), 4);

        //create a locator that returns only 3rd row
        WebElement thirdRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]"));
        System.out.println(thirdRow.getText());


        //create a locator that returns all of the cells inside all of the rows
        List<WebElement> allCellsInRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
        Assert.assertEquals(allCellsInRows.size(), 24);

        //create a locator that returns all the first names in table one
        List<WebElement> firstNamesInTable = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));
        Assert.assertEquals(firstNamesInTable.size(), 4);

        //create a locator that returns Frank's cell
        WebElement frankName = driver.findElement(By.xpath("//table[@id='table1']//tr[2]/td[2]"));
        //tr[2] gets the second row, /td[2] gets second cell in already located row
        //second option for located by the text of the cell --> //table[@id='table1']//td[.='Frank']
        Assert.assertEquals(frankName.getText(), "Frank");

        //create a locator that returns the $100.00 cell
        WebElement oneHundredDollars = driver.findElement(By.xpath("//table[@id='table1']//td[.='$100.00']"));
        //second option is by location row/column --> //table[@id='table1']//tr[3]/td[4]
        Assert.assertEquals(oneHundredDollars.getText(), "$100.00");

        //create a locator that returns Jason's due amount
        WebElement jasonDueAmount = driver.findElement(By.xpath("//table[@id='table1']//td[.='Jason']/../td[4]"));
        //locating jason by text, go to parent (/..), go back into rows with the /td and use index number
        //second option using following sibling --> //table[@id='table1']//td[.='Jason']/following-sibling::td[2]
        Assert.assertEquals(jasonDueAmount.getText(), "$100.00");

        //create a locator that returns Jason's last name by using "Jason" text
        WebElement jasonLastName = driver.findElement(By.xpath("//table[@id='table1']//td[.='Jason']/preceding-sibling::td[1]"));
        //second option --> //table[@id='table1']//td[.='Jason']/../td[1]
        Assert.assertEquals(jasonLastName.getText(), "Doe");

        List<WebElement> allFiftyDollarDonations = driver.findElements(By.xpath("//table[@id='table1']//td[.='$50.00']/preceding-sibling::td[2]"));
        for(WebElement each : allFiftyDollarDonations){
            System.out.println("Name of each $50 Donor: " + each.getText());
        }


    }
}
