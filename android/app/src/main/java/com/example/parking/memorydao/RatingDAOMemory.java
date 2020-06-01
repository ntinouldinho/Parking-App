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

    public double calculateStats(String username){
        int size=0;
        int addition=0;
        for(Rating r: ratings){
            if(r.getRatedUsername().equals(username)){
                size++;
                addition+=r.getRatingScore();
            }
        }
        if(size!=0){
            return addition/size;
        }
        return 0.0;
    }
    @Override
    public void delete(Rating p){
        ratings.remove(p);
    }

    public List<Rating> findAll(){
        return ratings;
    }

    public void deleteAll(){//delete deletes every rating
        for(Rating rat: ratings) {
            ratings.remove(rat);
        }
    }
}
