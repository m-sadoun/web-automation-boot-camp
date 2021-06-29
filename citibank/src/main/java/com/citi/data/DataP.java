package com.citi.data;

import org.testng.annotations.DataProvider;

public class DataP {
    @DataProvider(name="login")
    public Object[][] getLogin(){
        Object[][] data={{"sad456@gmail.co","menad12313"}};
        return data;
    }
}
