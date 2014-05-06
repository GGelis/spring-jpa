package fr.treeptik.model2;

import javax.persistence.Entity;

@Entity
public class DVD extends Article
{
	private static final long serialVersionUID = 1L;
	
	private String format;

	public String getFormat()
	{
		return format;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	@Override
	public String toString()
	{
		return "DVD [format=" + format + "] " + super.toString();
	}
}
