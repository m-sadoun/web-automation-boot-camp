package com.amazon.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreatAccountPage {
    public CreatAccountPage(WebDriver ldriver){
        TestBase.driver=ldriver;
        PageFactory.initElements(ldriver,this);
    }
    private static Logger logger = Logger.getLogger(CreatAccountPage.class);

    @FindBy(css ="#ap_customer_name" )
    private WebElement name;

    @FindBy(css="#ap_email")
    private WebElement email;

    @FindBy(css="#ap_password")
    private WebElement password;

    @FindBy(css="#continue")
    private WebElement creatYourAmazon;

    @FindBy(css="#ap_password_check")
    private WebElement reenterPassword;

    public void typeName(String key){
        name.sendKeys(key);
        ExtentTestManager.log("the " +key+ " hasbeen entred",logger);
    }
    public void typeEmail(String key){
        email.sendKeys(key);
        ExtentTestManager.log("the " +key+ " has been entred ",logger);
    }
    public void typePassowrd(String key){
        password.sendKeys(key);
        ExtentTestManager.log("the " +key+ " hasbeen entred ",logger);
    }
    public void retypePassword(String key){
        reenterPassword.sendKeys(key);
        ExtentTestManager.log("the " +key+ " hasbeen reentred ",logger);
    }
    public void creatYourAmazonButton(){
        creatYourAmazon.click();
        ExtentTestManager.log("the bouton amazon count button hasbeen cliked ",logger);
    }
    public void validation(){
        Assert.assertEquals(TestBase.driver.getTitle(),"Amazon Registration", "the title did not match");
        ExtentTestManager.log( "Amazon Registration form diplayed ",logger);
    }
    public void nameDisplayed(){
        Assert.assertTrue(name.isDisplayed(),"name is not displayed");
        ExtentTestManager.log("the name field is displayed ", logger);
    }
    public void emailDisplayed(){
        Assert.assertTrue(email.isDisplayed(),"email is not displayed");
        ExtentTestManager.log("the email field is displayed ", logger);
    }
    public void passwordDisplayed(){
        Assert.assertTrue(password.isDisplayed(),"password is not displayed");
        ExtentTestManager.log("the password diplayed field is displayed ", logger);
    }
    public void retaypePasswordDisplayed(){
        Assert.assertTrue(reenterPassword.isDisplayed(),"renterpassword is not displayes");
        ExtentTestManager.log("the retype password field is displayed ", logger);
    }
}
