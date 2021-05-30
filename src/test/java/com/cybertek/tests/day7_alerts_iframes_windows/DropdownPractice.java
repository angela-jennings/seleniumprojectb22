package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
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
    public void tc2_state_dropdown_test() {

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
        @Test
        public void tc3_date_dropdown_verification() throws InterruptedException {

            //We need to locate all the dropdowns to be able to select options
            Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
            Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
            Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

            //for shortcut code moving:
            //mac: command + shift + d
            //window: control + shift + d

            //Select “December 1 , 1922” and verify it is selected.
            //   Select year using : visible text
            Thread.sleep(1000);
            yearDropdown.selectByVisibleText("1922");

            //   Select month using : value attribute
            Thread.sleep(1000);
            monthDropdown.selectByValue("11");

            //   Select day using : index number
            Thread.sleep(1000);
            dayDropdown.selectByIndex(0);

            //creating expected values
            String expectedYear = "1922";
            String expectedMonth = "December";
            String expectedDay = "1";


            //getting our actual values from browser
            String actualYear = yearDropdown.getFirstSelectedOption().getText();
            String actualMonth = monthDropdown.getFirstSelectedOption().getText();
            String actualDay= dayDropdown.getFirstSelectedOption().getText();

            //creating assertions to compare actual vs expected values

            //AssertTrue expects one argument that is supposed to be returning boolean value
            Assert.assertTrue(actualYear.equals(expectedYear), "ActualYear is not equal to ExpectedYear!!!");

            Assert.assertTrue(actualMonth.equals(expectedMonth));

            Assert.assertEquals(actualDay, expectedDay);


        }

        @Test
        public void tc4_multiple_select_dropdown() throws InterruptedException {

            //Locating dropdown to work on it
            Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

            //3. Select all the options from multiple select dropdown.
            List<WebElement> allOptions = multipleSelectDropdown.getOptions();

            //Loop through the List and click to each option
            //iter for creating short cut for:each loop
            for (WebElement each : allOptions) {

                Thread.sleep(500);
                each.click();

                //4. Print out all selected values.
                System.out.println("Selected: " + each.getText());

                //Verifying each option is selected:
                Assert.assertTrue(each.isSelected(), "The option "+each.getText()+" is not selected!");
            }

            //5. Deselect all values.
            multipleSelectDropdown.deselectAll();

            for (WebElement each : allOptions) {
                //assertTrue expecting true boolean value to pass the test
                //Assert.assertTrue(!each.isSelected());

                //Assert.assertFalse method is expecting "false" boolean value to pass the test.
                //If expected result is "false" better to use this assertFalse
                Assert.assertFalse(each.isSelected());
            }

        }

        @Test
        public void tc5_non_select_dropdown() throws InterruptedException {

            //We need to locate the non-select dropdown as regular web element
            WebElement websiteDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));

            //3. Click to non-select dropdown
            Thread.sleep(1000);
            websiteDropdown.click();

            //4. Select Facebook from dropdown
            Thread.sleep(1000);

            //Locating Facebook from non-select dropdown
            WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

            //Click to facebook link to go to page
            facebookLink.click();

            //5. Verify title is “Facebook - Log In or Sign Up”
            String expectedTitle = "Facebook - Log In or Sign Up";
            String actualTitle = driver.getTitle();

            Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected!!!");


        }

        @AfterClass
    public void tearDownClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        }






}
