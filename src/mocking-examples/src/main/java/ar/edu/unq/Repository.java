/**
 * 
 */
package ar.edu.unq;

/**
 * @author Cristian
 * 
 */
public interface Repository {

    void persists(Object object) throws RepositoryException;

    void rollback();

}
