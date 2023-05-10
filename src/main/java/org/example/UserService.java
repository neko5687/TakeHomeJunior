package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserService {

    public void displayUserGreeting() {
        System.out.println("Hallo Filmfreund!");
    }

    public String requestMovieIdFromUser() throws IOException {
        String userInput;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            do {
                System.out.println("Bitte geben Sie eine gültige Filmnummer ein, zu der Sie eine Bewertung wünschen:");
                userInput = reader.readLine();
            } while (isValidMovieId(userInput));
            return userInput;
        }
    }

    private boolean isValidMovieId(String userInput) {
        return userInput != null && !userInput.matches("[1-9][0-9]*");
    }
}
