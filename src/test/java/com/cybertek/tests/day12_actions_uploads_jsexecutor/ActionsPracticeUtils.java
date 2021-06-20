package com.cybertek.tests.day12_actions_uploads_jsexecutor;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionsPracticeUtils {

    public static void imageHover(int imageNum){
        Actions actions = new Actions(Driver.getDriver());
        WebElement image = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])["+imageNum+"]"));
        actions.moveToElement(image).perform();

        WebElement userNameText = Driver.getDriver().findElement(By.xpath("(//h5)["+imageNum+"]"));
        Assert.assertEquals(userNameText.getText(), "name: user" + imageNum);
    }
}
