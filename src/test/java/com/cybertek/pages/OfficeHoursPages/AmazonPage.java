package com.cybertek.pages.OfficeHoursPages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {
public AmazonPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}
    @FindBy(xpath = "//a[@class='nav-a  ']")
    public List<WebElement> dashboardItems;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(xpath = "(//img[@data-image-index='1'])[1]")
    public WebElement firstSearchResult;

    @FindBy(id = "quantity")
    public WebElement quantityDropdownMenu;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(id = "price_inside_buybox")
    public WebElement itemPrice;

    @FindBy(id = "nav-cart")
    public WebElement shoppingCart;

    @FindBy(id = "sc-subtotal-label-activecart")
    public WebElement cartItemTotal;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
    public WebElement cartSubTotal;

    @FindBy(name = "quantity")
    public WebElement updateCartDropDown;



}
