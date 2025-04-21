package com.backend.getyourstart.helpers;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


import com.backend.getyourstart.dto.AdzunaJob;
import com.backend.getyourstart.dto.AdzunaJobResponse;
import com.backend.getyourstart.helpers.Header;


import com.backend.getyourstart.helpers.RequestHelper;

import java.io.UnsupportedEncodingException;
import java.lang.StringBuilder;

public class AdzunaRequestHelper {
    private RequestHelper requestHelper;
    private String query;
    private String appId;
    private String appKey;

    public AdzunaRequestHelper() {
        this.requestHelper = new RequestHelper();
        this.appId = System.getProperty("ADZUNA_APP_ID");
        this.appKey = System.getProperty("ADZUNA_APP_KEY");
    }

    public void setQuery(
        String country, 
        String numResults, 
        List<String> jobTypes, 
        String page, 
        String where, 
        String distance,
        String sortBy,
        String salaryMin,
        String salaryMax,
        String fullTime,
        String partTime,
        String contract,
        String permanent
    ) 
    {
        HashMap<String, String> parameters = new HashMap<>(10);
        parameters.put("results_per_page", numResults);
        parameters.put("where", where);
        parameters.put("distance", distance);
        parameters.put("sort_by", sortBy);
        parameters.put("salary_min", salaryMin);
        parameters.put("salary_max", salaryMax);
        parameters.put("full_time", fullTime);
        parameters.put("part_time", partTime);
        parameters.put("contract", contract);
        parameters.put("permanent", permanent);
        final String starterUrl = "http://api.adzuna.com/v1/api/jobs/" + country + "/search/" + page + "?app_id=" + this.appId + "&app_key=" + this.appKey;
        StringBuilder queryBuilder = new StringBuilder();
        String query = "";

        queryBuilder.append("&what=");
        String whatParams = "";
        for(int i = 0; i < jobTypes.size(); i++) {
            if (i < jobTypes.size() - 1) {
                whatParams = whatParams.concat(jobTypes.get(i) + " ");
            } else {
                whatParams = whatParams.concat(jobTypes.get(i));
            }
        }
        String encodedParams = "";
        try {
             encodedParams = URLEncoder.encode(whatParams, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }
        queryBuilder.append(encodedParams);
        
        
        parameters.forEach((k, v) -> {
            String encodedValue = "";
            if (v != null && !v.isEmpty()) {
                try {
                    encodedValue = URLEncoder.encode(v, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return;
                }
                queryBuilder.append("&" + k + "=" + encodedValue);
            }
        });

        queryBuilder.append("&content-type=application/json");

        query = queryBuilder.toString();
        this.query = starterUrl.concat(query);

        System.out.println(this.query);
    }

    public List<AdzunaJob> sendRequest() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("Content-Type", "application/json"));
        headers.add(new Header("accept", "application/json"));
        this.requestHelper.createRequest(query, headers);
        HttpResponse<String> response = null;
        try {
            response = this.requestHelper.sendRequest();
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            return null;
        }

        String responseBody = response.body();

        System.out.println(responseBody);

        AdzunaJobResponse jobResponse = null;

        try {
            jobResponse = objectMapper.readValue(responseBody, AdzunaJobResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return jobResponse.getResults();
    }
}