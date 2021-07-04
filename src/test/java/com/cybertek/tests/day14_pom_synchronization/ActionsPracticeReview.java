package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.TelerikPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPracticeReview {
    @Test
    public void dragAndDropTest(){
        /*
        TC #16: Hover Test
        1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        2.Drag and drop the small circle to bigger circle.
        3.Assert: -Text in big circle changedto: “You did great!”
         */

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.sleep(2);
        Actions action = new Actions(Driver.getDriver());
        TelerikPage tp = new TelerikPage();
        tp.acceptCookiesButton.click();
        action.sendKeys(Keys.DOWN);
        BrowserUtils.sleep(2);

        //first way of dragging the circle using drag and drop
        action.dragAndDrop(tp.smallCircle, tp.bigCircle).perform();

        //second way of moving an object using click and hold - longer way of writing
        //action.moveToElement(tp.smallCircle).clickAndHold(tp.smallCircle).moveToElement(tp.bigCircle).release().perform();

        BrowserUtils.sleep(2);

        Assert.assertEquals(tp.bigCircle.getText(), "You did great!");

        Driver.closeDriver();
    }
}
