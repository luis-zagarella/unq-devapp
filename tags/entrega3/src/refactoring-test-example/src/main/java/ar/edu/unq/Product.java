package ar.edu.unq;

import java.math.BigDecimal;

public class Product {

    BigDecimal unitprice;

    public Product(final int i, final String string, final BigDecimal bigDecimal) {
        unitprice = bigDecimal;
    }

    public BigDecimal getUnitPrice() {

        return unitprice;
    }

}
