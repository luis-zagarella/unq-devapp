package ar.edu.unq.services;

public interface CRUDUpdateService<T> extends CRUDRetriveService<T> {

	public void update(T object);

}
