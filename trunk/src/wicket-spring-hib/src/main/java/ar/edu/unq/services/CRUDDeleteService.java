package ar.edu.unq.services;

public interface CRUDDeleteService<T> extends CRUDRetriveService<T> {
	 void delete(T object);
}
