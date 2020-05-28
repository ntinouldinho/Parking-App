package com.example.parking.ui.viewVehiclesTest;

import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.viewVehicles.ViewVehiclesPresenter;
import com.example.parking.util.Colour;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class viewVehiclesPresenterTest {

    private viewVehiclesViewStub view;
    private ViewVehiclesPresenter presenter;
    @Before
    public void setup(){
        MemoryInitializer.prepareData();
        view = new viewVehiclesViewStub();
        view.setIntentUsername("ok");
        presenter = new ViewVehiclesPresenter(view,MemoryInitializer.getUserDAO());
    }

    @Test
    public void test(){
//        User u = MemoryInitializer.getUserDAO().find(view.getIntentUsername());
//
//        Vehicle vCorrect = new Vehicle(Colour.Golden,490,"Large SUV", "MEA6157","Escalade","Cadillac");
//        presenter.viewVe(vCorrect);
//        Assert.assertEquals(1,u.getVehicles().size());
//        Assert.assertEquals(vCorrect,u.getVehicles().get(0));

    }
}
