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

    @BeforeMethod
    private void pageObject() {
        homePage = new HomePage(driver);

    }

    @Test(enabled = false,dataProvider = "logindata", dataProviderClass = DataProviders.class)//10
    public void validateUserCanLoginWithValidCredentiels(String email, String password) {
         homePage.loginFonctionalities(email,password);
    }

    @Test(enabled = false)//11
    public void validateUserCanLoginWithValidDataFromDataBase() {
        ArrayList<String> user = ConnectDB.connectToDbAndGetDtata("select * from amazon;", "email", "password");
        homePage.loginFonctionalities(user.get(0),user.get(1));
    }

    @Test(enabled = false, dataProvider = "loginInvalidpasword", dataProviderClass = DataProviders.class)//13
    public void validateUserCannotLoginWithInvalidPassword(String email, String password) {
        homePage.loginFonctionalities(email,password);
    }

    @Test( dataProvider = "loginInvaliddata", dataProviderClass = DataProviders.class)//14
    public void vlaidateusercannotLoginWithInvaliddata(String email, String password) {
        homePage.loginFonctionalities(email,password);

    }


}

