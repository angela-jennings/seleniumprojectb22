package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Apple {
    public static void main(String[] args) throws InterruptedException {
        //TC #03: FINDELEMENTS_APPLE1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3.Click to all of the headers one by one
            // a.Mac, iPad, iPhone, Watch, TV, Music, Support

        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));
        //storing 9 web elements including "apple" logo and "search" box

        for(int eachLinkIndex = 1; eachLinkIndex <headerLinks.size()-1; eachLinkIndex++){
            //System.out.println(headerLinks.get(eachLinkIndex).getText());

            headerLinks.get(eachLinkIndex).click();
            Thread.sleep(1000);

            // 4.Print out the titles of the each page
            System.out.println("current title on the page - " + driver.getTitle());

            // 5.Print out total number of links in each page
            List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
            System.out.println("number of links on current page - " + allLinks.size());

            int linksWithNoText = 0;
            int linksWithText = 0;

            for (WebElement allLink : allLinks) {
                if(allLink.getText().isEmpty()){
                    linksWithNoText++;
                }else{
                    linksWithText++;
                }
            }

            // 6.While in each page:
            // a. Print out how many link is missing text TOTAL
            System.out.println("----> current page links with NO TEXT: " + linksWithNoText);

            // b. Print out how many link has text TOTAL
            System.out.println("----> current page links WITH TEXT: " + linksWithText);

            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));
            //above basically refreshes the page everytime by pointing back to the original reference point

        }


    }
}
