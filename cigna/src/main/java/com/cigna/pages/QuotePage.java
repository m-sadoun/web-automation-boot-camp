package com.cigna.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class QuotePage {
    public QuotePage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    private Logger logger = Logger.getLogger(QuotePage.class);

    @FindBy(xpath = "(//input[@name='zip_code'])[1]")
    private WebElement zipCode;
    @FindBy(xpath = "(//input[@name='name'])[1]")
    private WebElement namefield;
    @FindBy(xpath = "(//button[contains(text(),'See plans')])[1]")
    private WebElement seePlanBtn;
    @FindBy(xpath = "//div[contains(text(),'Call us to get')]")
    private WebElement messageQuote;



    public void typeFieldsAndClick(String zip, String name){
        Assert.assertTrue(zipCode.isDisplayed()&&zipCode.isEnabled());
        zipCode.sendKeys(zip);
        ExtentTestManager.log("Zip Code Typed in",logger);
        Assert.assertTrue(namefield.isDisplayed()&& namefield.isEnabled());
        namefield.sendKeys(name);
        ExtentTestManager.log("name Typed in",logger);
        Assert.assertTrue(seePlanBtn.isDisplayed());
        seePlanBtn.click();
        ExtentTestManager.log("see plan button clicked",logger);
    }
    public void seeQuoteValidation(){
        Assert.assertTrue(messageQuote.isDisplayed());
        ExtentTestManager.log("User Able to get a quote",logger);

    }
}