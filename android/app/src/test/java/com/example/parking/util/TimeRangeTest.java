package com.example.parking.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.util.TimeRange;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)

public class TimeRangeTest {

    private LocalDateTime from;
    private LocalDateTime to;
    private TimeRange tr;

    @Before
    public void setUp() {
        tr = new TimeRange(LocalDateTime.now(),30);
        from=tr.getFrom();
        to=tr.getTo();

    }

    @Test
    public void FullConTest() {
        TimeRange time = new TimeRange(LocalDateTime.now(),LocalDateTime.now());
        assertNotNull(time);
    }



    @Test
        public void getFromTest(){
        LocalDateTime a = LocalDateTime.of(2021, 2, 13, 15, 56);
        TimeRange time = new TimeRange(a,30);
        from=a;
        assertEquals(from.withNano(0),time.getFrom().withNano(0));
    }

    @Test
    public void differenceTest(){
        TimeRange tr = new TimeRange(30);

        assertEquals(30, tr.getDifference());

        tr = new TimeRange(LocalDateTime.now(), 30);
        assertEquals(30, tr.getDifference());
    }

    @Test
    public void addMinutesTest(){
        TimeRange time = new TimeRange(LocalDateTime.now(),0);
        time.setTo(time.addMinutes(time.getTo(),30));
        assertEquals(30,time.getDifference());
    }

    @Test
    public void toStringTest(){
        String fromstr = from.format(TimeRange.formatter);
        String tostr = to.format(TimeRange.formatter);
        String str= "TimeRange{" +
                "from=" + fromstr +
                ", to=" + tostr +
                '}';
        System.out.println(tr);
        assertEquals(str,tr.toString());
    }
}

