package com.example.parking.ui.viewOneVehicleTest;

import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.memorydao.UserDAOMemory;
import com.example.parking.ui.viewOneVehicle.viewOneVehiclePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class viewOneVehiclePresenterTest {
    private MemoryInitializer dataHelper;
    private viewOneVehiclePresenter presenter;
    private viewOneVehicleViewStub view;

    @Before
    public void setup() {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new viewOneVehicleViewStub();
        view.setIntentUsername("ok");


    }

    @Test
    public void testAddNew() {
        presenter = new viewOneVehiclePresenter(view,MemoryInitializer.getUserDAO());

        view.setPlate("mmmmmm");
        presenter.decide();
        Assert.assertEquals(view.getErrorTitle(),"plates");
        Assert.assertEquals(view.getErrorMessage(),"Plate must begin with 3 latin letter and then 4 numbers.");

        view.setBrand("aa");
        view.setPlate("MEA6157");
        presenter.decide();
        Assert.assertEquals("brand",view.getErrorTitle());
        Assert.assertEquals(view.getErrorMessage(),"Brand must be more than 3 characters and up to 15.");

        view.setBrand("NISSAN");
        view.setModel("b");
        presenter.decide();
        Assert.assertEquals(view.getErrorTitle(),"model");
        Assert.assertEquals(view.getErrorMessage(),"Model must be more than 3 characters and up to 15.");

        view.setModel("NOTE");
        view.setLength(10);
        presenter.decide();
        Assert.assertEquals(view.getErrorTitle(),"length");
        Assert.assertEquals(view.getErrorMessage(),"Length must be more than 100cm(1M) or less than 5000cm(500M).");

        view.setText("aaa");
        view.setLength(2000);
        presenter.decide();
        Assert.assertEquals(view.getErrorTitle(),"text");
        Assert.assertEquals(view.getErrorMessage(),"Text must be more than 5 characters and up to 50.");

        view.setText("Big vehicle, my Nissan Note is a big SUV");
        presenter.decide();

        Assert.assertEquals(view.getFinishMessage(), "Vehicle with plate"+ view.getIntentPlate() +" added");

    }

    @Test
    public void testUpdate() {
        view.setIntentPlate("MEA6157");
        presenter = new viewOneVehiclePresenter(view,MemoryInitializer.getUserDAO());

        presenter.decide();
        Assert.assertEquals("Vehicle with plate"+ view.getPlate() +" updated",view.getFinishMessage());

    }
}
