package ar.edu.unq.view.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import ar.edu.unq.view.Home;
import ar.edu.unq.view.components.ajaxLoadingButton.AjaxLoadingButton;
import ar.edu.unq.view.model.MenuButtonModel;

public class MenuButton extends Panel implements IHeaderContributor {

	private static final long serialVersionUID = 2742962506093131313L;
	private Home home;

	public MenuButton(final String id, final IModel<MenuButtonModel> model,
			final Home home) {
		super(id, model);
		this.home = home;
		this.addLink();
	}

	@SuppressWarnings("unchecked")
	private void addLink() {
		final MenuButtonModel menuModel = ((IModel<MenuButtonModel>) MenuButton.this
				.getDefaultModel()).getObject();

		AjaxLoadingButton<BodyPanel> link = new AjaxLoadingButton<BodyPanel>(
				"menuButtonLink", this.getHome().getLoadingPanel()) {

			private static final long serialVersionUID = -6682532912740865692L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				BodyPanel bodyPage = menuModel.getBodyPage();
				MenuButton.this.getHome().changeBodyPage(bodyPage, target);
				bodyPage.updateModel();
			}
		};
		String title = menuModel.getTitle();
		link.add(new Label("menuButtonLinkText",
				new ResourceModel(title, title)));
		this.add(link);

	}

	public Home getHome() {
		return home;
	}

	@Override
	protected void onInitialize() {
		this.add(new AttributeAppender("onMouseover",
				"javascript:mouseMoveButton(this);"));
		this.add(new AttributeAppender("onMouseOut",
				"javascript:mouseOutButton(this);"));
		super.onInitialize();
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		response.renderJavaScriptReference("scripts/ui/jquery.ui.core.js",
				"jquery.ui.core.js");
		response.renderJavaScriptReference(
				"scripts/ui/jquery.effects.shake.js", "jquery.effects.shake.js");
		response.renderJavaScriptReference(
				new PackageResourceReference(this.getClass(), "MenuButton.js"),
				"MenuButton.js");
		super.renderHead(response);
	}

	public void setHome(final Home home) {
		this.home = home;
	}

}
