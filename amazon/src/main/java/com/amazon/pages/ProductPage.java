package com.amazon.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {

    public ProductPage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }
    private Logger logger = Logger.getLogger(AccountPage.class);
    @FindBy(xpath = "(//span[contains(text(),'HP')])[9]")
    private WebElement hpLaptop;


    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCart;

    @FindBy(xpath="(//input[@class='a-button-input'])[2]")
    private WebElement noThanks;

    @FindBy(xpath = "(//input[@class ='a-button-input'])[13]")
    private WebElement proceed;

    @FindBy(id="attach-close_sideSheet-link")
     private WebElement close;

    @FindBy(xpath = "(//span[contains(text(),'Samsung')])[11]")
    private WebElement phone;

    public void clickOnHpLaptop(){
        Assert.assertTrue(hpLaptop.isDisplayed(),"is not dispalyed");
        hpLaptop.click();
        ExtentTestManager.log("Hp laptop is displayed and has been clicked",logger);
    }
    public void clickOnAddToCart(){
        Assert.assertTrue(addToCart.isDisplayed(),"is not dispalyed");
        addToCart.click();
        TestBase.sleepFor(2);
        noThanks.click();
        if(proceed.isDisplayed()){
            close.click();
        }
        TestBase.driver.navigate().refresh();
        ExtentTestManager.log("The Button add To the Cart has been Clicked",logger);

    }
    public void scrollDownToElement(){
        JavascriptExecutor js = (JavascriptExecutor)  TestBase.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", phone);
        phone.click();
    }
    public  void informationValidation(){
        String expected="Amazon.com: Samsung Electronics Galaxy";
        Assert.assertTrue(TestBase.driver.getTitle().contains(expected));
        ExtentTestManager.log("User can scroll Down and see phone information",logger);

    }
}
