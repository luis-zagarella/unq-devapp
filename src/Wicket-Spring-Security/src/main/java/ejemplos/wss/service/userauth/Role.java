package ejemplos.wss.service.userauth;

import org.springframework.security.core.GrantedAuthority;

public class Role  implements GrantedAuthority {
    private static final long serialVersionUID = -7157438012084854576L;

    private String name;

    public Role() {
        super();
    }

    public Role(String aName){
    	this.name = aName;
    }


    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }



}
