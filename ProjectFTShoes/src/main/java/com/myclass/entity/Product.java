package com.myclass.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id")
	private String id;
	@OneToMany(mappedBy = "product" , fetch = FetchType.LAZY)
	private List<DetailInvoices> detailInvoices;
	
	@Column(name = "nameProduct")
	private String name;

	private String producer_id;
	@ManyToOne
	@JoinColumn(name = "producer_id" ,insertable=false , updatable=false)
	private Producer producer;

	@Column(name = "typeProduct")
	private String type;

	private int size;

	@Column(name = "amountProduct")
	private int amount;
	private double price;
	private double priceSale;
	private Date dayInput;
	
	
	public Product() {}

	
	public Product(String id, String name, String producer_id, String type, int size, int amount, double price,
			double priceSale, Date dayInput) {
		super();
		this.id = id;
		this.name = name;
		this.producer_id = producer_id;
		this.type = type;
		this.size = size;
		this.amount = amount;
		this.price = price;
		this.priceSale = priceSale;
		this.dayInput = dayInput;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
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

	public String getProducer_id() {
		return producer_id;
	}

	public void setProducer_id(String producer_id) {
		this.producer_id = producer_id;
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

	public Date getDayInput() {
		return dayInput;
	}

	public void setDayInput(Date dayInput) {
		this.dayInput = dayInput;
	}

}
