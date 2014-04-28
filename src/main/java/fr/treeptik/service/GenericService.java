package fr.treeptik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.treeptik.exception.ServiceException;

@Service
public interface GenericService<T, K>
{
	T save(T person) throws ServiceException;
	public T update(T person) throws ServiceException;
	public void remove(T person) throws ServiceException;
	public T findById(K id) throws ServiceException;
	public List<T> findAll() throws ServiceException;
}
