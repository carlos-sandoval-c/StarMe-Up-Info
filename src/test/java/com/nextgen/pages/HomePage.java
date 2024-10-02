package com.nextgen.pages;

import com.nextgen.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCorrectURL() {
        return verifyUrlContains("home");
    }

    public void waitHomePageLoad() {
        waitElementIsDisplayed(logoImg);
        waitElementBeClickable(searchInput);
    }
}
