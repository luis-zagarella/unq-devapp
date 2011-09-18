package ar.edu.unq;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

    List<LineItem> list = new ArrayList<LineItem>();

    Customer customer;

    public Invoice(final Customer customer) {
        this.customer = customer;
    }

    public void addItemQuantity(final Product product, final int count) {

        BigDecimal value = product.getUnitPrice().multiply(BigDecimal.valueOf(count));
        BigDecimal extended = value.subtract(value.multiply(BigDecimal.valueOf(30)).divide(BigDecimal.valueOf(100)));
        list.add(new LineItem(this, product, count, product.getUnitPrice(), extended));
    }

    public List<LineItem> getLineItems() {
        return list;
    }

    public Customer getCustomer() {
        return customer;
    }

}
