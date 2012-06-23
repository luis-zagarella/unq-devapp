package ejemplos.wss.presentation;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ejemplos.wss.presentation.security.ComponentSecurityConfigurer;


public class JavaBaseProjectApplication extends AuthenticatedWebApplication implements ApplicationContextAware{
    private static final long serialVersionUID = -7489854575515312542L;

    private transient ApplicationContext context;

    private boolean initialized = false;

    private ComponentSecurityConfigurer componentSecurityConfigurer;

    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        if (!isInitialized()) {
            super.init();
            setListeners();
            setInitialized(true);
            getComponentInstantiationListeners().add(componentSecurityConfigurer);
        }
    }

    @Override
    public Session newSession(final Request request, final Response response) {
        return new JavaBaseProjectSession(request);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return context;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(final boolean isInitialized) {
        initialized = isInitialized;
    }

    private void setListeners() {
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, getApplicationContext(), true));
    }


    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return JavaBaseProjectSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return LoginPage.class;
    }

    public void setComponentSecurityConfigurer(final ComponentSecurityConfigurer componentSecurityConfigurer) {
        this.componentSecurityConfigurer = componentSecurityConfigurer;
    }

}
