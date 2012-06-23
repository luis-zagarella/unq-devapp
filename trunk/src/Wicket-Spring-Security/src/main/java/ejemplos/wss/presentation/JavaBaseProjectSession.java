package ejemplos.wss.presentation;

import java.io.Serializable;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class JavaBaseProjectSession extends AuthenticatedWebSession {
	private static final long serialVersionUID = 1L;

	@SpringBean(name = "authenticationManager")
	private AuthenticationManager authenticationManager;

	public JavaBaseProjectSession(final Request request) {
		super(request);
		injectDependencies();
	}

	public void add(final String key, final Serializable value) {
		setAttribute(key, value);
	}

	public void remove(final String key) {
		removeAttribute(key);
	}

	public Object get(final String key) {
		return getAttribute(key);
	}

	private void injectDependencies() {
		Injector.get().inject(this);
	}

	public static JavaBaseProjectSession getSession() {
		return (JavaBaseProjectSession) Session.get();
	}

	@Override
	public boolean authenticate(final String username, final String password) {
		boolean authenticated = false;
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							username, password));
			SecurityContextHolder.getContext()
					.setAuthentication(authentication);
			authenticated = authentication.isAuthenticated();
		} catch (AuthenticationException e) {
			authenticated = false;
		}
		return authenticated;
	}

	@Override
	public Roles getRoles() {
		Roles roles = new Roles();
		getRolesIfSignedIn(roles);
		return roles;
	}

	private void getRolesIfSignedIn(final Roles roles) {
		if (isSignedIn()) {
			Authentication authentication = SecurityContextHolder.getContext()
					.getAuthentication();
			addRolesFromAuthentication(roles, authentication);
		}
	}

	private void addRolesFromAuthentication(final Roles roles,
			final Authentication authentication) {
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			roles.add(authority.getAuthority());
		}
	}

}
