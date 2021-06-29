package com.cnn.data;

import org.testng.annotations.DataProvider;

import java.util.ResourceBundle;

public class CDataPro {
    ResourceBundle rb = ResourceBundle.getBundle("cdatat");
    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
        Object[][] data={{rb.getString("email"),rb.getString("password")},
                {rb.getString("femail"),rb.getString("password")},
                {rb.getString("email"),rb.getString("fpassword")}};
        return data;
    }
    @DataProvider(name="loginonce")
    public Object[][] getLoginonce(){
        Object[][] data={{rb.getString("email"),rb.getString("password")}};
        return data;
    }
}
