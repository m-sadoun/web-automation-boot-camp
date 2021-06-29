package com.citi.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    public HomePage(WebDriver ldriver){
        TestBase.driver= ldriver;
        PageFactory.initElements(ldriver,this);
    }
    private Logger logger = Logger.getLogger(HomePage.class);

    @FindBy(xpath="//input[@id='username']")
    private WebElement userId;

    @FindBy(xpath="//input[@id='password']")
    private WebElement password;

    @FindBy(xpath="//button[@id='signInBtn']")
    private WebElement signOn;

    @FindBy(xpath = "//span[contains(text(),'Trouble signing on?')]")
    private WebElement message;

    @FindBy(xpath = "//a[contains(text(),'Credit Cards')and@id='navcreditCardmainAnchor0']")
    private WebElement creditCardLinck;

    @FindBy(xpath = "//a[@id='View All Credit CardschildLink0']")
    private WebElement viewAllCredit;

    @FindBy(xpath = "(//a[contains(text(),'Forgot User ID?')])[2]")
    private WebElement forgetUserId;

    @FindBy(xpath = "//a[contains(text(),'Register for online access')]")
    private WebElement registerOnLine;





    public void typeInfieldsAndClick(String user,String pass){
        Assert.assertTrue(userId.isDisplayed());
        userId.sendKeys(user);
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys(pass);
        Assert.assertTrue(signOn.isDisplayed());
        signOn.click();
        ExtentTestManager.log("The fields are been Typed and submit clicked",logger);
    }

    public void signInValidation(){
        Assert.assertTrue(message.getText().contains("Trouble signing on?"));
        ExtentTestManager.log("User cannot Login with invalid data",logger);
    }
    public void moveToCreditCards(){
        Assert.assertTrue(creditCardLinck.isDisplayed());
        TestBase.mousseHover(creditCardLinck);
        ExtentTestManager.log("The Mousse moved to card link",logger);
    }

    public void moveTViewAllAndClick(){
        TestBase.mousseHoverClick(viewAllCredit);
        ExtentTestManager.log("view all card link has been clicked",logger);
    }
    public void clickforgetUser(){
        Assert.assertTrue(forgetUserId.isDisplayed());
        forgetUserId.click();
        ExtentTestManager.log("forget user has been clicked",logger);

    }
    public void clickregisterOnline(){
        Assert.assertTrue( registerOnLine.isDisplayed());
        registerOnLine.click();
        ExtentTestManager.log("registerOnlineAcces has been clicked",logger);

    }
}
