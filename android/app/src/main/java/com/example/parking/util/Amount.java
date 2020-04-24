package com.example.parking.util;

public class Amount {
    private Currency currency;
    private long amountToConvert;

    public Amount(Currency currency, long amountToConvert) {
        this.currency = currency;
        this.amountToConvert = amountToConvert;
    }

    public Amount() {
        this.currency = new Currency();
        this.amountToConvert = 0;
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
