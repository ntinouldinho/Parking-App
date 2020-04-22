package com.example.library.util;

import java.util.Objects;

public class ZipCode {
    private int zip;


    public ZipCode(int zip) {
        this.zip = zip;
    }

    public ZipCode() {
        this.zip = 0;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        String stringZip = String.valueOf(zip);
        if(stringZip.length()==5) {
            this.zip = zip;
        }
        return;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return Objects.equals(zip, zipCode.zip);
    }

}
