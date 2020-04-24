package com.example.parking.util;

public class Amount {
    private Currency currency;
    private long amountToConvert;

    public Amount(Currency currency, long amountToConvert) {
        this.currency = currency;
        this.amountToConvert = amountToConvert;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(long amountToConvert) {
        this.amountToConvert = amountToConvert;
    }
}
