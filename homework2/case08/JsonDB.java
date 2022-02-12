package com.study.springcore.case08;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class JsonDB { // Json 資料庫
	
	@Autowired
	private Gson gson;
	
	// Json file 資料庫存放地
	private static final Path PATH = Paths.get("src/main/java/com/study/springcore/case08/person.json");
	
	// 查詢全部
	public List<Person> queryAll() throws Exception {
		//String jsonStr = Files.readAllLines(PATH).stream().collect(Collectors.joining());
		String jsonStr = Files.lines(PATH).collect(Collectors.joining());
		Type type = new TypeToken<ArrayList<Person>>() {}.getType();
		List<Person> people = gson.fromJson(jsonStr, type);
		// 請將 age 變為最新年齡
		/*
		Date today = new Date();
		LocalDate todayLocalDate = today.toInstant()
									.atZone(ZoneId.systemDefault())
									.toLocalDate();
		for(Person person : people) {
			LocalDate birthLocalDate = person.getBirth().toInstant()
									.atZone(ZoneId.systemDefault())
									.toLocalDate();
			int age = todayLocalDate.getYear() - birthLocalDate.getYear();
			person.setAge(age);
		}
		*/
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int todayYear = calendar.get(Calendar.YEAR);
		for(Person person : people) {
			calendar.setTime(person.getBirth());
			int biythYear = calendar.get(Calendar.YEAR);
			int age = todayYear - biythYear;
			person.setAge(age);
		}
		return people;
	}
	
	public boolean add(Person person) throws Exception {
		List<Person> people = queryAll();
		/* 作業 1:
			如果 person 已存在則 return false
		 	name, age, birth 皆與目前資料庫某一 person 資料相同
		**/
		//用stream的anyMatch()分析，回傳boolean
		boolean present=people.stream()
							  .anyMatch(a->person.getName().equals(a.getName())
										&& person.getAge().equals(a.getAge())
										&& person.getBirth().equals(a.getBirth()));					
		if(present) {
			System.out.println("repeat");
			return false;
			
		}else {
			people.add(person);
			//將新增的資料寫回原json檔
			String newJsonString = gson.toJson(people);
			Files.write(PATH, newJsonString.getBytes("UTF-8"));
			return true;
		}
		}
		//修改
		public boolean modifyBirth(String name,  int yyyy ,int MM , int dd) {
	    	boolean check=false;
	    	List<Person> people;
			try {
				people = queryAll();
				Person person=new Person();
				person.setName(name);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date birth = sdf.parse(yyyy + "/" + MM + "/" + dd);
				person.setBirth(birth);
				
				for(int i=0 ; i<people.size() ; i++) {
					if(people.get(i).getName().equals(name)) {
						people.set(i, person);
						check=true;
					}
				}
				String newJsonString = gson.toJson(people);
				Files.write(PATH, newJsonString.getBytes("UTF-8"));
				return check;
				} catch (Exception e) {
					e.printStackTrace();
			}
			return check;
	    }
	
	
		
		//刪除
		public boolean delete(String name) throws Exception {
			List<Person> people=queryAll();
			List<Person> peopleDelete = queryAll().stream()
											.filter(a->name.equals(a.getName()))
											.collect(Collectors.toList());
			if(peopleDelete.size()!=0) {		
			for(int i=0 ; i<peopleDelete.size() ; i++) {
				people.remove(peopleDelete.get(i));
			}				
				String newJsonString = gson.toJson(people);
				Files.write(PATH, newJsonString.getBytes("UTF-8"));
				return true;
				
			}else {
				return false;
			}
		
		
	
	}
}