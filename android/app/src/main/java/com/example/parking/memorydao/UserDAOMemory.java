package com.example.parking.memorydao;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.Rating;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDAOMemory implements UserDAO {

    protected static ArrayList<User> users = new ArrayList<User>();

    @Override
    public void save(User u){
        if(!users.contains(u)){
            users.add(u);
        }
    }

    @Override
    public void delete(User u){
        users.remove(u);
    }

    public List<User> findAll(){
        return users;
    }

    @Override
    public String find(String username){
        for(User u: users){
            if(u.getUsername().equals(username)){
                return username;
            }
        }
        return null;
    }




}
