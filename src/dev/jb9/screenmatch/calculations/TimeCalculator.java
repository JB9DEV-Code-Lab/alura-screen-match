package dev.jb9.screenmatch.calculations;

import dev.jb9.screenmatch.models.Asset;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void add(Asset asset) {
        totalTime += asset.getDurationInMinutes();
    }
}
