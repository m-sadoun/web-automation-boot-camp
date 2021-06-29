package com.amazon.tests;

import com.amazon.data.DataProviders;
import com.amazon.pages.*;
import com.comerce.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivityCart extends TestBase {
    private HomePage homePage;
    private Login login;
    private AccountPage account;
    private SignInPage signIn;
    private SearchItems searchItems;
    private ProductPage product;
    private CartPage cartPage;

    @BeforeMethod
    private void pagesObject() {
        homePage = new HomePage(driver);
        login = new Login();
        account = new AccountPage(driver);
        signIn = new SignInPage(driver);
        searchItems = new SearchItems();
        product = new ProductPage(driver);
        cartPage = PageFactory.initElements(driver, CartPage.class);

    }

    @Test(enabled = false, dataProvider = "searchCustData", dataProviderClass = DataProviders.class)//1
    public void validateCustomerCanAddSearchedItemToCart(String email, String password, String item) {
        login.userLoginAction(homePage, account, signIn, email, password);
        searchItems.preformSearchAction(homePage, item);
        product.clickOnHpLaptop();
        product.clickOnAddToCart();
        cartPage.navigateToCart();
        cartPage.validateExisting();
    }

    @Test(enabled = false, dataProvider = "logindata", dataProviderClass = DataProviders.class)//2
    public void validateCustmerAbleToDeletITemsFromCartbByUsingDeletBtn(String email, String password) {
        login.userLoginAction(homePage, account, signIn, email, password);
        cartPage.navigateToCart();
        cartPage.clickDelet();
        cartPage.deletValidation();

    }
    @Test( enabled =false,dataProvider = "logindata", dataProviderClass = DataProviders.class)//3
      public void validateCustomerAbleToDeletItmeFromDropList(String email, String password){
        login.userLoginAction(homePage, account, signIn, email, password);
        cartPage.navigateToCart();
        cartPage.selecFreomDropList(0);
        cartPage.deletValidation();

    }

    @Test(enabled = false, dataProvider = "logindata", dataProviderClass = DataProviders.class)//4
    public void validateCustmerAbleToSaveItemForLater(String email, String password) {
        login.userLoginAction(homePage, account, signIn, email, password);
        homePage.clickOnCartLink();
        cartPage.clickOnSave();
        cartPage.itemSavedValidation();

    }

    @Test(enabled = false, dataProvider = "logindata", dataProviderClass = DataProviders.class)//5
    public void validateCustomerAbleToCompare(String email, String password) {
        login.userLoginAction(homePage, account, signIn, email, password);
        cartPage.navigateToCart();
        cartPage.clikCompare();
        cartPage.compareValidation();

    }

    @Test(enabled = false,dataProvider = "logindata", dataProviderClass = DataProviders.class)//6
    public void validateCustomerAbleToMoveItemTowishList(String email, String password) {
        login.userLoginAction(homePage, account, signIn, email, password);
        cartPage.navigateToCart();
        cartPage.clikMoveToWish();
        cartPage.refresh();
        cartPage.moveValidation();
    }

    @Test (enabled = false,dataProvider = "logindata", dataProviderClass = DataProviders.class)//7
    public void validateCustmoerAbleToAddQuantity(String email, String password) {
        login.userLoginAction(homePage, account, signIn, email, password);
        cartPage.navigateToCart();
        cartPage.selecFreomDropList(2);
        cartPage.dropListValidation("2");
    }
    @Test(dataProvider = "logindata", dataProviderClass = DataProviders.class)
    public void validateCustomerAblePerformeSelectOrDeslect(String email, String password) {
        login.userLoginAction(homePage, account, signIn, email, password);
        cartPage.navigateToCart();
        cartPage.clickOnSelectAll();
        cartPage.refresh();
        cartPage.clickDeselectAll();



    }

}
