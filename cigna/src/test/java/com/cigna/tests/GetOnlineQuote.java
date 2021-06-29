package com.cigna.tests;

import com.cigna.data.CignaData;
import com.cigna.pages.HomePage;
import com.cigna.pages.QuotePage;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetOnlineQuote extends TestBase {
    private HomePage homePage;
    private QuotePage quotePage;

    @BeforeMethod
    public void pages() {
        homePage = new HomePage(driver);
        quotePage= new QuotePage(driver);
    }


    @Test(dataProvider = "quote",dataProviderClass = CignaData.class)
    public void validateUserAbleToGetOnlineQuote(String zipCode,String name) {
       homePage.clickOnlineHealth();
       sleepFor(3);
       homePage.clickOngetOnlineQuote();
        quotePage.typeFieldsAndClick(zipCode,name);
        quotePage.seeQuoteValidation();


    }
}