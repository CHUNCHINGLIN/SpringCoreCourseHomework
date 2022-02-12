package com.study.springcore.case05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext5.xml");
		
		Student john=ctx.getBean("s1",Student.class);
		System.out.println(john);
		
		Student mary=ctx.getBean("s2",Student.class);
		System.out.println(mary);
		
		Teacher t1=ctx.getBean("t1",Teacher.class);
		System.out.println(t1);
		
		Teacher t2=ctx.getBean("t2",Teacher.class);
		System.out.println(t2);
		
		//Who are Mary's teachers?
	
		Set<Teacher> teacher2 =new LinkedHashSet<>();
		
		//Clazzs that mary has
		System.out.println(mary.getClazzs());
		
		Teacher[] teachers= {ctx.getBean("t1",Teacher.class),ctx.getBean("t2",Teacher.class)};
		
		
		for(Teacher teacher:teachers) {
			clazz_loop:
			for(Clazz cla1: teacher.getClazzs()) {
				for(Clazz cla2: mary.getClazzs()) {
					if(cla1.getId()==cla2.getId()) {
						//System.out.println(teacher.getName());
						teacher2.add(teacher);
						break clazz_loop;
					}
				}
			}
		}
		
		
		System.out.println(mary.getName()+"'s teacher:"+teacher2);
		System.out.println(mary.getName()+"'s teacher:"+teacher2.stream()
																.map(a->a.getName())
																.collect(Collectors.toSet()));
		
		
		
		
		//建立一個Map綁定課程Id及teacher name
		Map<Integer,String> map=new HashMap<>();
		map.put(101,t1.getName());
		map.put(102,t2.getName());
		map.put(103,t1.getName());
		map.put(104,t1.getName());
		
		//用stream回傳mary修的所有課程id的List
		List<Integer> maryId=Stream.of(mary)
									.flatMap(a->a.getClazzs().stream())
									.map(a->a.getId())
									.collect(Collectors.toList());
		//用stream回傳teachers開的所有課程的List					
		Set<Clazz> teachersId=Arrays.stream(teachers)
										.flatMap(b->b.getClazzs().stream())
										.collect(Collectors.toSet());	
		//比對並回傳相同的課程Id
		List<Integer> sameId=teachersId.stream()
										.filter(c->maryId.contains(c.getId()))
										.map(c->c.getId())
										.collect(Collectors.toList());
		//用課程Id去比對Map中開對應課程的teacher name
		System.out.print("Mary's teachers : ");
		map.keySet().stream()
					.filter(d->sameId.contains(d))
					.map(d->map.get(d))
					.distinct() //以防有重複的值
					.forEach(d->System.out.print(d+" "));
				
				
	
		
		
				
		
		
		
		
		
		
		
		
		
	}
	

}
