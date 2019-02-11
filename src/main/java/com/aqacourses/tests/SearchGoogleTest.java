package com.aqacourses.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marina on 10.02.2019.
 */
public class SearchGoogleTest {

    //  Instance of Webdriver
    private WebDriver driver;

    /**
     * Set up method
     */
    @Before
    public void setUp() {

        //  Disable infobars
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        //  Initialize path to chromedriver
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 10 seconds to implicitly waits
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //  Maximize window
        driver.manage().window().maximize();
    }

    /**
     * Open google, search, get search result and go to page https://wwww.qasymphony.com
     */
    @Test
    public void searchGoogleTest() {

        // Open Google
        driver.get("http://google.com");

        // SendKeys keyword
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Automation testing");

        //  Click to Search Button
        driver.findElement(By.xpath("//div[@class='VlcLAe']//input[@name='btnK']")).click();

        //  find element
        WebElement link = driver.findElement(By.partialLinkText("https://www.qasymphony.com"));

        // create actions for move to element
        Actions actions = new Actions(driver);
        actions.moveToElement(link).perform();

        // click to search link
        link.click();

    }

    /**
     * After method, quit driver
     */
    @After
    public void tearDown() {

        // close window
        driver.quit();
    }
}