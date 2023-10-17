package dev.jb9.screenmatch.main;

import dev.jb9.screenmatch.models.Movie;
import dev.jb9.screenmatch.models.Series;
import dev.jb9.screenmatch.models.Asset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainLists {
    public static void main(String[] args) {
        Movie oblivion = new Movie("Oblivion", 2012);
        oblivion.rate(7);
        Movie worldZWar = new Movie("World Z War", 2013);
        worldZWar.rate(9);
        Movie blackPanther = new Movie("Black Panther", 2018);
        blackPanther.rate(8);
        Series vikins = new Series("Vikins", 2013);
        vikins.rate(10);

        ArrayList<Asset> watchedAssets = new ArrayList<>();
        watchedAssets.add(oblivion);
        watchedAssets.add(worldZWar);
        watchedAssets.add(blackPanther);
        watchedAssets.add(vikins);

        for (Asset asset : watchedAssets) {
            System.out.printf("Watched asset %s %n", asset.getName());

            if (asset instanceof Movie movie && movie.getSorting() > 2) {
                System.out.printf("  => sorting is %d %n", movie.getSorting());
            }
        }

        System.out.println("watched assets after sort by name");
        Collections.sort(watchedAssets);
        System.out.println(watchedAssets);

        System.out.println("watched assets after sort by launched year");
        watchedAssets.sort(Comparator.comparing(Asset::getLaunchedAtYear));
        System.out.println(watchedAssets);
     }
}
