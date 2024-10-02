package com.nextgen.pages;

import com.nextgen.utils.basePage.BasePage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    // public void sendKeysToSearchInput(String keys) {
    //     waitElementBeClickable(searchInput); 
    //     searchInput.clear(); 
    //     searchInput.sendKeys(keys); 
    // }

    // public boolean isGloberNameListDisplayed(){
    //     waitForUserResultsToBeDisplayed();
    //     return !userResultsList.isEmpty();
    // }

    // private void waitForUserResultsToBeDisplayed() {
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".main-search-list__users > .main-search-list-item")));
    // }

    // public void clickOnFirstUserResult() {
    //     waitForUserResultsToBeDisplayed();
    //     if (!userResultsList.isEmpty()) {
    //         userResultsList.get(0).click(); 
    //     } else {
    //         throw new RuntimeException("No user results available to click.");
    //     }
    // }
}
