package com.facebook.tests;

import com.comerce.base.TestBase;
import com.facebook.data.DataProv;
import com.facebook.pages.LandingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccount extends TestBase {
    private LandingPage landingPage;

    @BeforeMethod
    private void pageObject(){
        landingPage = new LandingPage(driver);

    }

    @Test(dataProvider = "acountdata",dataProviderClass = DataProv.class)
    public void validateUserCanCreateAccount(String name, String lastN, String email, String password){
        landingPage.cliskCreateAccountBtn();
        landingPage.verifieAndTypeOnFields(name,lastN,email,password);
        landingPage.selectBirthDay();
        landingPage.selectGendre();
        landingPage.creationValidation();
    }
}
