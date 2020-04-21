import java.math.BigDecimal;

public class Amount {
    private Currency currency;
    private BigDecimal amountToConvert;

    public Amount(Currency currency, BigDecimal amountToConvert) {
        this.currency = currency;
        this.amountToConvert = amountToConvert;
    }

}
