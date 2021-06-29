package com.cnn.tests;

import com.cnn.data.CDataPro;
import com.cnn.pages.CHomePage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut extends TestBase {
    private CHomePage cHomePage;

    @BeforeMethod
    private void pageOb(){
        cHomePage =new CHomePage(driver);
    }

    @Test(dataProvider = "loginonce",dataProviderClass = CDataPro.class)
    public void validateUserCannLogOut(String name, String password){
        cHomePage.loginFonctionality(name,password);
        cHomePage.clickOnLogout();


    }

}
