package com.exinity.api.test;

import com.exinity.api.service.ApiClient;
import com.exinity.api.base.BaseClassApi;
import com.exinity.utility.ApiAssertion;
import com.microsoft.playwright.APIResponse;
import org.testng.annotations.Test;
import java.io.IOException;
import static com.exinity.utility.CommonApiMethods.*;

public class JiraApiTest extends BaseClassApi {

    public String issueId = null;
    public ApiClient apiClient;

    @Test(description="Using Jira public API to create an Issue")
    public void create_JIRA_Issue() throws IOException {
        apiClient = new ApiClient(apiContext,configReader);
        APIResponse apiResponse = apiClient.sendPostRequest();
        ApiAssertion.validateResponse(apiResponse,201);
        issueId = getValueFromResponse(apiResponse,"id");

    }

    @Test(description="Using Jira public API to fetch the issue created via the Create Issue api")
    public void get_JIRA_Issue()
    {
        apiClient = new ApiClient(apiContext,configReader);
        APIResponse apiResponse = apiClient.sendGetRequest(issueId);
        ApiAssertion.validateResponse(apiResponse,200);
        System.out.println(apiResponse.text());
    }

    @Test(description="Using Jira public API to update the issue created via the Create Issue api")
    public void update_JIRA_Issue() throws IOException {
        apiClient = new ApiClient(apiContext,configReader);
        APIResponse apiResponse = apiClient.setPutRequest(issueId);
        ApiAssertion.validateResponse(apiResponse,204);
    }
}
