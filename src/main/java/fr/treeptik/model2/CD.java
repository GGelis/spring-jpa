package fr.treeptik.model2;

import javax.persistence.Entity;

@Entity
public class CD extends Article
{
	private static final long serialVersionUID = 1L;

	private Integer duration;

	public Integer getDuration()
	{
		return duration;
	}

	public void setDuration(Integer duration)
	{
		this.duration = duration;
	}

	@Override
	public String toString()
	{
		return "CD [duration=" + duration + "] " + super.toString();
	}
}
