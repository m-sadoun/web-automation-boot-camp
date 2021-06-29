package com.amazon.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage {
    public HomePage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    private static Logger logger = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']/ancestor::a")
    private WebElement accountAndList;

    @FindBy(linkText = "Account")
    private WebElement accountlink;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement clickSignIn;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "(//span[@class='nav-line-2'])[3]")
    private WebElement cartlink;

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    private WebElement dropList;

    @FindBy(id = "nav-search-label-id")
    private WebElement specificDpt;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]/self::span")
    private WebElement logOut;

    public void locateAccountAndList() {
        TestBase.mousseHover(accountAndList);
        ExtentTestManager.log("Mousse is in Acount&list link", logger);
    }

    public void mouseHouverClick() {
        TestBase.mousseHoverClick(accountlink);
        ExtentTestManager.log("the mousse moved to acounts link and it has been clicked", logger);
    }

    public void clickSigninLink() {
        clickSignIn.click();
        ExtentTestManager.log("the link hasbeen cliked ", logger);
    }

    public void typeOnSearchBox(String txt) {
        if (searchTextBox.isDisplayed() && searchTextBox.isEnabled()) {
            searchTextBox.sendKeys(txt);
            ExtentTestManager.log(" Search inbox displayed , enable and " + txt + " tayped", logger);
        } else {
            ExtentTestManager.log("Search box is not dispalyed or not enable", logger);
        }
    }

    public void clickOnSearchbutton() {
        if (searchButton.isDisplayed() && searchButton.isEnabled()) {
            searchButton.click();
            ExtentTestManager.log(" search button is dispalyed , enable and clicked", logger);
        } else {
            ExtentTestManager.log("Search button is not displayed or not enable", logger);
        }
    }

    public void searchValidation(String expected) {
        Assert.assertTrue(TestBase.driver.getTitle().contains(expected), "the title did not contains " + expected);
        ExtentTestManager.log("user able to serach for items", logger);
    }

    public void clearSearchBox() {
        searchTextBox.clear();
    }

    public void clickOnCartLink() {
        TestBase.driver.navigate().refresh();
        Assert.assertTrue(cartlink.isDisplayed());
        cartlink.click();
        ExtentTestManager.log("Cart link dispalyed and has been cliked", logger);
    }

    public void selecFreomDropList(String txt) {
        Select select = new Select(dropList);
        select.selectByVisibleText(txt);
        ExtentTestManager.log(txt + " is selected", logger);
    }

    public void dropListValidation(String txt) {
        Assert.assertTrue(specificDpt.getText().contains(txt));
        ExtentTestManager.log("User Able To Select department from Droplist", logger);
    }
    public void mouseHouverLogOut(){
        TestBase.mousseHoverClick(logOut);
        ExtentTestManager.log("the mousse moved to LogOut link and it has been clicked", logger);
    }
    public void logOutValidation(){
        Assert.assertTrue(accountAndList.getText().contains("Hello"));
        ExtentTestManager.log("The Customer succefuly loged out",logger);
    }
    public void navigateHomePage(){
        TestBase.navigateToURL("https://www.amazon.com");
    }
}
