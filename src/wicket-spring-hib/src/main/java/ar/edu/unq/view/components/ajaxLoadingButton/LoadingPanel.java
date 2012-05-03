package ar.edu.unq.view.components.ajaxLoadingButton;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.PackageResourceReference;

public class LoadingPanel extends Panel implements IHeaderContributor {

	private static final long serialVersionUID = -6030094353475638802L;

	public LoadingPanel(final String id) {
		super(id);

	}

	private void addImage() {
		Image image = new Image("loadingImage", new PackageResourceReference(
				this.getClass(), "loading.gif"));
		image.add(new AttributeAppender("class", "loadingPanelImage"));
		this.add(image);
	}

	@Override
	protected void onInitialize() {
		this.add(new AttributeAppender("class", "loadingPanel"));
		this.addImage();
		super.onInitialize();
		this.setVisible(true);
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		response.renderJavaScriptReference("scripts/ui/jquery.ui.core.js",
				"jquery.ui.core.js");
		response.renderJavaScriptReference(
				"scripts/ui/jquery.effects.explode.js",
				"jquery.effects.explode.js");
		response.renderJavaScriptReference(
				new PackageResourceReference(this.getClass(), "LoadingPanel.js"),
				"loadingPanelScript");
		response.renderCSSReference(new PackageResourceReference(this
				.getClass(), "LoadingPanel.css"));
		super.renderHead(response);
	}
}
