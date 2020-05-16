package com.example.parking.dao;


import com.example.parking.domain.Rating;

import java.util.List;

public interface RatingDAO {

    void save(Rating r);

    List<Rating> findAllOfUser(String username);

    List<Rating> findAll();

    double calculateStats(String username);

    void deleteAll();
}
