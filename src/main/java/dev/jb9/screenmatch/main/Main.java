package dev.jb9.screenmatch.main;

import dev.jb9.screenmatch.calculations.RecomendationFilter;
import dev.jb9.screenmatch.calculations.TimeCalculator;
import dev.jb9.screenmatch.models.Episode;
import dev.jb9.screenmatch.models.Movie;
import dev.jb9.screenmatch.models.Series;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Movie avengers = new Movie("The Avengers", 2012);
        avengers.setDurationInMinutes(143);
        avengers.rate(7);
        avengers.rate(8);
        avengers.rate(9);
        avengers.showDatasheet();
        System.out.println("Average from getAverage method: " + avengers.getAverage());

        Movie furiosFast = new Movie("Furios Fast", 2000);
        furiosFast.setDurationInMinutes(120);

        Series theWheelOfTime = new Series("Time Wheel", 2021);
        theWheelOfTime.setSeasons(2);
        theWheelOfTime.setEpisodesPerSeason(8);
        theWheelOfTime.setMinutesPerEpisode(60);

        TimeCalculator calculator = new TimeCalculator();
        calculator.add(avengers);
        calculator.add(furiosFast);
        calculator.add(theWheelOfTime);
        System.out.println("Amount of time to watch all added assets: " + calculator.getTotalTime() + " minutes");

        Episode episode1 = new Episode();
        episode1.setNumber(1);
        episode1.setSeries(theWheelOfTime);
        episode1.setTotalViews(150);

        RecomendationFilter recomendationFilter = new RecomendationFilter();
        recomendationFilter.filter(avengers);
        recomendationFilter.filter(furiosFast);
        recomendationFilter.filter(episode1);

        Movie ipman = new Movie("Ipman the greatest master", 2008);
        ipman.setDurationInMinutes(90);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(avengers);
        movies.add(furiosFast);
        movies.add(ipman);

        System.out.println("Movies: " + movies);
        System.out.printf("First movie: %s", movies.get(0).getName());
        System.out.printf("Movies count: %d", movies.size());
    }
}
