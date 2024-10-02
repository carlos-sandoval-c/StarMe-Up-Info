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
        waitElementBeClickable(logoHomeBtn);
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
