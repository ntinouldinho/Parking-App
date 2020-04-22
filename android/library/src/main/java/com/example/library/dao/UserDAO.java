package com.example.library.dao;

import com.example.library.domain.User;
import com.example.library.domain.Vehicle;

import java.util.List;

public interface UserDAO {

    void save(User u);

    void delete(User u);

    void update(User u);

    List<User> findAll();

}
