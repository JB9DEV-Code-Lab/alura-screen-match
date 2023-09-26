package dev.jb9.screenmatch.models;

import dev.jb9.screenmatch.calculations.Sortable;

public class Movie extends Asset implements Sortable {
    // region fields
    private String director;
    // endregion fields

    // region constructors
    public Movie(String name, int launchedYear) {
        super(name, launchedYear);
    }
    // endregion contructors

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

    // region overriginds
    @Override
    public String toString() {
        return String.format("Filme: %s (%d)", this.getName(), this.getLaunchedAtYear());
    }
    // endregion overriginds
}
