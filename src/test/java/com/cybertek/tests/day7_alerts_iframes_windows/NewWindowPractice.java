package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewWindowPractice {
    //TC	#	:	Window	Handle practice
    //1. Create	a	new	class	called:	WindowHandlePractice
    //2. Create	new	test	and	make	set	ups
    //3. Go	to	:	http://practice.cybertekschool.com/windows
    //4. Assert:	Title	is	“Practice”
    //5. Click	to:	“Click	Here” text
    //6. Switch	to	new	Window.
    //7. Assert:	Title	is	“New	Window”

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //1. Create	a	new	class	called:	WindowHandlePractice
        //2. Create	new	test	and	make	set	ups
        //3. Go	to	:	http://practice.cybertekschool.com/windows
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");

    }

    @Test
    public void newWindow(){
        String mainHandle = driver.getWindowHandle();

        //4. Assert:	Title	is	“Practice”
        String actualTitle = driver.getTitle();
        String expTitle = "Practice";

        Assert.assertEquals(driver.getTitle(), "Practice");

        System.out.println("actual title before click - " + actualTitle);

        //5. Click	to:	“Click	Here” text
        WebElement clickHereLink = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHereLink.click();

        for(String eachWindow : driver.getWindowHandles()){
            driver.switchTo().window(eachWindow);
            System.out.println("Current Title while switching = " + driver.getTitle());

//            if(driver.getTitle().contains("New Window")){
//                break;
//            }   <-- this is optional, especially if you have multiple windows
        }

        String actualTitleAfterClick = driver.getTitle();
        System.out.println("actual title after click - " + actualTitleAfterClick);

        //6. Switch	to	new	Window.



        //7. Assert:	Title	is	“New	Window”
        Assert.assertEquals(driver.getTitle(), "New Window");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
