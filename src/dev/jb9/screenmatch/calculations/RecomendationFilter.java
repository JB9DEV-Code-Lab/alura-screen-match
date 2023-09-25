package dev.jb9.screenmatch.calculations;

public class RecomendationFilter {
    public void filter(Sortable sortable) {
        int sortableSorting = sortable.getSorting();

        if (sortableSorting >= 4) {
            System.out.println("It's on top 10!");
        } else if (sortableSorting >= 2) {
            System.out.println("It's pretty good!");
        } else {
            System.out.println("Add it to your watchlist.");
        }
    }
}
