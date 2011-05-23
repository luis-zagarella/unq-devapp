package ar.edu.unq;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class Home extends WebPage {

	@SpringBean(name = "unBean")
	private BeanEjemplo beanEjemplo;

	public Home() {
		initialize();
	}

	public final void initialize() {
		Label markupLabel = new Label("markupLabel", "esto es un <b>"
				+ beanEjemplo.getShow() + " !!!! </b>");
		markupLabel.setEscapeModelStrings(false);
		add(markupLabel);
	}
}
