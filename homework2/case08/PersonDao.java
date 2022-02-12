package com.study.springcore.case08;

import java.util.Date;
import java.util.List;

public interface PersonDao {
	// 建立 Person
	public boolean create(Person person);
	// 查詢所有 Person
	public List<Person> readAll();
	//刪除
	public boolean delete(String name);
	public boolean modifyBirth(String name,  int yyyy ,int MM , int dd);
}