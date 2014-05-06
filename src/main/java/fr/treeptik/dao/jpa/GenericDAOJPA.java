package fr.treeptik.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model2.GenericModel;

public abstract class GenericDAOJPA<E extends GenericModel<K> , K> implements GenericDAO<E , K>
{
	@PersistenceContext
	protected EntityManager entityManager;

	private Class<E> type;

	public GenericDAOJPA(Class<E> type)
	{
		this.type = type;
	}

	@Override
	public E save(E entity) throws DAOException
	{
		try
		{
			entityManager.persist(entity);
		}

		catch (PersistenceException e)
		{
			throw new DAOException(type.getName() + " wasn't save correctly.");
		}

		return entity;
	}

	@Override
	public E update(E entity) throws DAOException
	{
		try
		{
			entity = entityManager.merge(entity);
		}

		catch (PersistenceException e)
		{
			throw new DAOException(type.getName() + " wasn't update correctly.");
		}

		return entity;
	}

	@Override
	public void remove(E entity) throws DAOException
	{
		try
		{
			entityManager.remove(entity);
		}

		catch (PersistenceException e)
		{
			throw new DAOException(type.getName() + " wasn't delete correctly.");
		}
	}

	@Override
	public E findById(K id) throws DAOException
	{
		E result = null;

		try
		{
			result = entityManager.find(type, id);
		}

		catch (PersistenceException e)
		{
			throw new DAOException("Person wasn't find correctly.");
		}

		return result;
	}

	@Override
	public List<E> findAll() throws DAOException
	{
		List<E> resultList = null;
		try
		{
			TypedQuery<E> q = entityManager.createQuery("select t from " + type.getName() + " t",
					type);
			resultList = q.getResultList();
		}

		catch (PersistenceException e)
		{
			throw new DAOException("Can't retrieve the list of Person.");
		}

		return resultList;
	}
}
