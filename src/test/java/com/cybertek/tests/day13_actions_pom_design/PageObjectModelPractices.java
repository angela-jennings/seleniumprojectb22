package com.cybertek.tests.day13_actions_pom_design;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectModelPractices {
    @Test
    public void negativeLogInToLibrary(){
        //go to library
        Driver.getDriver().get("https://library2.cybertekschool.com/login.html");

        //create object of the class. When we create the object of LibraryLoginPage the constructor will automatically initialize the driver and object of LibraryLoginPage. --> this means we will be able to use selenium methods through the object of the class
        LibraryLoginPage login = new LibraryLoginPage();

        //enter incorrect username
        login.inputEmail.sendKeys("tester@something.com");

        //enter incorrect password
        login.inputPassword.sendKeys("abc123");

        //click to sign in
        login.signInButton.click();
        BrowserUtils.sleep(2);

        //verify error message is displayed
        Assert.assertTrue(login.incorrectEmailOrPassword.isDisplayed());

        Driver.closeDriver();
    }
}
