package dev.jb9.screenmatch;

import dev.jb9.screenmatch.calculations.TimeCalculator;
import dev.jb9.screenmatch.models.Movie;
import dev.jb9.screenmatch.models.Series;


public class Main {
    public static void main(String[] args) {
        Movie avengers = new Movie();
        avengers.setName("The Avengers");
        avengers.setLaunchedAtYear(2012);
        avengers.setDurationInMinutes(143);
        avengers.rate(7);
        avengers.rate(8);
        avengers.rate(9);
        avengers.showDatasheet();
        System.out.println("Average from getAverage method: " + avengers.getAverage());

        Movie furiosFast = new Movie();
        furiosFast.setName("Furios Fast");
        furiosFast.setLaunchedAtYear(2000);
        furiosFast.setDurationInMinutes(120);

        Series timeWheel = new Series();
        timeWheel.setName("Time Wheel");
        timeWheel.setSeasons(2);
        timeWheel.setEpisodesPerSeason(8);
        timeWheel.setMinutesPerEpisode(60);

        TimeCalculator calculator = new TimeCalculator();
        calculator.add(avengers);
        calculator.add(furiosFast);
        calculator.add(timeWheel);
        System.out.println("Amount of time to watch all added assets: " + calculator.getTotalTime() + "minutes");
    }
}
