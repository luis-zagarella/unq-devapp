package ar.edu.unq.services;

public class GeneralService {

	private CarService carService;
	private PersonService personService;

	public CarService getCarService() {
		return this.carService;
	}

	public PersonService getPersonService() {
		return this.personService;
	}

	public void setCarService(final CarService carService) {
		this.carService = carService;
	}

	public void setPersonService(final PersonService personService) {
		this.personService = personService;
	}

}
