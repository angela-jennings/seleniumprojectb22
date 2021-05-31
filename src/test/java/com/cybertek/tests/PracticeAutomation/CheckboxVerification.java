package com.cybertek.tests.PracticeAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckboxVerification {

    //TC #1: SeleniumEasy CheckboxVerification–Section 1
    // 1.Open Chrome browser
    // 2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // 3.Verify “Success –Check box is checked” message is NOT displayed.
    // 4.Click to checkbox under “Single Checkbox Demo” section
    // 5.Verify “Success –Check box is checked” message is displayed.

    //TC #2: SeleniumEasy Checkbox Verification –Section 2
    // 1.Open Chrome browser
    // 2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // 3.Verify “Check All” button text is “Check All”
    // 4.Click to “Check All” button
    // 5.Verify all check boxes are checked
    // 6.Verify button text changed to “Uncheck All”

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @Test
    public void tc001(){
        WebElement checkboxOne = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement successText = driver.findElement(By.xpath("//div[@id='txtAge']"));
        Assert.assertTrue(!successText.isDisplayed());
        checkboxOne.click();
        Assert.assertTrue(successText.isDisplayed());

        WebElement checkAllButton = driver.findElement(By.xpath("//input[@id='check1']"));
        String actualText = checkAllButton.getAttribute("value");
        String expText = "Check All";

        Assert.assertEquals(actualText, expText);

        checkAllButton.click();

        List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement webElement : checkboxList) {
            if (webElement.isSelected()){
                System.out.println("checkbox is selected - pass");
            }else{
                System.out.println("checkbox not selected - fail");
            }
        }

        String actTextAfterClick = checkAllButton.getAttribute("value");
        String expTextAfterClick = "Uncheck All";

        Assert.assertEquals(actTextAfterClick, expTextAfterClick);

    }
}
