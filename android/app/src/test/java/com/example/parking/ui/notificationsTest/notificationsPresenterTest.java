package com.example.parking.ui.notificationsTest;

import static org.junit.Assert.*;

import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.notifications.notificationsPresenter;
import org.junit.Before;
import org.junit.Test;

public class notificationsPresenterTest {
    private notificationsViewStub view;
    private notificationsPresenter presenter;
    @Before
    public void setup(){
        MemoryInitializer.prepareData();
        view = new notificationsViewStub();
        view.setUsername("ok");
        presenter = new notificationsPresenter(view,MemoryInitializer.getRequestDAO(),MemoryInitializer.getUserDAO());
    }

    @Test
    public void approveRequest(){

    }
}
