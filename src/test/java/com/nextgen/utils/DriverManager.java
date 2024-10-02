package com.nextgen.utils;

import com.nextgen.utils.Logger.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Getter
public class DriverManager {
    private final WebDriver driver;

    public DriverManager(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
        }
    }

    public void goToUrl(String url) {
        if (url == null || url.isEmpty()) {
            Log.warn("DriverManager - goToUrl: Null or empty string is used. Keep in page");
            return;
        }
        this.driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void close() {
        driver.close();
    }
}