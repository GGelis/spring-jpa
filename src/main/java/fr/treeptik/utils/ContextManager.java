package fr.treeptik.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextManager
{
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
	
	public static ClassPathXmlApplicationContext getContext()
	{
		return context;
	}
	
	public static void close()
	{
		context.close();
	}	
}
