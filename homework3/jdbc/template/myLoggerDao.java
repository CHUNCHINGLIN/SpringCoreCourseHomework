package com.study.springcore.jdbc.template;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.entity.myLogger;

@Repository
public class myLoggerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//新增
	public int add(String method_name, String log_time) {
		String sql="insert into myLogger(method_name,log_time) values(?,?)";
		int rowcount=jdbcTemplate.update(sql,method_name,log_time);
		return rowcount;	
	}
	
	
	
	
	
	
	
	
	
	
	//查詢
	public List<myLogger> query(){
		String sql="select method_name, log_time from myLogger";
		List<myLogger> data=jdbcTemplate.query(sql, (ResultSet rs, int rowNum)->{
			myLogger mylogger=new myLogger();
			mylogger.setMethod_name(rs.getString("method_name"));
			mylogger.setLog_time(rs.getString("log_time"));
			return mylogger;
		});
		return data;
	}
	
	
	
	
	
	
	
	
	
	

}
