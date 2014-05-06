package fr.treeptik.model2;

import javax.persistence.Entity;

@Entity
public class Book extends Article
{
	private static final long serialVersionUID = 1L;

	private Integer nbPages;

	public Integer getNbPages()
	{
		return nbPages;
	}

	public void setNbPages(Integer nbPages)
	{
		this.nbPages = nbPages;
	}

	@Override
	public String toString()
	{
		return "Book [nbPages=" + nbPages + "] " + super.toString();
	}
}
