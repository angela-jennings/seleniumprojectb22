package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractice {
    //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    WebDriver driver;

    @BeforeClass //all of this set up in its own class rather than using main method to run everything
    public void setUpClass(){
            // 1.Open Chrome browser
            // 2.Go to http://practice.cybertekschool.com/dropdown
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/dropdown");
        }

        @Test
    public void tc1SimpleDropdownTest(){
            // 3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”
            Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

            Assert.assertEquals(simpleDropdown.getFirstSelectedOption().getText(), "Please select an option");

//            WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
//            String actualTextOfCurrentOption = currentlySelectedOption.getText();
//            String expectedText = "Please select an option";
//            Assert.assertTrue(actualTextOfCurrentOption.equals(expectedText));
//            This way wouldn't really be used because there are so many lines of code. its another way of doing it but its not recommended

            // 4.Verify“State selection” default selected value is correctExpected: “Select a State”

            Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
            String actualStateDropdownText = stateDropdown.getFirstSelectedOption().getText();
            String expStateDropdownText = "Select a State";


            Assert.assertEquals(actualStateDropdownText, expStateDropdownText);

        }


    @Test
    public void tc2_state_dropdown_test(){

        //LOCATING STATE DROPDOWN
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        stateDropdown.selectByVisibleText("Illinois");
        //using the different ways to select in a dropdown

        //4. Select Virginia
        stateDropdown.selectByValue("VA");
        //this and by visible text are probably the most straightforward

        //5. Select California
        stateDropdown.selectByIndex(5);
        //generally least efficient because you have to count. California is just near the top, but obviously wouldnt use for virginia or other states farther down.

        //6. Verify final selected option is California.
        String expOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOptionText, expOptionText, "this message will be printed out only if assertion fails");
        //can pass a third string which will only print if test fails. not mandatory but can be useful

        //Assert.assertTrue(stateDropdown.getFirstSelectedOption().getText().equals("California"));
        //Use all Select options. (visible text, value, index)


    }

        @AfterClass
    public void tearDownClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        }






}
