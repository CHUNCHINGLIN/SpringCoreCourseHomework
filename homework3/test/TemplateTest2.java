package com.study.springcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		int rowcount = 0;
		int[] rowcounts = null;
		// 測試單筆新增 I
		//rowcount = empDao.addOne1("test5", 18);
		//System.out.println("測試單筆新增 I: " + rowcount);
		// 測試單筆新增 II
		//rowcount = empDao.addOne2("test6", 19);
		//System.out.println("測試單筆新增 II: " + rowcount);
		
		// 測試多筆新增 I
		/*
		List<Object[]> rows = new ArrayList<>();
		rows.add(new Object[] {"Jo2", 20});
		rows.add(new Object[] {"Mark2", 21});
		rows.add(new Object[] {"Vincent2", 22});
		rowcounts = empDao.multiAdd1(rows);
		System.out.println("測試多筆新增 I: " + Arrays.toString(rowcounts));
		**/
		// 測試多筆新增 II
		/*
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("Bobo2", 25));
		emps.add(new Emp("Bob", 26));
		emps.add(new Emp("Alice", 27));
		rowcounts = empDao.multiAdd2(emps);
		System.out.println("測試多筆新增 II: " + Arrays.toString(rowcounts));
		**/
		// 測試修改
		//rowcount = empDao.updateById(1, "Tom", 34);
		//System.out.println("測試-測試修改 I: " + rowcount);
		// 測試刪除
		//rowcount = empDao.deleteById(6);
		//System.out.println("測試-測試刪除 I: " + rowcount);
	}
}
