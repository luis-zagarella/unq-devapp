package ar.edu.unq.view;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import ar.edu.unq.services.GeneralService;

public class MyApplication extends AuthenticatedWebApplication {

    private ar.edu.unq.view.MounterURL aMounterURL;

    private GeneralService generalService;

    public GeneralService getGeneralService() {
        return generalService;
    }

    public void setGeneralService(final GeneralService generalService) {
        this.generalService = generalService;
    }

    public MyApplication() {
        System.out.println(" Constructor de MyApplication  ");

    }

    @Override
    public void init() {
        aMounterURL = new MounterURL(this);
        this.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        this.mountUrl("home", Home.class, "");
    }

    private void mountUrl(final String mountPath, final Class<? extends WebPage> pageClass, final String... parameters) {
        aMounterURL.mount(mountPath, pageClass, parameters);
    }

    @Override
    protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
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
        return this.getServletContext().getContextPath();
    }

}
