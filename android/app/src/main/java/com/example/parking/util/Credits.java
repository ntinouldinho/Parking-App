package com.example.parking.util;

public class Credits {
    private int points;

    public Credits(int points) {
        this.points = points;
    }

    public Credits() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addCredits(int points){
        int currentPoints=getPoints();
        setPoints(currentPoints+points);
    }

    public boolean removeCredits(int points){
        int currentPoints=getPoints();
        if(currentPoints<points){
            return false;
        }
        setPoints(currentPoints-points);
        return true;
    }

}
