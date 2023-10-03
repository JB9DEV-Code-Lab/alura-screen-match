package dev.jb9.screenmatch.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jb9.screenmatch.dtos.AssetDTO;
import dev.jb9.screenmatch.models.Asset;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        System.out.print("Which movie do you want to search? \n> ");
        String searchTerm = reader.nextLine();
        String endpoint = "https://www.omdbapi.com/?t=" + searchTerm + "&apikey=dc5935c";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        AssetDTO assetDTO = gson.fromJson(response.body(), AssetDTO.class);
        System.out.println("AssetDTO: " + assetDTO);
        Asset assetFromSearchTerm = new Asset(assetDTO);
        System.out.println("Built asset from search term: " + assetFromSearchTerm);
    }
}
