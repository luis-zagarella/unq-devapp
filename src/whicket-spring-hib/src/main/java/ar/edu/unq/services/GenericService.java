package ar.edu.unq.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.repositories.GenericRepository;

public class GenericService<T> implements CRUDUpdateService<T>,
		CRUDCreateService<T>, CRUDDeleteService<T>, CRUDRetriveService<T>,
		Serializable {

	private static final long serialVersionUID = -6540963495078524186L;
	private GenericRepository<T> repository;

	@Override
	@Transactional(readOnly = true)
	public void delete(final T object) {
		this.getRepository().delete(object);
	}

	public GenericRepository<T> getRepository() {
		return this.repository;
	}

	@Override
	@Transactional
	public List<T> retriveAll() {
		return this.getRepository().findAll();
	}

	@Override
	@Transactional
	public void save(final T object) {
		this.getRepository().save(object);
	}

	public void setRepository(final GenericRepository<T> repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public void update(final T object) {
		this.getRepository().update(object);
	}

}
