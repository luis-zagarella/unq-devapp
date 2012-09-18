package ar.edu.unq.view;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.model.Car;
import ar.edu.unq.model.Person;
import ar.edu.unq.services.CarService;
import ar.edu.unq.services.GeneralService;
import ar.edu.unq.services.PersonService;
import ar.edu.unq.view.components.BodyPanel;
import ar.edu.unq.view.components.MenuButton;
import ar.edu.unq.view.components.ajaxLoadingButton.LoadingPanel;
import ar.edu.unq.view.components.crud.create.CRUDCreateCarBodyPage;
import ar.edu.unq.view.components.crud.create.CRUDCreatePersonBodyPage;
import ar.edu.unq.view.components.crud.delete.CRUDDeleteBodyPage;
import ar.edu.unq.view.components.crud.update.CRUDUpdateCarBodyPage;
import ar.edu.unq.view.components.crud.update.CRUDUpdatePersonBodyPage;
import ar.edu.unq.view.model.MenuButtonModel;

public class Home extends WebPage {
	private static final long serialVersionUID = 6007296848816900008L;
	private BodyPanel bodyPage;
	@SpringBean(name = "services.general")
	private GeneralService generalService;
	private LoadingPanel loadingPanel;
	private Label message;

	private void addBodyPage() {
		BodyPanel aBodyPage = new BodyPanel(this);
		this.configuredBodyPage(aBodyPage);
		this.add(aBodyPage);
	}

	private void addMenu() {
		this.add(new ListView<MenuButtonModel>("menuButton", this.getMenues()) {

			private static final long serialVersionUID = -6536873757791884900L;

			@Override
			protected void populateItem(final ListItem<MenuButtonModel> item) {
				item.setRenderBodyOnly(true);
				item.add(new MenuButton("menuButtonComponent", item.getModel(),
						Home.this));
			}
		});
	}

	public void changeBodyPage(final BodyPanel aBodyPage,
			final AjaxRequestTarget target) {
		this.getBodyPage().replaceWith(aBodyPage);
		this.configuredBodyPage(aBodyPage);
		this.setBodyPage(aBodyPage);
		target.add(aBodyPage);
	}

	public void changeBodyPageWithMessage(final BodyPanel aBodyPage,
			final String message, final AjaxRequestTarget target) {

		this.changeBodyPage(aBodyPage, target);
		target.appendJavaScript("$(function() {"
				+ "				$('#dialog').dialog('open');"//
				+ "				 return false;"//
				+ "				 });");
		this.replaceMessage(message);
		target.add(this.getMessage());
	}

	private void configuredBodyPage(final BodyPanel aBodyPage) {
		aBodyPage.setOutputMarkupId(true);
		aBodyPage.setOutputMarkupPlaceholderTag(true);
		this.setBodyPage(aBodyPage);
	}

	private void createEmptyMessage() {
		message = new Label("messageDialog");
		this.add(message);
	}

	public BodyPanel getBodyPage() {
		return bodyPage;
	}

	public GeneralService getGeneralService() {
		return generalService;
	}

	public LoadingPanel getLoadingPanel() {
		return loadingPanel;
	}

	private List<? extends MenuButtonModel> getMenues() {
		CarService carService = this.getGeneralService().getCarService();
		PersonService personService = this.getGeneralService()
				.getPersonService();
		return Arrays
				.asList(new MenuButtonModel[] {
						new MenuButtonModel("home.menu.crud.car.create",
								new CRUDCreateCarBodyPage(carService, this)),
						new MenuButtonModel("home.menu.crud.car.update",
								new CRUDUpdateCarBodyPage(this, carService,
										"brand")),
						new MenuButtonModel("home.menu.crud.car.delete",
								new CRUDDeleteBodyPage<Car>(carService,
										"brand", this)),
						new MenuButtonModel("home.menu.crud.person.create",
								new CRUDCreatePersonBodyPage(personService,
										this)),
						new MenuButtonModel("home.menu.crud.person.update",
								new CRUDUpdatePersonBodyPage(this,
										personService, "name")),
						new MenuButtonModel("home.menu.crud.person.delete",
								new CRUDDeleteBodyPage<Person>(personService,
										"name", this)) });
	}

	public Label getMessage() {
		return message;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		loadingPanel = new LoadingPanel("loadingPanel");
		this.add(loadingPanel);
		this.createEmptyMessage();
		this.replaceMessage("home.dialog.emptyMessage");
		this.addBodyPage();
		this.addMenu();
	}

	private void replaceMessage(final String message) {
		Label replacement = new Label("messageDialog", new ResourceModel(
				message));
		replacement.setOutputMarkupId(true);
		this.setOutputMarkupPlaceholderTag(true);
		this.getMessage().replaceWith(replacement);
		this.setMessage(replacement);
	}

	public void setBodyPage(final BodyPanel bodyPage) {
		this.bodyPage = bodyPage;
	}

	public void setGeneralService(final GeneralService generalService) {
		this.generalService = generalService;
	}

	public void setMessage(final Label message) {
		this.message = message;
	}
}
