package com.study.springcore.homework4.entity;

public class Item {
	
	//claim properties
	private Integer id;
	private Integer amount;
	
	//claim relationship of other tables
	private ItemProduct itemProduct;
	private Invoice invoice;
	
	//setter and getter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public ItemProduct getItemProduct() {
		return itemProduct;
	}
	public void setItemProduct(ItemProduct itemProduct) {
		this.itemProduct = itemProduct;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	//toString
	@Override
	public String toString() {
		return "Item [id=" + id + ", amount=" + amount + ", itemProduct=" + itemProduct + ", invoice=" + invoice + "]";
	}
	
	
	
	
	
}
