package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RatingService {
    List<Rating> ratingList = new ArrayList<>();

    public void loadRatingsFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String ratingEntry;
            while ((ratingEntry = br.readLine()) != null) {
                String[] ratingValues = ratingEntry.split(",");
                ratingList.add(new Rating(ratingValues[1], ratingValues[2]));
            }
        }
    }

    private double calculateAverageRating(Movie movie) {
        double sumOfRatings = 0;
        int numOfRatings = 0;
        for (Rating rating : ratingList) {
            if (rating.getId().equals(movie.getMovieId())) {
                sumOfRatings += Double.parseDouble(rating.getRating());
                numOfRatings++;
            }
        }
        return sumOfRatings / numOfRatings;
    }

    public void displayAverageRating(Movie movie) {
        double avgRating = this.calculateAverageRating(movie);
        DecimalFormat f = new DecimalFormat("#0.00");
        System.out.println("Die durchschnittliche Bewertung für den Film ist: " +
                f.format(avgRating) + " / 5 ⭐");
    }
}