package com.study.springcore.case08;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonController {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		PersonController personController = ctx.getBean("personController", PersonController.class);
		
		//personController.printAllPersons();
		
		//personController.addPerson("Bob", 2013, 12, 26);
		
		//personController.printAllPersons();
		
		
		//String name="momo";
		//if(personController.getPersonByName("name").equals(name)) {
		System.out.println(personController.getPersonByName("Mary"));
		
		
	}

}