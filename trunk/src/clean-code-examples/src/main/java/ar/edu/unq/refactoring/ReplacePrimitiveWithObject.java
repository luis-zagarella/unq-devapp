package ar.edu.unq.refactoring;

import ar.edu.unq.refactoring.support.Range;

/**
 * Muchas veces comenzamos usando objetos simples para representar cosas, en
 * algun momento puede ocurrir que ese objeto ya no es tan simple como cuando
 * empezo y necesitamos algo mas inteligente para eliminar duplicados.
 * 
 * Ej: Al ppio represento un telefono como String, luego empiezan a aparecer
 * metodos que formatean o validad telefonos, y ademas ese telefono se usa en
 * mas de una clase.
 */
@SuppressWarnings("unused")
public class ReplacePrimitiveWithObject {

    static class Loan_v1 {
        private static double minAmount = 100;

        private static double maxAmount = 5000;

        private final Client client;

        private final double amountToLoan;

        public Loan_v1(final Client aClient, final double amount) {
            client = aClient;
            this.checkAmountToLoan(amount);
            amountToLoan = amount;
        }

        private void checkAmountToLoan(final double amount) {
            if (amount < minAmount || maxAmount < amount) {
                throw new RuntimeException("the loan can not be ... etc");
            }
        }

        // ...
    }

    // Montana rusa (?)
    static class RollerCoaster_v1 {
        private static int minAge = 13;

        private static int maxAge = 40;

        public void admit(final Person person) {
            if (person.age < minAge || maxAge < person.age) {
                throw new RuntimeException("no esta en el rango de edad permitido");
            }
        }

        // ...
    }

    static class Loan_v2 {
        private static Range<Double> rangeOfAllowedAmount = new Range<Double>(100.0, 5000.0);

        private final Client client;

        private final double amountToLoan;

        public Loan_v2(final Client aClient, final double amount) {
            client = aClient;
            this.checkAmountToLoan(amount);
            amountToLoan = amount;
        }

        private void checkAmountToLoan(final double amount) {
            if (rangeOfAllowedAmount.notIncludes(amount)) {
                throw new RuntimeException("the loan can not be ... etc");
            }
        }

        // ...
    }

    //@formatter:off
	static class Loan_v3 {
		private static Range<Money> rangeOfAllowedAmount 
			= new Range<Money>(Money.dollars(100), Money.dollars(5000));

		private final Client client;
		private final Money amountToLoan;

		public Loan_v3(final Client aClient, final Money amount) {
			client = aClient;
			this.checkAmountToLoan(amount);
			amountToLoan = amount;
		}

		private void checkAmountToLoan(final Money amount) {
			if (rangeOfAllowedAmount.notIncludes(amount)) {
				throw new RuntimeException("the loan can not be ... etc");
			}
		}

		// ...
	}

	// Montana rusa (?)
	static class RollerCoaster_v2 {
		private static Range<Integer> rangeOfAllowedAge = new Range<Integer>(13, 40);

		public void admit(final Person person) {
			if (rangeOfAllowedAge.notIncludes(person.age)) {
				throw new RuntimeException("no esta en el rango de edad permitido");
			}
		}

		// ...
	}

	static class Client {

	}

	static class Person {
		int age;
	}

	static class Money implements Comparable<Money> {

		public static Money dollars(final int i) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int compareTo(final Money o) {
			throw new UnsupportedOperationException();
		}

	}

}
