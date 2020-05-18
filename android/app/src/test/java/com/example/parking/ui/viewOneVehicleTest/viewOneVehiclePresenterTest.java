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

    }

    @Test
    public void testAddNew() {
        presenter = new viewOneVehiclePresenter(view,new UserDAOMemory());

        presenter.decide();
        view.setPlate("");
        Assert.assertEquals(view.getErrorTitle(),"Error");
        Assert.assertEquals(view.getErrorMessage(),"Plate must begin with 3 latin letter and then 4 numbers.");

        view.setPlate("IEH1515");
        view.setBrand("");
        presenter.decide();
        Assert.assertEquals(view.getErrorTitle(),"Error");
        Assert.assertEquals(view.getErrorMessage(),"Brand must be more than 3 characters and up to 15.");

        view.setBrand("NISSAN");
        view.setModel("");
        presenter.decide();
        Assert.assertEquals(view.getErrorTitle(),"Error");
        Assert.assertEquals(view.getErrorMessage(),"Model must be more than 3 characters and up to 15.");

        view.setModel("NOTE");
        view.setLength(10);
        presenter.decide();
        Assert.assertEquals(view.getErrorTitle(),"Error");
        Assert.assertEquals(view.getErrorMessage(),"Length must be more than 100cm(1M) or less than 5000cm(500M).");

        view.setLength(300);
        presenter.decide();

        Assert.assertEquals(view.getFinishMessage(), "Vehicle with plate"+ view.getPlate() +" added");

    }

    @Test
    public void testUpdate() {
        presenter = new viewOneVehiclePresenter(view,MemoryInitializer.getUserDAO());
        presenter.decide();
        Assert.assertEquals(view.getFinishMessage(),"Vehicle with plate"+ view.getPlate() +" updated");

    }
}
