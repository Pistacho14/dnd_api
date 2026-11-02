package org.iesteis.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.iesteis.model.ApiListResponse;
import org.iesteis.model.Response;


import tools.jackson.databind.ObjectMapper;
import tools.jackson.core.type.TypeReference;

public class DndApiClient {
 
    private DndApiClient() {}

    public static Response readAPIRest() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create("https://www.dnd5eapi.co/api/2024"))
                                    .GET()
                                    .build();
            HttpResponse<String> response = client
                                            .send(
                                    request,
                                    HttpResponse.BodyHandlers.ofString());
            
            return mapper.readValue(response.body(), Response.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readAPIRest(String url, TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create("https://www.dnd5eapi.co" + url))
                                    .GET()
                                    .build();
            HttpResponse<String> response = client
                                            .send(
                                    request,
                                    HttpResponse.BodyHandlers.ofString());
            
            return mapper.readValue(response.body(), typeReference);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
