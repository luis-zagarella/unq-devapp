/**
 * 
 */
package org.assembly.nornas.web.template;

import org.apache.click.Page;

/**
 * @author Cristian
 *
 *	Class repesent the template, father of all pages.
 *
 */
public abstract class Template extends Page {

	private static final long serialVersionUID = 5522432061754148471L;
	
	@Override
	public String getTemplate() {
		return "/template/template.htm";
	}
	

}
