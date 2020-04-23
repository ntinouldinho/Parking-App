package com.example.library.domain;

public class Rating {
    private int ratingScore;
    private String comment;



    public Rating(int ratingScore, String comment) {
        this.ratingScore = ratingScore;
        this.comment = comment;
    }

    public Rating() {
        this.ratingScore = 0;
        this.comment = "";
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingScore=" + ratingScore +
                ", Comment='" + comment + '\'' +
                '}';
    }


}
