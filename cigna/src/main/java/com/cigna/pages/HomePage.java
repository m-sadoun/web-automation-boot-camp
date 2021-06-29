package com.cigna.pages;

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

    @FindBy(xpath = "(//li[contains(@class,'nav')]//span[@class='text-md-nowrap'and text()='International'])[1]")
    private WebElement cignaInt;

    @FindBy(linkText = "Member Log In")
    private WebElement memberLogin;

    @FindBy(xpath = "//div [text()='Global Individual Policy']")
    private WebElement globalIndiv;

    @FindBy(xpath = "(//a[contains(@class,'btn btn-primary')])[1]")
    private WebElement loginlink;

    @FindBy(xpath = "//input[@id='username']")
    private  WebElement username;

    @FindBy(xpath ="//input[@id='password']")
    private WebElement password;

    @FindBy(xpath ="//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'The email')]")
    private  WebElement wrongMessage;

    @FindBy(xpath = "//a[contains(text(),'get an online quote and ')]")
    private WebElement onlineQuote;

    @FindBy(xpath = "(//a[contains(text(),'Health Insurance')])[3]")
    private WebElement healthPlan;



   public void brwosing(){
       cignaInt.click();
       TestBase.windowsHandle();
       TestBase.sleepFor(2);
       memberLogin.click();
       TestBase.sleepFor(2);
       globalIndiv.click();
       TestBase.sleepFor(2);
       loginlink.click();
       TestBase.windowsHandle();

   }
   public void typefields(String name , String pass){
       Assert.assertTrue(username.isDisplayed());
       username.sendKeys(name);
       Assert.assertTrue(password.isDisplayed());
       password.sendKeys(pass);
       ExtentTestManager.log("the fields has been field",logger);
   }
   public void clickLogin(){
       Assert.assertTrue(loginBtn.isDisplayed());
       loginBtn.click();
       ExtentTestManager.log("the login btn has been clicked ",logger);
   }

   public void loginvalidation(){
        Assert.assertTrue(wrongMessage.isDisplayed());
        ExtentTestManager.log("user cannot Login with non valid data",logger);
   }

   public void clickOnlineHealth(){
       healthPlan.click();
   }
   public void clickOngetOnlineQuote(){
       onlineQuote.click();
       TestBase.windowsHandle();
   }
   public void clickOnSignaInt(){
       cignaInt.click();
       TestBase.windowsHandle();
   }

}