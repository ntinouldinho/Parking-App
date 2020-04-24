package com.example.parking.test;

import com.example.parking.util.Currency;
import com.example.parking.util.CurrencyEnum;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CurrencyTest {
    private Currency c1;
    @Test
    public void getAmountTest() {
        c1 = new Currency();
        c1.setAmount(new BigDecimal(10));
        Assert.assertEquals(new BigDecimal(10),c1.getAmount());
    }

    @Test
    public void getCurrency() {
        c1 = new Currency();
        c1.setCurrency(CurrencyEnum.EUR);
        Assert.assertEquals(CurrencyEnum.EUR,c1.getCurrency());
    }
}
