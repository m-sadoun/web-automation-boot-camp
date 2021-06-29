package com.amazon.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage {
    public SignInPage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    private Logger logger = Logger.getLogger(SignInPage.class);
    @FindBy(css = "input#ap_email") // with tag and id
    private WebElement emailInbox;
    @FindBy(name = "password")// with name
    private WebElement password;
    @FindBy(id = "signInSubmit") // with id
    private WebElement sigInButton;
    @FindBy(css = "input[aria-labelledby=continue-announce]")//tag and attribut
    private WebElement continueButton;
    @FindBy(linkText = "Done")// with name
    private WebElement doneButton;
    @FindBy(css = ".a-list-item")//tag and classname
    private WebElement message;
    @FindBy(id = "createAccountSubmit")
    private WebElement creatAccount;

    public void typeInEmailBox(String data) {
        emailInbox.clear();
        emailInbox.sendKeys(data);
        ExtentTestManager.log("The email has been tayped", logger);
    }

    public void typePassword(String data) {
        password.clear();
        password.sendKeys(data);
        ExtentTestManager.log("The password has been clicked", logger);

    }

    public void clickSigInButton() {
        sigInButton.click();
        ExtentTestManager.log("The Sig In Button has been clicked", logger);
    }

    public void clickContinueButton() {
        continueButton.click();
        ExtentTestManager.log("The Contiue Button has been clicked", logger);
    }

    public void clickDoneButton() {
        doneButton.click();
    }

    public void validationWrongPassword() {
        Assert.assertTrue(message.getText().contains("Your password is incorrect"));
        ExtentTestManager.log("User not able to login with invalid password", logger);
    }

    public void vlaidationWrongUsernam() {
        Assert.assertTrue(message.getText().contains("We cannot find an account with that email address"));
        ExtentTestManager.log("User not able to login with invalid username", logger);

    }

    public void clickCreatAcountButton() {
        creatAccount.click();
        ExtentTestManager.log("the button  has been cliked ", logger);
    }

    public void validation() {
        Assert.assertEquals(TestBase.driver.getTitle(), "Amazon Sign-In", "the title did not match");
        ExtentTestManager.log("Amazon Sign-In page  displayed ", logger);


    }


}