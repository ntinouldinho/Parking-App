package com.example.parking.util;

import android.util.Log;

import java.time.LocalDateTime;

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
       Log.e("in set","set "+String.valueOf(getPoints())+ " to "+points); this.points = points;
    }

    public void addCredits(int points){
        setPoints(points+getPoints());
    }

    public boolean removeCredits(int points){
        int currentPoints=getPoints();
        if(currentPoints<points){
            return false;
        }
        Log.e("before removal",String.valueOf(getPoints()));
        setPoints(currentPoints-points);
        Log.e("after removal",String.valueOf(getPoints()));
        return true;
    }

}
