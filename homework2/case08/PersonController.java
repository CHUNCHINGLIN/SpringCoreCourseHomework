package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * 功能:
 * 1. 建立 Person 資料
 * 		-> 輸入 name, birth
 * 2. 取得 Person 全部資料
 * 		-> 不用輸入參數
 * 3. 根據姓名取得 Person
 * 		-> 輸入 name
 * 4. 取得今天生日的 Person
 * 		-> 輸入今天日期
 * 5. 取得某一歲數以上的 Person
 * 		-> 輸入 age
 * 6. 根據姓名來修改Person的生日
 * 		-> 輸入 name, birth
 * 7. 根據姓名來刪除Person
 * 		-> 輸入 name
 * */

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	public void addPerson(String name, int yyyy, int mm, int dd) {
		// 1. 判斷 name, yyyy, mm 與 dd 是否有資料?
		// 2. 將 yyyy/mm/dd 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth = sdf.parse(yyyy + "/" + mm + "/" + dd);
			addPerson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPerson(String name, Date birth) {
		// 1. 判斷 name 與 birth 是否有資料?
		// 2. 建立 Person 資料
		Person person=new Person();
		person.setName(name);
		person.setBirth(birth);
		boolean check = personService.append(person);
		System.out.println("add person: " + check);
	}
	
	public void printAllPersons() {
		//System.out.println(personService.findAllPersons());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// 資料呈現
		List<Person> people = personService.findAllPersons();
		System.out.println("+--------------+---------+--------------+");
		System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
		System.out.println("+--------------+---------+--------------+");
		for(Person p : people) {
			String birthday = sdf.format(p.getBirth());
			System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
			System.out.println("+--------------+---------+--------------+");
		}
	}
	
	// 根據姓名取得 Person
	public Person getPersonByName(String name) {
		// 1. 判斷 name ?
		// 2. 根據姓名取得 Person
		Person person = personService.getPerson(name);
		return person;
	}
	
	public List<Person> getTodayBirthdayPerson() {
		int month=new Date().getMonth();
		int day=new Date().getDate();
		return personService.findAllPersons()
							.stream()
							.filter(a->a.getBirth().getMonth()==month) 
							.filter(a->a.getBirth().getDate()==day)
							.collect(Collectors.toList());
	}
	
	public List<Person> getAgeGreater(int age){
		return personService.findAllPersons()
					.stream()
					.filter(a->a.getAge()>age)
					.collect(Collectors.toList());
					
	}
	
	//修改
	public void modifyBirth(String name, int yyyy ,int MM , int dd) {
		
		if(personService.modifyBirth(name, yyyy , MM ,  dd)){
			System.out.println("修改完成");
		}else {
			System.out.println("沒有此姓名，無法修改");
		}
		
		
	}
	
	//刪除
	public boolean delete(String name) {
		return personService.delete(name);
		
	}
	
	
}