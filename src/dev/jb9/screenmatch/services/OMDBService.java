package dev.jb9.screenmatch.services;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jb9.screenmatch.dtos.OMDBAssetDTO;
import dev.jb9.screenmatch.models.Asset;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class OMDBService {
    private final List<Asset> searchedMovies = new ArrayList<>();
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public OMDBAssetDTO searchMovie(String term) throws IOException, InterruptedException {
        String searchTerm = URLEncoder.encode(term, StandardCharsets.UTF_8);
        String endpoint = "https://www.omdbapi.com?t=" + searchTerm + "&apikey=" + System.getenv("OMDB_API_KEY");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            System.out.printf("%nMovie %s successfuly found!%n%n", term);
        } else {
            System.out.printf("%nCouldn't find movie %s%n%n", term);
        }

        return gson.fromJson(response.body(), OMDBAssetDTO.class);
    }

    public void saveSearchedMovie(OMDBAssetDTO searchedMovie) {
        Asset asset = new Asset(searchedMovie);
        searchedMovies.add(asset);
    }

    public void saveMovies(File file) throws IOException {
        String json = gson.toJson(searchedMovies);
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(json);
        fileWriter.close();
        System.out.println("Searched movies saved at " + file.getPath());
    }
}
