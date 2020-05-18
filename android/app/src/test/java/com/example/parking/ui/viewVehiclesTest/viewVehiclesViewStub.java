package com.example.parking.ui.viewVehiclesTest;
import com.example.parking.ui.viewVehicles.ViewVehiclesPresenter;
import com.example.parking.ui.viewVehicles.ViewVehiclesView;

public class viewVehiclesViewStub implements ViewVehiclesView {
    ViewVehiclesPresenter presenter;
    String username,intentUsername;

    public viewVehiclesViewStub()
    {
        username = intentUsername  = "";
    }

    public void setPresenter(ViewVehiclesPresenter presenter) {
        this.presenter = presenter;
    }

    public String getUserName()
    {
       return username;
    }

    public void setIntentUsername(String username){
        intentUsername=username;
    }

    public String getIntentUsername (){
        return intentUsername;
    }


}
