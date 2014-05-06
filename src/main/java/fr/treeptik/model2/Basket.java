package fr.treeptik.model2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Basket extends GenericModel<Integer> implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Client client;
	
	@ManyToMany
	private List<Article> articles;

	@Temporal(value = TemporalType.DATE)
	private Date deliveryDate;

	public List<Article> getArticles()
	{
		return articles;
	}

	public void setArticles(List<Article> articles)
	{
		this.articles = articles;
	}

	public Date getDeliveryDate()
	{
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}

	@Override
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Basket [id=" + id + ", deliveryDate=" + deliveryDate + "]";
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}
}
