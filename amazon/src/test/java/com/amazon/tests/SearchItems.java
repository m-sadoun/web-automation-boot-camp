package com.amazon.tests;

import com.amazon.data.DataProviders;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.comerce.base.ConnectDB;
import com.comerce.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SearchItems extends TestBase {
    private HomePage homePage;
    private ProductPage product;

    @BeforeMethod
    private void pagesObject() {
        homePage = new HomePage(driver);
        product = new ProductPage(driver);
    }

    public void preformSearchAction(HomePage homePage, String item) {
        homePage.typeOnSearchBox(item);
        homePage.clickOnSearchbutton();
        homePage.searchValidation(item);

    }

    @Test(enabled = false, dataProvider = "searchData", dataProviderClass = DataProviders.class)//15
    public void validatNonRegistredCustomerCanSearchItmes(String item) {
        preformSearchAction(homePage, item);

    }

    @Test(enabled = false)//16
    public void validatNonRegistredCustomerCanSearchItmesfromDb() {
        ArrayList<String> data = ConnectDB.connectToDbAndGetDtata("select * from items", "itemname");
        for (int i = 0; i < data.size(); i++) {
            preformSearchAction(homePage, data.get(i));
            homePage.clearSearchBox();
        }
    }

    @Test(enabled = false, dataProvider = "searchCustData", dataProviderClass = DataProviders.class)//17
    public void validateRegistredCustmerCanSearchItme(String email, String password, String item) {
        homePage.loginFonctionalities(email, password);
        preformSearchAction(homePage, item);

    }

    @Test(enabled = false)//18
    public void validateRegistredCustmerCanSearchItmesFromDb() {
        ArrayList<String> items = ConnectDB.connectToDbAndGetDtata("select * from items", "itemname");
        ArrayList<String> users = ConnectDB.connectToDbAndGetDtata("select * from amazon", "email", "password");
        homePage.loginFonctionalities(users.get(0), users.get(1));
        for (int i = 0; i < items.size(); i++) {
            preformSearchAction(homePage, items.get(i));
            homePage.clearSearchBox();
        }

    }

    @Test(enabled = false, dataProvider = "searchOne", dataProviderClass = DataProviders.class)
    public void validateUserCanScrollDownElementAndClick(String item) {
        preformSearchAction(homePage, item);
        product.scrollDownToElement();
        product.informationValidation();
    }

    @Test(dataProvider = "dpt", dataProviderClass = DataProviders.class)
    public void validateUserCanSelectDepartementFromDropDown(String department) {
        homePage.selecFreomDropList(department);
        homePage.dropListValidation(department);
    }


}
