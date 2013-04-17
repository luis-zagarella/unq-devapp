package ar.edu.unq.view.components.crud.create;

import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.model.Car;
import ar.edu.unq.services.CRUDCreateService;
import ar.edu.unq.view.Home;

public class CRUDCreateCarBodyPage extends CRUDCreateBodyPage<Car> {

	private static final long serialVersionUID = -5517883757645818649L;

	
	public CRUDCreateCarBodyPage(final CRUDCreateService<Car> service,
			final Home home) {
		super(service, home);
	}

	@Override
	protected void addComponents(final Form<Car> form) {
		form.add(new TextField<String>("brand"));
		form.add(new TextField<Integer>("occupeds"));
		// TextField<Date> sinceField = new TextField<Date>("since");
		DateField sinceField = new DateField("since");
		// sinceField.add(new DatePicker());
		form.add(sinceField);
	}

	@Override
	protected Car createEmptyObject() {
		return new Car();
	}

}
