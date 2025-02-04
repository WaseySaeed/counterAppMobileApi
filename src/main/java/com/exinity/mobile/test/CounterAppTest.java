package com.exinity.mobile.test;

import com.exinity.mobile.page.CounterAppTestPage;
import com.exinity.mobile.base.BaseClassMobile;
import com.exinity.utility.MobileAssertion;
import org.testng.annotations.*;


public class CounterAppTest extends BaseClassMobile {


    @Test
    public void validateCalendarAppElements() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        MobileAssertion.validateUiElements(counterAppTestPage);
    }

    @Test
    public void validatingAdditionByOneFunctionality() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        MobileAssertion.validateCounterFunctionality(counterAppTestPage.validatingCounterByOneFunctionality(5));
    }

    @Test
    public void validatingResetBtnFunctionality() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        counterAppTestPage.validatingCounterByOneFunctionality(3);
        MobileAssertion.validateResetBtnFunctionality(counterAppTestPage.validatingResetBtnFunctionality());
    }

    @Test
    public void validatingNoDateBeingSelected() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        counterAppTestPage.validateCalendarFunctionality("cancelBtn");
    }

    @Test
    public void validatingDateBeingSelected() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        counterAppTestPage.validateCalendarFunctionality("selectDate");
    }

    @Test
    public void failedTestCaseOfDateNotBeingDisplayed()
    {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        counterAppTestPage.validateCalendarFunctionality("selectDate");
        counterAppTestPage.ValidateSelectedDateIsDisplayed();

    }
}
