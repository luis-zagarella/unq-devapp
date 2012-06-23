package ejemplos.wss.service.userauth;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException, DataAccessException {
		//  TODO REEMPLAZAR ESTO X BUSCAR EL USER EN EL SERVICIO CORRESPONDIENTE
		Role roleUser = new Role("ROLE_USER");
		Role roleAdmin = new Role("ROLE_SUPERVISOR");
		if (username == null)throw new UsernameNotFoundException("");
		if (username.equals("user")){
			return new User("user","user",roleUser);
		}
		if (username.equals("admin")){
			return new User("admin","admin",roleUser,roleAdmin);
		}
		throw new UsernameNotFoundException("No user found for username: " +username);
	}
}