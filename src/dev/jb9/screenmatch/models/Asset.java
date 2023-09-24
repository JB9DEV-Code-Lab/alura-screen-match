package dev.jb9.screenmatch.models;

public class Asset {
    // region fields
    private String name;
    private int launchedAtYear;
    private int durationInMinutes;
    private boolean isPremium = false;
    private double ratingSum;
    private double totalRatings;
    // endregion fields

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

    // region private methods
    // endregion private methods
}
