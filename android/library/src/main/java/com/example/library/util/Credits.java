package com.example.library.util;
public class Credits {
    private double points;

    public Credits(double points) {
        this.points = points;
    }

    public Credits() {
        this.points = 0;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void addCredits(double points){
        double currentPoints=getPoints();
        setPoints(currentPoints+points);
    }

    public boolean removeCredits(double points){
        double currentPoints=getPoints();
        if(currentPoints<points){
            return false;
        }
        setPoints(currentPoints-points);
        return true;
    }

}
