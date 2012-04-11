package ar.edu.unq.wannaplay;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class ClientSoapClient extends SoapClient {

    public static void main(final String args[]) {

        try {
            SOAPMessage message = getSoapMessage();
            SOAPBody body = getBody(message);

            // numberOfClients(body);
            addClient(body, "pepina", "pepi@shemale.com", "545 evergreen st",
            "spring");
            //getAll(body);
            message.saveChanges();

            SOAPMessage reply = sendMessage(message, "clientService");
            System.out.println(getReplyText(reply));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected static void numberOfClients(final SOAPBody body) throws SOAPException {
        body.addChildElement("numberOfClients", WS, WS_XML);
    }

    protected static void getAll(final SOAPBody body) throws SOAPException {
        body.addChildElement("getAll", WS, WS_XML);
    }

    protected static void addClient(final SOAPBody body, final String name, final String email, final String address,
            final String town) throws SOAPException {
        SOAPElement bodyElement = body.addChildElement("addClient", WS, WS_XML);
        bodyElement.addChildElement("arg0").addTextNode(name);
        bodyElement.addChildElement("arg1").addTextNode(email);
        bodyElement.addChildElement("arg2").addTextNode(address);
        bodyElement.addChildElement("arg3").addTextNode(town);
    }
}
