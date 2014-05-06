package fr.treeptik.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model2.GenericModel;

public abstract class GenericService<T extends GenericDAO<E, K>, E extends GenericModel<K>, K>
{	
	public abstract T getGenericDAO();

	@Transactional
	public E save(E entity) throws ServiceException
	{
		try
		{
			return getGenericDAO().save(entity);
		}

		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public E update(E entity) throws ServiceException
	{
		try
		{
			return getGenericDAO().update(entity);
		}

		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public E remove(E entity) throws ServiceException
	{
		try
		{
			 entity = getGenericDAO().findById(entity.getId());
			getGenericDAO().remove(entity);
			entity = null;
		}

		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
		
		return entity;
	}

	public E findById(K id) throws ServiceException
	{
		try
		{
			return getGenericDAO().findById(id);
		}

		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<E> findAll() throws ServiceException
	{
		try
		{
			return getGenericDAO().findAll();
		}

		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
