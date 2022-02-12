package com.study.springcore.jdbc.template;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.study.springcore.jdbc.entity.myLogger;



@Component
@Aspect
@Order(1)
public class EmpAOP {
	
	@Autowired
	myLoggerDao myloggerDao;
	
	@Pointcut(value="execution(* com.study.springcore.jdbc.template.EmpDao.*(..))")	
	public void cut() {}
	
	
	@Before(value="cut()")
	public void before(JoinPoint joinPoint) {
		String method_name=joinPoint.getSignature().getName();
		DateFormat df=new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		String log_time=df.format(new Date());
		//把方法名稱和時間存到資料庫
		myloggerDao.add(method_name,log_time);
		
	}
	
	@After(value="cut()")
	public void after(JoinPoint joinPoint) {
		
		
	}
	/*
	@AfterReturning(value="cut()",returning="result")
	public void afterReturning(Object result) {
		//取出儲存的方法名和時間
		List<myLogger> myLoggers=myLoggerDao.query();
		//排版
		System.out.println("+------------+--------------------+");
		
		
	}
	**/
	
	
	
	
	

	
}
