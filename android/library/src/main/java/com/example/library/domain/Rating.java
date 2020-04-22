package com.example.library.domain;

public class Rating {
    private int ratingScore;
    private String s;



    public Rating(int ratingScore, String s) {
        this.ratingScore = ratingScore;
        this.s = s;
    }

    public Rating() {
        this.ratingScore = 0;
        this.s = "";
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingScore=" + ratingScore +
                ", s='" + s + '\'' +
                '}';
    }


}
