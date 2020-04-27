package com.example.parking.util;

import com.example.parking.util.Amount;
import com.example.parking.util.Currency;
import com.example.parking.util.CurrencyEnum;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AmountTest {
    Amount amount;
    BigDecimal number;
    CurrencyEnum currencyEnum;
    Currency currency;
    @Before
    public void setup(){
        number = new BigDecimal(100);
        currencyEnum = CurrencyEnum.EUR;
        currency = new Currency(number,currencyEnum);
        amount = new Amount();
        amount.setAmountToConvert(number);
        amount.setCurrency(currency);
    }
    @Test
    public void getAmountTest(){
        assertEquals(number,amount.getAmountToConvert());
    }

    @Test
    public void getCurrencyTest(){
        assertEquals(currency,amount.getCurrency());
    }

}
