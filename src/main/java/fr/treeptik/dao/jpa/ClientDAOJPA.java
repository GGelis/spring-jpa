package fr.treeptik.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.model2.Client;

@Repository
public class ClientDAOJPA extends GenericDAOJPA<Client, Integer> implements ClientDAO
{
	public ClientDAOJPA()
	{
		super(Client.class);
	}
}
