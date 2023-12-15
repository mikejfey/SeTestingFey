package com.applitools.example;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class AcmeBankTest {
    // This JUnit test case class contains everything needed to run a full visual test against the ACME bank site.
    // It runs the test once locally.
    // If you use the Ultrafast Grid, then it performs cross-browser testing against multiple unique browsers.
    // It runs the test from a main function, not through a test framework.
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
       // System.setProperty("webdriver.chrome.driver","/Users/michafey/chromedriver-mac-x64/chromedriver");
      //  WebDriver driver = new ChromeDriver();

    }
    @Test
    public void logIntoBankAccounttest() {


        System.setProperty("webdriver.chrome.driver","/Users/michafey/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
      System.out.println("running the test");
        driver.get("https://demo.applitools.com");

        driver.manage().window().setSize(new Dimension(1558, 983));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("mike");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("mike");
        driver.findElement(By.id("log-in")).click();
        driver.close();
        // Verify the full login page loaded correctly.
        //eyes.check(Target.window().fully().withName("Login page"));

        // Perform login.
       // driver.findElement(By.id("username")).sendKeys("applibotxxxxFey");
       // eyes.check(Target.window().fully().withName("Username entered"));
       // driver.findElement(By.id("password")).sendKeys("I<3VisualTests");
      // Thread.sleep(5000);
       // System.out.println("sleep a couple of seconds");
      // driver.findElement(By.id("log-in")).click();

        // Verify the full main page loaded correctly.
        // This snapshot uses LAYOUT match level to avoid differences in closing time text.
        //eyes.check(Target.window().fully().withName("Main page").layout());
    }




}
