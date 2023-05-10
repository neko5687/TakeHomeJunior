package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieService {
    List<Movie> movieList = new ArrayList<>();

    public void loadMoviesFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String movieEntry;
            while ((movieEntry = br.readLine()) != null) {
                String[] movieValues = movieEntry.split(",");
                movieList.add(new Movie(movieValues[0], movieValues[1]));
            }
        }
    }

    public Optional<Movie> findMovieById(String movieId) {

        for (Movie movie : movieList) {
            if (movie.getMovieId().equals(movieId)) {
                System.out.println("Es wurde der Film: " + movie.getTitle() + " ausgewählt.");
                return Optional.of(movie);
            }
        }
        System.out.println("Film mit ID " + movieId + " wurde nicht gefunden.");
        return Optional.empty();
    }
}

