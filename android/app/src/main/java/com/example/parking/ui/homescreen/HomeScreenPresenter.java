package com.example.parking.ui.homescreen;

class HomeScreenPresenter {
    HomeScreenView view;

    public HomeScreenPresenter(HomeScreenView view){
        this.view=view;
    }

    public void spaceIntent(){
        view.spaceIntent();
    }

    public void requestIntent(){
        view.requestIntent();
    }

    public void profileIntent(){
        view.profileIntent();
    }

    public void notificationIntent(){
        view.notificationIntent();
    }
}
