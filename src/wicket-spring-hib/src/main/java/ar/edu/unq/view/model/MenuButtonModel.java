package ar.edu.unq.view.model;

import java.io.Serializable;

import ar.edu.unq.view.components.BodyPanel;

public class MenuButtonModel implements Serializable {

	private static final long serialVersionUID = 8896316531793354377L;
	private BodyPanel bodyPage;
	private String title;

	public MenuButtonModel(final String title, final BodyPanel bodyPage) {
		this.title = title;
		this.bodyPage = bodyPage;
	}

	public BodyPanel getBodyPage() {
		return bodyPage;
	}

	public String getTitle() {
		return title;
	}

	public void setBodyPage(final BodyPanel bodyPage) {
		this.bodyPage = bodyPage;
	}

	public void setTitle(final String title) {
		this.title = title;
	}
}
