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
@Table(name = "saleinvoices")
public class SaleInvoice {
	@Id
	private String sale_id;
	@OneToMany(mappedBy = "saleinvoice",fetch = FetchType.LAZY)
	private List<DetailInvoices> detailinvoices;
	
	@Column(name="employees_id")
	private String employees_id;
	@ManyToOne
	@JoinColumn(name ="employees_id" , insertable = false , updatable = false)
	private Employees employees;
	
	@NotBlank(message = "ID không được bỏ trống!")
	@Column(name = "customer_id")
	private String customer_id;
	
	private String nameCustomer;
	private String phoneCustomer;
	private Date dayOutput;
	private Double totalMoney;
	private Double totalInput;
	@Column(name="tolalOutput")
	private Double totalOutput;
	
	public SaleInvoice(String sale_id, String employees_id, String customer_id, String nameCustomer,
			String phoneCustomer, Date dayOutput, Double totalMoney, Double totalInput,
			Double totalOutput) {
		super();
		this.sale_id = sale_id;
		this.employees_id = employees_id;
		this.customer_id = customer_id;
		this.nameCustomer = nameCustomer;
		this.phoneCustomer = phoneCustomer;
		this.dayOutput = dayOutput;
		this.totalMoney = totalMoney;
		this.totalInput = totalInput;
		this.totalOutput = totalOutput;
	}
	
	public SaleInvoice() {
		// TODO Auto-generated constructor stub
	}
	
	public String getSale_id() {
		return sale_id;
	}
	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}
	public String getEmployees_id() {
		return employees_id;
	}
	public void setEmployees_id(String employees_id) {
		this.employees_id = employees_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getPhoneCustomer() {
		return phoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}
	public Date getDayOutput() {
		return dayOutput;
	}
	public void setDayOutput(Date dayOutput) {
		this.dayOutput = dayOutput;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Double getTotalInput() {
		return totalInput;
	}
	public void setTotalInput(Double totalInput) {
		this.totalInput = totalInput;
	}
	public Double getTotalOutput() {
		return totalOutput;
	}
	public void setTotalOutput(Double totalOutput) {
		this.totalOutput = totalOutput;
	}
	
}
