package com.facebook.tests;

import com.comerce.base.TestBase;
import com.facebook.data.DataProv;
import com.facebook.pages.FriendPage;
import com.facebook.pages.HomePage;
import com.facebook.pages.LandingPage;
import com.facebook.pages.PeoplePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserFonctionality extends TestBase {
    private LandingPage landingPage;
    private HomePage homePage;
    private PeoplePage peoplePage;
    private FriendPage friendPage;

    @BeforeMethod
    private void pageObject() {
        landingPage = new LandingPage(driver);
        homePage = new HomePage(driver);
        peoplePage = new PeoplePage(driver);
        friendPage = new FriendPage(driver);

    }

    @Test(enabled = false, dataProvider = "search", dataProviderClass = DataProv.class)
    public void validateUserCanSearchFriend(String email, String password, String friend) {
        landingPage.loginFonctionality(email, password);
        homePage.typeSearchBoxAndClick(friend);
        peoplePage.searchValidation();
    }

    @Test(enabled = false, dataProvider = "searchsend", dataProviderClass = DataProv.class)
    public void validateUserAbleToSendFriendRequest(String email, String password, String friend) {
        landingPage.loginFonctionality(email, password);
        homePage.typeSearchBoxAndClick(friend);
        peoplePage.searchValidation();
        sleepFor(3);
        peoplePage.clickAddAndValidation();

    }

    @Test(enabled = false, dataProvider = "loginonce", dataProviderClass = DataProv.class)
    public void validateUserAbleToAcceptFriendRequest(String email, String password) {
        landingPage.loginFonctionality(email, password);
        sleepFor(3);
        homePage.clickFriendLogo();
        friendPage.clickConfirmeBtn();
        friendPage.acceptRequestValidation();
    }

    @Test(enabled = false, dataProvider = "like", dataProviderClass = DataProv.class)
    public void validateUserAbleToLikePost(String email, String password, String friend) {
        landingPage.loginFonctionality(email, password);
        homePage.typeSearchBoxAndClick(friend);
        peoplePage.clickOnfriend();
        friendPage.clickLikeBtn();
        friendPage.likeValidation();
    }

    @Test(enabled = false,dataProvider = "writecom", dataProviderClass = DataProv.class)
    public void validateUserCanCommentOnPost(String email, String password, String friend, String comment) {
        landingPage.loginFonctionality(email, password);
        homePage.typeSearchBoxAndClick(friend);
        peoplePage.clickOnfriend();
        friendPage.typeOnComment(comment);
        friendPage.commentValidation();
    }
    @Test( dataProvider = "loginonce", dataProviderClass = DataProv.class)
    public void validateUserCanAddPicture(String email, String password)  {
        landingPage.loginFonctionality(email, password);
        homePage.clickAddAndUpload();
        homePage.uploadValidation();

    }
}
