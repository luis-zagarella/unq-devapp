package ar.edu.unq.view;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class WebSession extends AuthenticatedWebSession {

	public WebSession(final Request request) {
		super(request);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean authenticate(final String username, final String password) {
		return true;
	}

	@Override
	public Roles getRoles() {
		Roles roles = new Roles();
		roles.add("ADMIN");
		return roles;
	}

}
