package com.facebook.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FriendPage {
    public FriendPage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    private Logger logger = Logger.getLogger(HomePage.class);
    @FindBy(xpath = "//div[contains(@class,'k4urcfbm')]//div[@aria-label='Confirm']")
    private WebElement confirmBtn;

    @FindBy(xpath = "//div[contains(@class,'k4urcfbm')]//span[contains(text(),'Request confirmed')]")
    private WebElement requestConfirmed;

    @FindBy(xpath = "//div[contains(@class,'qzhwtbm6 knvmm38d')]//span[contains(text(),'Friend Requests')]")
    private WebElement friendsRequests;

    @FindBy(xpath = "//div[contains(@class,'jei6r52m dhix69tm wkznzc2l')]//span[contains(text(),'No new requests')]")
    private WebElement noNewRqst;

    @FindBy(xpath = "(//div[contains(@class,'rq0escxv')]//div[@aria-label='Like'])[1]")
    private WebElement likebtn;

    @FindBy(xpath = "(//span[contains(@class,'tojvnm2t')]//div[@role='button'])[13]")
    private WebElement likeMessage;

    @FindBy(xpath = "(//p[@class='hcukyx3x oygrvhab cxmmr5t8 kvgmc6g5'])[1]")
    private WebElement writeCommentBx;

    @FindBy(xpath = "//div[contains(text(),'azul')]")
    private WebElement comment;

    public void clickConfirmeBtn() {
        Assert.assertTrue(confirmBtn.isDisplayed());
        confirmBtn.click();
        ExtentTestManager.log("confirm btn has been clicked", logger);
        TestBase.driver.navigate().refresh();


    }

    public void acceptRequestValidation() {
        Assert.assertTrue(friendsRequests.isDisplayed());
        friendsRequests.click();
        ExtentTestManager.log("Friends request has been clicked", logger);
        Assert.assertTrue(noNewRqst.getText().contains("No new requests"));
        ExtentTestManager.log("User able to accept friend request", logger);

    }

    public void clickLikeBtn() {
        likebtn.click();
        ExtentTestManager.log("like Bton has been clicked", logger);
    }

    public void likeValidation() {
        Assert.assertTrue(likeMessage.getText().contains("You"));
        ExtentTestManager.log("User Able To like post", logger);
    }

    public void typeOnComment(String txt) {
        Assert.assertTrue(writeCommentBx.isDisplayed());
        Actions actions = new Actions(TestBase.driver);
        writeCommentBx.sendKeys(txt);
        actions.sendKeys(Keys.ENTER).perform();
        ExtentTestManager.log("The comment has been writeen", logger);
    }

    public void commentValidation() {
        Assert.assertTrue(comment.getText().contains("azul"));
        ExtentTestManager.log("user able to comment", logger);
    }
}
