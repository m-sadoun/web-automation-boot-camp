package com.cigna.pages;

import com.comerce.base.TestBase;
import com.comerce.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CoronaPage {
    public CoronaPage(WebDriver ldriver){
        TestBase.driver= ldriver;
        PageFactory.initElements(ldriver,this);
    }
    private Logger logger = Logger.getLogger(CoronaPage.class);

    @FindBy(xpath = "//h1[contains(text(),'Coronavirus Updates')]")
    private WebElement coronaUpdate;

    public void coronaUpdateValidation(){
        Assert.assertTrue(coronaUpdate.getText().contains("Coronavirus Updates"));
        ExtentTestManager.log("user is able to see corona update",logger);
    }
}
