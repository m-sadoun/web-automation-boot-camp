package com.amazon.tests;


import com.amazon.data.DataProviders;
import com.amazon.pages.CreatAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import com.comerce.base.ConnectDB;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CreatAccount extends TestBase {
    private HomePage homePage;
    private CreatAccountPage creatAccount;
    private SignInPage signIn;

    @BeforeMethod
    private void pageObject() {
        homePage = new HomePage(driver);
        creatAccount = new CreatAccountPage(driver);
        signIn = new SignInPage(driver);

    }

    private void createAcountfonctionality(HomePage homePage, CreatAccountPage creatAccount, SignInPage signIn, String name, String email, String password) {
        homePage.clickSigninLink();
        signIn.validation();
        signIn.clickCreatAcountButton();
        creatAccount.validation();
        creatAccount.nameDisplayed();
        creatAccount.typeName(name);
        creatAccount.emailDisplayed();
        creatAccount.typeEmail(email);
        creatAccount.passwordDisplayed();
        creatAccount.typePassowrd(password);
        creatAccount.retaypePasswordDisplayed();
        creatAccount.retypePassword(password);
        creatAccount.creatYourAmazonButton();
    }

    @Test
    public void validateUserAbleToCreateAcountDataFromDb()//8
    {
        ArrayList<String> user = ConnectDB.connectToDbAndGetDtata("select * from account");
        createAcountfonctionality(homePage, creatAccount, signIn, user.get(0), user.get(1), user.get(2));
    }

    @Test(dataProvider = "accountData", dataProviderClass = DataProviders.class)//9
    public void validateUserAbleToCreateAccount(String name, String email, String password) {
        createAcountfonctionality(homePage, creatAccount, signIn, name, email, password);
    }
}
