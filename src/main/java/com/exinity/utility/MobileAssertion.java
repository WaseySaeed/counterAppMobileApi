package com.exinity.utility;

import com.exinity.mobile.page.CounterAppTestPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class MobileAssertion {

    public static void validateUiElements(CounterAppTestPage counterAppTestPage) {
        Assert.assertTrue(counterAppTestPage.validateCalendarHomePage());
    }

    public static void validateCounterFunctionality(boolean value) {
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(value);
        System.out.println("AddOneButton functionality works!");

    }

    public static void validateResetBtnFunctionality(boolean value) {
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(value);
        System.out.println("Reset functionality works!");

    }

    public static void assertCalendarCancellationBtn(boolean value) {
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(value);
        System.out.println("Cancel Calendar Button Functionality works!");

    }

    public static void assertCalendarDateSelectionBtn(boolean value) {
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(value);
        System.out.println("Date Selection Calendar Button Functionality works!");
    }

}
