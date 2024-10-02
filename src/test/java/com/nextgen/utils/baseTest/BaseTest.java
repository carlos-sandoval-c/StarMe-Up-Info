package com.nextgen.utils.baseTest;

import com.nextgen.pages.HomePage;
import com.nextgen.pages.LandingPage;
import com.nextgen.utils.DriverManager;
import com.nextgen.utils.Logger.Log;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected DriverManager driverManager;

    protected void navigateTo(String url) {
        driverManager.goToUrl(url);
    }

    protected LandingPage loadFirstPage() throws NullPointerException {
        if (driverManager == null || driverManager.getDriver() == null) {
            Log.error("BaseTest - LoadFirstPage: Error in the reference of the DriverManager or the WebDriver managed by it.");
            throw new NullPointerException("DriverManager is null or DriverManager.getDriver() return null");
        }

        return new LandingPage(driverManager.getDriver());
    }

    protected HomePage loadHomePage() throws NullPointerException {
        if (driverManager == null || driverManager.getDriver() == null) {
            Log.error("BaseTest - LoadHomePage: Error in the reference of the DriverManager or the WebDriver managed by it.");
            throw new NullPointerException("DriverManager is null or DriverManager.getDriver() return null");
        }
        driverManager.goToUrl("https://app.starmeup.com/home");
        return new HomePage(driverManager.getDriver());
    }

    @BeforeSuite
    protected void setupDriver() {
        String browser = "chrome"; // TODO: Use data provider, env vars o something more scalable
        String url = "https://www.starmeup.com/en.html";
        driverManager = new DriverManager(browser);
        driverManager.maximizeWindow();
        navigateTo(url);
    }

    @BeforeTest
    protected void manualLogin() {
        LandingPage landingPage = loadFirstPage();
        Assert.assertFalse(landingPage.isUserRedirected());
        Assert.assertTrue(landingPage.isLoginBtnClickable());
        landingPage.startManualLogin();
    }

    @AfterTest
    protected void closeDriver() {
        driverManager.close();
    }
}
