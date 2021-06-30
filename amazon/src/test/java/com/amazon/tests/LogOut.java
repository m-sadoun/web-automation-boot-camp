package com.amazon.tests;


import com.amazon.data.DataProviders;
import com.amazon.pages.HomePage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut extends TestBase {
    private HomePage homePage;


    @BeforeMethod
    private void pageObject() {
        homePage = new HomePage(driver);
    }

    @Test(dataProvider = "logindata", dataProviderClass = DataProviders.class)
    public void ValidateUserCanLogOutUsingMouseHouver(String email, String password) {
        homePage.loginFonctionalities(email, password);
        homePage.locateAccountAndList();
        homePage.mouseHouverLogOut();
        homePage.navigateHomePage();
        homePage.logOutValidation();

    }
}
