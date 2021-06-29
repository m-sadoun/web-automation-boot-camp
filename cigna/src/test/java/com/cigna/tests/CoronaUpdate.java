package com.cigna.tests;

import com.cigna.pages.CignaIntPage;
import com.cigna.pages.CoronaPage;
import com.cigna.pages.HomePage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CoronaUpdate extends TestBase {
    private HomePage homePage;
    private CignaIntPage cignaIntPage;
    private CoronaPage coronaPage;

    @BeforeMethod
    private void pages(){
         homePage= new HomePage(driver);
         cignaIntPage = new CignaIntPage(driver);
         coronaPage = new  CoronaPage(driver);
    }

    @Test
    public void validateUserCanSeeCoronaUpdates(){
        homePage.clickOnSignaInt();
        cignaIntPage.clickOnCoronaUpdate();
        coronaPage.coronaUpdateValidation();

    }
}
