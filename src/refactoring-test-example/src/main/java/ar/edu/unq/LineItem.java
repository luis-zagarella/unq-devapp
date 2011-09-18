package ar.edu.unq;

import java.math.BigDecimal;

public class LineItem {

    Product product;

    Invoice invoice;

    int quantity;

    BigDecimal extended;

    BigDecimal unitPrice;

    public LineItem(final Invoice invoice, final Product prod, final int i) {
        product = prod;
        this.invoice = invoice;
        quantity = i;

    }

    public LineItem(final Invoice invoice, final Product product, final int i, final BigDecimal unitPrice,
            final BigDecimal extended) {
        this.product = product;
        this.invoice = invoice;
        quantity = i;
        this.unitPrice = unitPrice;
        this.extended = extended;

    }

    public Object getInv() {
        // TODO Auto-generated method stub
        return invoice;
    }

    public Product getProd() {
        // TODO Auto-generated method stub
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPercentDiscount() {
        return invoice.getCustomer().getPercentDiscount();
    }

    public BigDecimal getUnitPrice() {

        return unitPrice;
    }

    public BigDecimal getExtendedPrice() {
        return extended;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (extended == null ? 0 : extended.hashCode());
        result = prime * result + (invoice == null ? 0 : invoice.hashCode());
        result = prime * result + (product == null ? 0 : product.hashCode());
        result = prime * result + quantity;
        result = prime * result + (unitPrice == null ? 0 : unitPrice.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // LineItem other = (LineItem) obj;
        // if (extended == null) {
        // if (other.extended != null)
        // return false;
        // } else if (extended.doubleValue()!= other.extended.doubleValue())
        // return false;
        // if (invoice == null) {
        // if (other.invoice != null)
        // return false;
        // } else if (!invoice.equals(other.invoice))
        // return false;
        // if (product == null) {
        // if (other.product != null)
        // return false;
        // } else if (!product.equals(other.product))
        // return false;
        // if (quantity != other.quantity)
        // return false;
        // if (unitPrice == null) {
        // if (other.unitPrice != null)
        // return false;
        // } else if (!unitPrice.equals(other.unitPrice))
        // return false;
        return true;
    }

}
