package ar.edu.unq.view;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

public class MounterURL {

	private WebApplication webApplication;

	/**
	 * @param webApplication
	 */
	public MounterURL(final WebApplication webApplication) {
		this.webApplication = webApplication;
	}

	/**
	 * @param mountPath
	 *            Mount path (not empty)
	 * @param pageClass
	 *            Class of mounted page (not null)
	 * @param parameters
	 *            The parameter names (not null)
	 */
	public void mount(final String mountPath,
			final Class<? extends WebPage> pageClass,
			final String... parameters) {
		webApplication.mountPage(mountPath, pageClass);
	}

}