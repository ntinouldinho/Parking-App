//package com.example.parking.memorydao;
//
//import com.example.parking.dao.UserDAO;
//import com.example.parking.domain.Rating;
//import com.example.parking.domain.User;
//import com.example.parking.domain.Vehicle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDAOMemory implements UserDAO {
//
//    protected static ArrayList<User> users = new ArrayList<User>();
//
//    public void save(User u){
//        if(!users.contains(u)){
//            users.add(u);
//        }
//    }
//
//    public void delete(User u){
//        users.remove(u);
//    }
//
//    public List<User> findAll(){
//        return users;
//    }
//
//    public String find(String username){
//        for(User u: users){
//            if(u.getUsername().equals(username)){
//                return username;
//            }
//        }
//        return null;
//    }
//
//
//}
