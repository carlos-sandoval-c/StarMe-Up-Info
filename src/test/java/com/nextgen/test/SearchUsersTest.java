package com.nextgen.test;

import com.nextgen.pages.HomePage;
import com.nextgen.pages.LandingPage;
import com.nextgen.pages.UserMainPage;
import com.nextgen.utils.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchUsersTest extends BaseTest {
    @Test
    public void getTotalStars() {
        HomePage homePage = loadHomePage();
        Assert.assertTrue(homePage.isCorrectURL());
        homePage.waitHomePageLoad();
        Assert.assertTrue(homePage.isLogoDisplayed());
        Assert.assertTrue(homePage.isSearchInputEnabled());

        LandingPage landPage = loadFirstPage();
        
        String searchTerm = "Carlos Santiago Sandoval";
        landPage.sendKeysToSearchInput(searchTerm);

        Assert.assertTrue(landPage.isGloberNameListDisplayed());

        landPage.clickOnFirstUserResult();

        UserMainPage userMainPage = loadProfile();

        userMainPage.untilImgIsDisplayed();

        Assert.assertTrue(userMainPage.isAvatarDisplayed());





    }
}
