package com.gic.tution_center.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    public static WebDriver driver;

    public void openBrowser () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void implicitWait(int waitTime) {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }
}

