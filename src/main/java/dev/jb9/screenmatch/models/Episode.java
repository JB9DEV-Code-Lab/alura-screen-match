package dev.jb9.screenmatch.models;

import dev.jb9.screenmatch.calculations.Sortable;

public class Episode implements Sortable {
    // region fields
    String title;
    int number;
    Series series;
    int totalViews;
    // endregion fields

    // region getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }
    // endregion getters and setters

    // region implementations
    @Override
    public int getSorting() {
        if (getTotalViews() > 100) {
            return 4;
        }

        return 2;
    }
    // endregion implementations
}
