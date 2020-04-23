package com.example.library.util;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;

import static org.junit.Assert.*;

public class TimeRangeTest {

    @Test
    public void difference() {
        //dont really know how to deal with clock and instant etc...
        TimeRange tr = new TimeRange();
        Instant in = Instant.now();
        in = in.plusSeconds(1);
        System.out.println(tr.difference(Instant.now(), in));

    }
}