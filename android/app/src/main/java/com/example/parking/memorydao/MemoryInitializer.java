package com.example.parking.memorydao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.dao.VehicleDAO;
import com.example.parking.domain.Address;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.Rating;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.util.Colour;
import com.example.parking.util.Credits;
import com.example.parking.util.Pin;
import com.example.parking.util.TimeRange;
import com.example.parking.util.ZipCode;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemoryInitializer {
    private static ParkingRequestDAO PRDao = new ParkingRequestDAOMemory();
    private static ParkingSpaceDAO PSDao = new ParkingSpaceDAOMemory();
    private static UserDAO UDao = new UserDAOMemory();
    private static VehicleDAO VDao = new VehicleDAOMemory();

    protected static void eraseData() {
        List<User> users = getUserDAO().findAll();
        for(User user : users) {
            getUserDAO().delete(user);
        }

        List<ParkingRequest> parkingRequests = getRequestDAO().findAll();
        for(ParkingRequest parkingRequest : parkingRequests) {
            getRequestDAO().delete(parkingRequest);
        }

        List<ParkingSpace> parkingSpaces = getParkingDAO().findAll();
        for(ParkingSpace parkingSpace : parkingSpaces) {
            getParkingDAO().delete(parkingSpace);
        }

        List<Vehicle> vehicles = getVehicleDAO().findAll();
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void prepareData(){
        eraseData();

        //Init addresses
        Address add1 = new Address("Elm St.","69", new ZipCode(15125));
        Address add2 = new Address("Wall St.","23", new ZipCode(71310));
        Address add3 = new Address("Baker St.","158", new ZipCode(61717));
        Address add4 = new Address("Antoniadou St.","510", new ZipCode(16715));
        Address add5 = new Address("Derigny St.","53", new ZipCode(16716));



        //Init users
        User user1= new User ("John", "Snow", "6980808080", "johnsnow@gmail.com", "IknowNothing","valarmorgulis",add1, new ArrayList<Rating>(),new ArrayList<Vehicle>());
        User user2= new User ("Walter", "White", "6941051051", "walterwhite@gmail.com", "GoodGuyWalt","saymyname",add2, new ArrayList<Rating>(),new ArrayList<Vehicle>());
        User user3= new User ("Jax", "Teller", "6912515918", "jaxteller@gmail.com", "JaxTellerHarley","jaxtellerdidnothingwrong",add3, new ArrayList<Rating>(),new ArrayList<Vehicle>());
        User user4= new User ("Harry", "Potter", "6991850231", "harrypotter@gmail.com", "1","2",add4, new ArrayList<Rating>(),new ArrayList<Vehicle>());
        User user5= new User ("Luke", "Skywalker", "6958285692", "lukeskywalker@gmail.com", "WhoIsMyFather","iamyourfather",add5, new ArrayList<Rating>(),new ArrayList<Vehicle>());

        //vehicle ex vi is for user i vii is also for user i...viiii is for user i
        Vehicle v1 = new Vehicle(Colour.White,451,"Medium Size car, fits most places","IEH1234","A3","Audi");
        Vehicle v2 = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        Vehicle v3 = new Vehicle(Colour.Black,324,"Medium Bike", "AZE9152","2003 Dyna Super Glide Sport with custom T-bars","Harley Davidson");
        Vehicle v4 = new Vehicle(Colour.Golden,511,"Large SUV", "MEA6157","Escalade","Cadillac");
        Vehicle v5 = new Vehicle(Colour.Blue,441,"Small SUV", "IZA6015","Escape","Ford");
        Vehicle v55 = new Vehicle(Colour.Black,1400000000,"Space Battle Station", "ZOE5555","Death Star","Galactic Empire");

        user1.addVehicle(v1);
        user2.addVehicle(v2);
        user3.addVehicle(v3);
        user4.addVehicle(v4);
        user5.addVehicle(v5);
        user5.addVehicle(v55);

        getUserDAO().save(user1);
        getUserDAO().save(user2);
        getUserDAO().save(user3);
        getUserDAO().save(user4);
        getUserDAO().save(user5);

        ParkingSpace p1 = new ParkingSpace(add1,false,new Credits(10),new TimeRange(LocalDateTime.now(),30),new Date(),user1,"IEH1234");
        ParkingSpace p2 = new ParkingSpace(add2,false,new Credits(15),new TimeRange(LocalDateTime.now(),30),new Date(),user2,"APK1551");
        ParkingSpace p3 = new ParkingSpace(add3,false,new Credits(8),new TimeRange(LocalDateTime.now(),30),new Date(),user3,"AZE9152");
        ParkingSpace p4 = new ParkingSpace(add4,false,new Credits(3),new TimeRange(LocalDateTime.now(),30),new Date(),user4,"MEA6157");
        ParkingSpace p5 = new ParkingSpace(add5,false,new Credits(4),new TimeRange(LocalDateTime.now(),30),new Date(),user5,"IZA6015");

        getParkingDAO().save(p1);
        getParkingDAO().save(p2);
        getParkingDAO().save(p3);
        getParkingDAO().save(p4);
        getParkingDAO().save(p5);

        TimeRange time = new TimeRange(LocalDateTime.now(),0);
        time.addMinutes(time.getTo(),30);
        ParkingRequest pr1 = new ParkingRequest(time,new Pin(1541),user1,p2);
        ParkingRequest pr2 = new ParkingRequest(time,new Pin(7119),user2,p3);
        ParkingRequest pr3 = new ParkingRequest(time,new Pin(4689),user3,p4);
        ParkingRequest pr4 = new ParkingRequest(time,new Pin(9268),user4,p5);
        ParkingRequest pr5 = new ParkingRequest(time,new Pin(0235),user5,p1);

        getRequestDAO().save(pr1);
        getRequestDAO().save(pr2);
        getRequestDAO().save(pr3);
        getRequestDAO().save(pr4);
        getRequestDAO().save(pr5);

        Rating rating1 = new Rating();
        rating1.setRatingScore(5);
        rating1.setComment("Thank you for the exchange!");

        Rating rating2 = new Rating();
        rating1.setRatingScore(5);
        rating1.setComment("He was 5 minutes late, but he said sorry!");

        Rating rating3 = new Rating();
        rating1.setRatingScore(1);
        rating1.setComment("She never came!");

        Rating rating4 = new Rating();
        rating1.setRatingScore(2);
        rating1.setComment("Waited 20 minutes for him...");

        Rating rating5 = new Rating();
        rating1.setRatingScore(5);
        rating1.setComment("She was really generous and came on time.");










    }

    public static ParkingRequestDAO getRequestDAO() {
        return PRDao;
    }


    public static ParkingSpaceDAO getParkingDAO() {
        return PSDao;
    }


    public static UserDAO getUserDAO() {
        return UDao;
    }


    public static VehicleDAO getVehicleDAO() {
        return VDao;
    }

}
