package ar.edu.unq.view.components.crud.delete;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;

import ar.edu.unq.services.CRUDDeleteService;
import ar.edu.unq.view.Home;
import ar.edu.unq.view.components.BodyPanel;
import ar.edu.unq.view.components.crud.create.CRUDCreateBodyPage;

public class CRUDDeleteBodyPage<T> extends BodyPanel {

	private static final long serialVersionUID = -2748844133604562739L;

	private T choice;

	private final String displayExpression;

	private Form<T> form;

	private CRUDDeleteService<T> service;

	public CRUDDeleteBodyPage(final CRUDDeleteService<T> service,
			final String displayExpression, final Home home) {
		super(home);
		this.displayExpression = displayExpression;
		this.service = service;
		this.initialize();
	}

	private void addCancelButton(final Form<T> aForm) {
		aForm.add(new AjaxFallbackLink<CRUDCreateBodyPage<T>>("cancelButton",
				new PropertyModel<CRUDCreateBodyPage<T>>(this, "dummyMethod")) {
			private static final long serialVersionUID = -8949442308458919782L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				CRUDDeleteBodyPage.this.sendMessage(target,
						"crud.message.cancel");
			}

		});
	}

	private void addChoices(final Form<T> aForm) {
		IModel<T> model = new PropertyModel<T>(this, "choice");
		aForm.add(new DropDownChoice<T>("choice", model, this.getChoices(), this
				.getRenderer()));
	}

	private void addSubmit(final Form<T> aForm) {
		form.add(new AjaxSubmitLink("deleteButton") {

			private static final long serialVersionUID = 2442800141852634117L;

			@Override
			protected void onError(final AjaxRequestTarget target,
					final Form<?> aFormOnError) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> aForm) {
				CRUDDeleteBodyPage.this.getService().delete(
						CRUDDeleteBodyPage.this.getChoice());

				CRUDDeleteBodyPage.this.sendMessage(target,
						"crud.delete.message.success");
			}
		});
	}

	public T getChoice() {
		return this.choice;
	}

	private ListModel<T> getChoices() {

		return new ListModel<T>(this.getService().retriveAll());

	}

	private String getDisplayExpression() {
		return this.displayExpression;
	}

	public Form<T> getForm() {
		return this.form;
	}

	private ChoiceRenderer<T> getRenderer() {
		return new ChoiceRenderer<T>(this.getDisplayExpression());
	}

	public CRUDDeleteService<T> getService() {
		return this.service;
	}

	private void initialize() {
		this.form = new Form<T>("crudForm");
		this.addCancelButton(this.form);
		this.addSubmit(this.form);
		this.addChoices(this.form);
		this.add(this.form);
	}

	public void setChoice(final T choice) {
		this.choice = choice;
	}

	public void setForm(final Form<T> form) {
		this.form = form;
	}

	public void setService(final CRUDDeleteService<T> service) {
		this.service = service;
	}

}
