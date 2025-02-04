package com.exinity.mobile.test;

import com.exinity.mobile.page.CounterAppTestPage;
import com.exinity.mobile.base.BaseClassMobile;
import com.exinity.utility.MobileAssertion;
import org.testng.annotations.*;


public class CounterAppTest extends BaseClassMobile {


    @Test(description = "Validating the initial state of app, the increment counter by 1 and reset button functionality")
    public void validate_Counter_App_Initial_State_And_Counter_Increment_And_Reset() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        MobileAssertion.validateUiElements(counterAppTestPage);
        MobileAssertion.validateCounterFunctionality(counterAppTestPage.validatingCounterByOneFunctionality(5));
        MobileAssertion.validateResetBtnFunctionality(counterAppTestPage.validatingResetBtnFunctionality());
    }

    @Test(description = "Validation the selection of date and pressing cancel button on date picker")
    public void validate_No_Date_Selected_And_Date_Selected() {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        counterAppTestPage.validateCalendarFunctionality("cancelBtn");
        counterAppTestPage.validateCalendarFunctionality("selectDate");
    }

    @Test(description = "Verifying the failure of the test case as the selected date is not displayed")
    public void failedTestCaseOfDateNotBeingDisplayed()
    {
        CounterAppTestPage counterAppTestPage = new CounterAppTestPage(driver);
        counterAppTestPage.validateCalendarFunctionality("selectDate");
        counterAppTestPage.ValidateSelectedDateIsDisplayed();

    }
}
