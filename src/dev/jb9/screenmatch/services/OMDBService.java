package dev.jb9.screenmatch.services;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import dev.jb9.screenmatch.dtos.OMDBAssetDTO;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OMDBService {

    public static OMDBAssetDTO searchMovie(String term) throws IOException, InterruptedException {
        String searchTerm = URLEncoder.encode(term, StandardCharsets.UTF_8);
        String endpoint = "https://www.omdbapi.com?t=" + searchTerm + "&apikey=" + System.getenv("OMDB_API_KEY");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create()
                .fromJson(response.body(), OMDBAssetDTO.class);
    }
}
