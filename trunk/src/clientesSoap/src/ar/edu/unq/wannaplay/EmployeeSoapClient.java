package ar.edu.unq.wannaplay;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class EmployeeSoapClient extends SoapClient {

    public static void main(final String args[]) {

        try {
            // Next, create the actual message
            SOAPMessage message = getSoapMessage();
            // Create objects for the message parts
            SOAPBody body = getBody(message);

            // addEmployee(body, "34", "sasa", "123 sasa st",
            // "fede@shemale.com", "4261-4525", "UNQ", "mieres", "fede");
            addMediumSkill(body, "35156460", "soap");

            message.saveChanges();
            // SOAPMessage reply =
            sendMessage(message, "employeeService");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static SOAPElement addMediumSkill(final SOAPBody body, final String id, final String skill)
            throws SOAPException {
        SOAPElement bodyElement = body.addChildElement("addMediumSkillToEmployee", WS, WS_XML);
        bodyElement.addChildElement("arg0").addTextNode(id);
        bodyElement.addChildElement("arg1").addTextNode(skill);

        return bodyElement;
    }

    protected static SOAPElement addEmployee(final SOAPBody body, final String id, final String town,
            final String address, final String mail, final String tel, final String uni, final String surname,
            final String name) throws SOAPException {
        SOAPElement bodyElement = body.addChildElement("addEmployee", WS, WS_XML);
        bodyElement.addChildElement("arg0").addTextNode(name);
        bodyElement.addChildElement("arg1").addTextNode(id);
        bodyElement.addChildElement("arg2").addTextNode(surname);
        bodyElement.addChildElement("arg3").addTextNode(tel);
        bodyElement.addChildElement("arg4").addTextNode(uni);
        bodyElement.addChildElement("arg5").addTextNode(mail);
        bodyElement.addChildElement("arg6").addTextNode(address);
        bodyElement.addChildElement("arg7").addTextNode(town);
        return bodyElement;
    }
}
