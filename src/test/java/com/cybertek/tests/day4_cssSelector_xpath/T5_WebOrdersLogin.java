package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_WebOrdersLogin {
    public static void main(String[] args) {

//        1- Open	a	chrome	browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
//        2- Go	to:
//        http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();

//        3- Verify	title	equals:
//        Expected:	Web	Orders	Login
        String expTitle = "Web Orders Login";
        String actTitle = driver.getTitle();

        if(actTitle.equals(expTitle)){
            System.out.println("title verification passed");
        }else{
            System.out.println("title verification failed");
        }

//        4- Enter	username:	Tester
        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUsername.sendKeys("Tester");

//        5- Enter	password:	test
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");

//        6- Click	“Sign	In”	button
        WebElement signInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        signInButton.click();

//        7- Verify	title equals:
        String expSignInTitle = "Web Orders";
        String actSignInTitle = driver.getTitle();

        if(actSignInTitle.equals(expSignInTitle)){
            System.out.println("Login title passed");
        }else{
            System.out.println("login title failed");
        }
//        Expected:	Web	Orders




    }
}
