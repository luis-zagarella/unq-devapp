package ejemplos.wss.presentation;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public final class LoginPage extends WebPage {
    private static final long serialVersionUID = 2592095126620671889L;

    public LoginPage() {
        this(null);
    }

    public LoginPage(final PageParameters parameters) {
        super();
        add(new LoginForm("loginform"));
        //new DataInitPage();
    }

    @SuppressWarnings("rawtypes")
    private class LoginForm extends Form {

        private static final long serialVersionUID = 2978971723282052820L;

        private String username;

        private String password;

        @SuppressWarnings("unchecked")
        public LoginForm(final String id) {
            super(id);
            setModel(new CompoundPropertyModel(this));
            add(new RequiredTextField("username"));
            add(new PasswordTextField("password"));
            add(new FeedbackPanel("feedback"));
        }

        @Override
        protected void onSubmit() {
            JavaBaseProjectSession session = JavaBaseProjectSession.getSession();
            if (session.signIn(username, password)) {
                LoginForm.this.setResponsePage(HomePage.class);
            } else {
                error(getString("login.failed"));
            }
        }
    }

}
