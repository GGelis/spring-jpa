package fr.treeptik.model2;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client extends GenericModel<Integer> implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName, lastName;
	private String address;

	@OneToMany(mappedBy = "client")
	private List<Basket> baskets;

	@Override
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public List<Basket> getBaskets()
	{
		return baskets;
	}

	public void setBaskets(List<Basket> baskets)
	{
		this.baskets = baskets;
	}

	@Override
	public String toString()
	{
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}
}
