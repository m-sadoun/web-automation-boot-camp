package com.amazon.tests;


import com.amazon.data.DataProviders;
import com.amazon.pages.AccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut extends TestBase {
    private HomePage homePage;
    private AccountPage account;
    private SignInPage signIn;
    private Login login;


    @BeforeMethod
    private void pageObject() {
        homePage = new HomePage(driver);
        account = new AccountPage(driver);
        signIn = new SignInPage(driver);
        login = new Login();
    }

    @Test( dataProvider = "logindata", dataProviderClass = DataProviders.class)
    public void ValidateUserCanLogOutUsingMouseHouver(String email, String password) {
        login.userLoginAction(homePage, account, signIn, email, password);
        homePage.locateAccountAndList();
        homePage.mouseHouverLogOut();
        homePage.navigateHomePage();
        homePage.logOutValidation();

    }
}
