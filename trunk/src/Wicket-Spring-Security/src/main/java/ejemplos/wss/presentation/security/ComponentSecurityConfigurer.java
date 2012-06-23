package ejemplos.wss.presentation.security;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.wicket.Component;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;

/**
 * @see IComponentInstantiationListener
 * @see MetaDataRoleAuthorizationStrategy
 * 
 *      On component instantiation, a ComponentSecurityListener instance will
 *      check for an existing ui security configuration, bounded to that
 *      component. Configurations get loaded from security.properties file.
 * 
 *      If there is a configuration, regarding a target action (RENDER or
 *      ENABLE), and a list of required roles to perform that action
 *      (RoleA,RoleB,RoleC, ANY of the roles will do), then that configuration
 *      is applied.
 * 
 *      IMPORTANT!!: If there were no unique component IDs, it is possible to
 *      register a configuration for a unique ID, and then do something like:
 * 
 *      <code>
 *      applySecurityConstraintsTo(targetComponent, aUniqueID)
 *      </code>
 * 
 */
public class ComponentSecurityConfigurer implements
		IComponentInstantiationListener {
	private static final Logger LOGGER = Logger
			.getLogger(ComponentSecurityConfigurer.class);

	private Properties properties;

	@Override
	public void onInstantiation(final Component component) {
		boolean isPage = component instanceof WebPage;
		final String targetObjectId = isPage ? component.getClass()
				.getSimpleName() : component.getId();

		final String componentSecurityConfiguration = properties
				.getProperty(targetObjectId);
		// component security configuration exists
		if (componentSecurityConfiguration != null) {
			final String fullName = isPage ? component.getClass().getName()
					: component.getPath();
			if (!targetObjectId.equals(fullName)) {
				LOGGER.info("warning: matching " + targetObjectId + " to "
						+ fullName);
			}
			this.applySecurityConstraintsTo(component, targetObjectId);
		}
	}

	public void applySecurityConstraintsTo(final Component targetComponent,
			final String targetObjectId) {
		// search registered configuration for target object
		final String componentSecurityConfiguration = this
				.getSecurityConfigurationFor(targetObjectId);

		if (componentSecurityConfiguration != null) {
			// get target action and expected roles (any of those roles)
			final int configValuesSeparatorIndex = componentSecurityConfiguration
					.indexOf(',');
			final String targetActionName = componentSecurityConfiguration
					.substring(0, configValuesSeparatorIndex);
			final String expectedRoles = componentSecurityConfiguration
					.substring(configValuesSeparatorIndex + 1);
			final Action targetAction = this.asWicketAction(targetActionName);

			LOGGER.info("Configuring " + targetObjectId + ". Action: "
					+ targetActionName + ". Role: " + expectedRoles);

			MetaDataRoleAuthorizationStrategy.authorize(targetComponent,
					targetAction, expectedRoles);
		}
	}

	private Action asWicketAction(final String actionName) {
		Action action = null;
		if (actionName.equalsIgnoreCase("RENDER")) {
			action = Component.RENDER;
		} else if (actionName.equalsIgnoreCase("ENABLE")) {
			action = Component.ENABLE;
		} else {
			LOGGER.error("No Action found: " + actionName);
		}
		return action;
	}

	private String getSecurityConfigurationFor(final String componentId) {
		return properties.getProperty(componentId);
	}

	public void setProperties(final Properties properties) {
		this.properties = properties;
	}

}
