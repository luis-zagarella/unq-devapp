package ar.edu.unq;
import java.math.BigDecimal;
import java.util.List;

import junit.framework.TestCase;


public class ItemQuantityTest extends TestCase {

    public void testAddItemQuantity_severalQuantity_v1() {
        Address billingAddress = null;
        Address shippingAddress = null;
        Customer customer = null;
        Product product = null;
        Invoice invoice = null;
        try {
            billingAddress = new Address("1222 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            shippingAddress = new Address("1333 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            customer = new Customer(99, "John", "Doe", new BigDecimal("30"), billingAddress, shippingAddress);
            product = new Product(88, "SomeWidget", new BigDecimal("19.99"));
            invoice = new Invoice(customer);
            // Exercise SUT
            invoice.addItemQuantity(product, 5);
            // Verify outcome
            List lineItems = invoice.getLineItems();
            if (lineItems.size() == 1) {
                LineItem actItem = (LineItem) lineItems.get(0);
                assertEquals("inv", invoice, actItem.getInv());
                assertEquals("prod", product, actItem.getProd());
                assertEquals("quant", 5, actItem.getQuantity());
                assertEquals("discount", new BigDecimal("30"), actItem.getPercentDiscount());
                assertEquals("unit price", new BigDecimal("19.99"), actItem.getUnitPrice());
                assertEquals("extended", new BigDecimal("69.965"), actItem.getExtendedPrice());
            } else {
                assertTrue("Invoice should have 1 item", false);
            }
        } finally {
            // Teardown
            this.deleteObject(invoice);
            this.deleteObject(product);
            this.deleteObject(customer);
            this.deleteObject(billingAddress);
            this.deleteObject(shippingAddress);
        }

    }

    public void testAddItemQuantity_severalQuantity_v2() {
        Address billingAddress = null;
        Address shippingAddress = null;
        Customer customer = null;
        Product product = null;
        Invoice invoice = null;
        try {
            billingAddress = new Address("1222 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            shippingAddress = new Address("1333 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            customer = new Customer(99, "John", "Doe", new BigDecimal("30"), billingAddress, shippingAddress);
            product = new Product(88, "SomeWidget", new BigDecimal("19.99"));
            invoice = new Invoice(customer);
            // Exercise SUT
            invoice.addItemQuantity(product, 5);
            // Verify outcome
            List lineItems = invoice.getLineItems();
            if (lineItems.size() == 1) {
                LineItem actItem = (LineItem) lineItems.get(0);
                assertEquals("inv", invoice, actItem.getInv());
                assertEquals("prod", product, actItem.getProd());
                assertEquals("quant", 5, actItem.getQuantity());
                assertEquals("discount", new BigDecimal("30"), actItem.getPercentDiscount());
                assertEquals("unit price", new BigDecimal("19.99"), actItem.getUnitPrice());
                assertEquals("extended", new BigDecimal("69.965"), actItem.getExtendedPrice());
            } else {
                fail("Invoice should have exactly one line item");
            }

        } finally {
            // Teardown
            this.deleteObject(invoice);
            this.deleteObject(product);
            this.deleteObject(customer);
            this.deleteObject(billingAddress);
            this.deleteObject(shippingAddress);
        }

    }

    public void testAddItemQuantity_severalQuantity_v3() {
        Address billingAddress = null;
        Address shippingAddress = null;
        Customer customer = null;
        Product product = null;
        Invoice invoice = null;
        try {
            billingAddress = new Address("1222 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            shippingAddress = new Address("1333 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            customer = new Customer(99, "John", "Doe", new BigDecimal("30"), billingAddress, shippingAddress);
            product = new Product(88, "SomeWidget", new BigDecimal("19.99"));
            invoice = new Invoice(customer);
            // Exercise SUT
            invoice.addItemQuantity(product, 5);
            // Verify outcome

            List lineItems = invoice.getLineItems();
            if (lineItems.size() == 1) {
                LineItem expected = new LineItem(invoice, product, 5, new BigDecimal("30"), new BigDecimal("69.965"));
                LineItem actItem = (LineItem) lineItems.get(0);
                assertEquals("invoice", expected, actItem);
            } else {
                fail("Invoice should have exactly one line item");
            }

        } finally {
            // Teardown
            this.deleteObject(invoice);
            this.deleteObject(product);
            this.deleteObject(customer);
            this.deleteObject(billingAddress);
            this.deleteObject(shippingAddress);
        }

    }

    public void testAddItemQuantity_severalQuantity_v6() {
        Address billingAddress = null;
        Address shippingAddress = null;
        Customer customer = null;
        Product product = null;
        Invoice invoice = null;
        try {
            billingAddress = new Address("1222 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            shippingAddress = new Address("1333 1st St SW", "Calgary", "Alberta", "T2N 2V2", "Canada");
            customer = new Customer(99, "John", "Doe", new BigDecimal("30"), billingAddress, shippingAddress);
            product = new Product(88, "SomeWidget", new BigDecimal("19.99"));
            invoice = new Invoice(customer);
            // Exercise SUT
            invoice.addItemQuantity(product, 5);
            // Verify outcome

            LineItem expected = new LineItem(invoice, product, 5, new BigDecimal("30"), new BigDecimal("69.96"));
            this.assertContainsExactlyOneLineItem(invoice, expected);

        } finally {
            // Teardown
            this.deleteObject(invoice);
            this.deleteObject(product);
            this.deleteObject(customer);
            this.deleteObject(billingAddress);
            this.deleteObject(shippingAddress);
        }

    }

    public void testAddItemQuantity_severalQuantity_v11() {
        final int QUANTITY = 5;

        Address billingAddress = this.createAnAddress();
        Address shippingAddress = this.createAnAddress();
        Customer customer = this.createACustomer(new BigDecimal("30"), billingAddress, shippingAddress);
        Product product = this.createAProduct(new BigDecimal("19.99"));
        Invoice invoice = this.createInvoice(customer);
        // Exercise SUT
        invoice.addItemQuantity(product, QUANTITY);
        // Verify outcome
        LineItem expected = new LineItem(invoice, product, 5, new BigDecimal("30"), new BigDecimal("69.965"));
        this.assertContainsExactlyOneLineItem(invoice, expected);
    }

    public void testAddItemQuantity_severalQuantity_v14() {
        final int QUANTITY = 5;
        final BigDecimal UNIT_PRICE = new BigDecimal("19.99");
        final BigDecimal CUST_DISCOUNT_PC = new BigDecimal("30");
        //
        Customer customer = this.createACustomer(CUST_DISCOUNT_PC);
        Product product = this.createAProduct(UNIT_PRICE);
        Invoice invoice = this.createInvoice(customer);
        // Exercise SUT
        invoice.addItemQuantity(product, QUANTITY);
        // Verify outcome
        final BigDecimal BASE_PRICE = UNIT_PRICE.multiply(new BigDecimal(QUANTITY));
        final BigDecimal EXTENDED_PRICE = BASE_PRICE.subtract(BASE_PRICE.multiply(CUST_DISCOUNT_PC.movePointLeft(2)));
        LineItem expected = this.createLineItem(QUANTITY, CUST_DISCOUNT_PC, EXTENDED_PRICE, product, invoice);
        this.assertContainsExactlyOneLineItem(invoice, expected);
    }

    private LineItem createLineItem(final int quantity, final BigDecimal cust_discount_pc,
            final BigDecimal extended_price, final Product product, final Invoice invoice) {
        return new LineItem(invoice, product, quantity, cust_discount_pc, extended_price);

    }

    private Customer createACustomer(final BigDecimal cust_discount_pc) {
        return new Customer(99, "John", "Doe", cust_discount_pc, null, null);
    }

    // /////////////////////////HELPERS/////////////////////////////
    // /////////////////////////////////////////////////////////
    private Invoice createInvoice(final Customer customer) {
        return new Invoice(customer);
    }

    private Customer createACustomer(final BigDecimal bigDecimal, final Address billingAddress,
            final Address shippingAddress) {
        return new Customer(99, "John", "Doe", bigDecimal, billingAddress, shippingAddress);

    }

    private Address createAnAddress() {
        return null;
    }

    private Product createAProduct(final BigDecimal unitPrice) {
        BigDecimal uniqueId = this.getUniqueNumber();
        String uniqueString = uniqueId.toString();
        return new Product(uniqueId.toBigInteger().intValue(), uniqueString, unitPrice);
    }

    private BigDecimal getUniqueNumber() {
        return BigDecimal.valueOf(1);
    }

    private void assertContainsExactlyOneLineItem(final Invoice invoice, final LineItem expected) {
        List<LineItem> lineItems = invoice.getLineItems();
        if (lineItems.size() == 1) {
            LineItem actItem = lineItems.get(0);
            assertEquals("invoice", expected, actItem);
        } else {
            fail("Invoice should have exactly one line item");
        }

    }

    private void deleteObject(final Object invoice) {
        // TODO Auto-generated method stub

    }
}
