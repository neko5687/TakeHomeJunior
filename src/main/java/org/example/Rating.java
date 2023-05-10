package org.example;

public class Rating {

    private final String id;
    private final String rating;

    public Rating(String id, String rating) {
        this.id = id;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }
}
