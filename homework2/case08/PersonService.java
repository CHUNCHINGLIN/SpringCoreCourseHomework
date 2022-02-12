package com.study.springcore.case08;

import java.util.Date;
import java.util.List;

public interface PersonService {
	boolean append(String name, Date birth);
	boolean append(Person person);
	List<Person> findAllPersons();
	Person getPerson(String name);
	boolean delete(String name);
	boolean modifyBirth(String name, int yyyy ,int MM , int dd);
}