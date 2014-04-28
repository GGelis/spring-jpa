package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Person;

public interface PersonDAO
{
	public Person save(Person person) throws DAOException;
	public Person update(Person person) throws DAOException;
	public void remove(Person person) throws DAOException;
	public Person findById(Integer id) throws DAOException;
	public List<Person> findAll() throws DAOException;
}
