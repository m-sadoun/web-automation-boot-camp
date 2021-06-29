package com.amazon.tests;

import com.amazon.pages.AccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;

public class OtherFonctionality extends TestBase {
    private HomePage homePage;
    private Login login;
    private AccountPage account;
    private SignInPage signIn;

    @BeforeMethod
    private void pagesObject() {
        homePage = new HomePage(driver);
        login = new Login();
        account = new AccountPage(driver);
        signIn = new SignInPage(driver);
    }


}
