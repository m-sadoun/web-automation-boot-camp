package com.cigna.tests;

import com.cigna.data.CignaData;
import com.cigna.pages.HomePage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {
    private HomePage homePage;

    @BeforeMethod
    public void pages(){
         homePage= new HomePage(driver);
    }

    @Test(dataProvider = "login",dataProviderClass = CignaData.class)
    public void validateUserCanNontLoginWithInvalidCredentiels(String email, String password){
        homePage.brwosing();
        homePage.typefields(email,password);
        homePage.clickLogin();
        homePage.loginvalidation();

    }
}
