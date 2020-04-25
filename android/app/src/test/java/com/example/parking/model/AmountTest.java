package com.example.parking.model;

import com.example.parking.util.Amount;
import com.example.parking.util.Currency;
import com.example.parking.util.CurrencyEnum;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class AmountTest {
    Amount amount;
    @Test
    public void getAmountTest(){
        BigDecimal number = new BigDecimal(100);
        amount = new Amount(new Currency(number, CurrencyEnum.EUR),number);
        Assert.assertEquals(number,amount.getAmountToConvert());
    }
}
