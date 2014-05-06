package fr.treeptik.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.model2.Article;

@Repository
public class ArticleDAOJPA extends GenericDAOJPA<Article, Integer> implements ArticleDAO
{
	public ArticleDAOJPA()
	{
		super(Article.class);
	}
}
