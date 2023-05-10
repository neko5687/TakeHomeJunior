package org.example;

public class Movie {

    private final String movieId;
    private final String title;

    public Movie(String id, String title) {
        this.movieId = id;
        this.title = title;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }
}
