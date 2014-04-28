package fr.treeptik.runtime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.model.Animal;
import fr.treeptik.model.Person;
import fr.treeptik.service.PersonService;

public class Exemple
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		PersonService personService = context.getBean(PersonService.class);
		
		Person p = new Person();
		p.setFirstName("Tu");
		p.setLastName("Troll");
		p.setBirthDate(new Date());
		
		Animal a1 = new Animal();
		a1.setName("Castor");
		Animal a2 = new Animal();
		a2.setName("Lapin");
		
		List<Animal> animalsList = new ArrayList<Animal>();
		animalsList.add(a1);
		animalsList.add(a2);
		p.setAnimaux(animalsList);
		
		try
		{
			personService.save(p);
			
			p = personService.findById(p.getId());
			Animal a10 = new Animal();
			a10.setName("Blaireau");
			Animal a20 = new Animal();
			a20.setName("Lievre");
			List<Animal> animalsList2 = new ArrayList<Animal>();
			animalsList2.add(a10);
			animalsList2.add(a20);
			p.setAnimaux(animalsList2);
			personService.update(p);
		}
		
		catch (Exception e)
		{
			System.out.println("J'tai bien eu !");
		}
		
		context.close();
	}

}
