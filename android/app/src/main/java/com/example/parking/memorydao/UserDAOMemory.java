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
    public User login(String username,String password){
        User currentUser = find(username);
        if(currentUser!=null){
            if(currentUser.getPassword().equals(password)) {
                return currentUser;
            }
            return null;
        }
        return null;
    }
    @Override
    public void delete(User u){
        users.remove(u);
    }

    public List<User> findAll(){
        return users;
    }

    @Override
    public User find(String username){
        for(User u: users){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }

    @Override
    public Vehicle findVehicle(String username,String plate){
        for(User u: users){
            if(u.getUsername().equals(username)){
                for(Vehicle vehicle:u.getVehicles()){
                    if(vehicle.getPlate().equals(plate)){
                        return vehicle;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override
    public void updateVehicle(String username,Vehicle temp){
        for(User u: users){
            if(u.getUsername().equals(username)){
                for(int i=0;i<u.getVehicles().size();i++){
                    if(u.getVehicles().get(i).getPlate().equals(temp.getPlate())){
                        u.getVehicles().set(i,temp);
                    }
                }
            }
        }
    }


}
