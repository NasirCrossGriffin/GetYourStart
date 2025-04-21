package com.backend.getyourstart.helpers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.List;
import com.backend.getyourstart.helpers.Header;





public class RequestHelper {
    private HttpClient client;
    private HttpRequest request;

    public RequestHelper() {
        this.client = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();  
    }

    public void createRequest(String URL, List<Header> headers) {
        System.out.println(URL);
        Builder requestBuilder = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(URL))
            .timeout(Duration.ofMinutes(2));
            headers.forEach((header) -> {
                requestBuilder.header(header.getName(), header.getValue());
            });

            this.request = requestBuilder.build();   
    }

    public HttpResponse<String> sendRequest() throws InterruptedException, ExecutionException, TimeoutException {
        try {
            HttpResponse<String> response = client.sendAsync(this.request, BodyHandlers.ofString())
                .get(1, TimeUnit.MINUTES);
            return response;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            return null; 
        }
    }
}
