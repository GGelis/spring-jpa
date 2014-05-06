package fr.treeptik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.model2.Client;

@Service
public class ClientService extends GenericService<ClientDAO, Client, Integer>
{
	@Autowired
	private ClientDAO clientDAO;

	@Override
	public ClientDAO getGenericDAO()
	{
		return clientDAO;
	}
}

