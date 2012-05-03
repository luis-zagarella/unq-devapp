package ar.edu.unq.view.components.ajaxLoadingButton;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxCallDecorator;
import org.apache.wicket.ajax.calldecorator.CancelEventIfNoAjaxDecorator;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.ComponentTag;

public abstract class AjaxLoadingButton<T> extends AjaxFallbackLink<T> {

	private static final long serialVersionUID = 5413575249070371252L;
	private final LoadingPanel loadingPanel;

	public AjaxLoadingButton(final String id, final LoadingPanel loadingPanel) {
		super(id);
		this.loadingPanel = loadingPanel;
	}

	public LoadingPanel getLoadingPanel() {
		return this.loadingPanel;
	}

	@Override
	protected AjaxEventBehavior newAjaxEventBehavior(final String event) {
		return new AjaxEventBehavior(event) {
			private static final long serialVersionUID = 1L;

			@Override
			protected IAjaxCallDecorator getAjaxCallDecorator() {
				return new CancelEventIfNoAjaxDecorator(
						AjaxLoadingButton.this.getAjaxCallDecorator());
			}

			@Override
			protected CharSequence getCallbackScript() {
				// TODO Auto-generated method stub
				return "showLoadingPanel();" + super.getCallbackScript();
			}

			@Override
			protected CharSequence getSuccessScript() {

				return "hideLoadingPanel();";
			}

			@Override
			protected void onComponentTag(final ComponentTag tag) {
				if (AjaxLoadingButton.this.isLinkEnabled()) {
					super.onComponentTag(tag);
				}
			}

			@Override
			protected void onEvent(final AjaxRequestTarget target) {
				AjaxLoadingButton.this.onClick(target);
			}
		};
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		this.add(this.newAjaxEventBehavior("onclick"));
	}
}
