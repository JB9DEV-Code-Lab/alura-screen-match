package dev.jb9.screenmatch.main;

import dev.jb9.screenmatch.dtos.OMDBAssetDTO;
import dev.jb9.screenmatch.models.Asset;
import dev.jb9.screenmatch.services.OMDBService;

import java.io.IOException;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args)  {
        Scanner reader = new Scanner(System.in);
        System.out.print("Which movie do you want to search? \n> ");
        String movieName = reader.nextLine();

        try {
            OMDBAssetDTO omdbAssetDTO = OMDBService.searchMovie(movieName);
            Asset assetFromSearchTerm = new Asset(omdbAssetDTO);
            System.out.println("OMDBAssetDTO: " + omdbAssetDTO);
            System.out.println("Built asset from search term: " + assetFromSearchTerm);
        } catch (IOException | InterruptedException exception) {
            System.out.println("Couldn't search for movie. " + exception.getMessage());
        } finally {
            System.out.println("End of program!");
        }
    }
}
