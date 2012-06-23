package ejemplos.wss.presentation;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.TextField;

public class HomePage extends BasePage {
    private static final long serialVersionUID = -5663183559341343305L;

    public HomePage() {
        super();
        this.initializePage();
        
    }

	private void initializePage() {
		TextField<String> nameTextFieldAdmin = new TextField<String>("textFieldAdmin");
        nameTextFieldAdmin.add(new AttributeModifier("value", "Solo ADMINs"));
        nameTextFieldAdmin.setRequired(false);
        this.add(nameTextFieldAdmin);
        
        
    	TextField<String> nameTextFieldUser = new TextField<String>("textFieldUser");
    	nameTextFieldUser.add(new AttributeModifier("value", "Solo USERs"));
        nameTextFieldUser.setRequired(false);
        this.add(nameTextFieldUser);
		
	}

    
    
    
}
