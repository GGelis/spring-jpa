package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model2.GenericModel;

public interface GenericDAO<E extends GenericModel<K>, K>
{
	public E save(E entity) throws DAOException;
	public E update(E entity) throws DAOException;
	public void remove(E entity) throws DAOException;
	public E findById(K id) throws DAOException;
	public List<E> findAll() throws DAOException;
}
