package dev.jb9.screenmatch.models;

import dev.jb9.screenmatch.calculations.Sortable;

public class Movie extends Asset implements Sortable {
    // region fields
    private String director;
    // endregion fields

    // region getters and setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    // endregion getters and setters

    // region implementations
    @Override
    public int getSorting() {
        return (int) getAverage() / 2;
    }
    // endregion implementations
}
