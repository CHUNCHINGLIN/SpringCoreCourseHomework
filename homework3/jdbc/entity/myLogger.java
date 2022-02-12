package com.study.springcore.jdbc.entity;

public class myLogger {

	String method_name;
	String log_time;
	
	public myLogger() {}
	
	
	public myLogger(String method_name, String log_time) {
		super();
		this.method_name = method_name;
		this.log_time = log_time;
	}
	public String getMethod_name() {
		return method_name;
	}
	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	
	
	
	
}
