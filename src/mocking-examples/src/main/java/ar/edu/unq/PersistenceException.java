/**
 * 
 */
package ar.edu.unq;

/**
 * @author diego
 * 
 */
public class PersistenceException extends RuntimeException {

    public PersistenceException(final Throwable e) {
        super(e);
    }

    private static final long serialVersionUID = 3588879762044188819L;

}
