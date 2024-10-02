package com.nextgen.pages;

import com.nextgen.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    @FindBy(css = "header button")
    protected WebElement loginBtn;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserRedirected() {
        return !verifyUrlContains("/en.html"); // Verify that you have not been redirected.
    }

    public boolean isLoginBtnClickable() {
        return loginBtn.isDisplayed() && loginBtn.isEnabled();
    }

    public void startManualLogin() {
        waitElementBeClickable(loginBtn);
        loginBtn.click();
        manualLoginWait();
    }
}
