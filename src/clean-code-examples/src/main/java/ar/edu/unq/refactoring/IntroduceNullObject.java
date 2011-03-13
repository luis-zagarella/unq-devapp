package ar.edu.unq.refactoring;

import java.util.List;

import javax.swing.JTextField;

/**
 * Sirve para eliminar checkeos por null antes de enviar un mesaje a un objeto.
 * 
 * Abrir los ojos cuando vemos muchos if (blabla != null) then blabla.message()
 * en varios lados diferentes (los mensajes que se manden despeus pueden ser
 * diferentes.)
 */
public class IntroduceNullObject {

	class Person_v1 {

		private String name;

		private MailAddress_v1 mailAddress;

		public MailAddress_v1 getMailAddress() {
			return mailAddress;
		}

		public void setMail(MailAddress_v1 mailAddress) {
			this.mailAddress = mailAddress;
		}

		// ..
	}

	static class MailAddress_v1 implements MailAddress {

		private final String userName;

		private final String domain;

		public MailAddress_v1(String userName, String domain) {
			this.userName = userName;
			this.domain = domain;
		}

		public static MailAddress from(String aString) {
			return new MailAddress_v1(parseUserNameFrom(aString), parseDomainFrom(aString));
		}

		@Override
		public String toString() {
			return userName + "@" + domain;
		}

		@Override
		public String getUserName() {
			return userName;
		}

		@Override
		public String getDomain() {
			return domain;
		}

		private static String parseDomainFrom(String aString) {
			throw new UnsupportedOperationException();
		}

		private static String parseUserNameFrom(String aString) {
			throw new UnsupportedOperationException();
		}

	}

	public interface MailAddress {
		String getUserName();

		String getDomain();
	}

	class AboutPersonWindow_v1 {

		private JTextField mailAddressTextField;
		private JTextField nameTextField;

		private Person_v1 person;

		public void render() {
			// ...
			nameTextField.setText(person.name);

			if (person.getMailAddress() != null) {
				mailAddressTextField.setText(person.getMailAddress().toString());
			}

			// ...
		}

	}

	class XMLExporter_v1 {

		private List<Person_v1> persons;

		public void export() {
			// ...

			for (Person_v1 person : persons) {
				print("<person>");
				// ..

				print("<mailAddress>");
				if (person.getMailAddress() != null) {
					print(person.getMailAddress().toString());
				} else {
					print("-");
				}
				print("</mailAddress>");

				// ..
				print("</person>");
			}

			// ...

		}

		private void print(String aString) {
			// ...
		}
	}

	// con nullobject

	class Person_v2 {

		private String name;

		private MailAddress mailAddress = new NullMailAddress();

		public MailAddress getMailAddress() {
			return mailAddress;
		}

		public void setMail(MailAddress mailAddress) {
			this.mailAddress = mailAddress;
		}

		// ..
	}

	class NullMailAddress implements MailAddress {

		@Override
		public String toString() {
			return "-";
		}

		@Override
		public String getUserName() {
			return "-";
		}

		@Override
		public String getDomain() {
			return "-";
		}

	}

	class AboutPersonWindow_v2 {

		private JTextField mailAddressTextField;
		private JTextField nameTextField;

		private Person_v2 person;

		public void render() {
			// ...
			nameTextField.setText(person.name);

			mailAddressTextField.setText(person.getMailAddress().toString());

			// ...
		}

	}

	class XMLExporter_v2 {

		private List<Person_v2> persons;

		public void export() {
			// ...

			for (Person_v2 person : persons) {
				print("<person>");
				// ..

				print("<mailAddress>");
				print(person.getMailAddress().toString());
				print("</mailAddress>");

				// ..
				print("</person>");
			}

			// ...

		}

		private void print(String aString) {
			// ...
		}
	}

}
