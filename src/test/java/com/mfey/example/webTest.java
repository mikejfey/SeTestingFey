package com.mfey.example;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class webTest {
    // This JUnit test case class contains everything needed to run a full visual test against the ACME bank site.
    // It runs the test once locally.
    // If you use the Ultrafast Grid, then it performs cross-browser testing against multiple unique browsers.
    // It runs the test from a main function, not through a test framework.
   protected RemoteWebDriver driver;
    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();

        browserOptions.setCapability("platformName", "Android");
        browserOptions.setCapability("browserName", "Chrome");
        // --- to run on iphone simulater ----
        // browserOptions.setCapability("platformName", "iOS");
        //browserOptions.setCapability("browserName", "Safari");
      //  browserOptions.setCapability("appium:deviceName", "iPhone Simulator");
       // browserOptions.setCapability("appium:platformVersion", "16.1");
      //  browserOptions.setCapability("appium:automationName", "XCUITest");
        // ---- to run on real iPhone
     // browserOptions.setCapability("deviceName","iPhone");
        // browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("realDevice", false);
        sauceOptions.put("username", "glossier-auto");
        sauceOptions.put("accessKey", "f6e2fa96-448c-4524-a7d2-c413226c7af1");
        sauceOptions.put("build", "android chrome");
        // sauceOptions.put("name", "DemoTest");
        browserOptions.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        //RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
        driver = new RemoteWebDriver(url, browserOptions);
    }
    @Test
    public void correctTitle() throws InterruptedException {
        driver.navigate().to("https://www.glossier.com/collections/brow?parent_collection=makeup");
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".swatch--blond")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".swatch--brown")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".swatch--auburn")).click();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//span[contains(.,\'Add to bag\')]")).click();
        Thread.sleep(10000);
        driver.quit();
    }
    //@AfterMethod
   // public void teardown(ITestResult result) {
     //   String status = result.isSuccess() ? "passed" : "failed";
      //  driver.executeScript("sauce:job-result=" + status);
   // }


}
