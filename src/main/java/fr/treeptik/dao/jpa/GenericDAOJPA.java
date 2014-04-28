package fr.treeptik.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;

@Repository
public abstract class GenericDAOJPA<T, K> implements GenericDAO<T, K>
{
	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> type;
	
	public GenericDAOJPA(Class<T> type)
	{
		this.type = type;
	}
	
	public T save(T entity) throws DAOException
	{
		try
		{
			entityManager.persist(entity);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException(type.getName()+" wasn't save correctly.");
		}
		
		return entity;
	}

	@Override
	public T update(T entity) throws DAOException
	{
		try
		{
			entity = entityManager.merge(entity);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException(type.getName()+" wasn't update correctly.");
		}
		
		return entity;
	}

	@Override
	public void remove(T entity) throws DAOException
	{
		try
		{
			entityManager.remove(entity);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException(type.getName()+" wasn't delete correctly.");
		}	
	}

	@Override
	public T findById(K id) throws DAOException
	{
		T result = null;
		
		try
		{
			result = entityManager.find(type, id);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException("Person wasn't find correctly.");
		}
		
		return result;
	}

	@Override
	public List<T> findAll() throws DAOException
	{
		List<T> resultList = null;
		try
		{
			TypedQuery<T> q = entityManager.createQuery("select * from "+type.getName()+" t",type);
			resultList = q.getResultList();
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException("Can't retrieve the list of Person.");
		}
		
		return resultList;
	}
}
