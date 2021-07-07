package com.cybertek.tests.office_hours.practice_06_30_2021;

import com.cybertek.pages.OfficeHoursPages.AmazonPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.OfficeHoursUtilities.AmazonUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonUtilsCases {
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
    }

    @Test
    public void hatTest(){
        AmazonPage amazonPage = new AmazonPage();
        Actions actions = new Actions(Driver.getDriver());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        for(WebElement each : amazonPage.dashboardItems){
            System.out.println(each.getText());
        }
        amazonPage.searchBar.sendKeys(ConfigurationReader.getProperty("searchAmazon") + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(amazonPage.firstSearchResult));
        amazonPage.firstSearchResult.click();

        String priceText = amazonPage.itemPrice.getText();
        double singlePriceForHat = AmazonUtils.priceConverter(priceText);

        Select quantityDropdown = new Select((amazonPage.quantityDropdownMenu));
        quantityDropdown.selectByIndex(1);
        amazonPage.addToCartButton.click();
        BrowserUtils.sleep(2);
        amazonPage.shoppingCart.click();

        Assert.assertTrue(amazonPage.cartItemTotal.getText().contains("2 items"));

        Assert.assertEquals(singlePriceForHat*2, AmazonUtils.priceConverter(amazonPage.cartSubTotal.getText()));

        Select updateCartDropDown = new Select((amazonPage.updateCartDropDown));
        updateCartDropDown.selectByIndex(1);
        BrowserUtils.sleep(2);

        Assert.assertTrue(amazonPage.cartItemTotal.getText().contains("1 item"));

        Assert.assertEquals(singlePriceForHat, AmazonUtils.priceConverter(amazonPage.cartSubTotal.getText()));
    }
}
