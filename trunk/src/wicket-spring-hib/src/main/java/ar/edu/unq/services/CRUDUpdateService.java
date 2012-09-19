package ar.edu.unq.services;

public interface CRUDUpdateService<T> extends CRUDRetriveService<T> {

	void update(T object);

}
