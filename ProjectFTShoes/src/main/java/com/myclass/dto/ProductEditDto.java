package com.myclass.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.myclass.entity.Producer;

public class ProductEditDto {
	
	private String id;
	@NotBlank(message = "cap nhat ten san pham")
	private String name;
	@NotBlank(message = "cap nhat Kieu san pham")
	private String type;
	@NotBlank(message = "cap nhat size san pham")
	private int size;
	@NotBlank(message = "cap nhat so luong san pham")
	private int amount;
	@NotBlank(message = "cap nhat gia san pham")
	private double price;
	@NotBlank(message = "cap nhat gia ban san pham")
	private double priceSale;
	private String producer_id;
	
	public ProductEditDto() {
	}
	
	public ProductEditDto(String id, String name, String type, int size, int amount, double price, double priceSale,
			Date dayInput, String producer_id) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.size = size;
		this.amount = amount;
		this.price = price;
		this.priceSale = priceSale;
		this.producer_id = producer_id;
	}



	public String getProducer_id() {
		return producer_id;
	}

	public void setProducer_id(String producer_id) {
		this.producer_id = producer_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
	
	public double getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}

	
}
