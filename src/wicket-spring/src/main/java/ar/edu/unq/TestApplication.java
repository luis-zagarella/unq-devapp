package ar.edu.unq;

import org.apache.wicket.Page;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class TestApplication extends AuthenticatedWebApplication{
	
	private ar.edu.unq.MounterURL aMounterURL;
	
	
	private ServiceGeneral generalService;


	public ServiceGeneral getGeneralService() {
		return generalService;
	}

	public void setGeneralService(ServiceGeneral generalService) {
		this.generalService = generalService;
	}

	public TestApplication(){
			
	}
	
	public void init(){
		aMounterURL = new MounterURL(this);
		this.addComponentInstantiationListener(new SpringComponentInjector(this));
		//this.mountUrl("home", Home.class);
	}

	private void mountUrl(String mountPath, Class<? extends WebPage> pageClass,
			String... parameters) {
		aMounterURL.mount(mountPath, pageClass, parameters);
	}
	@Override
	protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
		// TODO Auto-generated method stub
		return WebSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return Home.class;
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Home.class;
	}
	
	public String getContextPath() {
		return getServletContext().getContextPath();
	}

}
