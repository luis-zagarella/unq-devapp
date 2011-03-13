/**
 * 
 */
package com.hexacta.hat.mockingexamples;

/**
 * @author diego
 * 
 */
public interface Repository {

    void persists(Object object) throws RepositoryException;

    void rollback();

}
