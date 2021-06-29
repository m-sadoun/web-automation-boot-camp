package com.facebook.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage {
    public LandingPage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }
    private Logger logger = Logger.getLogger(LandingPage.class);
    HomePage homePage;


    @FindBy(xpath=" //a[contains(text(),'Create New Account')]")
    private WebElement createAccount;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "reg_email__")
    private WebElement email;

    @FindBy(name = "reg_passwd__")
    private WebElement password;

    @FindBy(name = "birthday_month")
    private WebElement birthDayMonth;

    @FindBy(name="birthday_day")
    private WebElement birthDayDay;

    @FindBy(name = "birthday_year")
    private WebElement getBirthDayYear;

    @FindBy(xpath = "(//input[@name='sex'])[2]")
    private  WebElement gendre;

    @FindBy(xpath=" //button[contains(text(),'Sign Up')and@name='websubmit']")
    private WebElement signUp;

    @FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    private WebElement reEmail;

    @FindBy(xpath = "//h2[contains(text(),'Enter')and @aria-hidden='true']")
    private WebElement message;

    @FindBy(name = "email")
    private WebElement loginEmail;

    @FindBy(name="pass")
    private WebElement loginPassword;

    @FindBy(xpath ="//button[@name='login']" )
    private WebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'_4-i2 _pig _9kpl _50f4')]//div[contains(text(),'Is this')]")
    private WebElement userMessage;

    @FindBy(xpath = "//div[contains(@class,'clearfix _5466 _44mg')]//div[contains(text(),'The password')]")
    private WebElement pasMessage;

    @FindBy(xpath = "//span[contains(text(),'Welcome to Facebook, Menad')]")
    private WebElement loginMessage;

   public void verifieAndTypeOnFields(String nameu,String last ,String emailu,String passwordu){
       Assert.assertTrue(firstName.isDisplayed()&&firstName.isEnabled());
       firstName.sendKeys(nameu);
       ExtentTestManager.log("first name tayped",logger);
       Assert.assertTrue(lastName.isDisplayed()&&lastName.isEnabled());
       lastName.sendKeys(last);
       ExtentTestManager.log("last name tayped",logger);
       Assert.assertTrue(email.isDisplayed()&&email.isEnabled());
       email.sendKeys(emailu);
       ExtentTestManager.log(" email  tayped",logger);
       Assert.assertTrue(reEmail.isDisplayed()&& reEmail.isEnabled());
       reEmail.sendKeys(emailu);
       ExtentTestManager.log("retype email dispalyed and has been clicked",logger);
       Assert.assertTrue(password.isDisplayed()&&password.isEnabled());
       password.sendKeys(passwordu);
       ExtentTestManager.log(" email  tayped",logger);

   }
    public void cliskCreateAccountBtn(){
        Assert.assertTrue(createAccount.isDisplayed());
        createAccount.click();
        ExtentTestManager.log("Create new Account displayed and has been clicked",logger);
        Assert.assertTrue(firstName.isDisplayed()&&firstName.isEnabled());

    }
    public void selectBirthDay(){
       TestBase.select(birthDayMonth,5);
       TestBase.select(birthDayDay,16);
       TestBase.select(getBirthDayYear,50);
       ExtentTestManager.log("Birthday selected",logger);
    }
    public void selectGendre(){
        Assert.assertTrue(gendre.isSelected()==false);
        gendre.click();
        ExtentTestManager.log("Gendre selected",logger);
    }

    public void clickSigUP(){
       Assert.assertTrue(signUp.isDisplayed());
       signUp.click();
    }
    public void creationValidation(){
       String expected ="Enter the code from your email";
       Assert.assertTrue(message.getText().contains(expected));
       ExtentTestManager.log("The User Able To create an Account",logger);
    }
    public void typeInFields(String username , String password){
       Assert.assertTrue(loginEmail.isDisplayed());
       loginEmail.sendKeys(username);
       Assert.assertTrue(loginPassword.isDisplayed());
       loginPassword.sendKeys(password);
       ExtentTestManager.log("The fields are field",logger);
    }
    public void clickLogin(){
       Assert.assertTrue(loginBtn.isDisplayed());
       loginBtn.click();
    }

    public void wrongUservalidation(){
       Assert.assertTrue(userMessage.getText().contains("Is this your account?"));
       ExtentTestManager.log("user cannot Loging with invalid username",logger);
    }
    public void wrongPassvalidation(){
        Assert.assertTrue(pasMessage.getText().contains("The password you’ve entered is incorrect."));
        ExtentTestManager.log("user cannot Loging with invalid pasword",logger);
    }

    public void loginFonctionality(String email, String password){
       if(email.equalsIgnoreCase("sdfg@gmail.com")&& password.equalsIgnoreCase("")) {
          typeInFields(email,password);
          clickLogin();
          wrongUservalidation();
       }else if(email.equalsIgnoreCase("sdounm105@gmail.com")&& password.equalsIgnoreCase("")){
          typeInFields(email,password);
          clickLogin();
          wrongPassvalidation();
       }else if(email.equalsIgnoreCase("sdounm105@gmail.com")&& password.equalsIgnoreCase("")){
           homePage = new HomePage(TestBase.driver);
           typeInFields(email,password);
           clickLogin();
          homePage.loginValidation();
       }
    }
}
