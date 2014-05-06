package fr.treeptik.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.BasketDAO;
import fr.treeptik.model2.Basket;

@Repository
public class BasketDAOJPA extends GenericDAOJPA<Basket, Integer> implements BasketDAO
{
	public BasketDAOJPA()
	{
		super(Basket.class);
	}
}
