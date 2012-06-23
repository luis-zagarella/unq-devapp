package ejemplos.wss.presentation;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

@AuthorizeInstantiation("ROLE_USER")
public class BasePage extends WebPage {

	private static final long serialVersionUID = 1129872141829429463L;

	public BasePage() {
		super();
		initialize();
	}

	private void initialize() {
		this.addLinkToHome();
//		this.addLinkToManagePersonsPage();
//		this.addLinkToDataTableDemo();
//		this.addLinkToSearchPersons();
	}

	private void addLinkToHome() {
		BookmarkablePageLink<HomePage> linkToHome = new BookmarkablePageLink<HomePage>(
				"linkToHomePage", HomePage.class);
		this.add(linkToHome);
		
		BookmarkablePageLink<HomePage> linkToContentAdmin = new BookmarkablePageLink<HomePage>(
				"linkToContentAdmin", HomePage.class);
		this.add(linkToContentAdmin);
		
		BookmarkablePageLink<HomePage> linkToContentUser = new BookmarkablePageLink<HomePage>(
				"linkToContentUser", HomePage.class);
		this.add(linkToContentUser);
	}

//	private void addLinkToDataTableDemo() {
//		BookmarkablePageLink<DataTableDemoPage> linkToDataTableDemo = new BookmarkablePageLink<DataTableDemoPage>(
//				"linkToDataTableDemo", DataTableDemoPage.class);
//		this.add(linkToDataTableDemo);
//	}
//
//	private void addLinkToManagePersonsPage() {
//		BookmarkablePageLink<ManagePersonsPage> linkToPersons = new BookmarkablePageLink<ManagePersonsPage>(
//				"linkToPersons", ManagePersonsPage.class);
//		this.add(linkToPersons);
//	}
//
//	private void addLinkToSearchPersons() {
//		BookmarkablePageLink<PersonSearchPage> linkToSearchPersons = new BookmarkablePageLink<PersonSearchPage>(
//				"linkToSearchPersons", PersonSearchPage.class);
//		this.add(linkToSearchPersons);
//	}

}
