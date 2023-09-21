package dev.jb9.screenmatch;

import dev.jb9.screenmatch.models.Movie;

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
    }
}
