package com.cybertek.tests.office_hours.practice_06_23_2021;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class TechCrunch {
    // (//article[@class='post-block post-block--image post-block--unread'])[1]//a
    @Test
    public void techCrunchTestCase() {
        Driver.getDriver().get("https://techcrunch.com/");
        List<WebElement> latestNewsLinks = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));

        BrowserUtils.sleep(2);
        for (int i = 1; i < latestNewsLinks.size(); i++) {
            String authorLocator = "(//article[@class='post-block post-block--image post-block--unread'])[" + i + "]//a[contains(@aria-label, 'Posts by')]";
            WebElement authorElement = Driver.getDriver().findElement(By.xpath(authorLocator));
            Assert.assertTrue(authorElement.isDisplayed());
            String imageLocator = "(//article[@class='post-block post-block--image post-block--unread'])["+i+"]//img[@sizes ='(min-width: 1024px) 430px, 100vw']";
            WebElement imageElement = Driver.getDriver().findElement(By.xpath(imageLocator));
            Assert.assertTrue(imageElement.isDisplayed());
        }

        Random random = new Random();
        int newsNumber = random.nextInt(latestNewsLinks.size()+1);
        latestNewsLinks.get(newsNumber).click();
        BrowserUtils.sleep(2);
        String expTitle = Driver.getDriver().findElement(By.xpath("(//h1)[1]")).getText();
        String actTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actTitle.contains(expTitle));

        List<WebElement> links = Driver.getDriver().findElements(By.xpath("//div[@class='article-content']/p/a"));
        for(WebElement each : links){
            System.out.println(each.getAttribute("href"));
        }

    Driver.closeDriver();
    }

}
