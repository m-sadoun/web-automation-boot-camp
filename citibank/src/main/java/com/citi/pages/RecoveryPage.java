package com.citi.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RecoveryPage {
    public RecoveryPage(WebDriver ldriver){
        TestBase.driver= ldriver;
        PageFactory.initElements(ldriver,this);
    }
    private Logger logger = Logger.getLogger(RecoveryPage.class);
    @FindBy(xpath = "//h2[contains(text(),'Having Trouble Signing On?')]")
    private WebElement recoverMessage;

    public void vlaidationCredentielRecovery(){
        Assert.assertTrue(recoverMessage.getText().contains("Having Trouble Signing"));
        ExtentTestManager.log("User Able to recover his password or username",logger);
    }
}
