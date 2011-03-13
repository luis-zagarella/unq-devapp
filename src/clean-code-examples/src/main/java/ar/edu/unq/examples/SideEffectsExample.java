package ar.edu.unq.examples;

import ar.edu.unq.examples.ext.Cryptographer;
import ar.edu.unq.examples.ext.Phrase;
import ar.edu.unq.examples.ext.Session;
import ar.edu.unq.examples.ext.User;

/**
 * @author diego
 * 
 */
public class SideEffectsExample {

    private Cryptographer cryptographer;

    public boolean checkPassword(final User user, final String password) {
        Phrase userCodedPhrase = user.getPhraseEncodedByPassword();

        Phrase phrase = cryptographer.decryp(password);

        if (phrase.sameAs(userCodedPhrase)) {
            Session.initialize();
            return true;
        }

        return false;
    }

}
