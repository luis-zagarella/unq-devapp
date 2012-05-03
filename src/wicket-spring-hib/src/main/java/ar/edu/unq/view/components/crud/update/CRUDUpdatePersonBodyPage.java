package ar.edu.unq.view.components.crud.update;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.model.Car;
import ar.edu.unq.model.Person;
import ar.edu.unq.services.CRUDUpdateService;
import ar.edu.unq.services.CarService;
import ar.edu.unq.view.Home;

public class CRUDUpdatePersonBodyPage extends CRUDUpdateBodyPage<Person> {

	private static final long serialVersionUID = -7867297535512806399L;
	@SpringBean(name = "services.car")
	private CarService carService;

	public CRUDUpdatePersonBodyPage(final Home home,
			final CRUDUpdateService<Person> service,
			final String displayProperty) {
		super(home, service, displayProperty);
	}

	@Override
	protected void addToForm(final Form<Person> form) {
		form.add(new TextField<String>("name"));
		form.add(new TextField<Integer>("age"));
		form.add(this.createPallete());

	}

	private Component createPallete() {
		IModel<? extends List<? extends Car>> model = new PropertyModel<List<? extends Car>>(
				this, "personCars");
		IModel<? extends Collection<? extends Car>> choicesModel = this
				.getCarChoices();
		int rows = 10;
		return new Palette<Car>("cars", model, choicesModel,
				this.getCarRenderer(), rows, true);
	}

	private IModel<? extends Collection<? extends Car>> getCarChoices() {
		return new ListModel<Car>(this.getCarService().retriveAll());
	}

	private IChoiceRenderer<Car> getCarRenderer() {
		return new IChoiceRenderer<Car>() {

			private static final long serialVersionUID = 8711849661403779166L;

			@Override
			public Object getDisplayValue(final Car object) {
				return object.getBrand();
			}

			@Override
			public String getIdValue(final Car object, final int index) {
				return Integer.toString(object.getId());
			}
		};
	}

	public CarService getCarService() {
		return this.carService;
	}

	public List<Car> getPersonCars() {
		return this.getChoice() == null ? new ArrayList<Car>() : this
				.getChoice().getCars();
	}

	public void setCarService(final CarService carService) {
		this.carService = carService;
	}

	public void setPersonCars(final List<Car> cars) {
		this.getChoice().setCars(cars);
	}

}
