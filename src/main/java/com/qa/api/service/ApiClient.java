package com.qa.api.service;

import com.qa.utility.ConfigReader;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiClient {

    private final APIRequestContext apiContext;
    private final ConfigReader configReader;

    public ApiClient(APIRequestContext apiContext, ConfigReader configReader)
    {
        this.apiContext = apiContext;
        this.configReader = configReader;

    }

    public APIResponse sendPostRequest() throws IOException {
        String payload = new String(Files.readAllBytes(Paths.get("src/main/resources/payloads/createIssue.json")));
        return apiContext.post(configReader.getProperty("baseUrl"),
                RequestOptions.create()
                        .setHeader("Content-Type", "application/json")
                        .setHeader("Authorization", configReader.getProperty("authorization"))
                        .setData(payload));
    }

    public APIResponse sendGetRequest(String issueId) {
        return apiContext.get(configReader.getProperty("baseUrl") + "/" + issueId,
                RequestOptions.create()
                        .setHeader("Content-Type", "application/json")
                        .setHeader("Authorization", configReader.getProperty("authorization")));
    }

    public APIResponse setPutRequest(String issueId) throws IOException {
        String payload = new String(Files.readAllBytes(Paths.get("src/main/resources/payloads/updateIssue.json")));

        return apiContext.put(configReader.getProperty("baseUrl") + "/" + issueId,
                RequestOptions.create()
                        .setHeader("Content-Type", "application/json")
                        .setHeader("Authorization", configReader.getProperty("authorization"))
                        .setData(payload));
    }
}
