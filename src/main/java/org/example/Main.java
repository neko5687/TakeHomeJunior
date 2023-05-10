package org.example;

import java.io.IOException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        MovieService movieService = new MovieService();
        RatingService ratingService = new RatingService();

        userService.displayUserGreeting();

        try {
            movieService.loadMoviesFromFile("Dateien/movies.csv");
        } catch (IOException e) {
            System.err.println("No movie file found.");
            return;
        }

        String movieId;
        try {
            movieId = userService.requestMovieIdFromUser();
        } catch (IOException e) {
            System.err.println("Error reading input:");
            return;
        }

        try {
            ratingService.loadRatingsFromFile("Dateien/ratings.csv");
        } catch (IOException e) {
            System.err.println("No rating file found.");
            return;
        }

        Optional<Movie> selectedMovie = movieService.findMovieById(movieId);
        if (selectedMovie.isPresent()) {
            ratingService.displayAverageRating(selectedMovie.get());
        }
    }
}