package com.qa.mobile.appium;

import com.qa.utility.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.time.Duration;


public class DriverFactory {

    public ConfigReader configReader = new ConfigReader();
    public static AppiumDriver appiumDriver;
    public static AppiumDriverLocalService appiumDriverService;

    public UiAutomator2Options uiOptions() {
        String apkPath = new File(configReader.getProperty("android_app_file_path")).getAbsolutePath();
        return new UiAutomator2Options()
                .setUdid(configReader.getProperty("android_device_name"))
                .setAppPackage(configReader.getProperty("android_app_package"))  // App package name
                .setNewCommandTimeout(Duration.ofSeconds(Integer.parseInt(configReader.getProperty("newCommandTimeout"))))  // Command timeout
                .setApp(apkPath)
                .setNoReset(false)
                .setFullReset(true)
                .autoGrantPermissions();
    }

    private void startAppiumService() {
        if (appiumDriverService == null || !appiumDriverService.isRunning()) {
            appiumDriverService = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                            .withIPAddress("127.0.0.1")
                            .usingPort(4723)
                            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                            .withTimeout(Duration.ofSeconds(30000))
            );
            System.out.println("Start Appium server");
            appiumDriverService.start();
            System.out.println("Appium server started.");
        }
    }

    public void startTheAppiumService() {
        startAppiumService();
    }

    public void setAppiumDriver() {
        appiumDriver = new AndroidDriver(appiumDriverService.getUrl(), uiOptions());
    }

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }
}
