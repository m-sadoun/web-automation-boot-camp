package com.amazon.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage {
    public AccountPage(WebDriver ldriver) {
        TestBase.driver = ldriver;
        PageFactory.initElements(ldriver, this);
    }
    private Logger logger = Logger.getLogger(AccountPage.class);
    @FindBy(xpath = "//img[@alt='Login & security']") //Relative xpath
    private WebElement loginAndSecurity;

    public void clickLoginAndSecurity() {
        loginAndSecurity.click();
        ExtentTestManager.log("Login & security Clicked", logger);
    }

    public void loginValidation() {
        String actual = TestBase.driver.getTitle();
        String expected ="Your Account";
        Assert.assertEquals(actual,expected, "The Title did not match");
        ExtentTestManager.log("The user succefuly loged in", logger);

    }

}
