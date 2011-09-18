/**
 * 
 */
package ar.edu.unq;

/**
 * @author diego
 * 
 */
public interface Repository {

    void persists(Object object) throws RepositoryException;

    void rollback();

}
