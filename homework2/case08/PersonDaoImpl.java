package com.study.springcore.case08;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private JsonDB jsonDB;
	
	@Override
	public boolean create(Person person) {
		Boolean check = null;
		try {
			check = jsonDB.add(person);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public List<Person> readAll() {
		List<Person> people = null;
		try {
			people = jsonDB.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return people;
	}

	@Override
	public boolean delete(String name) {
		Boolean check=null;
		try {
			return jsonDB.delete(name);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		
	}

	@Override
	public boolean modifyBirth(String name,  int yyyy ,int MM , int dd) {
		return jsonDB.modifyBirth(name, yyyy,MM,dd);
		
	}
	
}