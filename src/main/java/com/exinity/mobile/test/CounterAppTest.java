package com.exinity.mobile.test;

import com.exinity.mobile.page.CounterAppTestPage;
import com.exinity.mobile.base.BaseClassMobile;
import com.exinity.utility.MobileAssertion;
import org.testng.annotations.*;


public class CounterAppTest extends BaseClassMobile {


    @Test
    public void validate_Counter_App_Initial_State_And_Counter_Increment_And_Reset() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        MobileAssertion.validateUiElements(counterAppTestPage);
        MobileAssertion.validateCounterFunctionality(counterAppTestPage.validatingCounterByOneFunctionality(5));
        MobileAssertion.validateResetBtnFunctionality(counterAppTestPage.validatingResetBtnFunctionality());
    }

    @Test
    public void validate_No_Date_Selected_And_Date_Selected() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        counterAppTestPage.validateCalendarFunctionality("cancelBtn");
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
