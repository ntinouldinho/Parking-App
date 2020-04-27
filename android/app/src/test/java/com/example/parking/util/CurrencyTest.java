package com.example.parking.util;

import com.example.parking.util.Currency;
import com.example.parking.util.CurrencyEnum;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CurrencyTest {
    private Currency c1;
    BigDecimal number;
    CurrencyEnum currencyEnum;

    @Before
    public void setup(){
        c1 = new Currency();
        number = new BigDecimal(10);
        currencyEnum = CurrencyEnum.EUR;
        c1.setAmount(number);
        c1.setCurrency(currencyEnum);
    }

    @Test
    public void FullConTest() {
        Currency c = new Currency(new BigDecimal(10),CurrencyEnum.EUR);
    }

    @Test
    public void getAmountTest() {
        assertEquals(number,c1.getAmount());
    }

    @Test
    public void getCurrency() {
        assertEquals(CurrencyEnum.EUR,c1.getCurrency());
    }

    @Test
    public void toStringTest() {
        String str="Currency{" +
                "amount=" + number +
                ", currency=" + currencyEnum +
                '}';
        assertEquals(str,c1.toString());
    }

}
