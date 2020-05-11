package com.example.parking.dao;


import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;

import java.util.List;

public interface UserDAO {

    void save(User u);

    void delete(User u);

    User find(String username);

    List<User> findAll();

    User login(String username,String password);
}
