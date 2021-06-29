package com.facebook.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PeoplePage {
    public PeoplePage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    private Logger logger = Logger.getLogger(PeoplePage.class);
    @FindBy(xpath = "(//span[contains(text(),'People')])[2]")
    private WebElement peopleTxt;

    @FindBy(xpath = "//div[@class ='ozuftl9m taijpn5t cbu4d94t j83agx80']")
    private WebElement addFriendBtn;

    @FindBy(xpath = "(//div[@class ='k4urcfbm'])[2]")
    private WebElement cancelRequest;

    @FindBy(xpath = "(//div[@class='qzhwtbm6 knvmm38d']//span[@class ='nc684nl6'])[1]")
    private WebElement searchedFriend;

    @FindBy(xpath = "//span[text()='Boualem Boudid']")
    private WebElement boualam;

    public void searchValidation() {
        Assert.assertTrue(peopleTxt.getText().contains("People"));
        ExtentTestManager.log("User Able to Search for name", logger);

    }

    public void clickAddAndValidation() {
        TestBase.mousseHoverClick(searchedFriend);
        TestBase.mousseHoverClick(cancelRequest);
        ExtentTestManager.log("Add friend button clicked", logger);
        Assert.assertTrue(cancelRequest.getText().contains("Cancel"));
        ExtentTestManager.log("User is Able To Add Friend", logger);


    }

    public void clickOnfriend() {
        boualam.click();
    }
}
