package fr.treeptik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.treeptik.dao.BasketDAO;
import fr.treeptik.model2.Basket;

@Service
public class BasketService extends GenericService<BasketDAO, Basket, Integer>
{
	@Autowired
	private BasketDAO basketDAO;
	
	@Override
	public BasketDAO getGenericDAO()
	{
		return basketDAO;
	}
}
