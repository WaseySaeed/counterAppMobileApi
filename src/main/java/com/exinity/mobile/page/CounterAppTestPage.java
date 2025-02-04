package com.exinity.mobile.page;

import com.exinity.utility.CommonMobileMethod;
import com.exinity.utility.MobileAssertion;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;

import java.util.*;

public class CounterAppTestPage extends CommonMobileMethod {

    @AndroidFindBy(accessibility = "Counter App")
    private static WebElement counterAppHeading;
    @AndroidFindBy(accessibility = "Current Value:")
    private static WebElement currentValueHeading;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Current Value:']/following-sibling::android.view.View")
    private static WebElement counter;
    @AndroidFindBy(accessibility = "+1")
    private static WebElement addOneBtn;
    @AndroidFindBy(accessibility = "-2")
    private static WebElement subtractTwoBtn;
    @AndroidFindBy(accessibility = "Reset")
    private static WebElement resetBtn;
    @AndroidFindBy(accessibility = "Pick a Date")
    private static WebElement pickADateBtn;
    @AndroidFindBy(accessibility = "Selected")
    private static WebElement selectedLabel;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Selected'])[2]")
    private static WebElement selectedToastMessage;
    @AndroidFindBy(accessibility = "OK")
    private WebElement okButton;
    @AndroidFindBy(accessibility = "Cancel")
    private WebElement cancelButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'15')]")
    private WebElement firstDate;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'16')]")
    private WebElement secondDate;

    public CounterAppTestPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateCalendarHomePage() {
        List<WebElement> elementsToCheck = Arrays.asList(
                counterAppHeading,
                currentValueHeading,
                counter,
                addOneBtn,
                subtractTwoBtn,
                resetBtn,
                pickADateBtn
        );

        for (WebElement element : elementsToCheck) {
            if (!checkElementVisibility(element) &&
                    Integer.parseInt(Objects.requireNonNull(counter.getDomAttribute("contest-desc")))!= 0) {
                return false;
            }
        }

        return true;
    }

    public boolean validatingCounterByOneFunctionality(int range) {
        String value = counter.getDomAttribute("content-desc");

        if (value != null && value.startsWith("0")) {
            for (int i = 1; i <= range; i++) {
                click(addOneBtn);
                value = counter.getDomAttribute("content-desc");

                if (value != null && Integer.parseInt(value) != i) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validatingResetBtnFunctionality()
    {
        click(resetBtn);
        String value = counter.getDomAttribute("content-desc");
        return value != null && Integer.parseInt(value) == 0;
    }

    public void validateCalendarFunctionality(String dateFunction) {
        click(pickADateBtn);
        switch (dateFunction){
            case "cancelBtn":
                click(cancelButton);
                MobileAssertion.assertCalendarCancellationBtn(validateAfterPressingCancelBtn());
                break;

            case "selectDate":
                click(okButton);
                MobileAssertion.assertCalendarDateSelectionBtn(validateAfterDateSelection());

        }

    }

    private boolean validateAfterDateSelection() {
        if(checkElementVisibility(selectedLabel))
        {
            return checkElementVisibility(selectedToastMessage);
        }
        return false;
    }

    private boolean validateAfterPressingCancelBtn() {
        if(!checkElementVisibility(selectedLabel))
        {
            return !checkElementVisibility(selectedToastMessage);
        }
        return false;
    }


    public void ValidateSelectedDateIsDisplayed() {
        String currentDate = getCurrentDateFormatted();
        String dateXpath = "//android.view.View[@content-desc='" + currentDate + "']";
        WebElement element = findElementBasedOnTheCurrentDate(dateXpath);
        checkElementVisibility(element);
    }
}


