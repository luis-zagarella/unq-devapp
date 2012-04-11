package ar.edu.unq;

public class Notifier {

    private final MailSender mailSender;

    public Notifier(final MailSender mailSender) {

        this.mailSender = mailSender;
    }

}
