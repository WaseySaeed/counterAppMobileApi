package com.exinity.utility;

import com.microsoft.playwright.APIResponse;
import org.testng.Assert;

public class ApiAssertion {

    public static void validateResponse(APIResponse apiResponse, int statusCode) {
        System.out.println(apiResponse.status());
        Assert.assertEquals(apiResponse.status(), statusCode, "Issue creation failed!");
    }

}
