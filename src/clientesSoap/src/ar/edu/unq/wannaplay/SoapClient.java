package ar.edu.unq.wannaplay;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.DOMException;

public abstract class SoapClient {

    protected static final String WEBSERVICE = "http://localhost:8080/wp/soap/";

    protected static final String WS = "ws";

    protected static final String WS_XML = "http://ws.wannaplay.unq.edu.ar/";

    protected static SOAPMessage sendMessage(final SOAPMessage message, final String service) throws SOAPException {
        SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnFactory.createConnection();

        SOAPMessage reply = connection.call(message, WEBSERVICE + service);
        connection.close();
        return reply;
    }

    protected static SOAPBody getBody(final SOAPMessage message) throws SOAPException {
        SOAPPart soapPart = message.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPBody body = envelope.getBody();
        return body;
    }

    protected static SOAPMessage getSoapMessage() throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage message = messageFactory.createMessage();
        return message;
    }

    protected static String getReplyText(final SOAPMessage reply) throws DOMException, SOAPException {
        return reply.getSOAPBody().getFirstChild().getTextContent();
    }

}
