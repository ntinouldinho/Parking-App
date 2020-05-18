package com.example.parking.ui.notificationsTest;

import static org.junit.Assert.*;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.notifications.notificationsPresenter;
import com.example.parking.util.Pin;

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
    public void validateParking(){
        ParkingRequest request = view.getPinReq().get(0);
        int requestFunds = request.getParkingSpace().getPrice().getPoints();

        int requestingUserPointsBefore = request.getRequestingUser().getCredits().getPoints();

        int parkedUserPointBefore = request.getParkingSpace().getParkedUser().getCredits().getPoints();

        presenter.validateParking(request,new Pin(4444));
        assertEquals("Wrong pin.",view.getToast());

        presenter.validateParking(request,new Pin(5555));
        assertEquals("Transaction complete",view.getToast());

        assertEquals(requestingUserPointsBefore-requestFunds,MemoryInitializer.getUserDAO().find(request.getRequestingUser().getUsername()).getCredits().getPoints());

        assertEquals(parkedUserPointBefore+requestFunds,MemoryInitializer.getUserDAO().find(request.getParkingSpace().getParkedUser().getUsername()).getCredits().getPoints());
    }

    @Test
    public void approveRequest(){
        ParkingRequest request = view.getToApprove().get(0);
        int pin = presenter.approveRequest(request);
        assertEquals("Pin generated",view.getToast());
        assertEquals(pin,MemoryInitializer.getRequestDAO().find(request).getPin().getPin());
    }

    @Test
    public void denyRequest(){
        ParkingRequest request = view.getToApprove().get(0);
        presenter.denyRequest(request);
        assertEquals("Request denied",view.getToast());
        assertNull(MemoryInitializer.getRequestDAO().find(request).getDate());
    }
}
