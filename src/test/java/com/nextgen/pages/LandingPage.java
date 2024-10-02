package com.nextgen.pages;

import com.nextgen.utils.basePage.BasePage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

     public void sendKeysToSearchInput(String keys) {
        waitElementBeClickable(searchInput); 
        searchInput.clear(); 
        searchInput.sendKeys(keys); 
    }

    public boolean isGloberNameListDisplayed(){
        waitForUserResultsToBeDisplayed();
        return !userResultsList.isEmpty();
    }

    private void waitForUserResultsToBeDisplayed() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".main-search-list__users > .main-search-list-item")));
    }

    public void clickOnFirstUserResult() {
        waitForUserResultsToBeDisplayed();
        if (!userResultsList.isEmpty()) {
            userResultsList.get(0).click(); 
        } else {
            throw new RuntimeException("No user results available to click.");
        }
    }
}
