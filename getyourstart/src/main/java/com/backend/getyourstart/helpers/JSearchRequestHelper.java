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


import com.backend.getyourstart.dto.JSearchJob;
import com.backend.getyourstart.dto.JSearchJobResponse;

import com.backend.getyourstart.helpers.RequestHelper;
import com.backend.getyourstart.helpers.Header;


import java.io.UnsupportedEncodingException;
import java.lang.StringBuilder;

public class JSearchRequestHelper {
    private RequestHelper requestHelper;
    private String query;   
    private String appKey;

    public JSearchRequestHelper() {
        this.requestHelper = new RequestHelper();
        this.appKey = System.getProperty("RAPIDAPI_APP_KEY");
    }

    public void setQuery(
        String job,
        String page,
        String numPages,
        String country,
        String language,
        String datePosted,
        String employmentTypes,
        String jobRequirements,
        String radius
    ) {
        String starterUrl = "https://jsearch.p.rapidapi.com/search?";
        StringBuilder queryBuilder = new StringBuilder();

        String encodedJob = null;

        try {
            encodedJob = URLEncoder.encode(job, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        queryBuilder.append("query=" + encodedJob);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("page", page);
        params.put("num_pages", numPages);
        params.put("country", country);
        params.put("language", language);
        params.put("date_posted", datePosted);
        params.put("employment_types", employmentTypes);
        params.put("job_requirements", jobRequirements);
        params.put("radius", radius);

        params.forEach((k, v) -> {
            queryBuilder.append("&" + k + "=" + v);
        });

        this.query = starterUrl.concat(queryBuilder.toString());
    }

    public List<JSearchJob> sendRequest() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("x-rapidapi-host", "jsearch.p.rapidapi.com"));
        headers.add(new Header("x-rapidapi-key", this.appKey));
        this.requestHelper.createRequest(this.query, headers);
        HttpResponse<String> response = null;

        try {
            response = this.requestHelper.sendRequest();
        } catch(InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            //return null;
        }

        String responseBody = response.body();

        System.out.println(responseBody);

        JSearchJobResponse jobResponse = null;

        try {
            jobResponse = objectMapper.readValue(responseBody, JSearchJobResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return jobResponse.getData();

    }
}
