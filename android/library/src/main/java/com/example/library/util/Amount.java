package com.example.library.util;

import java.math.BigDecimal;

public class Amount {
    private Currency currency;
    private BigDecimal amountToConvert;

    public Amount(Currency currency, BigDecimal amountToConvert) {
        this.currency = currency;
        this.amountToConvert = amountToConvert;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(BigDecimal amountToConvert) {
        this.amountToConvert = amountToConvert;
    }
}
