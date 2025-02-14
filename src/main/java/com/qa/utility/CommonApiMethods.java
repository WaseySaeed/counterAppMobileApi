package com.qa.utility;

import com.microsoft.playwright.APIResponse;
import org.json.JSONObject;

public class CommonApiMethods {

    public static String getValueFromResponse(APIResponse apiResponse, String key)
    {
        JSONObject jsonResponse = new JSONObject(apiResponse.text());
        return jsonResponse.getString(key);
    }
}
