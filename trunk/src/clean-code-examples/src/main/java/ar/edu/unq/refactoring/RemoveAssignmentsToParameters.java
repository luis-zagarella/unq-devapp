package ar.edu.unq.refactoring;

/**
 * Si bien en java es todo por valor, genera confusion al lector. Debera ser
 * solo leido. (se puede usar final para que el compilador nos ayude)
 */
public class RemoveAssignmentsToParameters {

    public int discount_v1(int value, final int quantity) {
        if (value > 50) {
            value -= 2;
        }
        if (quantity > 100) {
            value -= 5;
        }
        return value;
    }

    public int discount_v2(final int value, final int quantity) {
        int discount = value;
        if (value > 50) {
            discount -= 2;
        }
        if (quantity > 100) {
            discount -= 5;
        }
        return discount;
    }

}
