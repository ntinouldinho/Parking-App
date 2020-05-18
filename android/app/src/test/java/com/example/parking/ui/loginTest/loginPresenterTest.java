package com.example.parking.ui.loginTest;

import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.login.LoginPresenter;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class loginPresenterTest {
    private loginPresenterViewStub view;
    private LoginPresenter presenter;
    @Before
    public void setup(){
        MemoryInitializer.prepareData();
        view = new loginPresenterViewStub();
        presenter = new LoginPresenter(view,MemoryInitializer.getUserDAO());
    }

    @Test
    public void loginUserExists(){
        view.setUsername("ok");
        view.setPassword("2");
        presenter.login();
        Assert.assertEquals("Logged in",view.getToast());
    }

    @Test
    public void loginUserDoesntExist(){
        view.setUsername("ok");
        view.setPassword("ok");
        presenter.login();
        Assert.assertEquals("Wrong username or password",view.getToast());
    }
}
