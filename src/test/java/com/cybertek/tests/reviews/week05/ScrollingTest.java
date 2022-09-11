package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
    http://practice.cybertekschool.com/

    - P.I.Q.: How many ways do you know to scroll using Selenium?
    1. action.moveToElement().perform()
    2. PageUp, PageDown keys for scrolling

        action.sendKeys(Keys.PAGE_UP, PAGE_DOWN)

    3. jse.executeScript("window.scrollBy(0,250)");
    4. jse.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink);
     */

public class ScrollingTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void moveToElementTest() throws InterruptedException {
        //Scroll down to "Powered by Cybertek School"
        Actions actions = new Actions(driver);
        WebElement cybertekschoolLink = driver.findElement(By.linkText("Cybertek School"));
        //Scrolling to that element
        Thread.sleep(5000);     //checked exception

        actions.moveToElement(cybertekschoolLink).perform();

        //advanced Keyboard acion
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
    }

    @Test
    public void scrollTestWithJSE() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //first way
        Thread.sleep(2000);
        jse.executeScript("window.scroll(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        jse.executeScript("window.scroll(0,-document.body.scrollHeight)");
        Thread.sleep(1000);
        //second way
        WebElement cybertekschoolLink = driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true)", cybertekschoolLink);
        Thread.sleep(1000);


    }
/*
    HW: v.Test application www.IonicPartners.com:
        vi. Test 1: Go to <Blog> page and scroll it down
        vii. Test 2: Go to <About> page, scroll it down and click on Twitter icon at the bottom of the page
 */
}
