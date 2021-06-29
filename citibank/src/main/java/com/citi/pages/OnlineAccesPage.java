package com.citi.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OnlineAccesPage {
    public OnlineAccesPage(WebDriver ldriver){
        TestBase.driver= ldriver;
        PageFactory.initElements(ldriver,this);
    }
    private Logger logger = Logger.getLogger(OnlineAccesPage.class);

    @FindBy(xpath = "//h1[contains(text(),' Let’s Set Up Your Online Access ')]")
    private WebElement accesMessage;

    public void onlineaccessvali(){
        Assert.assertTrue(accesMessage.getText().contains("Let’s Set Up Your"));
        ExtentTestManager.log("User Able to register for online access",logger);
    }

}
