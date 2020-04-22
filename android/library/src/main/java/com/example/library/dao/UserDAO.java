package com.example.library.dao;

import com.example.library.domain.User;
import com.example.library.domain.Vehicle;

import java.util.List;

public interface UserDAO {

    void save(User u);

    void delete(User u);

    String find(String username);

    List<User> findAll();

}
