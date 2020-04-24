package com.example.parking.test;

import com.example.parking.util.Amount;
import com.example.parking.util.Currency;
import com.example.parking.util.CurrencyEnum;

import org.junit.Test;
import org.junit.Assert;

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
