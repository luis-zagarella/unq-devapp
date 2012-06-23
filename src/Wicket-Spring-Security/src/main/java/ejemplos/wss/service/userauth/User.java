package ejemplos.wss.service.userauth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User  implements UserDetails {
    private static final long serialVersionUID = 1588265571172283477L;

    private String username;

    private String password;

    private Set<Role> roles;

    public User() {
        super();
        roles = new HashSet<Role>();
    }
    
    public User(String aUserName,String aPassword, Role... aRoles) {
        this();
        this.username = aUserName;
        this.password = aPassword;
        for (Role role : aRoles) {
			roles.add(role);
		}
        
    }


    @Override
    public String toString() {
        return username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(final String name) {
        username = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>(roles);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
