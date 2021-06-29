package com.cigna.pages;

import com.comerce.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CignaIntPage {
    public CignaIntPage(WebDriver ldriver){
        TestBase.driver= ldriver;
        PageFactory.initElements(ldriver,this);
    }
    private Logger logger = Logger.getLogger(CignaIntPage.class);

    @FindBy(xpath = "//span[contains(text(),' virus')]")
    private WebElement virus;

  public void clickOnCoronaUpdate(){
      Assert.assertTrue(virus.isDisplayed());
      virus.click();
      TestBase.windowsHandle();
  }
}
