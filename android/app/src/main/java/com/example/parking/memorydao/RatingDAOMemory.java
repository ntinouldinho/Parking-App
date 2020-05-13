package com.example.parking.memorydao;

import com.example.parking.dao.RatingDAO;
import com.example.parking.domain.Rating;

import java.util.ArrayList;
import java.util.List;

public class RatingDAOMemory implements RatingDAO {

    protected static ArrayList<Rating> ratings = new ArrayList<Rating>();

    @Override
    public void save(Rating r){
        ratings.add(r);
    }

    public List<Rating> findAllOfUser(String username){
        List<Rating> ratedUser=new ArrayList<>();
        for(Rating r: ratings){
            if(r.getRatedUsername().equals(username)){
                ratedUser.add(r);
            }
        }
        return  ratedUser;

    }
}
