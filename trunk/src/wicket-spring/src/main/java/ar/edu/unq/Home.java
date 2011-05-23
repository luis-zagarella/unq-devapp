package ar.edu.unq;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;


public class Home extends WebPage {

	@SpringBean(name = "unBean")
	private BeanEjemplo beanEjemplo;
	
	
	public Home() {
		init();
	}

	public void init() {
		Label markupLabel = new Label("markupLabel",
				"esto es un <b>TEST!</b>");
		markupLabel.setEscapeModelStrings(false);
		add(markupLabel);
	}
}
