package com.example.library.domain;


import com.example.library.util.Credits;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String username;
    private String password;
    private Credits credits;
    private Address address;
    private ArrayList<Rating> rating;
    private ArrayList<Vehicle> vehicles;


    public User(String name, String surname, String phone, String email, String username, String password, Credits credits, Address address, ArrayList<Rating> rating,ArrayList<Vehicle> vehicles) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.credits = credits;
        this.address = address;
        for(Rating r:rating){
            this.rating.add(r);
        }

        for(Vehicle vehicle:vehicles){
            this.vehicles.add(vehicle);
        }
    }

    public User(){
        this.name = "";
        this.surname = "";
        this.phone = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.credits = new Credits();
        this.address = new Address();
        this.rating = new ArrayList<Rating>();
        this.vehicles = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Credits getCredits() {
        return credits;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Rating> getRating() {
        return rating;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addRating(Rating rating){
        this.rating.add(rating);
    }

    public void removeRating(Rating rating){
        this.rating.remove(rating);
    }

    public void addVehicle(Vehicle vehicle){
        for(Vehicle currentVehicle:vehicles){
            if(currentVehicle.getPlate().equals(vehicle.getPlate())) return;
        }
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }

    public double calculateRating(){
        int currentRating = 0;
        for(Rating rate: rating){
            currentRating+=rate.getRatingScore();
        }
        return currentRating/rating.size();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", credits=" + credits +
                ", address=" + address +
                ", rating=" + rating +
                '}';
    }
}
