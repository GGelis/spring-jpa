package fr.treeptik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.model2.Article;

@Service
public class ArticleService extends GenericService<ArticleDAO, Article, Integer>
{
	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public ArticleDAO getGenericDAO()
	{
		return articleDAO;
	}
}
