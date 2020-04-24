package com.example.parking.test;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.testng.annotations.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import com.example.parking.util.TimeRange;
import static org.junit.Assert.*;

public class TimeRangeTest {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Test
    public void difference() {
        //dont really know how to deal with clock and instant etc...
        TimeRange tr = new TimeRange();
        Instant in = Instant.now();
        in = in.plusSeconds(1);
        System.out.println(tr.difference(Instant.now(), in));

    }
}