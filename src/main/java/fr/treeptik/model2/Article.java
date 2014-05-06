package fr.treeptik.model2;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Article extends GenericModel<Integer> implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "my_generator")
	@TableGenerator(name = "my_generator", initialValue = 1, allocationSize = 1)
	private Integer id;
	
	private Integer cost;
	private String title;

	public Integer getCost()
	{
		return cost;
	}

	public void setCost(Integer cost)
	{
		this.cost = cost;
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

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@Override
	public String toString()
	{
		return "Article [id=" + id + ", cost=" + cost + ", title=" + title + "]";
	}
}
