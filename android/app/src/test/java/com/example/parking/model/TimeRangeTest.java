package com.example.parking.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.util.TimeRange;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class TimeRangeTest {

    @Test
    public void difference(){
        TimeRange tr = new TimeRange(30);

        Assert.assertEquals(30, tr.getDifference());

        tr = new TimeRange(LocalDateTime.now(), 30);
        Assert.assertEquals(30, tr.getDifference());
    }

    @Test
    public void addMinutes(){
//        TimeRange tr = new TimeRange(0);
//        long mins =
//        tr.addMinutes(tr.getFrom(), 30);
//        Assert.assertEquals();

        //unimplemented
    }

    @Test
    public void difference11(){

    }
}
