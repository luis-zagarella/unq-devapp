package ar.edu.unq;

public class Notifier_AcopladoPorMetodoStatico {

    private final MailSender mailSender;

    public Notifier_AcopladoPorMetodoStatico() {
        mailSender = MyMailSender.getInstance();
        // o por ejemplo
        // mailSender = ApplicationContext.mailSender();
    }

}
