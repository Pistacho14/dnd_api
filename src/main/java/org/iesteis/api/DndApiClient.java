package org.iesteis.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.iesteis.model.Response;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class DndApiClient {

    private static final String API_URL = "https://www.dnd5eapi.co";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private DndApiClient() {}

    public static Response readAPIRest() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "/api/2024"))
                    .GET()
                    .build();
            HttpResponse<String> response = CLIENT.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());
            return MAPPER.readValue(response.body(), Response.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readAPIRest(String url, TypeReference<T> typeReference) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + url))
                    .GET()
                    .build();
            HttpResponse<String> response = CLIENT.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());
            return MAPPER.readValue(response.body(), typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
