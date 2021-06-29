package com.cnn.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CHomePage {
    public CHomePage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }
    private Logger logger = Logger.getLogger(CHomePage.class);
    @FindBy(xpath = "(//div[@id='account-icon-button'])[1]")
    private WebElement userIcone;

    @FindBy(xpath = "//input[@name='loginEmail']")
    private WebElement emailInbx;

    @FindBy(xpath = "//input[@name='loginPassword']")
    private WebElement passlInbx;

    @FindBy(xpath = "//button[@id='login-form-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[@id='feedback-message']")
    private WebElement messageWrCre;

    @FindBy(linkText = "Log Out")
    private  WebElement logOut;

    public void typeOnfields(String name, String pass){
        TestBase.sleepFor(2);
        //TestBase.driver.switchTo().parentFrame();
        userIcone.click();
        Assert.assertTrue(emailInbx.isDisplayed()&& emailInbx.isEnabled());
        emailInbx.sendKeys(name);
        Assert.assertTrue(passlInbx.isDisplayed()&& passlInbx.isEnabled());
        passlInbx.sendKeys(pass);
        ExtentTestManager.log("the fields Typed in",logger);
    }
    public void clickLogin(){
        Assert.assertTrue(loginBtn.isDisplayed());
        loginBtn.click();
        ExtentTestManager.log("Login button has been clicked",logger);
    }

    public void NonValidCredValidation(){
        Assert.assertTrue(messageWrCre.getText().contains("You"));
        ExtentTestManager.log("User cannot lofin with invalid credentiels",logger);
    }

    public void loginValidation(){

        TestBase.sleepFor(2);
        userIcone.click();
        Assert.assertTrue(logOut.isDisplayed());
        ExtentTestManager.log("User is Able To login With Valid credentiels",logger);

    }
    public void loginFonctionality(String email, String password){
        if(email.equalsIgnoreCase("sadounm105@gmail.com")&& password.equalsIgnoreCase("Aylan10222019?")) {
            typeOnfields(email,password);
            clickLogin();
            loginValidation();
        }else {
            typeOnfields(email,password);
            clickLogin();
            NonValidCredValidation();
    }
}
public void clickOnLogout(){
        TestBase.sleepFor(2);
        userIcone.click();
        TestBase.sleepFor(2);
        logOut.click();
        ExtentTestManager.log("user able to logout",logger);

}

}
