package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.DynamicLoad1Page;
import com.cybertek.pages.DynamicLoad7Page;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice {
   //TC#40 : Dynamically Loaded Page Elements 7
    //1. Go to http://practice.cybertekschool.com/dynamic_loading/7
    //2. Wait until title is “Dynamic title”
    //3. Assert : Message “Done” is displayed.
    //4. Assert : Image is displayed.
    //Note: Follow POM

    @Test
    public void waitPractice(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");
        DynamicLoad7Page waitPage = new DynamicLoad7Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        Assert.assertTrue(waitPage.doneMessage.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(waitPage.spongebobImage));
        Assert.assertTrue(waitPage.spongebobImage.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    //TC#41 : Dynamically Loaded Page Elements 1
    //    //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
    //    //2. Click to start
    //    //3. Wait until loading bar disappears
    //    //4. Assert username inputbox is displayed
    //    //5. Enter username: tomsmith
    //    //6. Enter password: incorrectpassword
    //    //7. Click to Submit button
    //    //8. Assert “Your password is invalid!” text is displayed.
    //    //Note: Follow POM Design Pattern
    public void loadingBarWait(){
        DynamicLoad1Page dl1Page = new DynamicLoad1Page();
        //Actions actions = new Actions(Driver.getDriver());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        dl1Page.startButton.click();
        wait.until(ExpectedConditions.invisibilityOf(dl1Page.loadingBar));
        Assert.assertTrue(dl1Page.usernameBox.isDisplayed());
        dl1Page.usernameBox.sendKeys("tomsmith");
        dl1Page.passwordBox.sendKeys("incorrectpassword");
        dl1Page.submitButton.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(dl1Page.errorMessage.isDisplayed());

        Driver.closeDriver();

}
}
