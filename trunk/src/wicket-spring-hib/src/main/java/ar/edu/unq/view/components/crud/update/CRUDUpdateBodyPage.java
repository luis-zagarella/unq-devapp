package ar.edu.unq.view.components.crud.update;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import ar.edu.unq.services.CRUDUpdateService;
import ar.edu.unq.view.Home;
import ar.edu.unq.view.components.BodyPanel;
import ar.edu.unq.view.components.crud.create.CRUDCreateBodyPage;

public abstract class CRUDUpdateBodyPage<T> extends BodyPanel {

	private static final long serialVersionUID = 3160813994459124767L;
	private T choice;
	private final String displayProperty;
	private Form<T> form;
	private Form<T> selectorForm;
	private final CRUDUpdateService<T> service;

	public CRUDUpdateBodyPage(final Home home,
			final CRUDUpdateService<T> service, final String displayProperty) {
		super(home);
		this.displayProperty = displayProperty;
		this.service = service;
		this.addSelector();
		this.form = new Form<T>("crudForm");
		this.form.setOutputMarkupId(true);
		this.form.setOutputMarkupPlaceholderTag(true);
		this.form.setVisible(false);
		this.initialize();
		this.addToForm(this.form);
	}

	private void addCancelButton(final Form<T> aForm) {
		aForm.add(new AjaxFallbackLink<CRUDCreateBodyPage<T>>("cancelButton",
				new PropertyModel<CRUDCreateBodyPage<T>>(this, "dummyMethod")) {
			private static final long serialVersionUID = -8949442308458919782L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				CRUDUpdateBodyPage.this.sendMessage(target,
						"crud.message.cancel");
				CRUDUpdateBodyPage.this.getForm().modelChanged();
				target.add(CRUDUpdateBodyPage.this.getForm());
			}

		});
	}

	private void addSelector() {
		this.selectorForm = new Form<T>("selector");
		this.addSelector(this.selectorForm);
		this.selectorForm.add(new AjaxSubmitLink("select") {

			private static final long serialVersionUID = -2865761104355410378L;

			@Override
			protected void onError(final AjaxRequestTarget target,
					final Form<?> aForm) {
			}

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> aForm) {
				CRUDUpdateBodyPage.this.getForm().setModel(
						new CompoundPropertyModel<T>(CRUDUpdateBodyPage.this
								.getChoice()));
				CRUDUpdateBodyPage.this.getForm().modelChanged();
				CRUDUpdateBodyPage.this.getForm().setVisible(true);
				target.add(CRUDUpdateBodyPage.this.getForm());

			}
		});
		this.addCancelButton(this.selectorForm);
		this.add(this.selectorForm);
	}

	private void addSelector(final Form<T> aForm) {
		IModel<T> model = new PropertyModel<T>(this, "choice");
		aForm.add(new DropDownChoice<T>("choices", model, this.getChoices(),
				this.getRenderer()));
	}

	private void addSubmit(final Form<T> aForm) {
		aForm.add(new AjaxSubmitLink("updateButton") {

			private static final long serialVersionUID = 2442800141852634117L;

			@Override
			protected void onError(final AjaxRequestTarget target,
					final Form<?> aForm) {
			}

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> aForm) {
				CRUDUpdateBodyPage.this.getService().update(
						CRUDUpdateBodyPage.this.getChoice());
				CRUDUpdateBodyPage.this.resetForms(aForm);
				CRUDUpdateBodyPage.this.sendMessage(target,
						"crud.update.message.success");
			}
		});
	}

	protected abstract void addToForm(Form<T> form);

	public T getChoice() {
		return this.choice;
	}

	private List<T> getChoices() {
		return this.getService().retriveAll();
	}

	public String getDisplayProperty() {
		return this.displayProperty;
	}

	public Form<T> getForm() {
		return this.form;
	}

	private IChoiceRenderer<? super T> getRenderer() {
		return new ChoiceRenderer<T>(this.getDisplayProperty());
	}

	public CRUDUpdateService<T> getService() {
		return this.service;
	}

	protected void initialize() {
		this.addCancelButton(this.form);
		this.addSubmit(this.form);
		this.add(this.form);
	}

	private void resetForms(final Form<?> aForm) {
		CRUDUpdateBodyPage.this.setChoice(null);
		aForm.modelChanged();
		CRUDUpdateBodyPage.this.selectorForm.modelChanged();
		this.form.setVisible(false);
	}

	public void setChoice(final T choice) {
		this.choice = choice;
	}

	public void setForm(final Form<T> form) {
		this.form = form;
	}

	@Override
	public void updateModel() {
		// this.selectorForm.modelChanged();
		this.modelChanged();
		super.updateModel();
	}

}
