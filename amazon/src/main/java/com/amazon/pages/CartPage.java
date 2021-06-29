package com.amazon.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CartPage {

    private Logger logger = Logger.getLogger(CartPage.class);
    @FindBy(id = "deselect-all")
    private WebElement elementt;

    @FindBy(xpath = "(//input[starts-with(@name,'submit')])[1]")
    private WebElement delet;

    @FindBy(xpath = "//h2[contains(text(),'Your Amazon Cart is empty')]")
    private WebElement element;

    @FindBy(xpath = "(//input[starts-with(@name,'submit')])[2]")
    private WebElement save;

    @FindBy(xpath = "//div[contains(text(),'Saved ')]")
    private WebElement text;

    @FindBy(xpath = "//h1[contains(text(),'Compare with similar items')]")
    private WebElement compareText;

    @FindBy(xpath = "(//input[starts-with(@name,'submit')])[3]")
    private WebElement compare;

    @FindBy(xpath = "(//input[starts-with(@name,'submit')])[4]")
    private WebElement moveToWish;

    @FindBy(id = "sc-saved-cart-list-caption-text")
    private WebElement moveMessage;

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement dropList;

    @FindBy(css = ".a-dropdown-prompt")
    private WebElement specifiqueTexDroList;


    @FindBy(xpath = "//a[contains(@id,'select')]")
    private WebElement selectAll;

    public void navigateToCart() {
        TestBase.navigateToURL("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");

    }

    public void validateExisting() {
        String expected = "Deselect all items";
        Assert.assertTrue(elementt.getText().contains(expected));
        ExtentTestManager.log("Yes the product added to the Cart", logger);
    }

    public void clickDelet() {
        Assert.assertTrue(delet.isDisplayed());
        delet.click();
        ExtentTestManager.log("delet button has been clicked", logger);
    }

    public void deletValidation() {
        String expected = "our Amazon Cart is empty";
        Assert.assertTrue(element.getText().contains(expected));
        ExtentTestManager.log("The product was succesfully deleted from cart", logger);
    }

    public void clickOnSave() {
        Assert.assertTrue(save.isDisplayed());
        save.click();
        ExtentTestManager.log("save link has been clicked", logger);
    }

    public void itemSavedValidation() {
        Assert.assertTrue(text.getText().contains("Saved"));
        ExtentTestManager.log("The Item was saved In list for later", logger);
    }

    public void clikCompare() {
        Assert.assertTrue(compare.isDisplayed());
        compare.click();
        ExtentTestManager.log("compare with similar link has been clicked", logger);
    }

    public void compareValidation() {
        TestBase.driver.switchTo().alert();
        Assert.assertTrue(compare.getText().contains("Compare with"));
        ExtentTestManager.log("Comparaison window displayed", logger);

    }

    public void clikMoveToWish() {
        Assert.assertTrue(moveToWish.isDisplayed());
        moveToWish.click();
        TestBase.driver.navigate().refresh();
        ExtentTestManager.log("move to wish link has been clicked", logger);
    }
    public void moveValidation(){
        Assert.assertTrue(moveMessage.getText().contains("No items saved"));
        ExtentTestManager.log("the item was moved to wish list",logger);
    }
    public void refresh(){
        TestBase.driver.navigate().refresh();
    }
    public void selecFreomDropList(int index){
        Select select = new Select(dropList);
        select.selectByIndex(index);


    }
    public void dropListValidation(String index){
        Assert.assertTrue(specifiqueTexDroList.getText().contains(index));
        ExtentTestManager.log("User Able To Select Quantity from Drop list",logger);
    }
    public void clickDeselectAll(){
        Assert.assertTrue(selectAll.isDisplayed());
        selectAll.click();
        ExtentTestManager.log("Delet all is displayed and has been clicked",logger);
    }
    public void clickOnSelectAll(){
        Assert.assertTrue(selectAll.isDisplayed());
        ExtentTestManager.log("Select all is dispalyed and has been clicked",logger);
    }
}

