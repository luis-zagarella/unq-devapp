package ar.edu.unq;

import java.math.BigDecimal;

public class Customer {

    BigDecimal percentDiscount;

    public Customer(final int i, final String string, final String string2, final BigDecimal bigDecimal,
            final Address billingAddress, final Address shippingAddress) {
        percentDiscount = bigDecimal;
    }

    public BigDecimal getPercentDiscount() {
        return percentDiscount;
    }

}
