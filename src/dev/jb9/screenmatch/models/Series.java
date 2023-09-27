package dev.jb9.screenmatch.models;

public class Series extends Asset {
    // region fields
    private int seasons;
    private boolean active;
    private int episodesPerSeason;
    private int minutesPerEpisode;

    public int getSeasons() {
        return seasons;
    }
    // endregion fields

    // region constructors
    public Series(String name, int launchedYear) {
        super(name, launchedYear);
    }
    // endregion constructors

    // region getters and setters
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }
    // region getters and setters

    // region overridings
    @Override
    public int getDurationInMinutes() {
        return seasons * episodesPerSeason * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return String.format("Series: %s (%d)", getName(), getLaunchedAtYear());
    }
    // endregion overridings

}
