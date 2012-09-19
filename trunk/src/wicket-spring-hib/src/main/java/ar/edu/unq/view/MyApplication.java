package ar.edu.unq.view;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import ar.edu.unq.model.Car;
import ar.edu.unq.model.Person;
import ar.edu.unq.services.CarService;
import ar.edu.unq.services.GeneralService;
import ar.edu.unq.services.PersonService;
import ar.edu.unq.utils.DateUtils;

public class MyApplication extends AuthenticatedWebApplication {

	private MounterURL aMounterURL;
	private GeneralService generalService;

	public String getContextPath() {
		return this.getServletContext().getContextPath();
	}

	public GeneralService getGeneralService() {
		return generalService;
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Home.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return Home.class;
	}

	@Override
	protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
		return WebSession.class;
	}

	@Override
	public void init() {
		aMounterURL = new MounterURL(this);
		this.getComponentInstantiationListeners().add(
				new SpringComponentInjector(this));
		this.mountUrl("home", Home.class, "");
		this.initializeModel();
	}

	private void initializeModel() {
		CarService carService = this.getGeneralService().getCarService();
		Car fiatPunto = new Car("Fiat Punto", 4,
				DateUtils.getDate("10/11/2012"));
		carService.save(fiatPunto);
		carService.save(new Car("Peugeot 206", 4, DateUtils
				.getDate("01/12/2000")));
		PersonService personService = this.getGeneralService()
				.getPersonService();
		Person leandro = new Person("Leandro", 26);
		personService.save(leandro);
		personService.save(new Person("Jesica", 25));
		fiatPunto.setOwner(leandro);
	}

	private void mountUrl(final String mountPath,
			final Class<? extends WebPage> pageClass,
			final String... parameters) {
		aMounterURL.mount(mountPath, pageClass, parameters);
	}

	public void setGeneralService(final GeneralService generalService) {
		this.generalService = generalService;
	}

}
