package com.citi.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllCardPage {
    public AllCardPage(WebDriver ldriver){
        TestBase.driver= ldriver;
        PageFactory.initElements(ldriver,this);
    }
    private Logger logger = Logger.getLogger(AllCardPage.class);

    @FindBy(xpath = "//h1[contains(text(),'View and Compare All Credit Cards')]")
    private WebElement messageAllCard;

    public void viewAllCardsValidation(){
        Assert.assertTrue(messageAllCard.isDisplayed());
        ExtentTestManager.log("user can see all offers incredit cards",logger);
    }

}
