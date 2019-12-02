package com.myclass.dto;

import javax.persistence.Id;

import com.myclass.entity.DetailInvoices;

public class DetailInvoiceDto extends DetailInvoices {

	private String sale_id;
	@Id
	private String product_id;
	private int amount;
	private double price;
	private double total;
	
	
	
	public DetailInvoiceDto() {
		// TODO Auto-generated constructor stub
	}

	public DetailInvoiceDto(String sale_id, String product_id, int amount, double price, double total) {
		super();
		this.sale_id = sale_id;
		this.product_id = product_id;
		this.amount = amount;
		this.price = price;
		this.total = total;
	}

	public String getSale_id() {
		return sale_id;
	}

	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
