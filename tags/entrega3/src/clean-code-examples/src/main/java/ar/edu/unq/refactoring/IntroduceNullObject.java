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

        public void setMail(final MailAddress_v1 mailAddress) {
            this.mailAddress = mailAddress;
        }

        // ..
    }

    static class MailAddress_v1 implements MailAddress {

        private final String userName;

        private final String domain;

        public MailAddress_v1(final String userName, final String domain) {
            this.userName = userName;
            this.domain = domain;
        }

        public static MailAddress from(final String aString) {
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

        private static String parseDomainFrom(final String aString) {
            throw new UnsupportedOperationException();
        }

        private static String parseUserNameFrom(final String aString) {
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
                this.print("<person>");
                // ..

                this.print("<mailAddress>");
                if (person.getMailAddress() != null) {
                    this.print(person.getMailAddress().toString());
                } else {
                    this.print("-");
                }
                this.print("</mailAddress>");

                // ..
                this.print("</person>");
            }

            // ...

        }

        private void print(final String aString) {
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

        public void setMail(final MailAddress mailAddress) {
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
                this.print("<person>");
                // ..

                this.print("<mailAddress>");
                this.print(person.getMailAddress().toString());
                this.print("</mailAddress>");

                // ..
                this.print("</person>");
            }

            // ...

        }

        private void print(final String aString) {
            // ...
        }
    }

}
