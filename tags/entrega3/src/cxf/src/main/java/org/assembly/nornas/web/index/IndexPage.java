/**
 * 
 */
package org.assembly.nornas.web.index;

import java.util.List;

import org.apache.click.element.Element;
import org.apache.click.element.JsImport;
import org.apache.click.util.Bindable;
import org.assembly.nornas.web.template.BlogTemplate;

/**
 * Home Page
 * 
 * @author Cristian
 *
 */
public class IndexPage extends BlogTemplate {

	private static final long serialVersionUID = -2868696724309671438L;
	
	@Bindable
	private String titlePage;
	
	@Bindable
	private String subTitlePage;
	
	@Bindable
	private String urlPost;
	
	@Bindable
	private String tag;
	
	public IndexPage() {
		super();
	}
	
	@Override
	public List<Element> getHeadElements() {
		List<Element> elements = super.getHeadElements();
		
		JsImport jsImport = new JsImport("index.js");
		
		elements.add(jsImport);
		return elements;
	}
	
	@Override
	public void onInit() {
		titlePage = "CXF";
		subTitlePage = "Un ejemplo...";
		urlPost = this.getContext().getRequest().getContextPath() + "/rest/posts/";
		tag = "";
	}

	public String getTitlePage() {
		return titlePage;
	}

	public void setTitlePage(String titlePage) {
		this.titlePage = titlePage;
	}

	public String getSubTitlePage() {
		return subTitlePage;
	}

	public void setSubTitlePage(String subTitlePage) {
		this.subTitlePage = subTitlePage;
	}

	public String getUrlPost() {
		return urlPost;
	}

	public void setUrlPost(String urlPost) {
		this.urlPost = urlPost;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
