package dev.jb9.screenmatch.models;

import dev.jb9.screenmatch.dtos.AssetDTO;

public class Asset implements Comparable<Asset> {
    // region fields
    private String name;
    private int launchedAtYear;
    private int durationInMinutes;
    private boolean isPremium = false;
    private double ratingSum;
    private double totalRatings;
    // endregion fields

    // region constructors
    public Asset(String name, int launchedAtYear) {
        this.name = name;
        this.launchedAtYear = launchedAtYear;
    }

    public Asset(AssetDTO assetDTO) {
        this.name = assetDTO.title();
        this.launchedAtYear = Integer.parseInt(assetDTO.year().replaceAll("\\D", ""));
        try {
            this.durationInMinutes = Integer.parseInt(assetDTO.runtime().split(" ")[0]);
        } catch(NumberFormatException exception) {
            this.durationInMinutes = 0;
        }
    }
    // endregion constructors

    // region getters
    public String getName() {
        return name;
    }

    public int getLaunchedAtYear() {
        return launchedAtYear;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public double getTotalRatings() {
        return totalRatings;
    }
    // endregion getters

    // region setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLaunchedAtYear(int launchedAtYear) {
        this.launchedAtYear = launchedAtYear;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public void setTotalRatings(double totalRatings) {
        this.totalRatings = totalRatings;
    }
    // endregion setters

    // region public methods
    public void showDatasheet() {
        System.out.printf("""
                        Name: %s
                        Launched at: %d
                        Duration in minutes: %d
                        Premium member only: %s
                        The rating sum is: %.2f
                        The total ratings is: %.2f
                        The average is: %.2f
                        """, name, launchedAtYear, durationInMinutes,
                (isPremium ? "yes" : "no"), ratingSum,
                totalRatings, (ratingSum / totalRatings));
    }

    public void rate(double rating) {
        ratingSum += rating;
        totalRatings++;
    }

    public double getAverage() {
        return ratingSum / totalRatings;
    }
    // endregion public methods

    // region overridings
    @Override
    public int compareTo(Asset otherAsset) {
        return this.getName().compareTo(otherAsset.getName());
    }

    @Override
    public String toString() {
        if (this.name.isBlank() && this.launchedAtYear == 0 && this.durationInMinutes == 0) {
            return "Asset: no name, no year and no duration were provided";
        }

        if (this.launchedAtYear == 0 && this.durationInMinutes == 0) {
            return String.format("Asset: %s (no year and no duration were provided)", this.name);
        }

        if (this.launchedAtYear == 0) {
            return String.format("Asset: %s (no year was provided) - %d", this.name, this.durationInMinutes);
        }

        if (this.durationInMinutes == 0) {
            return String.format("Asset: %s (%d) - no duration was provided", this.name, this.launchedAtYear);
        }

        return String.format("Asset: %s (%d) - %d minutes", getName(), getLaunchedAtYear(), getDurationInMinutes());
    }

    // endregion overridings
}
