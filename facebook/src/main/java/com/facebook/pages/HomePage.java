package com.facebook.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;

public class HomePage extends TestBase {
    public HomePage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    private Logger logger = Logger.getLogger(HomePage.class);
    @FindBy(xpath = "//span[contains(text(),'Welcome to Facebook, Menad')]")
    private WebElement loginMessage;

    @FindBy(name = "global_typeahead")
    private WebElement searchInbox;

    @FindBy(xpath = "//span[contains(text(),'Search for ')]")
    private WebElement searchLink;

    @FindBy(xpath = "(//li[@class='buofh1pr to382e16 o5zgeu5y jrc8bbd0 dawyy4b1 h676nmdw hw7htvoc'])[1]")
    private WebElement friendLogo;

    @FindBy(xpath = "//div[contains(@class,'oajrlxb2 ')and @aria-label='Add Picture']")
    private WebElement addPicture;

    @FindBy(xpath = "//span[contains(text(),'Upload Photo')]")
    private WebElement uploadPhoto;
    @FindBy(xpath = "//div[@class='kkf49tns']//div[@aria-label='Save']")
    private WebElement uploadSaveBnt;


    public void loginValidation() {
        Assert.assertTrue(loginMessage.getText().contains("Welcome to Facebook"));
        ExtentTestManager.log("User is Able to login with valid credentiels", logger);

    }

    public void typeSearchBoxAndClick(String txt) {
        Assert.assertTrue(searchInbox.isDisplayed() && searchInbox.isEnabled());
        searchInbox.sendKeys(txt);
        TestBase.mousseHoverClick(searchLink);
        ExtentTestManager.log("Name type in and search link clicked", logger);
    }

    public void clickFriendLogo() {
        friendLogo.click();
        ExtentTestManager.log("friend logo has been clicked", logger);
    }
    public void clickAddAndUpload() {
        Assert.assertTrue(addPicture.isDisplayed());
        addPicture.click();
        ExtentTestManager.log("Add picture has been clicked",logger);
        Assert.assertTrue(uploadPhoto.isDisplayed());
        uploadPhoto.click();
        TestBase.sleepFor(2);
        TestBase.uploadPicture("C:\\Users\\sadou\\OneDrive\\Desktop\\20201004_162031.jpg");
        ExtentTestManager.log("Upload picture has been clicked",logger);
    }
    public void uploadValidation(){
        Assert.assertTrue(uploadSaveBnt.isDisplayed());
        ExtentTestManager.log("user Able to upload picture",logger);

    }

}
