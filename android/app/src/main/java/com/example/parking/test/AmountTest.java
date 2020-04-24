package com.example.parking.test;

import com.example.parking.util.Amount;
import com.example.parking.util.Currency;
import com.example.parking.util.CurrencyEnum;

import org.junit.Test;
import org.testng.Assert;

public class AmountTest {
    Amount amount;
    @Test
    public void getAmountTest{
        amount = new Amount(new Currency(100, CurrencyEnum.EUR),100);
    }
}
