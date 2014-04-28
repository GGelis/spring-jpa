package fr.treeptik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Person;

@Service
public interface PersonService
{
	Person save(Person person) throws ServiceException;
	public Person update(Person person) throws ServiceException;
	public void remove(Person person) throws ServiceException;
	public Person findById(Integer id) throws ServiceException;
	public List<Person> findAll() throws ServiceException;
}