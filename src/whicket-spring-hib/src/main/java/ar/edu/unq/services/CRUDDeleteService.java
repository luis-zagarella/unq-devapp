package ar.edu.unq.services;

public interface CRUDDeleteService<T> extends CRUDRetriveService<T> {
	public void delete(T object);
}
