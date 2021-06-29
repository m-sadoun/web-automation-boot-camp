package com.cnn.tests;

import com.cnn.data.CDataPro;
import com.cnn.pages.CHomePage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login  extends TestBase {
    private CHomePage cHomePage;

    @BeforeMethod
    private void pageOb(){
        cHomePage =new CHomePage(driver);
    }
    @Test(dataProvider = "loginData",dataProviderClass = CDataPro.class)
    public void validateUserCannOtLoginWithInvalidCredentiels(String name, String password){
        cHomePage.loginFonctionality(name,password);


    }
}
