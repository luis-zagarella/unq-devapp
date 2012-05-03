package ar.edu.unq.repositories;

import ar.edu.unq.model.Car;

public class CarRepository extends HibernateGenericDAO<Car> implements
		GenericRepository<Car> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Car> getDomainClass() {
		return Car.class;
	}

}
