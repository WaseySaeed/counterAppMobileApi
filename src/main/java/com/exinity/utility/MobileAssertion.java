package com.exinity.utility;

import com.exinity.mobile.page.CounterAppTestPage;
import org.testng.Assert;

public class MobileAssertion {

    public static void validateUiElements(CounterAppTestPage counterAppTestPage) {
        Assert.assertTrue(counterAppTestPage.validateCalendarHomePage());
    }

    public static void validateCounterFunctionality(boolean value) {
        try {
            Assert.assertTrue(value);
            System.out.println("AddOneButton functionality works!");
        } catch (AssertionError e) {
            System.out.println("AddOneButton functionality failed!");
        }

    }

    public static void validateResetBtnFunctionality(boolean value) {
        try {
            Assert.assertTrue(value);
            System.out.println("Reset functionality works!");
        } catch (AssertionError e) {
            System.out.println("Reset functionality failed!");
        }

    }

    public static void assertCalendarCancellationBtn(boolean value)
    {
        try {
            Assert.assertTrue(value);
            System.out.println("Cancel Calendar Button Functionality works!");
        } catch (AssertionError e) {
            System.out.println("Cancel Calendar Button functionality failed!");
        }

    }

    public static void assertCalendarDateSelectionBtn(boolean o) {
        try {
            Assert.assertTrue(o);
            System.out.println("Date Selection Calendar Button Functionality works!");
        } catch (AssertionError e) {
            System.out.println("Date Selection Calendar Button functionality failed!");
        }

    }


}
