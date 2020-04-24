package com.example.parking.util;

public class Currency {

    private long amount;
    private CurrencyEnum currency;

    public Currency(long amount, CurrencyEnum currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
