package com.facebook.tests;

import com.comerce.base.TestBase;
import com.facebook.data.DataProv;
import com.facebook.pages.LandingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {
    private LandingPage landingPage;

    @BeforeMethod
    private void pageObject() {
        landingPage = new LandingPage(driver);

    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProv.class)
    public void validateUserLoginCases(String email, String password) {
        landingPage.loginFonctionality(email, password);
    }

}
