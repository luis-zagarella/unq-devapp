package ar.edu.unq.view.components.crud.update;

import java.util.List;

import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.model.Car;
import ar.edu.unq.model.Person;
import ar.edu.unq.services.CRUDUpdateService;
import ar.edu.unq.services.PersonService;
import ar.edu.unq.view.Home;

public class CRUDUpdateCarBodyPage extends CRUDUpdateBodyPage<Car> {
	private static final long serialVersionUID = 4204791976631798535L;
	@SpringBean(name = "services.person")
	private PersonService personService;

	public CRUDUpdateCarBodyPage(final Home home,
			final CRUDUpdateService<Car> service, final String displayProperty) {
		super(home, service, displayProperty);

	}

	@Override
	protected void addToForm(final Form<Car> form) {
		form.add(new TextField<String>("brand"));
		form.add(new TextField<Integer>("occupeds"));
		form.add(new DateField("since"));
		form.add(this.createOwnChoicer());
	}

	private DropDownChoice<Person> createOwnChoicer() {
		return new DropDownChoice<Person>("owner", this.getAllPersons(),
				this.getPersonRenderer());
	}

	private List<? extends Person> getAllPersons() {
		return this.getPersonService().retriveAll();
	}

	private IChoiceRenderer<? super Person> getPersonRenderer() {
		return new ChoiceRenderer<Person>("name");
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(final PersonService personService) {
		this.personService = personService;
	}

}
