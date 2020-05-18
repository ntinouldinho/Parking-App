package com.example.parking.ui.signup;

import android.os.Bundle;

public interface SignUpView {
    String getName();
    String getSurname();
    String getPhone();
    String getEmail();
    String getUsername();
    String getPassword();
    String getStrN();
    String getZipCode();
    String getStreet();
    void makeToast(String str);
    void setError(String EditText,String error);
    void successfullyFinishActivity(String message);
    void onCreate(Bundle savedInstanceState);
}
