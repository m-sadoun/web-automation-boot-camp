package com.cigna.data;

import org.testng.annotations.DataProvider;

public class CignaData {
    @DataProvider(name="quote")
    public Object[][] getQuote(){
        Object[][] data={{"80231","menad"}};
        return data;
    }
    @DataProvider(name="login")
    public Object[][] getLogin(){
        Object[][] data={{"abc@gmail.com","12331"}};
        return data;
    }
}
