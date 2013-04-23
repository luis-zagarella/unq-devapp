package ar.edu.unq.view.components.crud.create;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.model.Person;
import ar.edu.unq.services.CarService;
import ar.edu.unq.services.GenericService;
import ar.edu.unq.view.Home;

public class CRUDCreatePersonBodyPage extends CRUDCreateBodyPage<Person> {

	private static final long serialVersionUID = -5517883757645818649L;
	@SpringBean(name = "services.car")
	private CarService carService;

	public CRUDCreatePersonBodyPage(final GenericService<Person> service,
			final Home home) {
		super(service, home);
	}

	@Override
	protected void addComponents(final Form<Person> form) {
		form.add(new TextField<String>("name"));
		form.add(new TextField<Integer>("age"));
	}

	@Override
	protected Person createEmptyObject() {
		return new Person();
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(final CarService carService) {
		this.carService = carService;
	}

}
