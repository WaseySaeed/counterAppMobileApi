package com.exinity.api.base;

import com.exinity.utility.ConfigReader;
import com.exinity.utility.TestListener;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestListener.class)
public class BaseClassApi {

    public static Playwright playwright;
    public static APIRequestContext apiContext;
    public static ConfigReader configReader;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        configReader = new ConfigReader();
        // For api setup
        playwright = Playwright.create();
        apiContext = playwright.request().newContext();
    }


    @AfterSuite
    public void afterSuite() {
        apiContext.dispose();
        playwright.close();
    }

}
