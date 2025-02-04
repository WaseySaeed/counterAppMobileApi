package com.exinity.utility;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.exinity.mobile.appium.DriverFactory.getAppiumDriver;

public class TestListener implements ITestListener {

    private static final String formattedTimestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;

    static {
        sparkReporter = new ExtentSparkReporter("reports/extent-report-" + formattedTimestamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = extent.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.pass("Test passed successfully!");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.fail("Test failed: " + iTestResult.getThrowable());
        String screenshotPath = captureScreenshot(iTestResult.getMethod().getMethodName());
        test.addScreenCaptureFromPath(screenshotPath);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }

    private String captureScreenshot(String testName) {
        TakesScreenshot takesScreenshot = getAppiumDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotDirPath = "screenshots";

        // Get the absolute path of the directory
        String absoluteDirPath = new File(screenshotDirPath).getAbsolutePath();
        String screenshotPath = absoluteDirPath + "/" + testName + "_" + formattedTimestamp + ".png";
        try {
            File screenshotDir = new File(absoluteDirPath);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs(); // Create the directory if it doesn't exist
            }

            // Copy the screenshot to the desired directory
            FileUtils.copyFile(source, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}

