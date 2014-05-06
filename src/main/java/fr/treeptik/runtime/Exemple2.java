package fr.treeptik.runtime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model2.Article;
import fr.treeptik.model2.Basket;
import fr.treeptik.model2.Book;
import fr.treeptik.model2.CD;
import fr.treeptik.model2.Client;
import fr.treeptik.model2.DVD;
import fr.treeptik.service.ArticleService;
import fr.treeptik.service.BasketService;
import fr.treeptik.service.ClientService;
import fr.treeptik.utils.ContextManager;


public class Exemple2
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = ContextManager.getContext();
		Logger logger = Logger.getLogger(Exemple2.class);
		
		ArticleService articleService = context.getBean(ArticleService.class);
		BasketService orderService = context.getBean(BasketService.class);
		ClientService clientService = context.getBean(ClientService.class);
		
		DVD dvd = new DVD();
		dvd.setCost(10);
		dvd.setFormat("BLU-RAY");
		dvd.setTitle("Chasse aux trolls");
		
		CD cd = new CD();
		cd.setCost(5);
		cd.setDuration(90);
		cd.setTitle("Musique de merde");
		
		Book book = new Book();
		book.setCost(1);
		book.setNbPages(105);
		book.setTitle("Cuisine pour les nuls");
		
		Basket basket = new Basket();
		basket.setDeliveryDate(new Date());
		List<Article> articles = new ArrayList<Article>();
		basket.setArticles(articles);
		
		Client client = new Client();
		client.setAddress("18 rue des trolls");
		client.setFirstName("Tu");
		client.setLastName("Troll");
		List<Basket> baskets = new ArrayList<Basket>();
		client.setBaskets(baskets);
			
		try
		{
			// Save
			dvd = (DVD) articleService.save(dvd);
			cd = (CD) articleService.save(cd);
			book = (Book) articleService.save(book);
			client = (Client) clientService.save(client);
			basket.getArticles().add(dvd);
			basket.getArticles().add(cd);
			basket.getArticles().add(book);
			basket.setClient(client);
			basket = (Basket) orderService.save(basket);
			client.getBaskets().add(basket);
			client.setFirstName("Alo");
			client = clientService.update(client);
			
			// Affichage des tables
			List<Article> articleTable = articleService.findAll();

			for(Article a : articleTable)
					logger.info(a.toString());
		}
		
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		
		context.close();
	}
}
