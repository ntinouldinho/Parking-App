package com.example.parking.ui.login;


import com.example.parking.R;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.parking.ui.homescreen.HomeScreenActivity;
import com.example.parking.memorydao.MemoryInitializer;

public class MainActivity extends AppCompatActivity implements LoginView{
    LoginPresenter presenter;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MemoryInitializer.prepareData();
        Log.e("test", String.valueOf(MemoryInitializer.getParkingDAO().findAll().get(0).toString()));
        Button login = findViewById(R.id.login);
        presenter = new LoginPresenter(this,MemoryInitializer.getUserDAO());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });

//        EditText user = (EditText) findViewById(R.id.username);
//        EditText pass = (EditText) findViewById(R.id.password);
//
//        final String username= user.getText().toString();
//        final String password= pass.getText().toString();


//        Intent myIntent = new Intent(this, HomeScreenActivity.class);
//        startActivity(myIntent);
    }
    @Override
    public String getUsername(){
        return ((EditText) findViewById(R.id.username)).getText().toString();
    }
    @Override
    public String getPassword(){
        return ((EditText) findViewById(R.id.password)).getText().toString();

    }

    @Override
    public void moveOn() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra("username", getUsername());
        startActivity(intent);
    }

    @Override
    public void createToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
