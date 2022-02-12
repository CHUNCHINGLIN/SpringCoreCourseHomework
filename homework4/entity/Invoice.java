package com.study.springcore.homework4.entity;

import java.util.Date;

public class Invoice {
	
	//claim properties
	private Integer id;
	private Date invdate;
	
	//setter and getter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getInvdate() {
		return invdate;
	}
	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}
	
	//toString
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invdate=" + invdate + "]";
	}
	
	

}
