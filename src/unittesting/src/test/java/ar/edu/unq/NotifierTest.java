package ar.edu.unq;

import org.junit.Test;

public class NotifierTest {

    /**
     * No quiero mandar mails en este test, quiero testear otra logica del
     * Notifier!
     */
    @Test
    public void notifier1____() throws Exception {
        Notifier_AcopladoPorMetodoStatico notifier = new Notifier_AcopladoPorMetodoStatico();

        // como le cambio el "mailSender" para que no mande mails?
        // ....
        // ....
    }

    /**
     * No quiero mandar mails en este test, quiero testear otra logica del
     * Notifier!
     */
    @Test
    public void notifier2____() throws Exception {
        Notifier_AcopladoPorNew notifier = new Notifier_AcopladoPorNew();

        // como le cambio el "mailSender" para que no mande mails?
        // ....
        // ....
    }

    /**
     * No quiero mandar mails en este test, quiero testear otra logica del
     * Notifier!
     */
    @Test
    public void notifier3____() throws Exception {
        MailSender mailSenderMock = new MailSenderMock();

        Notifier notifier = new Notifier(mailSenderMock);

        // uso el mailSender que me conviene para este test
        // ....
    }

}

class MailSenderMock implements MailSender {

    @Override
    public void send(final Mail mail) {
        // no hago nada por ejemplo.
    }

}
