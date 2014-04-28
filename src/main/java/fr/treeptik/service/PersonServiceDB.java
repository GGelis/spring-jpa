package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.PersonDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Person;

@Service
public class PersonServiceDB implements PersonService
{
	@Autowired
	private PersonDAO personDAO;
	
	@Override
	@Transactional
	public Person save(Person person) throws ServiceException
	{
		try
		{
			personDAO.save(person);
		}
		
		catch(DAOException e)
		{
			throw new ServiceException("Person wasn't save correctly.");
		}
		
		return person;
	}

	@Override
	@Transactional
	public Person update(Person person) throws ServiceException
	{
		try
		{
			person = personDAO.update(person);
		}
		
		catch(DAOException e)
		{
			throw new ServiceException("Person wasn't update correctly.");
		}
		
		return person;
	}

	@Override
	@Transactional
	public void remove(Person person) throws ServiceException
	{
		try
		{
			person = findById(person.getId());
			personDAO.remove(person);
		}
		
		catch(DAOException e)
		{
			throw new ServiceException("Person wasn't remove correctly.");
		}	
	}

	@Override
	@Transactional
	public Person findById(Integer id) throws ServiceException
	{
		Person result = null;
		
		try
		{
			result = personDAO.findById(id);
		}
		
		catch(DAOException e)
		{
			throw new ServiceException("Person wasn't find correctly.");
		}
		
		return result;
	}

	@Override
	@Transactional
	public List<Person> findAll() throws ServiceException
	{
		List<Person> result = null;
		
		try
		{
			result = personDAO.findAll();
		}
		
		catch(DAOException e)
		{
			throw new ServiceException("Can't retrieve the list of Person.");
		}
		
		return result;
	}
}
