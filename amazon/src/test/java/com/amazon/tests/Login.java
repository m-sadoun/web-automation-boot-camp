package com.amazon.tests;

import com.amazon.data.DataProviders;
import com.amazon.pages.AccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import com.comerce.base.ConnectDB;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class Login extends TestBase {
    private HomePage homePage;
    private AccountPage account;
    private SignInPage signIn;

    @BeforeMethod
    private void pageObject() {
        homePage = new HomePage(driver);
        account = new AccountPage(driver);
        signIn = new SignInPage(driver);
    }

    public void userLoginAction(HomePage homePage, AccountPage account, SignInPage signIn, String username, String password) {
        homePage.locateAccountAndList();
        homePage.mouseHouverClick();
        account.clickLoginAndSecurity();
        signIn.typeInEmailBox(username);
        signIn.clickContinueButton();
        signIn.typePassword(password);
        signIn.clickSigInButton();
        signIn.clickDoneButton();
        account.loginValidation();

    }

    @Test( dataProvider = "logindata", dataProviderClass = DataProviders.class)//10
    public void validateUserCanLoginWithValidCredentiels(String email, String password) {
        userLoginAction(homePage, account, signIn, email, password);

    }

    @Test(enabled = false)//11
    public void validateUserCanLoginWithValidDataFromDataBase() {
        ArrayList<String> user = ConnectDB.connectToDbAndGetDtata("select * from amazon;", "email", "password");
        userLoginAction(homePage, account, signIn, user.get(0), user.get(1));

    }

    @Test(enabled = false, dataProvider = "loginInvalidpasword", dataProviderClass = DataProviders.class)//13
    public void validateUserCannotLoginWithInvalidPassword(String email, String password) {
        homePage.locateAccountAndList();
        homePage.mouseHouverClick();
        account.clickLoginAndSecurity();
        signIn.typeInEmailBox(email);
        signIn.clickContinueButton();
        signIn.typePassword(password);
        signIn.clickSigInButton();
        signIn.validationWrongPassword();

    }

    @Test( enabled = false,dataProvider = "loginInvaliddata", dataProviderClass = DataProviders.class)//14
    public void vlaidateusercannotLoginWithInvaliddata(String email, String password) {
        homePage.locateAccountAndList();
        homePage.mouseHouverClick();
        account.clickLoginAndSecurity();
        signIn.typeInEmailBox(email);
        signIn.clickContinueButton();
        signIn.vlaidationWrongUsernam();

    }


}

