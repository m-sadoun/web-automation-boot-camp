package com.citi.tests;

import com.citi.data.DataP;
import com.citi.pages.HomePage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {
    private HomePage homePage;

    @BeforeMethod
    private void page(){
        homePage= new HomePage(driver);
    }

    @Test(dataProvider = "login",dataProviderClass = DataP.class)
    public void validateUserCanNotLoginWithInvalidData(String user,String pass){
        homePage.typeInfieldsAndClick(user,pass);
        homePage.signInValidation();
    }
}
