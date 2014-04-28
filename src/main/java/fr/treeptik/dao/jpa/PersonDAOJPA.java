package fr.treeptik.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.PersonDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Person;

@Repository
public class PersonDAOJPA implements PersonDAO
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public Person save(Person person) throws DAOException
	{
		try
		{
			entityManager.persist(person);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException("Person wasn't save correctly.");
		}
		
		return person;
	}

	@Override
	public Person update(Person person) throws DAOException
	{
		try
		{
			person = entityManager.merge(person);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException("Person wasn't update correctly.");
		}
		
		return person;
	}

	@Override
	public void remove(Person person) throws DAOException
	{
		try
		{
			entityManager.remove(person);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException("Person wasn't delete correctly.");
		}	
	}

	@Override
	public Person findById(Integer id) throws DAOException
	{
		Person result = null;
		
		try
		{
			result = entityManager.find(Person.class, id);
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException("Person wasn't find correctly.");
		}
		
		return result;
	}

	@Override
	public List<Person> findAll() throws DAOException
	{
		List<Person> resultList = null;
		try
		{
			TypedQuery<Person> q = entityManager.createQuery("select * from Person p",Person.class);
			resultList = q.getResultList();
		}
		
		catch(PersistenceException e)
		{
			throw new DAOException("Can't retrieve the list of Person.");
		}
		
		return resultList;
	}
}
