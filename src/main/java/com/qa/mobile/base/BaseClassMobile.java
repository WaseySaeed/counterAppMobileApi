package com.qa.mobile.base;

import com.qa.utility.ConfigReader;
import com.qa.mobile.appium.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;


public class BaseClassMobile extends DriverFactory {

    public static ConfigReader configReader;
    public static AppiumDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        configReader = new ConfigReader();
        // for Mobile Automation setup
        try {
            startTheAppiumService();
        } catch (Exception e) {
            System.out.println("Error during Appium driver setup in beforeSuite: " + e.getMessage());
        }
    }

    @BeforeMethod
    public void beforeMethod() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
        // Re-initialize the driver
        setAppiumDriver();
        driver = getAppiumDriver();

    }



    @AfterSuite
    public void afterSuite() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error during afterSuite cleanup: " + e.getMessage());
        }
    }

}
