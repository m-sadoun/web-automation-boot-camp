package com.amazon.tests;

import com.amazon.data.DataProviders;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.comerce.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivityCart extends TestBase {
    private HomePage homePage;
    private SearchItems searchItems;
    private ProductPage product;
    private CartPage cartPage;

    @BeforeMethod
    private void pagesObject() {
        homePage = new HomePage(driver);
        searchItems = new SearchItems();
        product = new ProductPage(driver);
        cartPage = PageFactory.initElements(driver, CartPage.class);

    }

    @Test(priority = 1,dataProvider = "searchCustData", dataProviderClass = DataProviders.class)//1
    public void validateCustomerCanAddSearchedItemToCart(String email, String password, String item) {

        homePage.loginFonctionalities(email, password);
        searchItems.preformSearchAction(homePage, item);
        product.clickOnHpLaptop();
        product.clickOnAddToCart();
        sleepFor(2);
        cartPage.navigateToCart();
        cartPage.validateExisting();
    }

    @Test(enabled = false,dataProvider = "logindata", dataProviderClass = DataProviders.class)//2
    public void validateCustmerAbleToDeletITemsFromCartbByUsingDeletBtn(String email, String password) {

        homePage.loginFonctionalities(email, password);
        cartPage.navigateToCart();
        cartPage.clickDelet();
        cartPage.deletValidation();


    }

    @Test(priority = 2,dataProvider = "logindata", dataProviderClass = DataProviders.class)//3
    public void validateCustomerAbleToDeletItmeFromDropList(String email, String password) {

        homePage.loginFonctionalities(email, password);
        cartPage.navigateToCart();
        cartPage.selecFreomDropList(0);
        cartPage.deletValidation();
        sleepFor(60);

    }

    @Test(enabled = false, dataProvider = "logindata", dataProviderClass = DataProviders.class)//4
    public void validateCustmerAbleToSaveItemForLater(String email, String password) {

        homePage.loginFonctionalities(email, password);
        homePage.clickOnCartLink();
        cartPage.clickOnSave();
        cartPage.itemSavedValidation();

    }

    @Test(enabled = false, dataProvider = "logindata", dataProviderClass = DataProviders.class)//5
    public void validateCustomerAbleToCompare(String email, String password) {

        homePage.loginFonctionalities(email, password);
        cartPage.navigateToCart();
        cartPage.clikCompare();
        cartPage.compareValidation();

    }

    @Test(enabled = false, dataProvider = "logindata", dataProviderClass = DataProviders.class)//6
    public void validateCustomerAbleToMoveItemTowishList(String email, String password) {

        homePage.loginFonctionalities(email, password);
        cartPage.navigateToCart();
        cartPage.clikMoveToWish();
        cartPage.refresh();
        cartPage.moveValidation();
    }

    @Test(enabled = false, dataProvider = "logindata", dataProviderClass = DataProviders.class)//7
    public void validateCustmoerAbleToAddQuantity(String email, String password) {

        homePage.loginFonctionalities(email, password);
        cartPage.navigateToCart();
        cartPage.selecFreomDropList(2);
        cartPage.dropListValidation("2");
    }

    @Test(enabled = false,dataProvider = "logindata", dataProviderClass = DataProviders.class)
    public void validateCustomerAblePerformeSelectOrDeslect(String email, String password) {

        homePage.loginFonctionalities(email, password);
        cartPage.navigateToCart();
        cartPage.clickOnSelectAll();
        cartPage.refresh();
        cartPage.clickDeselectAll();


    }

}
