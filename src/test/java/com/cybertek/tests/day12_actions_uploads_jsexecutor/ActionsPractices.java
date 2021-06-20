package com.cybertek.tests.day12_actions_uploads_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void scrollingTask(){
        //go to http://practice.cybertekschool.com/
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //scroll down to "Powered By Cybertek School"
        Actions actions = new Actions(Driver.getDriver());

        //locate "Powered By Cybertek School"
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        //scroll using actions object
        BrowserUtils.sleep(2);
        actions.moveToElement(cybertekSchoolLink).perform();

        //scroll up using Keys.PAGE_UP
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).perform();

        Driver.closeDriver();
    }
    @Test
    public void uploadTask() {
        //TC #14: UploadTest
        // 1.Go to http://practice.cybertekschool.com/upload
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        // 2.Find some small file from your computer, and get the path of it.
        String filePath = "C:\\Users\\amjen\\Desktop\\CyberTek\\Slides\\Automation\\Transcripts.pdf";

        // 3.Upload the file.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(filePath);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        // 4.Assert: -File uploaded text is displayed on the page
        WebElement fileUploaded = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploaded.getText().equals("File Uploaded!"));

        Driver.closeDriver();
    }
    @Test
    public void hoverTask(){
        //TC #15: Hover Test
        // 1.Go to http://practice.cybertekschool.com/hovers
        // 2.Hover over to first image
        // 3.Assert: a.“name: user1” is displayed
        // 4.Hover over to second image
        // 5.Assert: a.“name: user2” is displayed
        // 6.Hover over to third image
        // 7.Confirm: a.“name: user3” is displayed

        Driver.getDriver().get((ConfigurationReader.getProperty("url")));

        ActionsPracticeUtils.imageHover(1);
        ActionsPracticeUtils.imageHover(2);
        ActionsPracticeUtils.imageHover(3);

        Driver.closeDriver();
    }
    @Test
    public void doubleClickTask(){
        //TC #16: Double ClickTest
        // 1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        // 2.Switch to iframe.
        // 3.Double click on the text “Double-click me to change my text color.”
        // 4.Assert: Text’s “style” attribute value contains “red”.
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        WebElement iframe = Driver.getDriver().findElement(By.tagName("iframe"));
        Driver.getDriver().switchTo().frame(iframe);

        WebElement text = Driver.getDriver().findElement(By.id("demo"));
        actions.moveToElement(text).doubleClick().perform();

        Assert.assertTrue(text.getAttribute("style").contains("red"));

        Driver.closeDriver();

    }
    @Test
    public void dragAndDropTask(){
        //TC #16: Hover Test
        // 1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        // 2.Drag and drop the small circle to bigger circle.
        // 3.Assert: -Text in big circle changedto: “You did great!”

        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        actions.dragAndDrop(smallCircle, bigCircle).perform();
        BrowserUtils.sleep(1);

        Assert.assertEquals(bigCircle.getText(), "You did great!");
    }
    @Test
    public void contextClick(){
        //TC #17: Context Click –HOMEWORK
        // 1.Go to https://the-internet.herokuapp.com/context_menu
        // 2.Right click to the box.
        // 3.Alert will open.
        // 4.Accept alert - No assertion needed for this practice.

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(Driver.getDriver());

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
}
