package ar.edu.unq.view.components.crud.create;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ar.edu.unq.services.GenericService;
import ar.edu.unq.view.Home;
import ar.edu.unq.view.components.BodyPanel;

public abstract class CRUDCreateBodyPage<T> extends BodyPanel {

	private static final long serialVersionUID = -4080580813050030011L;

	private final Form<T> form;

	private T formModel;

	private GenericService<T> service;

	public CRUDCreateBodyPage(final GenericService<T> service,
			final Home home) {
		super(home);
		this.setService(service);
		this.formModel = this.createEmptyObject();
		this.form = new Form<T>("crudForm", new CompoundPropertyModel<T>(
				this.formModel));
		this.addComponents(this.form);
		this.addSubmit(this.form);
		this.addCancelButton(this.form);
		this.add(this.form);
	}

	private void addCancelButton(final Form<T> aForm) {
		aForm.add(new AjaxFallbackLink<CRUDCreateBodyPage<T>>("cancelButton",
				new PropertyModel<CRUDCreateBodyPage<T>>(this, "dummyMethod")) {
			private static final long serialVersionUID = -8949442308458919782L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				CRUDCreateBodyPage.this.sendMessage(target,
						"crud.message.cancel");
			}
		});
	}

	protected abstract void addComponents(Form<T> form);

	private void addSubmit(final Form<T> aForm) {
		aForm.add(new AjaxSubmitLink("saveButton") {

			private static final long serialVersionUID = 2442800141852634117L;

			@Override
			protected void onError(final AjaxRequestTarget target,
					final Form<?> aFormOnError) {
				// TODO Auto-generated method stub

			}

			@SuppressWarnings("unchecked")
			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> aForm) {
				CRUDCreateBodyPage.this.getService().save(
						(T) aForm.getModelObject());
				CRUDCreateBodyPage.this.sendMessage(target,
						"crud.message.create.success");
			}
		});
	}

	protected abstract T createEmptyObject();

	public Form<T> getForm() {
		return this.form;
	}

	public T getFormModel() {
		return this.formModel;
	}

	public GenericService<T> getService() {
		return this.service;
	}

	public void setFormModel(final T formModel) {
		this.formModel = formModel;
	}

	private void setService(final GenericService<T> service) {
		this.service = service;
	}

	@Override
	public void updateModel() {
		this.setFormModel(this.createEmptyObject());
		this.getForm().setModelObject(this.getFormModel());
		this.modelChanged();
	}

}
