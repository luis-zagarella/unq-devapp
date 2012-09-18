package ar.edu.unq.view.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;

import ar.edu.unq.view.Home;

public class BodyPanel extends Panel {
	private static final long serialVersionUID = 1235787111674062390L;
	private Home home;

	public BodyPanel(final Home home) {
		super("body");
		this.setHome(home);

	}

	public Home getHome() {
		return home;
	}

	public void sendMessage(final AjaxRequestTarget target, final String message) {
		this.getHome().changeBodyPageWithMessage(new BodyPanel(this.getHome()),
				message, target);
	}

	public void setHome(final Home home) {
		this.home = home;
	}

	public void updateModel() {

	}

}
