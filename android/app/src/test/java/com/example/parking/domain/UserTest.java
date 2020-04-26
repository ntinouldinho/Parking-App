package com.example.parking.domain;

import com.example.parking.util.Colour;
import com.example.parking.util.Credits;
import com.example.parking.util.ZipCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    private User u;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String username;
    private String password;
    private Credits credits;
    private Address address;
    private ArrayList<Rating> rating= new ArrayList<>();
    private ArrayList<Vehicle> vehicles= new ArrayList<>();

    @Before
    public void setup(){
        u = new User();
        address= new Address("Wall St.","23", new ZipCode(71310));
        u.setAddress(address);
        Credits credits=new Credits(10);
        u.setCredits(credits);
        name="Walter";
        u.setName(name);
        surname="White";
        u.setSurname(surname);
        phone="6941051051";
        u.setPhone(phone);
        email="walterwhite@gmail.com";
        u.setEmail(email);
        username="GoodGuyWalt";
        u.setUsername(username);
        password="saymyname";
        u.setPassword(password);
        address=address;
        u.setRating(rating);
        u.setVehicles(vehicles);
    }
    @Test
    public void FullConTest() {
        User user1= new User ("John", "Snow", "6980808080", "johnsnow@gmail.com", "IknowNothing","valarmorgulis",address, new ArrayList<Rating>(),new ArrayList<Vehicle>());
    }

    @Test
    public void getNameTest() {
        assertEquals(name, u.getName());
    }

    @Test
    public void getSurnameTest() {
        assertEquals(surname,u.getSurname());
    }

    @Test
    public void getPhoneTest() {
        assertEquals(phone,u.getPhone());
    }

    @Test
    public void getEmailTest() {
        assertEquals(email,u.getEmail());
    }

    @Test
    public void getUsernameTest() {
        assertEquals(username,u.getUsername());
    }

    @Test
    public void getPasswordTest() {
        assertEquals(password,u.getPassword());
    }

    @Test
    public void getCreditsTest() {
        System.out.println(u.getCredits());
        assertEquals(10,u.getCredits().getPoints());
    }

    @Test
    public void getAddressTest() {
        assertEquals(address,u.getAddress());
    }

    @Test
    public void setNameTest() {
        String temp="Gus";
        u.setName(temp);
        assertEquals(temp,u.getName());
    }

    @Test
    public void setSurnameTest() {
        String temp="Fring";
        u.setSurname(temp);
        assertEquals(temp,u.getSurname());
    }

    @Test
    public void setPhoneTest() {
        String temp="6980808000";
        u.setPhone(temp);
        assertEquals(temp,u.getPhone());
    }

    @Test
    public void setEmailTest() {
        String temp="gusfring@gmail.com";
        u.setEmail(temp);
        assertEquals(temp,u.getEmail());
    }

    @Test
    public void setUsernameTest() {
        String temp="GusFringMD";
        u.setUsername(temp);
        assertEquals(temp,u.getUsername());
    }

    @Test
    public void setPasswordTest() {
        String temp="walterwhiteded";
        u.setPassword(temp);
        assertEquals(temp,u.getPassword());
    }

    @Test
    public void setCreditsTest() {
        Credits temp= new Credits(10);
        u.setCredits(temp);
        assertEquals(temp,u.getCredits());
    }

    @Test
    public void getRatingTest() {
        assertEquals(rating,u.getRating());
    }

    @Test
    public void getVehicleAndItExistsTest() {
        Vehicle vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        u.getVehicles().add(vehicle);
        assertEquals(vehicle,u.getVehicle("APK1551"));
    }

    @Test
    public void getVehicleAndItDoesNotExistTest() {
        Vehicle v = new Vehicle();
        v.setPlate("APK1551");
        assertEquals(v,u.getVehicle("APK1551"));
    }

    @Test
    public void getVehiclesTest() {
        assertEquals(vehicles,u.getVehicles());
    }

    @Test
    public void addRatingTest() {
        Rating rating1 = new Rating();
        rating1.setRatingScore(5);
        rating1.setComment("Good!");
        u.addRating(rating1);
        assertEquals(rating1,u.getRating().get(0));
        assertEquals(1,u.getRating().size());
    }

    @Test
    public void removeRatingTest() {
        Rating rating2 = new Rating();
        rating2.setRatingScore(1);
        rating2.setComment("Bad!");
        u.getRating().add(rating2);
        u.removeRating(rating2);
        assertEquals(0,u.getRating().size());
    }


    @Test
    public void addVehicleTest() {
        Vehicle vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        u.getVehicles().add(vehicle);
        assertEquals(1,u.getVehicles().size());
    }

    @Test
    public void addVehicleTestAlreadyExists() {
        Vehicle vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        u.addVehicle(vehicle);
        Vehicle vehicleDup = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        u.addVehicle(vehicleDup);
        System.out.println(vehicle.getPlate()+vehicleDup.getPlate());
        assertEquals(1,u.getVehicles().size());
    }

    @Test
    public void removeVehicleThatExistsTest() {
        Vehicle vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        u.addVehicle(vehicle);
        u.removeVehicle(vehicle);
        assertEquals(0,u.getVehicles().size());
    }

    @Test
    public void removeVehicleThatDoesNotExistTest() {
        Vehicle vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        u.getVehicles().add(vehicle);
        u.getVehicles().remove(vehicle);
        assertEquals(0,u.getVehicles().size());
    }

    @Test
    public void removeVehicleButUserHasOnlyOneTest() {
        Vehicle vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );
        u.getVehicles().add(vehicle);
        u.getVehicles().remove(vehicle);
        assertEquals(0,u.getVehicles().size());
    }

    @Test
    public void removeVehicleButUserHasNoneTest() {
        u.getVehicles().remove(new Vehicle());
        assertEquals(0,u.getVehicles().size());
    }

    @Test
    public void calculateRatingTest() {
        Rating rating1 = new Rating();
        rating1.setRatingScore(5);
        rating1.setComment("Good!");
        u.getRating().add(rating1);
        Rating rating2 = new Rating();
        rating2.setRatingScore(2);
        rating2.setComment("Hmmm");
        u.getRating().add(rating2);
        double avg=u.calculateRating();
        assertEquals(3.5,avg,1);
    }

    @Test
    public void toStringTest() {
        String str="User{" +
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
        assertEquals(str,u.toString());
    }
}