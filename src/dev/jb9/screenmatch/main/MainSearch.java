package dev.jb9.screenmatch.main;

import dev.jb9.screenmatch.dtos.OMDBAssetDTO;
import dev.jb9.screenmatch.services.OMDBService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args)  {
        Scanner reader = new Scanner(System.in);
        OMDBService omdbService = new OMDBService();
        File searchedMoviesJson = new File("src/dev/jb9/screenmatch/resources/searched-movies.json");

        System.out.println("""
        Hi, this is the movie searcher. I'm keep asking you which movie you want to search until you say "done".
        Then I'll store all of them in a file at the end and I'll let you know.
        """);
        String movieName = "";

        while(true) {
            try {
                System.out.print("Which movie do you want to search? \n> ");
                movieName = reader.nextLine().toLowerCase();

                if (movieName.equals("done")) {
                    break;
                }

                OMDBAssetDTO searchedMovie = omdbService.searchMovie(movieName);
                omdbService.saveSearchedMovie(searchedMovie);
            } catch (IOException | InterruptedException exception) {
                System.out.println("Couldn't search for movie. " + exception.getMessage());
            }
        }

        try {
            omdbService.saveMovies(searchedMoviesJson);
        } catch (IOException exception) {
            System.out.println("Couldn't save searched movie: " + exception.getMessage());
        }
    }
}
