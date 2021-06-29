package com.facebook.data;

import org.testng.annotations.DataProvider;

import java.util.ResourceBundle;

public class DataProv {
    ResourceBundle rb = ResourceBundle.getBundle("fdata");
    @DataProvider(name="acountdata")
    public Object[][] getCreatData(){
        Object[][] data={{rb.getString("name"),rb.getString("last"),rb.getString("email"),rb.getString("password")}};
        return data;
    }
    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
        Object[][] data={{rb.getString("vemail"),rb.getString("password")},
                        {rb.getString("vemail"),rb.getString("fpassword")},
                         {rb.getString("femail"),rb.getString("password")}};
        return data;
    }
    @DataProvider(name="search")
    public Object[][] getSearch(){
        Object[][] data={{rb.getString("vemail"),rb.getString("password"),rb.getString("friend")}};
        return data;
    }
    @DataProvider(name="searchsend")
    public Object[][] getSearchSend(){
        Object[][] data={{rb.getString("vemail"),rb.getString("password"),rb.getString("friend1")}};
        return data;
    }
    @DataProvider(name="loginonce")
    public Object[][] getLoginOnce(){
        Object[][] data={{rb.getString("vemail"),rb.getString("password")}};
        return data;
    }
    @DataProvider(name="like")
    public Object[][] getLike(){
        Object[][] data={{rb.getString("vemail"),rb.getString("password"),rb.getString("friend3")}};
        return data;
    }
    @DataProvider(name="writecom")
    public Object[][] getWriteComment(){
        Object[][] data={{rb.getString("vemail"),rb.getString("password"),rb.getString("friend3"),rb.getString("comment")}};
        return data;
    }
}
