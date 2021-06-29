package com.citi.tests;

import com.citi.pages.AllCardPage;
import com.citi.pages.HomePage;
import com.citi.pages.OnlineAccesPage;
import com.citi.pages.RecoveryPage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserFonctionalities extends TestBase {
    private HomePage homePage;
    private AllCardPage allCardPage;
    private RecoveryPage recoveryPage;
    private OnlineAccesPage onlineAccesPage;

    @BeforeMethod
    private void pages(){
         homePage= new HomePage(driver);
         allCardPage = new AllCardPage(driver);
         recoveryPage = new RecoveryPage(driver);
         onlineAccesPage= new OnlineAccesPage(driver);
    }

    @Test
    public void validateUserCanSeeDifferentCards(){
         homePage.moveToCreditCards();
         homePage.moveTViewAllAndClick();
         allCardPage.viewAllCardsValidation();

    }

    @Test
    public void validatUserAbleTorecoverIdOrPassword(){
        homePage.clickforgetUser();
        recoveryPage.vlaidationCredentielRecovery();
    }

    @Test
    public void validatUserAbleToRegisterOnLine(){
        homePage.clickregisterOnline();
        onlineAccesPage.onlineaccessvali();

    }
}
