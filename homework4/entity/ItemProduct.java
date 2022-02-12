package com.study.springcore.homework4.entity;

public class ItemProduct {

	//claim properties
	private Integer id;
	private String text;
	private Integer price;
	private Integer inventory;
	
	//setter and getter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	
	//toString
	@Override
	public String toString() {
		return "ItemProduct [id=" + id + ", text=" + text + ", price=" + price + ", inventory=" + inventory + "]";
	}
	
	
	
	
}
